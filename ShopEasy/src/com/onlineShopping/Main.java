package com.onlineShopping;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	static Buy buy = new Buy();

	public static void main(String[] args) throws SQLException, InterruptedException {
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		Product p = new Product();
		System.out.println(
				"************************************* WELCOME TO SHOPEASY*************************************\n\n");
		System.out.println("\t\t\t Please Register to see our Products ");
		Scanner sc = new Scanner(System.in);
		/*Register register = new Register();
		register.getDetails();
		System.out.print("\t\t\t\tPlease wait...\n\t\t\t\tRegistering");
		for (int i = 0; i < 10; i++) {
			System.out.print(".");
			Thread.sleep(500);

		}

		System.out.println(
				"\n\n************************************* OUR PRODUCTS*************************************\n\n");
		System.out.println();
		Product product = new Product();
		Thread.sleep(1500);
		product.display();*/
		System.out.println("\n\t\t\t\tSelect products....");
		
		System.out.println("1.YES");
		System.out.println("2.No");
		char choice=sc.next().charAt(0);
		if(choice=='Y'||choice=='y') {
			buy.accessProductDetail();
		}

	}
}