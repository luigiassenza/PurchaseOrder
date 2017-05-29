package com.company.workflowpro.controller;

import java.io.IOException;
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
 * Servlet implementation class WorkflowproEmployeeChangeDeleteModify
 */
public class WorkflowproEmployeeChangeDeleteModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkflowproEmployeeChangeDeleteModify() {
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
			String oldName = request.getParameter("oldName");
			String newName = request.getParameter("newName");
			WorkflowproEmployeeToChangeDelete modifyName = new WorkflowproEmployeeToChangeDelete();
			modifyName.changeEmployee(oldName, newName);
			//To avoid closed MySQL connection
			WorkflowproEmployeeToChangeDelete modifyNameNew = new WorkflowproEmployeeToChangeDelete();
			modifyNameNew.changeWorkflowpro(oldName, newName);
			String message = oldName + " has been changed into " + newName;
			request.setAttribute("messageModify", message);
			request.getRequestDispatcher("employeechange.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
