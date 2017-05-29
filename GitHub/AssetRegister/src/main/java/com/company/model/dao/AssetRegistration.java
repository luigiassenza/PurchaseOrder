package com.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import com.company.connection.MySQLCnn;

public class AssetRegistration {
	
	Connection c = null;
	
	public AssetRegistration() {
		c = new MySQLCnn().getCnn();
	}
	
	public void Save(String device, String type, String memory, String hd, Date purchaseDate, Double purchasePrice, String currency,
			Double depreciation, String employee, String email, String department) { //Date purchaseDate,
		try {
			String sql = "INSERT INTO assets (device, type, memory, hd, purchase_date, currency, purchase_price, depreciation, employee,"
					+ "email, department) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prs = c.prepareStatement(sql);
			prs.setString(1, device);
			prs.setString(2, type);
			prs.setString(3, memory);
			prs.setString(4, hd);
			prs.setDate(5, purchaseDate);
			prs.setString(6, currency);
			prs.setDouble(7, purchasePrice);
			prs.setDouble(8, depreciation);
			prs.setString(9, employee);
			prs.setString(10, email);
			prs.setString(11, department);
			prs.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
