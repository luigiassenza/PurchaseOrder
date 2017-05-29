package com.company.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.dao.OrdersDAO;
import com.company.model.dto.OrderDTO;


public class GetOrders extends HttpServlet {
	
	public GetOrders() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<OrderDTO> orders = new OrdersDAO().GetOrders();
			request.setAttribute("allorders", orders);
			request.getRequestDispatcher("display.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
