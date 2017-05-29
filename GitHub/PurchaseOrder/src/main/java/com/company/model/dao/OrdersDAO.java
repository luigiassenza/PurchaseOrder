package com.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.company.connection.MySQLCnn;
import com.company.model.dto.OrderDTO;

public class OrdersDAO {
	
	Connection c = null;
	
	public OrdersDAO(){
		c = new MySQLCnn().getCnn();
	}
	
	public ArrayList<OrderDTO> GetOrders() throws SQLException {
		DecimalFormat df = new DecimalFormat("#,###.00");

		ArrayList<OrderDTO> orders = new ArrayList<OrderDTO>();
		String sql = "SELECT * FROM orders";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			OrderDTO order = new OrderDTO();
			order.setId(rs.getString("id"));
			order.setDate(rs.getDate("date"));
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
			orders.add(order);
		}
		return orders;
	}
	/*
	public static void main(String[] args) throws SQLException {
		ArrayList<OrderDTO> orders = new OrdersDAO().GetOrders();
		System.out.println(orders);
	}
*/
}
