package com.onlineShopping;


import java.util.Scanner;

public class Register extends Show {
	String name;

	public void getDetails() {
		Scanner sc = new Scanner(System.in);
		User user = new User();
		System.out.println("Enter your name ");
		String name = sc.next();

		System.out.println("Enter your Email");
		String email = sc.next();
		System.out.println("Enter your Password");
		String password = sc.next();
		System.out.println("Enter your mobile number");
		int mobile = sc.nextInt();

		user.setMobile(mobile); // user.setEmail(email);
		user.setPassword(password);

		user.setName(name);
		System.out.println(user.getName());
		System.out.println(user.getMobile());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());

	}

	@Override
	public void display() {

	}

}

