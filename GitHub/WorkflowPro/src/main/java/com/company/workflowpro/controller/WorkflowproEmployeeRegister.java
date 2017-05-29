package com.company.workflowpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproEmployeeToRegister;
import com.company.workflowpro.model.dao.WorkflowproEmployeeToRetrieve;
import com.company.workflowpro.model.dto.WorkflowproDetailEmployee;

/**
 * Servlet implementation class WorkflowproEmployeeRegister
 */
public class WorkflowproEmployeeRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkflowproEmployeeRegister() {
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
		
		String name = request.getParameter("name");
		WorkflowproEmployeeToRegister register = new WorkflowproEmployeeToRegister();
		String message;
		try {
			message = register.register(name);
			ArrayList<WorkflowproDetailEmployee> employees = new WorkflowproEmployeeToRetrieve().getEmployees();
			request.setAttribute("employees", employees);
			request.setAttribute("message", message);
			request.getRequestDispatcher("employee.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
