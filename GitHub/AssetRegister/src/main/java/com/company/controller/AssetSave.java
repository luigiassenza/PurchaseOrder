package com.company.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.dao.AssetRegistration;

/**
 * Servlet implementation class AssetSave
 */
public class AssetSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssetSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String device = request.getParameter("device");
			String type = request.getParameter("type");
			String memory = request.getParameter("memory");
			String hd = request.getParameter("hd");
			
			String purchaseDateString = request.getParameter("purchaseDate");
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date purchaseDateUtil = formatter.parse(purchaseDateString);
			java.sql.Date purchaseDate = new java.sql.Date(purchaseDateUtil.getTime());
			//System.out.println(purchaseDate); //to be deleted
			Double purchasePrice = Double.parseDouble(request.getParameter("purchasePrice"));
			String currency = request.getParameter("currency");
			Double depreciation = Double.parseDouble(request.getParameter("depreciation"));
			String employee = request.getParameter("employee");
			String email = request.getParameter("email");
			String department = request.getParameter("department");
		
			AssetRegistration registration = new AssetRegistration();
			registration.Save(device, type, memory, hd, purchaseDate, purchasePrice, currency, depreciation, employee, email, department);
			response.sendRedirect("/AssetRegister/AssetDisplay");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
