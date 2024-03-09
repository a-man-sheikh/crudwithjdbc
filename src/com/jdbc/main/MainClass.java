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
				System.out.println("5). Delete Employee");
				System.out.println("6). Exit");
				int key = Integer.parseInt(sc.nextLine());
				
				switch(key) {
				case 1:
					System.out.println("Enter name , address,salary");
					
					ds.insertEmployee(new Employee(sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine())));
					
					break;
				case 2:
					ds.getAllEmployee() ;
					break;
				case 3:
					System.out.println("Enter Employee Id: ");
					int empid= Integer.parseInt(sc.nextLine());
					ds.getEmployeeById(empid);
					break;
				case 4:
					System.out.println("Enter Employee Id : ");
					int  updateid = Integer.parseInt(sc.nextLine());
					boolean isFound = ds.getEmployeeById(updateid);
					
					if(isFound) {
					
						System.out.println("Enter employee name , address , salary");
						Employee emp = new Employee(updateid,sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()));
						ds.updateEmployee(emp);
						
						
					}
					else {
						System.out.println("Please input valid Id ");
					}
				
					break;
					
				case 5:
					System.out.println("Enter EmployeeId : ");
					ds.deleteEmployee(Integer.parseInt(sc.nextLine()));
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
