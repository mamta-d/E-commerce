package com.onlineShopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register extends Show {
	String name;
	String email;
	String password;
	String mobile;
	Scanner sc = new Scanner(System.in);
	User user = new User();
	PreparedStatement ps = null;
	Connection connection = null;

	public void getDetails() {
		System.out.println("Enter your name ");
		this.name = sc.next();
		Validation.validateEmail();
		System.out.println("Enter your Password");
		this.password = sc.next();
		Validation.validMobile();
		user.setMobile(Validation.phoneNumber);
		user.setEmail(Validation.email);
		user.setPassword(password);
		user.setName(name);
		Register register = new Register();
		try {
			register.insertUserData(name, Validation.phoneNumber, Validation.email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ----------------------------------------------------------------------------------
	public void insertUserData(String name, String mobile, String Email, String password) throws SQLException {
		ConnectionTest test = new ConnectionTest();
		connection = test.getConnectionDetail();
		try {
			ps = connection.prepareStatement("insert into user(name,mobile,Email,password)" + "values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, mobile);
			ps.setString(3, Email);
			ps.setString(4, password);
			int i = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void display() {

	}

}
