package com.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.connection.MySQLCnn;
import com.company.model.dto.AssetDetail;

public class AssetToSearch {
	
	Connection c = null;
	
	public AssetToSearch() {
		c = new MySQLCnn().getCnn();
	}
	
	public ArrayList<AssetDetail> SearchByElement(String searchName, String searchBy) throws SQLException{
		
		ArrayList<AssetDetail> assets = new ArrayList<AssetDetail>();
		String sql;
		PreparedStatement pst;
		
		if(searchBy.equals("device")) {
			sql = "SELECT * FROM assets WHERE device like '%" + searchName + "%'";
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				AssetDetail asset = new AssetDetail();
				asset.setId(rs.getString("id"));
				asset.setDevice(rs.getString("device"));
				asset.setType(rs.getString("type"));
				asset.setMemory(rs.getString("memory"));
				asset.setHd(rs.getString("hd"));
				asset.setPurchaseDate(rs.getDate("purchase_date"));
				asset.setCurrency(rs.getString("currency"));
				asset.setPurchasePrice(Double.parseDouble(rs.getString("purchase_price")));
				asset.setDepreciation(Double.parseDouble(rs.getString("depreciation")));
				asset.setEmployee(rs.getString("employee"));
				asset.setEmail(rs.getString("email"));
				asset.setDepartment(rs.getString("department"));
				
				ResidualAmount resAmt = new ResidualAmount(); 
				asset.setResidualAmount(resAmt.Calculate(rs.getString("purchase_date"), Double.parseDouble(rs.getString("depreciation")), Double.parseDouble(rs.getString("purchase_price"))));
				
				assets.add(asset);
			}
			c.close();
		} else if(searchBy.equals("type")) {
			sql = "SELECT * FROM assets WHERE type like '%" + searchName + "%'";
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				AssetDetail asset = new AssetDetail();
				asset.setId(rs.getString("id"));
				asset.setDevice(rs.getString("device"));
				asset.setType(rs.getString("type"));
				asset.setMemory(rs.getString("memory"));
				asset.setHd(rs.getString("hd"));
				asset.setPurchaseDate(rs.getDate("purchase_date")); 
				asset.setCurrency(rs.getString("currency"));
				asset.setPurchasePrice(Double.parseDouble(rs.getString("purchase_price")));
				asset.setDepreciation(Double.parseDouble(rs.getString("depreciation")));
				asset.setEmployee(rs.getString("employee"));
				asset.setEmail(rs.getString("email"));
				asset.setDepartment(rs.getString("department"));
				
				ResidualAmount resAmt = new ResidualAmount(); 
				asset.setResidualAmount(resAmt.Calculate(rs.getString("purchase_date"), Double.parseDouble(rs.getString("depreciation")), Double.parseDouble(rs.getString("purchase_price"))));
				
				assets.add(asset);
			}
			c.close();		
		} else if(searchBy.equals("employee")) {
			sql = "SELECT * FROM assets WHERE employee like '%" + searchName + "%'";
			pst = c.prepareStatement(sql);
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
				
				ResidualAmount resAmt = new ResidualAmount(); 
				asset.setResidualAmount(resAmt.Calculate(rs.getString("purchase_date"), Double.parseDouble(rs.getString("depreciation")), Double.parseDouble(rs.getString("purchase_price"))));
				
				assets.add(asset);
			}
			c.close();
		}
		return assets;
		
	}
	
}
