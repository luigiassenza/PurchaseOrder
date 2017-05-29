package com.company.workflowpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproTaskToStart;

/**
 * Servlet implementation class WorkflowproTaskStart
 */
public class WorkflowproTaskStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkflowproTaskStart() {
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
		String id = request.getParameter("id");
		int idInt = Integer.parseInt(id);
		try {
			WorkflowproTaskToStart taskStart = new WorkflowproTaskToStart();
			taskStart.start(idInt);
			response.sendRedirect("./WorkflowproDisplay"); //"/Workflow/TaskDisplay"
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
