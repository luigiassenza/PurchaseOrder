package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.workflowpro.connection.MySQLCnn;
import com.company.workflowpro.model.dto.WorkflowproDetail;

public class WorkflowproToUpdate {
	
	Connection c = null;
	
	public WorkflowproToUpdate() {
		c = new MySQLCnn().getCnn();
	}
	
	public ArrayList<WorkflowproDetail> getDetail(int id) throws SQLException {
		
		ArrayList<WorkflowproDetail> details = new ArrayList<WorkflowproDetail>();
		String sql = "SELECT * FROM workflowpro WHERE id = ?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			WorkflowproDetail detail = new WorkflowproDetail();
			detail.setId(rs.getInt("id"));
			detail.setName(rs.getString("name"));
			detail.setTask(rs.getString("task"));
			detail.setStart(rs.getDate("start"));
			detail.setEnd(rs.getDate("end"));
			detail.setStatus(rs.getString("status"));
			detail.setComments(rs.getString("comments"));
			details.add(detail);
		}
		c.close();
		return details;
	}
	
	public void update(int id, String name, String task, String comments) throws SQLException {
		String sql = "UPDATE workflowpro SET name=?, task=?, comments=? WHERE id=?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, task);
		pst.setString(3, comments);
		pst.setInt(4, id);
		pst.executeUpdate();
		c.close();
		
	}
	

}
