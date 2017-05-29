package com.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.model.dao.RegisterApproval;

/**
 * Servlet implementation class GetApproval
 */
public class GetApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetApproval() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//int id = Integer.parseInt(request.getParameter("id"));
		String securityKey = (String)session.getAttribute("securityKey");
		
		String approval = request.getParameter("approval");
		String comments = request.getParameter("comments");
		RegisterApproval approvalResult = new RegisterApproval();
		approvalResult.Register(securityKey, approval, comments); //id
		
		//RegisterApproval registerApproval = new RegisterApproval();
		approvalResult.Confirmation(securityKey, approval); //id
		
		session.removeAttribute("securityKey");
		session.invalidate();
		if(approval.equals("approved")) {
			response.sendRedirect("approved.jsp");
		} else if (approval.equals("rejected")) {
			response.sendRedirect("rejected.jsp");
		}
		
	}

}
