package com.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.connection.MySQLCnn;

public class AssetToDelete {
	
	Connection c = null;
	
	public AssetToDelete() {
		c = new MySQLCnn().getCnn();
	}
	
	public void Delete(int id) throws SQLException {
		String sql = "DELETE FROM assets WHERE id=?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
		c.close();
	}
	
}
