package com.company.workflowpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproEmployeeToChangeDelete;
import com.company.workflowpro.model.dao.WorkflowproEmployeeToRetrieve;
import com.company.workflowpro.model.dto.WorkflowproDetailEmployee;

/**
 * Servlet implementation class WorkflowproEmployeeChangeDelete
 */
public class WorkflowproEmployeeChangeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkflowproEmployeeChangeDelete() {
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
		String action = request.getParameter("action");
		if(action.equals("change")) {
			String oldName = request.getParameter("oldName");
			request.setAttribute("oldName", oldName);
			request.getRequestDispatcher("employeechange.jsp").forward(request, response);
		} else if(action.equals("delete")) {
			String oldName = request.getParameter("oldName");
			WorkflowproEmployeeToChangeDelete modifyName = new WorkflowproEmployeeToChangeDelete();
			try {
				modifyName.delete(oldName);
				ArrayList<WorkflowproDetailEmployee> employees = new WorkflowproEmployeeToRetrieve().getEmployees();
				String message = oldName + " has been deleted";
				request.setAttribute("messageDelete", message);
				request.setAttribute("employees", employees);
				request.getRequestDispatcher("employee.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
