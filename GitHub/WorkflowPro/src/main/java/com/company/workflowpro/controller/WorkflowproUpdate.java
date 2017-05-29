package com.company.workflowpro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproEmployeeToRetrieve;
import com.company.workflowpro.model.dao.WorkflowproToUpdate;
import com.company.workflowpro.model.dto.WorkflowproDetail;
import com.company.workflowpro.model.dto.WorkflowproDetailEmployee;

/**
 * Servlet implementation class WorkflowproUpdate
 */
public class WorkflowproUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkflowproUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int idInt = Integer.parseInt(id);
		try {
			ArrayList<WorkflowproDetail> details = new WorkflowproToUpdate().getDetail(idInt);
			request.setAttribute("details", details);
			
			ArrayList<WorkflowproDetailEmployee> employees = new WorkflowproEmployeeToRetrieve().getEmployees();
			request.setAttribute("employees", employees);
			
			request.getRequestDispatcher("update.jsp").forward(request, response);
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
