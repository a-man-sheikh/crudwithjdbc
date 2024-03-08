package com.jdbc.util;

public class QueryUtil {
	public static String insertEmployeeQuery() {
		String query = "insert into employee_info(employee_name,employee_address,employee_salary) value(?,?,?) ";
		return query;
	}

}
