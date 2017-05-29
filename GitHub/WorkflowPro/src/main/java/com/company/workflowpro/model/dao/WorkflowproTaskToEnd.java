package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.company.workflowpro.connection.MySQLCnn;

public class WorkflowproTaskToEnd {
	
	
		Connection c = null;
		
		public WorkflowproTaskToEnd() {
			c = new MySQLCnn().getCnn();
		}
		
		public void end(int id) throws SQLException {
			Calendar calendar = Calendar.getInstance();
			Timestamp end = new Timestamp(calendar.getTime().getTime());
			
			String sql = "UPDATE workflowpro SET end=?, status=? WHERE id=?";
			PreparedStatement prs = c.prepareStatement(sql);
			prs.setTimestamp(1, end);
			prs.setString(2, "Finished");
			prs.setInt(3, id);
			prs.executeUpdate();
			c.close();
		}

	}

