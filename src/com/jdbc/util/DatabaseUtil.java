package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static final String DRIVER_PATH ="com.mysql.cj.jdbc.Driver";
	private static final String url ="jdbc:mysql://localhost:3306/jdbc";
	private static final String user ="root";
	private static final String pass = "admin";
   public DatabaseUtil() {
	   try {
		   
		   Class.forName(DRIVER_PATH) ;
	   }
	 catch(Exception e) {
		 throw new RuntimeException("Something Went Wrong" +e);
		
	 }
	  
		   
	  
	   
   }//end of constructor
   public Connection getConnection() throws SQLException{
	  return  DriverManager.getConnection(url,user,pass);
	   
   }//end of getConnection

}
