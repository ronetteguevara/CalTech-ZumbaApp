package com.zumbaapp.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.zumbaapp.servlet.db.DB;
import com.zumbaapp.servlet.model.Classes;

/**
 * Servlet implementation class Classes
 */
public class ClassesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Classes classes = new Classes();
		classes.name = request.getParameter("txtClassName");
		classes.session = request.getParameter("txtSession");
		classes.date = request.getParameter("txtClassDate");
		classes.startTime = request.getParameter("txtClassStart");
		classes.endTime = request.getParameter("txtClassEnd");
		classes.location = request.getParameter("txtClassLocation");
		
		System.out.println("[Classes Servlet] Classes Details: " + classes);
		
		DB db = new DB();
		int result = db.addClasses(classes);
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		String message = " ";
		
		if(result > 0) {
			response.sendRedirect("ViewClasses.jsp");
		}
		else {
			message = classes.name + " not added in database. Please try again.";
		}
		
		out.print("<p>"+ message + "</p>");
		out.print("</center>");
	}

}
