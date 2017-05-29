package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.company.workflowpro.connection.MySQLCnn;

public class WorkflowproTaskToRegister {

		
		Connection c = null;
		
		public WorkflowproTaskToRegister() {
			c = new MySQLCnn().getCnn();
		}
		
		public void save(String name, String task, String comments) {
			try {
				String sql = "INSERT INTO workflowpro (name, task, status, comments) VALUES(?,?,?,?)";
				PreparedStatement prs = c.prepareStatement(sql);
				prs.setString(1, name);
				prs.setString(2, task);
				prs.setString(3,"Registered");
				prs.setString(4, comments);
				prs.executeUpdate();
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

