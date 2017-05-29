package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.company.workflowpro.connection.MySQLCnn;
public class WorkflowproTaskToStart {

			Connection c = null;
		
		public WorkflowproTaskToStart() {
			c = new MySQLCnn().getCnn();
		}
		
		public void start(int id) throws SQLException {
			Calendar calendar = Calendar.getInstance();
			Timestamp start = new Timestamp(calendar.getTime().getTime());
			Timestamp end = new Timestamp(calendar.getTime().getTime());
			
			String sql = "UPDATE workflowpro SET start=?, end=?, status=? WHERE id=?";
			PreparedStatement prs = c.prepareStatement(sql);
			prs.setTimestamp(1, start);
			prs.setTimestamp(2, end);
			prs.setString(3, "Started");
			prs.setInt(4, id);
			prs.executeUpdate();
			c.close();
		}

	}
