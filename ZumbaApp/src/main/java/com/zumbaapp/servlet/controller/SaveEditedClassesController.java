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
 * Servlet implementation class SaveEditedClassesController
 */
public class SaveEditedClassesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEditedClassesController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	int id = Integer.parseInt(request.getParameter("id"));
    	String name = request.getParameter("name");
    	String session = request.getParameter("session");
    	String date = request.getParameter("date");
    	String startTime = request.getParameter("startTime");
    	String endTime = request.getParameter("endTime");
    	String location = request.getParameter("location");
    	
    	Classes classes = new Classes(id, name, session, date, startTime, endTime, location);
    	
    	DB db = new DB();
    	int status = db.saveClasses(classes);
    	
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	out.print("<center>");

    	if(status > 0) {
    		response.sendRedirect("ViewClasses.jsp");
    	}
    	else {
    		out.print("Sorry, unable to update class. Please try again.");
    	}

    	db.closeConnection();

    	out.print("</center>");

    }
}
