package com.zumbaapp.servlet.model;

import java.sql.Date;
import java.sql.Time;

public class Classes {

	public int id;
	public String name;
	public String session;
	public String date;
	public String startTime;
	public String endTime;
	public String location;
	
	public Classes() {
		
	}

	public Classes(int id, String name, String session, String date, String startTime, String endTime, String location) {

		this.id = id;
		this.name = name;
		this.session = session;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", session=" + session + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", location=" + location + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
