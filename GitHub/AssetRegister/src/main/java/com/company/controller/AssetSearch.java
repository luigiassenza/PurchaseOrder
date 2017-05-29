package com.company.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.dao.AssetToSearch;
import com.company.model.dto.AssetDetail;

/**
 * Servlet implementation class AssetSearch
 */
public class AssetSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssetSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchName = request.getParameter("searchName");
		String searchBy = request.getParameter("searchBy");
		String message;
		
		try {
			ArrayList<AssetDetail> assets = new AssetToSearch().SearchByElement(searchName, searchBy);
			if(assets.isEmpty()) {
				message = "No records found!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("assetsearch.jsp").forward(request, response);
			} else {
				request.setAttribute("assetssearch", assets);
				request.getRequestDispatcher("assetsearch.jsp").forward(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
