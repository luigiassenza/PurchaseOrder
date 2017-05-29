package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.workflowpro.connection.MySQLCnn;

public class WorkflowproEmployeeToChangeDelete {
	
	Connection c = null;
	
	public WorkflowproEmployeeToChangeDelete() {
		
		c = new MySQLCnn().getCnn();
		
	}
	
	public void changeEmployee(String oldName, String newName) throws SQLException {
		String sqlEmployees = "UPDATE employees SET name = ? WHERE name = ?";
		PreparedStatement pstEmployees = c.prepareStatement(sqlEmployees);
		pstEmployees.setString(1, newName);
		pstEmployees.setString(2, oldName);
		pstEmployees.executeUpdate();
		c.close();
	}
	
	public void changeWorkflowpro(String oldName, String newName) throws SQLException {
		String sqlWorkflowpro = "UPDATE workflowpro SET name = ? WHERE name = ?";
		PreparedStatement pstWorkflowpro = c.prepareStatement(sqlWorkflowpro);
		pstWorkflowpro.setString(1, newName);
		pstWorkflowpro.setString(2, oldName);
		pstWorkflowpro.executeUpdate();
		c.close();
	}
	
	public void delete(String name) throws SQLException {
		String sql = "DELETE FROM employees WHERE name = ?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, name);
		pst.executeUpdate();
		c.close();
	}

}
