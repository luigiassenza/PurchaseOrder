package com.company.model.dto;

import java.util.Date;

public class OrderDTO {
	
	private String id;
	private Date date;
	private String yourName;
	private String yourEmail;
	private String approverName;
	private String approverEmail;
	private String supplierName;
	private String description;
	private String currency;
	private Double netPrice;
	private Double vat;
	private Double fullPrice;
	private String approval;
	private String comments;
	
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
	
	public String getYourName() {
		return yourName;
	}
	
	public void setYourName(String yourName) {
		this.yourName = yourName;
	}
	
	public String getYourEmail() {
		return yourEmail;
	}
	
	public void setYourEmail(String yourEmail) {
		this.yourEmail = yourEmail;
	}
	
	public String getApproverName() {
		return approverName;
	}
	
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	
	public String getApproverEmail() {
		return approverEmail;
	}
	
	public void setApproverEmail(String approverEmail) {
		this.approverEmail = approverEmail;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public Double getNetPrice() {
		return netPrice;
	}
	
	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
	}
	
	public Double getVat() {
		return vat;
	}
	
	public void setVat(Double vat) {
		this.vat = vat;
	}
	
	public Double getFullPrice() {
		return fullPrice;
	}
	
	public void setFullPrice(Double fullPrice) {
		this.fullPrice = fullPrice;
	}
	
	public String getApproval() {
		return approval;
	}
	
	public void setApproval(String approval) {
		this.approval = approval;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String toString() {
		return id + date + yourName + yourEmail + approverName + approverEmail + supplierName + 
				description + currency + netPrice + vat + fullPrice + approval + comments;
	}

}
