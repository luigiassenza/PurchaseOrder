package com.company.workflowpro.model.dto;

public class WorkflowproSummaryStatusDetail {
	
	private String status;
	private int count;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String toString() {
		return status + " " +  count;
		
	}

}
