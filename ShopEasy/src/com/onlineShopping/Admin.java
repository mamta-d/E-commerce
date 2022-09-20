package com.onlineShopping;

import java.util.Scanner;

public class Admin {
	private static String username = "mamta";
	private String password = "admin";
	char choice;

	public void adminLoggin() {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter username");
			String name = sc.next();
			System.out.println("Enter Password");
			String pw = sc.next();
			if (username.equals(name)&&password.equals(pw)) {
				 
				System.out.println("\t\t\t\t\t SUCCESSFULLY LOGIN");
			}else {
				System.out.println("\t\tUsername or password is  incorrect please Try again.....");
				adminLoggin();
			}
do {System.out.println("----------------------------------------------------------------------");
			System.out.println("1.To Check Quantity of Products");
			System.out.println("2.To see User Register List");
			System.out.println("3.To see user Purchasing History");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				ShowQuantity sq=new ShowQuantity();
				sq.quanity();
				break;
			case 2:
				ShowUser user= new ShowUser();
				user.user();
				break;
			case 3:PurchasingHistory p=new PurchasingHistory();
				p.userHistory();
				break;
			default:
				System.out.println("Enter correct Choice");
				break;

			}
			System.out.println("Do you want to Continue");
			System.out.println("1.Yes");
			System.out.println("2.No");
			choice = sc.next().charAt(0);
		} while (choice == 'Y' || choice == 'y');
System.out.println("************************Thank You************************");
	}
}
