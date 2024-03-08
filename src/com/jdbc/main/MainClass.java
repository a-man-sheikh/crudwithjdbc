package com.jdbc.main;

import java.util.Scanner;

import com.jdbc.model.Employee;
import com.jdbc.service.DatabaseService;

public class MainClass {
	public static void main(String[] a) {
		DatabaseService ds = new DatabaseService();
		try(Scanner sc = new Scanner(System.in);) {
			boolean isRunning=false;
			while(!isRunning) {
				System.out.println("Enter your choice: ");
				System.out.println("1). Insert");
				System.out.println("2). Select all");
				System.out.println("3). Select By Employee Id");
				System.out.println("4). Update Employee");
				System.out.println("5). Delet Employee");
				System.out.println("6). Exit");
				int key = Integer.parseInt(sc.nextLine());
				
				switch(key) {
				case 1:
					System.out.println("Enter name , address,salary");
					
					ds.insertEmployee(new Employee(sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine())));
					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
					
				case 5:
					break;
				case 6:
					System.out.println("Thank you for visiting !");
					isRunning = true;
					break;
				default:
					System.out.println("Enter valid key !");
				}
			}
		}
		catch(Exception e) {
			throw new RuntimeException("Something Went wrong" + e);
		}
	}

}
