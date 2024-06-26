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
 * Servlet implementation class EditClassesController
 */
public class EditClassesController extends HttpServlet {
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
		Classes classes = db.fetchClass(id);
		
		out.print("<h3>Update Classes</h3>");
		out.print("<div>");
		out.print("<center>");
		out.print("<form action='SaveEditedClasses' method='post'>");
		out.print("<table>");
		out.print("<tr><td><input type='hidden' name='id' value='" + classes.id + "'></td></tr>");  // Corrected placement of hidden input
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + classes.name + "'/></td></tr>");  // Corrected placement of input within td
		out.print("<tr><td>Session:</td><td><input type='text' name='session' value='" + classes.session + "'/></td></tr>");
		out.print("<tr><td>Date:</td><td><input type='text' name='date' value='" + classes.date + "'/></td></tr>");
		out.print("<tr><td>Start Time:</td><td><input type='text' name='startTime' value='" + classes.startTime + "'/></td></tr>");
		out.print("<tr><td>End Time:</td><td><input type='text' name='endTime' value='" + classes.endTime + "'/></td></tr>");
		out.print("<tr><td>Location:</td><td><input type='text' name='location' value='" + classes.location + "'/></td></tr>");
		out.print("<tr><td colspan='2' style='text-align:center;'><input type='submit' value='Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</center>");
		out.print("</div>");

	}

}
