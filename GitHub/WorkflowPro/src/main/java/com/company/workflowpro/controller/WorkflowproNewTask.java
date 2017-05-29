package com.company.workflowpro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproEmployeeToRetrieve;
import com.company.workflowpro.model.dto.WorkflowproDetailEmployee;

/**
 * Servlet implementation class WorkflowproNewTask
 */
public class WorkflowproNewTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkflowproNewTask() {
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
			ArrayList<WorkflowproDetailEmployee> employees = new WorkflowproEmployeeToRetrieve().getEmployees();
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("newtask.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		//request.getRequestDispatcher("newtask.jsp").forward(request, response);
	}

}
