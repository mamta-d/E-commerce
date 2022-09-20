package com.onlineShopping;
import java.sql.SQLIntegrityConstraintViolationException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	
	static  Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, InterruptedException {
		int login=0;
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		Product p = new Product();
		System.out.println(
				"************************************* WELCOME TO SHOPEASY*************************************\n\n");
		System.out.println("\t\t\t\t\t1.Admin LogIn");
		System.out.println("\t\t\t\t\t2.User LogIn");
		try {
		login=sc.nextInt();
		 Login log = new Login();
		
		if(login==1) {
			Admin admin = new Admin();
			admin.adminLoggin();
			System.exit(0);
		}
		else { 
			log.existingUser1();
			
			}
		 
		}catch(InputMismatchException i) {
			
			
			System.out.println("\n                                Please enter Integer value");
		}
		
		}
		}

