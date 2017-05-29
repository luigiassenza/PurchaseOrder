package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.workflowpro.connection.MySQLCnn;
import com.company.workflowpro.model.dto.WorkflowproSummaryNameStatusDetail;
import com.company.workflowpro.model.dto.WorkflowproSummaryStatusDetail;

public class WorkflowproToSummary {
	
	Connection c = null;
	
	public WorkflowproToSummary() {
		
		c = new MySQLCnn().getCnn();
		
	}
	
	//Summary by Status
	public ArrayList<WorkflowproSummaryStatusDetail> byStatus() throws SQLException {
		
		ArrayList<WorkflowproSummaryStatusDetail> statusDetail = new ArrayList<WorkflowproSummaryStatusDetail>();
		String sql = "SELECT status, COUNT(*) FROM workflowpro GROUP BY status";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			WorkflowproSummaryStatusDetail detail = new WorkflowproSummaryStatusDetail();
			detail.setStatus(rs.getString("status"));
			detail.setCount(rs.getInt("count(*)"));
			statusDetail.add(detail);
		}
		c.close();
		return statusDetail;
	}
	
	//Summary by Name and Status
	public ArrayList<WorkflowproSummaryNameStatusDetail> getSummaryNameStatus() throws SQLException {
		
		ArrayList<WorkflowproSummaryNameStatusDetail> summaryNameStatus = new ArrayList<WorkflowproSummaryNameStatusDetail>();
		//MySQL command: SELECT col_name1, col_name2, COUNT(col_name1) FROM table_name GROUP BY col_name1, col_name2;
		String sql = "SELECT name, status, COUNT(*) FROM workflowpro GROUP BY name, status";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			WorkflowproSummaryNameStatusDetail summaryNameStatusDetail = new WorkflowproSummaryNameStatusDetail();
			summaryNameStatusDetail.setName(rs.getString("name")); //rs.getString(1);
			summaryNameStatusDetail.setStatus(rs.getString("status")); //rs.getstring(2);
			summaryNameStatusDetail.setCount(rs.getInt("count(*)")); //rs.getInt(3);
			summaryNameStatus.add(summaryNameStatusDetail);
		}
		c.close();
		return summaryNameStatus;
	}
	
	//Summary by Name and Status Outstanding
		public ArrayList<WorkflowproSummaryNameStatusDetail> getSummaryNameStatusOutstanding() throws SQLException {
			
			ArrayList<WorkflowproSummaryNameStatusDetail> summaryNameStatusOutstanding = new ArrayList<WorkflowproSummaryNameStatusDetail>();
			//MySQL command: SELECT col_name1, col_name2, COUNT(*) FROM table_name WHERE col_name1 = 'value1' OR col_name2 = 'value2' GROUP BY col_name1, col_name2;
			String sql = "SELECT name, status, COUNT(*) FROM workflowpro WHERE status = 'Started' OR status = 'Registered' GROUP BY name, status;";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				WorkflowproSummaryNameStatusDetail summaryNameStatusDetail = new WorkflowproSummaryNameStatusDetail();
				summaryNameStatusDetail.setName(rs.getString("name")); //rs.getString(1);
				summaryNameStatusDetail.setStatus(rs.getString("status")); //rs.getstring(2);
				summaryNameStatusDetail.setCount(rs.getInt("count(*)")); //rs.getInt(3);
				summaryNameStatusOutstanding.add(summaryNameStatusDetail);
			}
			c.close();
			return summaryNameStatusOutstanding;
		}

}
