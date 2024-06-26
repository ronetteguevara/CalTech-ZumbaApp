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
 * Servlet implementation class ParticipantsController
 */
public class ParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipantsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Participant participant = new Participant();
		participant.firstName = request.getParameter("txtFName");
		participant.lastName = request.getParameter("txtLName");
		participant.email = request.getParameter("txtEmail");
		participant.phone = request.getParameter("txtPhone");
		participant.zumbaClass = request.getParameter("txtClass");

		System.out.println("[Participant Servlet] Participant Details: " + participant);
		
		DB db = new DB();
		int result = db.addParticipant(participant);
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		String message = " ";
		
		if(result > 0) {
			response.sendRedirect("ViewParticipants.jsp");
		}
		else {
			message = participant.firstName + " not added in database. Please try again.";
		}
		
		out.print("<p>"+ message + "</p>");
		out.print("</center>");
	}

}
