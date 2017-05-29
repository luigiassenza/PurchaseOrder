package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import com.company.workflowpro.connection.MySQLCnn;
import com.company.workflowpro.model.dto.WorkflowproDetail;

public class WorkflowproToSearch {
	
	Connection c = null;
	
	public WorkflowproToSearch() {
		
		c = new MySQLCnn().getCnn();
	}
	
	public ArrayList<WorkflowproDetail> byAll(String value) throws SQLException {
		
		ArrayList<WorkflowproDetail> all = new ArrayList<WorkflowproDetail>();
		String sql = "SELECT * FROM workflowpro WHERE name LIKE ? OR task LIKE ? OR status LIKE ? OR comments LIKE ?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, "%" + value + "%");
		pst.setString(2, "%" + value + "%");
		pst.setString(3, "%" + value + "%");
		pst.setString(4, "%" + value + "%");
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
			all.add(detail);
		}
		c.close();
		return all;
	}
	
	public ArrayList<WorkflowproDetail> byDate(Date start, Date end) throws SQLException, ParseException {
		
		ArrayList<WorkflowproDetail> all = new ArrayList<WorkflowproDetail>();
		String sql = "SELECT * FROM workflowpro WHERE (start >= ? AND start <= ?) OR (end >= ? AND end <= ?)";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setDate(1, start);
		pst.setDate(2, end);
		pst.setDate(3, start);
		pst.setDate(4, end);
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
			all.add(detail);
		}
		c.close();
		return all;
	}
	
	public ArrayList<WorkflowproDetail> byName(String name) throws SQLException {
		
		ArrayList<WorkflowproDetail> all = new ArrayList<WorkflowproDetail>();
		String sql = "SELECT * FROM workflowpro WHERE name = ?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, name);
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
			all.add(detail);
		}
		c.close();
		return all;
	}
	

}
