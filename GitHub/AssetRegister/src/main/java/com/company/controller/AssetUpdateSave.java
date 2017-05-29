package com.company.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.dao.AssetRegistration;
import com.company.model.dao.AssetToUpdate;

/**
 * Servlet implementation class AssetUpdateSave
 */
public class AssetUpdateSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssetUpdateSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int id = Integer.parseInt(request.getParameter("id"));
		String device = request.getParameter("device");
		String type = request.getParameter("type");
		String memory = request.getParameter("memory");
		String hd = request.getParameter("hd");
		//Date purchaseDate = request.getDate("purchaseDate");
		
		String purchaseDateString = request.getParameter("purchaseDate");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date purchaseDateUtil = formatter.parse(purchaseDateString);
		java.sql.Date purchaseDate = new java.sql.Date(purchaseDateUtil.getTime());
		
		Double purchasePrice = Double.parseDouble(request.getParameter("purchasePrice"));
		String currency = request.getParameter("currency");
		Double depreciation = Double.parseDouble(request.getParameter("depreciation"));
		String employee = request.getParameter("employee");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		
		AssetToUpdate update = new AssetToUpdate();
		//try {
			update.Update(device, type, memory, hd, purchaseDate, currency, purchasePrice, depreciation, employee, email, department, id);;
			response.sendRedirect("/AssetRegister/AssetDisplay");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

}
