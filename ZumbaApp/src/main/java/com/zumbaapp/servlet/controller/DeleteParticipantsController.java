package com.zumbaapp.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.zumbaapp.servlet.db.DB;

/**
 * Servlet implementation class DeleteParticipantsController
 */
public class DeleteParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<center>");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		DB db = new DB();
		
		int result = db.deleteParticipant(id);
		
		if(result > 0) {
			out.print("<h3>Participant deleted successfully!</h3>");
		}
		else {
			response.sendRedirect("ViewParticipants.jsp");
		}

		out.print("</center>");
	}
}
