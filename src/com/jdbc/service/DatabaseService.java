package com.jdbc.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.model.Employee; 
import com.jdbc.util.*;

public class DatabaseService {
	DatabaseUtil  dutl = new DatabaseUtil();
	public void insertEmployee(Employee employee) throws SQLException{
		try(Connection con = dutl.getConnection();){
			
		
			PreparedStatement pstmt = con.prepareStatement(QueryUtil.insertEmployeeQuery());
			pstmt.setString(1, employee.getEmployeeName());
			pstmt.setString(2, employee.getEmployeeAddress());
			pstmt.setDouble(3, employee.getEmployeeSalary());
			int row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("Inserted Query has been executed Successfully !");
			}
			else {
				System.out.println("Something Went Wrong");
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}//end of insertEmployee
	public void getAllEmployee()throws SQLException {
		try(Connection con = dutl.getConnection();){
			Statement stm = con.createStatement();
			ResultSet rslt=stm.executeQuery(QueryUtil.getAllQuery());
			while(rslt.next()) {
				printEmployee(new Employee(rslt.getInt(1),rslt.getString(2),rslt.getString(3),rslt.getDouble(4)));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//end of getAllEmployee
	private void printEmployee(Employee employee) {
		System.out.println("Employee Id: "+employee.getEmployeeId());
		System.out.println("Employee Name: "+employee.getEmployeeName());
		System.out.println("Employee Address: "+employee.getEmployeeAddress());
		System.out.println("Employee Salary: "+employee.getEmployeeSalary());
		System.out.println("------------------------------------------------");
		
	}//end of printEmployee
   public boolean getEmployeeById(int id) throws SQLException {
	   boolean isFound = false;
    	try(Connection con = dutl.getConnection();){
    		PreparedStatement pstmt = con.prepareStatement(QueryUtil.getById());
    		pstmt.setInt(1, id);
    		
    		ResultSet rslt = pstmt.executeQuery();
    		if(rslt.next()) {
    			isFound=true;
    			printEmployee(new Employee(rslt.getInt(1),rslt.getString(2),rslt.getString(3),rslt.getDouble(4)));
    		}
    		else {
    			System.out.println("........... Record Not Found ..........");
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return isFound;
    }//end of getEmployeeById
   public void updateEmployee(Employee employee)throws SQLException {
	   try(Connection con = dutl.getConnection();
			   PreparedStatement pstmt = con.prepareStatement(QueryUtil.updateQuery());){
		   pstmt.setString(1,employee.getEmployeeName());
		   pstmt.setString(2,employee.getEmployeeAddress());
		   pstmt.setDouble(3, employee.getEmployeeSalary());
		   pstmt.setInt(4, employee.getEmployeeId());
		  int row=  pstmt.executeUpdate();
		  if(row>0) {
			  System.out.println("------  Update Successfully   -----");
		  }
		  else {
			  System.out.println("------- Update Failed ---------");
		  }
		   
		   
		   
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   public void deleteEmployee(int id) {
	   try(Connection con = dutl.getConnection()){
		   Statement stm = con.createStatement();
		  int row = stm.executeUpdate(QueryUtil.deleteQuery(id));
		  if(row>0) {
			  System.out.println("Deleted Query has been executed....");	
			  }
		  else {
			  System.out.println("------------ RECORD NOT FOUND --------------");
		  }
		   
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }//end of deleteEmployee
   
}
