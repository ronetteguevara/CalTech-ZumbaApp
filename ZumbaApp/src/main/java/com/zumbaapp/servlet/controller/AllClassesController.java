package com.zumbaapp.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.zumbaapp.servlet.db.DB;
import com.zumbaapp.servlet.model.Classes;

/**
 * Servlet implementation class AllClassesController
 */
public class AllClassesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllClassesController() {
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
		out.print("<h3>All Classes</h3>");
		
		DB db = new DB();
		
		ArrayList<Classes> zumbaClasses = db.fetchAllClasses();
		
		db.closeConnection();
		
		StringBuffer buffer = new StringBuffer();
		if(zumbaClasses.size() > 0) {
			buffer.append("<table>");
			buffer.append("<tr>");
			buffer.append("<th>ID</th>");
			buffer.append("<th>Name</th>");
			buffer.append("<th>Session</th>");
			buffer.append("<th>Date</th>");
			buffer.append("<th>Start Time</th>");
			buffer.append("<th>End Time</th>");
			buffer.append("<th>Location</th>");
			buffer.append("</tr>");
			
			for(Classes classes : zumbaClasses) {
				buffer.append("<tr>");
				buffer.append("<td>"+classes.id+"</td>");
				buffer.append("<td>"+classes.name+"</td>");
				buffer.append("<td>"+classes.session+"</td>");
				buffer.append("<td>"+classes.date+"</td>");
				buffer.append("<td>"+classes.startTime+"</td>");
				buffer.append("<td>"+classes.endTime+"</td>");
				buffer.append("<td>"+classes.location+"</td>");
				buffer.append("<td><a href='DeleteClasses?id="+classes.id+"'>Delete</a> | <a href='EditClass.jsp?id="+classes.id+"'>Edit</a></td>");
				
				buffer.append("</tr>");
			}
			
			buffer.append("</table>");
		}
		else {
			buffer.append("<h3>No Classes Found.</h3>");
		}
		
		out.print(buffer.toString());
		out.print("</center>");
	}
}
