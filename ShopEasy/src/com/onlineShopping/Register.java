package com.onlineShopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class Register {
	static String name;
	String email;
	private String password;
	String mobile;
	int user_id;
	Scanner sc = new Scanner(System.in);
	User user = new User();
	PreparedStatement ps = null;
	Connection connection = null;

	public int getDetails() {
		System.out.println("Enter your name ");
		name = sc.next();
		Validation.validateEmail();
		System.out.println("Enter your Password");
		this.password = sc.next();
		Validation.validMobile();
		user.setMobile(Validation.phoneNumber);
		user.setEmail(Validation.email);
		user.setPassword(password);
		user.setName(name);
		user_id = 0;

		Register register = new Register();
		try {
			user_id = register.insertUserData(name, Validation.phoneNumber, Validation.email, password,
					register.user_id);

		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("\t\t\t\t Mobile Number is already Exist...");
				System.out.println("\t\t\t\tPlease Enter new Number ");
				} else {
				// Other SQL Exception
			}
		}
		return user_id;

	}

	// ----------------------------------------------------------------------------------
	public int insertUserData(String name, String mobile, String Email, String password, int user_id)
			throws SQLException {
		ConnectionTest test = new ConnectionTest();
		connection = test.getConnectionDetail();
		int int1 = 0;
		try {
			ps = connection.prepareStatement("select max(user_id) from user");
			ResultSet rs = ps.executeQuery();
			rs.next();
			ps = connection
					.prepareStatement("insert into user(name,mobile,Email,password,user_id)" + "values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, mobile);
			ps.setString(3, Email);
			ps.setString(4, password);
			ps.setInt(5, rs.getInt(1) + 1);
			int i = ps.executeUpdate();

			ps = connection.prepareStatement("select user_id from user where Email =?");
			ps.setString(1, Email);
			rs = ps.executeQuery();
			rs.next();
			int1 = rs.getInt(1);
			ps.close();
			rs.close();
		} 
		catch (SQLException e) {
			System.out.println(" \t\t\tThis Phone nemuber is already exist");
			System.out.println("\t\t\t\t Please try with new Number");
			System.exit(0);
		}

		return int1;

	}

}