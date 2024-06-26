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
import com.zumbaapp.servlet.model.Participant;

/**
 * Servlet implementation class AllParticipantsController
 */
public class AllParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllParticipantsController() {
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
		
		DB db2 = new DB();
		
		ArrayList<Participant> zumbaParticipants = db2.fetchAllParticipants();
		
		db2.closeConnection();
		
		StringBuffer buffer = new StringBuffer();
		if(zumbaParticipants.size() > 0) {
			buffer.append("<table>");
			buffer.append("<tr>");
			buffer.append("<th>ID</th>");
			buffer.append("<th>First Name</th>");
			buffer.append("<th>Last Name</th>");
			buffer.append("<th>Email</th>");
			buffer.append("<th>Phone Number</th>");
			buffer.append("<th>Zumba Class</th>");
			buffer.append("</tr>");
			
			for(Participant participant : zumbaParticipants) {
				buffer.append("<tr>");
				buffer.append("<td>"+participant.id+"</td>");
				buffer.append("<td>"+participant.firstName+"</td>");
				buffer.append("<td>"+participant.lastName+"</td>");
				buffer.append("<td>"+participant.email+"</td>");
				buffer.append("<td>"+participant.phone+"</td>");
				buffer.append("<td>"+participant.zumbaClass+"</td>");
				buffer.append("<td><a href='DeleteParticipants?id="+participant.id+"'>Delete</a> | <a href='EditParticipant.jsp?id="+participant.id+"'>Edit</a></td>");
				buffer.append("</tr>");
			}
			
			buffer.append("</table>");
		}
		else {
			buffer.append("<h3>No Participants Found.</h3>");
		}
		
		out.print(buffer.toString());
		out.print("</center>");
	}

}
