package com.company.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.connection.MySQLCnn;
import com.company.model.dto.AssetDetail;

public class AssetToUpdate {
	
	Connection c = null;
	
	public AssetToUpdate() {
		c = new MySQLCnn().getCnn();
	}
	
	public ArrayList<AssetDetail> GetAsset(int id) throws SQLException {
		
		ArrayList<AssetDetail> assets = new ArrayList<AssetDetail>();
		String sql = "SELECT * FROM assets WHERE id=?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			AssetDetail asset = new AssetDetail();
			asset.setId(rs.getString("id"));
			asset.setDevice(rs.getString("device"));
			asset.setType(rs.getString("type"));
			asset.setMemory(rs.getString("memory"));
			asset.setHd(rs.getString("hd"));
			asset.setPurchaseDate(rs.getDate("purchase_date")); //prs.setDate(5, (java.sql.Date) purchaseDate);
			asset.setCurrency(rs.getString("currency"));
			asset.setPurchasePrice(Double.parseDouble(rs.getString("purchase_price")));
			asset.setDepreciation(Double.parseDouble(rs.getString("depreciation")));
			asset.setEmployee(rs.getString("employee"));
			asset.setEmail(rs.getString("email"));
			asset.setDepartment(rs.getString("department"));
			assets.add(asset);
		}
		c.close();		
		return assets;
		
	}
		
	public void Update(String device, String type, String memory, String hd, Date purchaseDate, String currency,
			Double purchasePrice, Double depreciation, String employee, String email,
			String department, int id) throws SQLException {
		String sql = "UPDATE assets SET device=?, type=?, memory=?, hd=?, purchase_date=?, currency=?, "
				+ "purchase_price=?, depreciation=?, employee=?, email=?, department=? WHERE id=?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, device);
		pst.setString(2, type);
		pst.setString(3, memory);
		pst.setString(4, hd);
		pst.setDate(5, purchaseDate);
		pst.setString(6, currency);
		pst.setDouble(7, purchasePrice);
		pst.setDouble(8, depreciation);
		pst.setString(9, employee);
		pst.setString(10, email);
		pst.setString(11, department);
		pst.setInt(12, id);
		pst.executeUpdate();
		c.close();
		
		
	}

}
