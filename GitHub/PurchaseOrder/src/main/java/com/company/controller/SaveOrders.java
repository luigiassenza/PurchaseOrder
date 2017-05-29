package com.company.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.dao.SendEmail;
import com.company.model.dao.UpdateOrdersDAO;

/**
 * Servlet implementation class SaveOrders
 */
public class SaveOrders extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String yourName = request.getParameter("your_name");
		String yourEmail = request.getParameter("your_email");
		String approverName = request.getParameter("approver_name");
		String approverEmail = request.getParameter("approver_email");
		String supplierName = request.getParameter("supplier_name");
		String description = request.getParameter("description");
		String currency = request.getParameter("currency");
		Double netPrice = Double.parseDouble(request.getParameter("net_price"));
		Double vat = Double.parseDouble(request.getParameter("vat"));
		Double fullPrice = Double.parseDouble(request.getParameter("full_price"));
		UpdateOrdersDAO update = new UpdateOrdersDAO();
		update.Update(yourName, yourEmail, approverName, approverEmail, supplierName, description, currency, netPrice, vat, fullPrice);
		response.sendRedirect(request.getContextPath());
	}

}
