package com.zumbaapp.servlet.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		
		String typeOfRequest = request.getParameter("txtType");
		
		String url = " ";
		
		if(typeOfRequest.equals("login")) {
			url = "Login";
		}
		else if(typeOfRequest.equals("register")) {
			url = "Registration";
		}
		else {
			out.print("<h3>Sorry, request cannot be processed.</h3>");	
		}
		
		if(!url.isEmpty()) {
			RequestDispatcher reqDispatcher = request.getRequestDispatcher(url);
			reqDispatcher.forward(request, response);
		}
		out.print("</center>");
	}

}
