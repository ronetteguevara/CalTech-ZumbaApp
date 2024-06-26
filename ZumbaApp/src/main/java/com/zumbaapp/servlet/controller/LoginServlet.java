package com.zumbaapp.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import jakarta.servlet.http.Cookie;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final String EMAIL = "admin@zumbabyrohit.com";
	private final String PASSWORD = "admin123!";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		
		String message = " ";
		
		if(email.equals(EMAIL) && password.equals(PASSWORD)) {
			response.sendRedirect("Home.jsp");
		}
		else {
			message = "<center><h3>Login unsuccessful. Please try again.</h3> <br> <a href='index.html'>Home</a></center>";
		}
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print(message);
		
	}

}
