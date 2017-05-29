package com.company.model.dto;

public class EmailDetails {
	
	private String senderEmail = "finance@company.com"; 
	private String password = "xxxx";
	
	private String smtpAuthKey = "mail.smtp.auth";
	private String smtpAuthValue = "true";
	
	private String smtpStarttlsKey = "mail.smtp.starttls.enable";
	private String smtpStarttlsValue = "true";
	
	private String smtpHostKey = "mail.smtp.host";
	private String smtpHostValue = "smtp.gmail.com";
	
	private String smtpPortKey = "mail.smtp.port";
	private String smtpPortValue = "587";
	
	
	public String getSenderEmail() {
		return senderEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getSmtpAuthKey() {
		return smtpAuthKey;
	}
	
	public String getSmtpAuthValue() {
		return smtpAuthValue;
	}
	
	public String getSmtpStarttlsKey() {
		return smtpStarttlsKey;
	}
	
	public String getSmtpStarttlsValue() {
		return smtpStarttlsValue;
	}
	
	public String getSmtpHostKey () {
		return smtpHostKey;
	}
	
	public String getSmtpHostValue(){
		return smtpHostValue;
	}
	
	public String getSmtpPortKey() {
		return smtpPortKey;
	}
	
	public String getSmtpPortValue() {
		return smtpPortValue;
	}
	

}
