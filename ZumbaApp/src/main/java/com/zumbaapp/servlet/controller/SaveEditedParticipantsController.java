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
 * Servlet implementation class SaveEditedParticipantsController
 */
public class SaveEditedParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEditedParticipantsController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	int id = Integer.parseInt(request.getParameter("id"));
    	String firstName = request.getParameter("firstName");
    	String lastName = request.getParameter("lastName");
    	String email = request.getParameter("email");
    	String phone = request.getParameter("phone");
    	String zumbaClass = request.getParameter("zumbaClass");
    	
    	Participant participant = new Participant(id, firstName, lastName, email, phone, zumbaClass);
    	
    	DB db = new DB();
    	int status = db.saveParticipant(participant);
    	
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	out.print("<center>");

    	if(status > 0) {
    		response.sendRedirect("ViewParticipants.jsp");
    	}
    	else {
    		out.print("Sorry, unable to update participant. Please try again.");
    	}

    	db.closeConnection();

    	out.print("</center>");

    }

}
