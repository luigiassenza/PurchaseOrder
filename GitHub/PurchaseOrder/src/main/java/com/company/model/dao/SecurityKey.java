package com.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.company.connection.MySQLCnn;

public class SecurityKey {
	
	public String GenerateSecurityKey(int key) {
		
		//First random number
		int rdm1;
		//Second random number
		int rdm2;
		
		//Generating first random integer number between 0 and 1000
		rdm1 = (int) Math.floor(Math.random()*1000);
		//Generating second random integer number between 0 and 1000
		rdm2 = (int) Math.floor(Math.random()*1000);
		
		//Generating security key
		String securityKey = String.valueOf(rdm1) + String.valueOf(key) + String.valueOf(rdm2);
		
		return securityKey;
	}
	
	public void UpdateMySQLSecurityKey(int key, String securityKey) {
		
		Connection c = null;
		c = new MySQLCnn().getCnn();
		
		try {
			String sql = "UPDATE orders SET approval=?, security_key=? WHERE id=?";
			PreparedStatement prs = c.prepareStatement(sql);
			prs.setString(1, "sent");
			prs.setString(2, securityKey);
			prs.setInt(3, key);
			prs.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
