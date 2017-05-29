package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.company.workflowpro.model.dto.WorkflowproDetailChart;
import com.company.workflowpro.connection.MySQLCnn;

public class WorkflowproChartToDisplay {
	
	Connection c = null;
	
	public WorkflowproChartToDisplay() {
		
		c = new MySQLCnn().getCnn();
		
	}
	
	public ArrayList<WorkflowproDetailChart> getChart() throws SQLException {
		
		Calendar calStart = Calendar.getInstance();
		Calendar calEnd = Calendar.getInstance();
		
		ArrayList<WorkflowproDetailChart> workflows = new ArrayList<WorkflowproDetailChart>();
		String sql = "SELECT * FROM workflowpro";
		PreparedStatement prs = c.prepareStatement(sql);
		ResultSet rs = prs.executeQuery();
		while(rs.next()) {
			Timestamp startSQL = rs.getTimestamp("start");
			Timestamp endSQL = rs.getTimestamp("end");
			calStart.setTime(startSQL);
			calEnd.setTime(endSQL);
			
			int yearStart = calStart.get(Calendar.YEAR);
			int monthStart = calStart.get(Calendar.MONTH);
			int dayStart = calStart.get(Calendar.DAY_OF_MONTH);
			int hourStart = calStart.get(Calendar.HOUR_OF_DAY);
			int minuteStart = calStart.get(Calendar.MINUTE);
			
			int yearEnd = calEnd.get(Calendar.YEAR);
			int monthEnd = calEnd.get(Calendar.MONTH);
			int dayEnd = calEnd.get(Calendar.DAY_OF_MONTH);
			int hourEnd = calEnd.get(Calendar.HOUR_OF_DAY);
			int minuteEnd = calEnd.get(Calendar.MINUTE);
						
			WorkflowproDetailChart workflow = new WorkflowproDetailChart();
			workflow.setId(rs.getInt("id"));
			workflow.setName(rs.getString("name"));
			workflow.setTask(rs.getString("task"));
			workflow.setYearStart(yearStart);
			workflow.setMonthStart(monthStart);
			workflow.setDayStart(dayStart);
			workflow.setHourStart(hourStart);
			workflow.setMinuteStart(minuteStart);
			workflow.setYearEnd(yearEnd);
			workflow.setMonthEnd(monthEnd);
			workflow.setDayEnd(dayEnd);
			workflow.setHourEnd(hourEnd);
			workflow.setMinuteEnd(minuteEnd);
			workflow.setStatus(rs.getString("status"));
			workflows.add(workflow);
		}
		c.close();
		return workflows;
	}
	
	public void updateCurrentTime() throws SQLException {
		Calendar calendar = Calendar.getInstance();
		Timestamp now = new Timestamp(calendar.getTime().getTime());
		
		String sql = "UPDATE workflowpro SET end=? WHERE status=?";
		PreparedStatement prs = c.prepareStatement(sql);
		prs.setTimestamp(1, now);
		prs.setString(2, "Started");
		prs.executeUpdate();
		c.close();
		
	}

}
