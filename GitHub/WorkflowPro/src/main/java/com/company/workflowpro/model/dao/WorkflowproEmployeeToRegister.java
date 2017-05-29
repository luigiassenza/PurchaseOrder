package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.workflowpro.connection.MySQLCnn;

public class WorkflowproEmployeeToRegister {
	
	Connection c = null;
	
	public WorkflowproEmployeeToRegister() {
		
		c = new MySQLCnn().getCnn();
		
	}
		
	public String register(String name) throws SQLException {
		
		String message = "";
		String sqlCheck = "SELECT name FROM employees WHERE name = ?";
		PreparedStatement pstCheck = c.prepareStatement(sqlCheck);
		pstCheck.setString(1, name);
		ResultSet rs = pstCheck.executeQuery();
		if(rs.next()) {
			message = name + " already exists";
		} else {
			message = name + " has been registered";
			String sql = "INSERT INTO employees (name) VALUES (?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, name);
			pst.executeUpdate();
			c.close();
		}
				
		return message;
	}
	

}
