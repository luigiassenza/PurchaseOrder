package com.company.xero.model;

import java.math.BigDecimal;

public class DataToDisplay {
	
	private String contactName;
	private BigDecimal amountPaid;
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	
}
