package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.workflowpro.connection.MySQLCnn;
import com.company.workflowpro.model.dto.WorkflowproDetailEmployee;

public class WorkflowproEmployeeToRetrieve {
	
	Connection c = null;
	
	public WorkflowproEmployeeToRetrieve() {
		
		c = new MySQLCnn().getCnn();
		
	}
	
	public ArrayList<WorkflowproDetailEmployee> getEmployees() throws SQLException {
		ArrayList<WorkflowproDetailEmployee> employees = new ArrayList<WorkflowproDetailEmployee>();
		String sql = "SELECT * FROM employees";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			WorkflowproDetailEmployee employee = new WorkflowproDetailEmployee();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employees.add(employee);
		}
		c.close();
		return employees;
	}	
	
}
