package com.entity;

public class UserObject {
	private String username;
	private String password;
	private String phone;
	public UserObject(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
	}
	private int id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
