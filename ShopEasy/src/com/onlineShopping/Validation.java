package com.onlineShopping;

import java.util.Scanner;

public class Validation {
	static Scanner sc = new Scanner(System.in);
	static Register register = new Register();
	static String email;
	static String phoneNumber;

	static void validateEmail() {

		System.out.println("Enter your Email: ");
		email = sc.next();
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		boolean result = email.matches(regex);
		if (result) {
		} else {
			System.out.println("\t\tPlease enter valid email address\n");
			
			Validation.validateEmail();

		}
	}

	static void validMobile() {
		System.out.println("Enter your mobile number");
		phoneNumber = sc.next();
		String regex = "(0/91)?[7-9][0-9]{9}";
		if (phoneNumber.matches(regex) == false) {
			System.out.println(" \t\t Please Enter valid phone number\n");
			Validation.validMobile();

		}
	}

}
