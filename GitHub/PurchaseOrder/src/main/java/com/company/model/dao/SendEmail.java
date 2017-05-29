package com.company.model.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.company.model.dto.EmailDetails;

public class SendEmail {
	
	public void SendEmailToApprover(String approverEmail, String subject, String text, String text2) {
		EmailDetails detail = new EmailDetails();
		
		final String senderEmail = detail.getSenderEmail();
		final String password = detail.getPassword();
		final String smtpAuthKey = detail.getSmtpAuthKey();
		final String smtpAuthValue = detail.getSmtpAuthValue();
		final String smtpStarttlsKey = detail.getSmtpStarttlsKey();
		final String smtpstarttlsValue = detail.getSmtpStarttlsValue();
		final String smtpHostKey = detail.getSmtpHostKey();
		final String smtpHostValue = detail.getSmtpHostValue();
		final String smtpPortKey = detail.getSmtpPortKey();
		final String smtpPortValue = detail.getSmtpPortValue();
		
		
		Properties props = new Properties();
		props.put(smtpAuthKey, smtpAuthValue);
		props.put(smtpStarttlsKey, smtpstarttlsValue);
		props.put(smtpHostKey, smtpHostValue);
		props.put(smtpPortKey, smtpPortValue);
		
		Session session = Session.getInstance(props, 
				new javax.mail.Authenticator() 
				{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(senderEmail, password);
			}
				});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("name@company.com")); 
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(approverEmail));
			message.setSubject(subject);
			message.setContent(text, "text/html");
			
			Transport.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//------------------instead of copy----------------------------------------
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("name@company.com")); 
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("finance@company.com")); //finance@adaptavsit.com
			message.setSubject(subject);
			message.setContent(text2, "text/html");
			
			Transport.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void SendEmailBackToSender(String buyer, String subject, String text, String text2) {
		EmailDetails detail = new EmailDetails();
		
		final String senderEmail = detail.getSenderEmail();
		final String password = detail.getPassword();
		final String smtpAuthKey = detail.getSmtpAuthKey();
		final String smtpAuthValue = detail.getSmtpAuthValue();
		final String smtpStarttlsKey = detail.getSmtpStarttlsKey();
		final String smtpstarttlsValue = detail.getSmtpStarttlsValue();
		final String smtpHostKey = detail.getSmtpHostKey();
		final String smtpHostValue = detail.getSmtpHostValue();
		final String smtpPortKey = detail.getSmtpPortKey();
		final String smtpPortValue = detail.getSmtpPortValue();
		
		
		Properties props = new Properties();
		props.put(smtpAuthKey, smtpAuthValue);
		props.put(smtpStarttlsKey, smtpstarttlsValue);
		props.put(smtpHostKey, smtpHostValue);
		props.put(smtpPortKey, smtpPortValue);
		
		Session session = Session.getInstance(props, 
				new javax.mail.Authenticator() 
				{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(senderEmail, password);
			}
				});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("name@company.com")); 
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(buyer));

			message.setSubject(subject);
			message.setContent(text, "text/html");
			
			Transport.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//----------------------for finance@company.com------------------------------
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("name@company.com")); 
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("name@company.com"));

			message.setSubject(subject);
			message.setContent(text2, "text/html");
			
			Transport.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
