package com.jdbc.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.model.Employee; 
import com.jdbc.util.*;

public class DatabaseService {
	DatabaseUtil  dutl = new DatabaseUtil();
	public void insertEmployee(Employee employee) throws SQLException{
		try(Connection con = dutl.getConnection()){
			
		
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
	
	}

}
