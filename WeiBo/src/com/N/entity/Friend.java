package com.N.entity;

public class Friend {
	private int id;
	private String f_name;
	
	public Friend() {
		
	}
	
	public Friend(int _id, String _f_name) {
		id = _id;
		f_name = _f_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	
}
