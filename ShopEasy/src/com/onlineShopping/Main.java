package com.onlineShopping;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Hello......");
		System.out.println("Welcome To SHOPEASY....");
		System.out.println("Our products ...");
		System.out.println();
		Product product = new Product();
		product.display();
		System.out.println("Do you want to buy Mobiles");
		System.out.println("Enter   1) yes \n\t2) no");
		char choice = sc.next().charAt(0);
		if (choice == 'y' || choice == 'y') {
			System.out.println("Please Sign in to the ShopEasy");
			Register register = new Register();
			register.getDetails();

		} else {
			System.out.println("Thank you for visiting us...");
		}

	}
}