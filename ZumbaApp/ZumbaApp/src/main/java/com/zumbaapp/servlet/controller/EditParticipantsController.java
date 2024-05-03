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
import com.zumbaapp.servlet.model.Participant;

/**
 * Servlet implementation class UpdateParticipantsController
 */
public class EditParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		out.print("<center>");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		DB db = new DB();
		Participant participant = db.fetchParticipant(id);
	    
		out.print("<center>");
		out.print("<form action='SaveEditedParticipants' method='post'>");
		out.print("<table>");
		out.print("<tr><td><input type='hidden' name='id' value='" + participant.id + "'></td></tr>");  // Corrected placement of hidden input
		out.print("<tr><td>Name:</td><td><input type='text' name='firstName' value='" + participant.firstName + "'/></td></tr>");  // Corrected placement of input within td
		out.print("<tr><td>Session:</td><td><input type='text' name='lastName' value='" + participant.lastName + "'/></td></tr>");
		out.print("<tr><td>Date:</td><td><input type='text' name='email' value='" + participant.email + "'/></td></tr>");
		out.print("<tr><td>Start Time:</td><td><input type='text' name='phone' value='" + participant.phone + "'/></td></tr>");
		out.print("<tr><td>End Time:</td><td><input type='text' name='zumbaClass' value='" + participant.zumbaClass + "'/></td></tr>");
		out.print("<tr><td colspan='2' style='text-align:center;'><input type='submit' value='Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</center>");

	}

}
