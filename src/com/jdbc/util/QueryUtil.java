package com.jdbc.util;

public class QueryUtil {
	public static String insertEmployeeQuery() {
		String query = "insert into employee_info(employee_name,employee_address,employee_salary) value(?,?,?) ";
		return query;
	}
	public static String getAllQuery() {
		return "select * from employee_info";
	}
	public static String getById() {
		return "select * from employee_info where employee_id = ?";
	}
	public static String updateQuery() {
		return "update employee_info set employee_name = ? ,employee_address = ? , employee_salary = ? where employee_id = ?";
	}
	public static String deleteQuery(int id) {
		return "delete from employee_info where employee_id = "+id;
	}
	
}
