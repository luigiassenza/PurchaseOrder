package com.company.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.connection.MySQLCnn;
import com.company.model.dto.OrderDTO;


public class SecurityKeyCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message;
		Connection c = null;
		c = new MySQLCnn().getCnn();
		String securityKey = request.getParameter("securityKey");
		String sql = "SELECT approval FROM orders WHERE security_key=?";
		
		if(securityKey.equals("")) {
			response.sendRedirect("securitykey.jsp");
		}
		
		
		try {
			PreparedStatement prs = c.prepareStatement(sql);
			prs.setString(1, securityKey);
			ResultSet rs = prs.executeQuery();
			while(rs.next()) {
				String approvalStatus = rs.getString(1);
				HttpSession session = request.getSession();
				session.setAttribute("securityKey",securityKey);
				
				if(approvalStatus.equals("sent")) {
					ArrayList<OrderDTO> orders = new ArrayList<OrderDTO>();
					String sql2 = "SELECT * FROM orders WHERE security_key=?";// + securityKey;
					PreparedStatement prs2 = c.prepareStatement(sql2);
					prs2.setString(1, securityKey);
					ResultSet rs2 = prs2.executeQuery();
					while(rs2.next()) {
						OrderDTO order = new OrderDTO();
						order.setId(rs2.getString("id"));
						order.setDate(rs2.getDate("date"));
						order.setYourName(rs2.getString("your_name"));
						order.setYourEmail(rs2.getString("your_email"));
						order.setApproverName(rs2.getString("approver_name"));
						order.setApproverEmail(rs2.getString("approver_email"));
						order.setSupplierName(rs2.getString("supplier_name"));
						order.setDescription(rs2.getString("description"));
						order.setCurrency(rs2.getString("currency"));
						order.setNetPrice(Double.parseDouble(rs2.getString("net_price")));
						order.setVat(Double.parseDouble(rs2.getString("vat")));
						order.setFullPrice(Double.parseDouble(rs2.getString("full_price")));
						orders.add(order);	
					}
					try {
						request.setAttribute("approvalOrder", orders);
						request.getRequestDispatcher("approval.jsp").forward(request, response);
						c.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if(approvalStatus.equals("approved")) {
					message = "Purchase has been already approved";
					request.setAttribute("message", message);
					request.getRequestDispatcher("approvaldenied.jsp").forward(request, response);
					c.close();
				} else if(approvalStatus.equals("rejected")) {
					message = "Purchase has been already rejected";
					request.setAttribute("message", message);
					request.getRequestDispatcher("approvaldenied.jsp").forward(request, response);
					c.close();
				} else {
					message = "Purchase with security key " + securityKey + " does not exist in the database. Please try to re-enter it.";
					request.setAttribute("message", message);
					request.getRequestDispatcher("approvaldenied.jsp").forward(request, response);
					c.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
