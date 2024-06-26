package com.zumbaapp.servlet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zumbaapp.servlet.model.Classes;
import com.zumbaapp.servlet.model.Participant;

public class DB {

		Connection connection;
		PreparedStatement preparedStatement;
		
		public DB() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("[DB] Driver Loaded");
				
				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zumba_management", "root", "201155876");
				System.out.println("[DB] Connection created");
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			}
		}
			
		public void closeConnection() {
			try {
				connection.close();
				System.out.println("[DB] Connection to DB closed");
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			}
		}
		
		public int addClasses(Classes classes) {
			int result = 0;
			
			try {
			String sql = "INSERT INTO Classes VALUES (null, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, classes.name);
			preparedStatement.setString(2, classes.session);
			preparedStatement.setString(3, classes.date);
			preparedStatement.setString(4, classes.startTime);
			preparedStatement.setString(5, classes.endTime);
			preparedStatement.setString(6, classes.location);
			
			result = preparedStatement.executeUpdate();
			
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			}
			return result;
		}
		
		public int addParticipant(Participant participant) {
			int result = 0;
			
			try {
			String sql = "INSERT INTO Participant VALUES (null, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, participant.firstName);
			preparedStatement.setString(2, participant.lastName);
			preparedStatement.setString(3, participant.email);
			preparedStatement.setString(4, participant.phone);
			preparedStatement.setString(5, participant.zumbaClass);
			
			result = preparedStatement.executeUpdate();
			
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			}
			return result;
		}
		
		public ArrayList<Classes> fetchAllClasses() {
			ArrayList<Classes> zumbaClasses = new ArrayList<>();
			try {
				String sql = "SELECT * FROM Classes";
				preparedStatement = connection.prepareStatement(sql);
				
				ResultSet set = preparedStatement.executeQuery();
				
				while(set.next()) {
					Classes classes = new Classes();
					classes.id = set.getInt(1);
					classes.name = set.getString(2);
					classes.session = set.getString(3);
					classes.date = set.getString(4);
					classes.startTime = set.getString(5);
					classes.endTime = set.getString(6);
					classes.location = set.getString(7);
					
					zumbaClasses.add(classes);
					
				}
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			
			}
			return zumbaClasses;
		}
		
		public ArrayList<Participant> fetchAllParticipants() {
			ArrayList<Participant> zumbaParticipants = new ArrayList<>();
			try {
				String sql = "SELECT * FROM Participant";
				preparedStatement = connection.prepareStatement(sql);
				
				ResultSet set = preparedStatement.executeQuery();
				
				while(set.next()) {
					Participant participant = new Participant();
					participant.id = set.getInt(1);
					participant.firstName = set.getString(2);
					participant.lastName = set.getString(3);
					participant.email = set.getString(4);
					participant.phone = set.getString(5);
					participant.zumbaClass = set.getString(6);

					zumbaParticipants.add(participant);
				}
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			
			}
			return zumbaParticipants;
		}
		
		public int deleteClasses(int id) {
			int result = 0; 
			try {
				String sql = "DELETE FROM Classes WHERE id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				
				preparedStatement.executeUpdate();
				
				result = preparedStatement.executeUpdate();
				
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			}
			return result;
	}
		
		public int deleteParticipant(int id) {
			int result = 0; 
			try {
				String sql = "DELETE FROM Participant WHERE id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				
				preparedStatement.executeUpdate();
				
				result = preparedStatement.executeUpdate();
				
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			}
			return result;
	}
		
		public Classes fetchClass(int id) {
			
			Classes classes = new Classes();
			
			try {
				String sql = "SELECT * FROM Classes WHERE id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				
				ResultSet set = preparedStatement.executeQuery();
				
				while(set.next()) {
					classes.id = set.getInt(1);
					classes.name = set.getString(2);
					classes.session = set.getString(3);
					classes.date = set.getString(4);
					classes.startTime = set.getString(5);
					classes.endTime = set.getString(6);
					classes.location = set.getString(7);
				}
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			
			}
			return classes;
		}
		
		public Participant fetchParticipant(int id) {
			Participant participant = new Participant();
			try {
				String sql = "SELECT * FROM Participant WHERE id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				
				ResultSet set = preparedStatement.executeQuery();
				
				while(set.next()) {
					participant.id = set.getInt(1);
					participant.firstName = set.getString(2);
					participant.lastName = set.getString(3);
					participant.email = set.getString(4);
					participant.phone = set.getString(5);
					participant.zumbaClass = set.getString(6);
				}
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			
			}
			return participant;
		}
		
		public int saveClasses (Classes classes) {
			int result = 0;
			
			try {
				String sql = "UPDATE Classes SET name = ?, session = ?, date = ?, startTime = ?, endTime = ?, location = ? WHERE id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, classes.name);
				preparedStatement.setString(2, classes.session);
				preparedStatement.setString(3, classes.date);
				preparedStatement.setString(4, classes.startTime);
				preparedStatement.setString(5, classes.endTime);
				preparedStatement.setString(6, classes.location);
				preparedStatement.setInt(7, classes.id);
		
				result = preparedStatement.executeUpdate();
				
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			}
			
			return result;
		}
		
		public int saveParticipant (Participant participant) {
			int result = 0;
			
			try {
				String sql = "UPDATE Participant SET firstName = ?, lastName = ?, email = ?, phone = ?, zumbaClass = ? WHERE id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, participant.firstName);
				preparedStatement.setString(2, participant.lastName);
				preparedStatement.setString(3, participant.email);
				preparedStatement.setString(4, participant.phone);
				preparedStatement.setString(5, participant.zumbaClass);
				preparedStatement.setInt(6, participant.id);
		
				result = preparedStatement.executeUpdate();
				
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
			}
			
			return result;
		}
		
}
