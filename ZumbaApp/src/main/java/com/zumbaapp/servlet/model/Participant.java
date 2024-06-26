package com.zumbaapp.servlet.model;

public class Participant {
	
	public int id;
	public String firstName;
	public String lastName;
	public String email;
	public String phone;
	public String zumbaClass;
	
	public Participant() {

	}

	public Participant(int id, String firstName, String lastName, String email, String phone, String zumbaClass) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.zumbaClass = zumbaClass;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", zumbaClass=" + zumbaClass + "]";
	}

}
