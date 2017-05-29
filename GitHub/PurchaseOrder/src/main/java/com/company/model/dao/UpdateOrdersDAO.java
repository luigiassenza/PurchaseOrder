package com.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import com.company.connection.MySQLCnn;

public class UpdateOrdersDAO {
	
	Connection c = null;
	
	public UpdateOrdersDAO() {
		c = new MySQLCnn().getCnn();
	}
	
	public void Update(String yourName, String yourEmail, String approverName, String approverEmail, 
			String supplierName, String description, String currency, Double netPrice, Double vat,
			Double fullPrice) {
		try {
			String sql = "INSERT INTO orders(your_name, your_email, approver_name, approver_email,"
					+ "supplier_name, description, currency, net_price, vat, full_price) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prs = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			prs.setString(1, yourName);
			prs.setString(2, yourEmail);
			prs.setString(3, approverName);
			prs.setString(4, approverEmail);
			prs.setString(5, supplierName);
			prs.setString(6, description);
			prs.setString(7, currency);
			prs.setDouble(8, netPrice);
			prs.setDouble(9, vat);
			prs.setDouble(10, fullPrice);
			prs.executeUpdate();
			
			ResultSet genKey = prs.getGeneratedKeys();
			genKey.next();
			int key = genKey.getInt(1);
			c.close();
			
			SecurityKey securityKeyGeneration = new SecurityKey();
			String securityKey = securityKeyGeneration.GenerateSecurityKey(key);
			securityKeyGeneration.UpdateMySQLSecurityKey(key, securityKey);
			
			DecimalFormat df = new DecimalFormat("#,##0.00");
			
			String subject = "Purchase Order Request from " + yourName;
			
			String text = "<b>" + yourName + "</b>" + " has requested your approval for the following purchase:<br><br>"
					+ "<b>ID: </b>" + key + "<br>"
					+ "<b>Supplier: </b>" + supplierName + "<br>"
					+ "<b>Description : </b>" + description + "<br>"
					+ "<b>Currency: </b>" + currency.toUpperCase() + "<br>"
					+ "<b>Net Amount: </b>" + df.format(netPrice) + "<br>"
					+ "<b>VAT: </b>" + df.format(vat) + "<br>"
					+ "<b>Total Amount: </b>" + df.format(fullPrice) + "<br><br>"
					+ "Please click below to approve or reject it.<br>"
					+ "<a href='http://localhost:12841/PurchaseOrder/securitykey.jsp'>Approve/Reject</a>" + "<br>"
					+ "Please use the following security key for submission approval: " + "<b>" + securityKey + "</b>";
			
			String text2 = "<b>" + yourName + "</b>" + " has requested the approval of <b>" + approverName + "</b> for the following purchase:<br><br>"
					+ "<b>ID: </b>" + key + "<br>"
					+ "<b>Supplier: </b>" + supplierName + "<br>"
					+ "<b>Description : </b>" + description + "<br>"
					+ "<b>Currency: </b>" + currency.toUpperCase() + "<br>"
					+ "<b>Net Amount: </b>" + df.format(netPrice) + "<br>"
					+ "<b>VAT: </b>" + df.format(vat) + "<br>"
					+ "<b>Total Amount: </b>" + df.format(fullPrice) + "<br><br>";
			
			SendEmail sendEmail = new SendEmail();
			sendEmail.SendEmailToApprover(approverEmail, subject, text, text2);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
