package com.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import com.company.connection.MySQLCnn;
import com.company.model.dto.OrderDTO;

public class RegisterApproval {
	
	
	public void Register(String securityKey, String approval, String comments) { 
		Connection c = null;

		c = new MySQLCnn().getCnn();
		
		try {
			String sql = "UPDATE orders SET approval=?, comments=? WHERE security_key=?"; 
			PreparedStatement prs = c.prepareStatement(sql);
			prs.setString(1, approval);
			prs.setString(2, comments);
			prs.setString(3, securityKey); 
			prs.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public OrderDTO Summary(String securityKey) { 
		Connection c = null;
		c = new MySQLCnn().getCnn();
		OrderDTO order = new OrderDTO();

		try {
			String sql = "SELECT * FROM orders WHERE security_key=?"; 
			PreparedStatement prs = c.prepareStatement(sql);
			prs.setString(1, securityKey); // setInt id
			ResultSet rs = prs.executeQuery();
			while(rs.next()) {
				order.setId(rs.getString("id"));
				//order.setDate(rs.getDate("date"));
				order.setYourName(rs.getString("your_name"));
				order.setYourEmail(rs.getString("your_email"));
				order.setApproverName(rs.getString("approver_name"));
				order.setApproverEmail(rs.getString("approver_email"));
				order.setSupplierName(rs.getString("supplier_name"));
				order.setDescription(rs.getString("description"));
				order.setCurrency(rs.getString("currency"));
				order.setNetPrice(Double.parseDouble(rs.getString("net_price")));
				order.setVat(Double.parseDouble(rs.getString("vat")));
				order.setFullPrice(Double.parseDouble(rs.getString("full_price")));
				order.setApproval(rs.getString("approval"));
				order.setComments(rs.getString("comments"));
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;	
	}
	
	public void Confirmation(String securityKey, String approval) { 
		
		RegisterApproval orders = new RegisterApproval();
		OrderDTO order = orders.Summary(securityKey);
		
		String id = order.getId();
		String buyerName = order.getYourName();
		String buyer = order.getYourEmail();
		String approver = order.getApproverName();
		String supplier = order.getSupplierName();
		String description = order.getDescription();
		String currency = order.getCurrency();
		Double netPrice = order.getNetPrice();
		Double vat = order.getVat();
		Double fullPrice = order.getFullPrice();
		String comments = order.getComments();
		
		DecimalFormat df = new DecimalFormat("#,##0.00");
		
		String subject = approver + " has " + approval + " the purchase";
		
		String text = "<b>" + approver + "</b> has " + approval + " your purchase: <br><br>" 
				+ "<b>ID: </b>" + id + "<br>"
				+ "<b>Supplier: </b>" + supplier + "<br>"
				+ "<b>Description: </b>" + description + "<br>"
				+ "<b>Currency: </b>" + currency.toUpperCase() + "<br>"
				+ "<b>Net Price: </b>" + df.format(netPrice) + "<br>"
				+ "<b>VAT: </b>" + df.format(vat) + "<br>"
				+ "<b>Full Price: </b>" + df.format(fullPrice) + "<br>"
				+ "<b>" + approver + "'s comments: </b>" + comments;
		
		String text2 = "<b>" + approver + "</b> has " + approval + " the <b>"+ buyerName + "</b>'s purchase: <br><br>" 
				+ "<b>ID: </b>" + id + "<br>"
				+ "<b>Supplier: </b>" + supplier + "<br>"
				+ "<b>Description: </b>" + description + "<br>"
				+ "<b>Currency: </b>" + currency.toUpperCase() + "<br>"
				+ "<b>Net Price: </b>" + df.format(netPrice) + "<br>"
				+ "<b>VAT: </b>" + df.format(vat) + "<br>"
				+ "<b>Full Price: </b>" + df.format(fullPrice) + "<br>"
				+ "<b>" + approver + "'s comments: </b>" + comments;
		
		SendEmail sendEmail = new SendEmail();
		sendEmail.SendEmailBackToSender(buyer, subject, text, text2);
	}
	

}
