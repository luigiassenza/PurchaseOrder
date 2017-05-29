package com.company.model.dto;

import java.util.Date;

public class AssetDetail {
	
	private String id;
	private Date date; //timestamp
	private String device;
	private String type;
	private String memory;
	private String hd;
	private Date purchaseDate;
	private String currency;
	private Double purchasePrice;
	private Double depreciation;
	private String employee;
	private String email;
	private String department;
	private Double residualAmount; //residual amount
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDevice() {
		return device;
	}
	
	public void setDevice(String device) {
		this.device = device;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getMemory() {
		return memory;
	}
	
	public void setMemory(String memory) {
		this.memory = memory;
	}
	
	public String getHd() {
		return hd;
	}
	
	public void setHd(String hd) {
		this.hd = hd;
	}
	
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public Double getDepreciation() {
		return depreciation;
	}
	
	public void setDepreciation(Double depreciation) {
		this.depreciation = depreciation;
	}
	
	public String getEmployee() {
		return employee;
	}
	
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Double getResidualAmount(){
		return residualAmount;
	}
	
	public void setResidualAmount(Double residualAmount) {
		this.residualAmount = residualAmount;
	}
	
	public String toString() {
		return id + date + device + type + memory + hd + purchaseDate + currency + purchasePrice + 
				depreciation + employee + email + department + residualAmount;
	}
	

}
