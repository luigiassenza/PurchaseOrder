package com.company.workflowpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproToSearch;
import com.company.workflowpro.model.dto.WorkflowproDetail;

/**
 * Servlet implementation class WorkflowproSearchByDate
 */
public class WorkflowproSearchByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkflowproSearchByDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String startString = request.getParameter("start");
		String endString = request.getParameter("end");
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//String start = fmt.format(startString);
			//String end = fmt.format(endString);
			java.util.Date startUtil = fmt.parse(startString);
			java.util.Date endUtil = fmt.parse(endString);
			java.sql.Date start = new java.sql.Date(startUtil.getTime());
			java.sql.Date end = new java.sql.Date(endUtil.getTime());
			
			//java.sql.Date start = (java.sql.Date) new Date(startUtil.getTime());
			//java.sql.Date end = (java.sql.Date) new Date(endUtil.getTime());
			//java.sql.Date start = java.sql.Date.valueOf(startString);
			//java.sql.Date end = java.sql.Date.valueOf(endString);
			
			ArrayList<WorkflowproDetail> allDate = new WorkflowproToSearch().byDate(start, end);
			request.setAttribute("allDate", allDate);
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
