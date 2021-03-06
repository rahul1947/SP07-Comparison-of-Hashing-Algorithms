package rsn170330.sp07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

/**
 * CS 5V81.001: Implementation of Data Structures and Algorithms
 * Short Project SP07: Comparison of Hashing Implementations
 * @author Rahul Nalawade
 * 
 * Date: January 4, 2019
 */
public class HashingDriver1 {
	
	static DoubleHashing<Integer> dh = new DoubleHashing<>();
	static RobinHood<Integer> rh = new RobinHood<>();
	static Cuckoo<Integer> ch = new Cuckoo<>();
	static Set<Integer> hs = new HashSet<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc;
		File file = new File(args[0]);
		sc = new Scanner(file);
		String operation;
		int operand;
		long modValue = 1000000009;
		long result = 0;
		boolean succeed = false;
		int choice = 0;
		boolean verbose = false;
		
		if (args.length > 1) {
			choice = Integer.parseInt(args[1]);
		}
		if (args.length > 2) {
			verbose = Boolean.parseBoolean(args[2]);
			System.out.format("%-10.10s%-10.10s%.10s%1.1s", "Operation ", "Operand ", "Result", "\n");
		}
		
		Timer timer = new Timer();
		
		while (!((operation = sc.next()).equals("End"))) {
			
			switch (operation) {
				case "Add": {
					operand = sc.nextInt();
					if (choice == 1) {
						succeed = dh.add(operand);
					} else if (choice == 2) {
						succeed = rh.add(operand);
					} else if (choice == 3) {
						succeed = ch.add(operand);
					} else {
						succeed = hs.add(operand);
					}
					
					if(succeed) {
						result = (result + 1) % modValue;
					}
					if (verbose) {
						System.out.format("%-10.10s%-10.10s%.10s%1.1s", "Add ", " "+operand, " "+result, "\n");
					}
					break;
				}
				case "Remove": {
					operand = sc.nextInt();
					if (choice == 1) {
						succeed = dh.remove(operand);
					} else if (choice == 2) {
						succeed = rh.remove(operand);
					} else if (choice == 3) {
						succeed = ch.remove(operand);
					} else {
						succeed = hs.remove(operand);
					}
					
					if(succeed) {
						result = (result + 1) % modValue;
					}
					if (verbose) {
						System.out.format("%-10.10s%-10.10s%.10s%1.1s", "Remove ", " "+operand, " "+result, "\n");
					}
					break;
				}
				case "Contains":{
					operand = sc.nextInt();
					if (choice == 1) {
						succeed = dh.contains(operand);
					} else if (choice == 2) {
						succeed = rh.contains(operand);
					} else if (choice == 3) {
						succeed = ch.contains(operand);
					} else {
						succeed = hs.contains(operand);
					}
					
					if(succeed) {
						result = (result + 1) % modValue;
					}
					if (verbose) {
						System.out.format("%-10.10s%-10.10s%.10s%1.1s", "Contains ", " "+operand, " "+result, "\n");
					}
					break;
				}
				default:
				break;
			}
		}
		if (choice == 1) {
			System.out.println("Double Hashing result: " + result);
			System.out.println("Double Hashing size: " + dh.size());
			
		} else if (choice == 2) {
			System.out.println("Robin Hood result: " + result);
			System.out.println("Robin Hood size: " + rh.size());
			
		} else if (choice == 3) {
			System.out.println("Cuckoo Hashing result: " + result);
			System.out.println("Cuckoo Hashing size: " + ch.size());
			
		} else {
			System.out.println("HashSet result: " + result);
			System.out.println("HashSet size: " + hs.size());
		}
		System.out.println(timer.end());
	}

}
