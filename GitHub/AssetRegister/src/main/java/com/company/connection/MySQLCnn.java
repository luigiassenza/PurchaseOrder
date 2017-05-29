package com.company.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLCnn {
	
	private String url = "jdbc:mysql://localhost:3306/purchase_order?useSSL=false";
	private String driver = "com.mysql.jdbc.Driver";
	private String user = "root";
	private String pwd = "root";
	
	public Connection getCnn() {
		Connection c = null;
		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
