package com.onlineShopping;

public class User {
	public String name;
	private int mobile;
	private String email;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, int mobile, String email, String password) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
