package com.onlineShopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	PreparedStatement ps = null;
	Connection connection = null;
	ResultSet rs = null;
	String no;
	int uid;

	public void existingUser1() throws SQLException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		Product product = new Product();
		Register register = new Register();
		UserHistory history = new UserHistory();
		Buy buy = new Buy();
		System.out.println(
				"--------------------------------------------------------------------------------------------");

		System.out.println("\t\t\t\t\t1. New to SHOPEASY");
		System.out.println("\t\t\t\t\t2. Already a customer");
		int de = sc.nextInt();
		if (de == 1) {
			System.out.println(
					"--------------------------------------------------------------------------------------------");

			System.out.println("\t\t\t\t Please Register to see our Products ");
			register.getDetails();

			System.out.print("\t\t\t\tPlease wait...\n\t\t\t\tRegistering");
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				Thread.sleep(200);
			}
			System.out.println(
					"\n\n************************************* OUR PRODUCTS*************************************\n\n");
			System.out.println();
			product.display();
			System.out.println("\n\t\t\t\tSelect products....");
			int user_id = register.user_id;
			buy.accessProductDetail(user_id);

		} else {

			System.out.println("Please Enter your Mobile number");
			no = sc.next();
			System.out.println("Enter your Password");
			String password = sc.next();
			try {
				ConnectionTest test = new ConnectionTest();
				connection = test.getConnectionDetail();
				ps = connection.prepareStatement("select password from user where mobile =? ");
				ps.setString(1, no);
				rs = ps.executeQuery();
				rs.next();
				int i = 1;
				String existigpassword = rs.getNString("password");
				if (password.equals(existigpassword)) {
					System.out.println("                             LOGIN SUCCESSFULL.......\n\n");
					System.out.println(
							"************************************* WELCOME TO SHOPEASY*************************************\n\n");
					do {
						System.out.println("\n");
						System.out.println("Enter 1 to see your purchase History");
						System.out.println("Enter 2 to Buy new products");
						System.out.println("Enter 3 to Sign Out");
						int choice = sc.nextInt();
						

						switch (choice) {
						case 1:
							System.out.println("                    Account Detail       ");

							ps = connection.prepareStatement("select name, mobile,user_id from user where mobile= ?");
							ps.setString(1, no);
							rs = ps.executeQuery();
							System.out.println("------------------------------------------------------------");
							while (rs.next()) {
								System.out.println(" User Name              = " + rs.getString(1));
								System.out.println(" Mobile No.             = " + rs.getString(2));
								System.out.println(" User Id                = " + rs.getInt(3));
								uid = rs.getInt(3);
							}
							ps = connection.prepareStatement("select order_id,product_ids from orders where user_id=?");
							ps.setInt(1, uid);
							ResultSet rs1 = ps.executeQuery();
							while (rs1.next()) {

								System.out.println(" Order Id               = " + rs1.getInt(1));
								System.out.println(" Purchased Product Id   = " + rs1.getString(2));
								System.out.println("------------------------------------------------------------");
							}
							break;
						case 2:
							System.out.println(
									"\n\n************************************* OUR PRODUCTS*************************************\n\n");
							System.out.println();
							product.display();
							System.out.println("\n\t\t\t\tSelect products....");
							int user_id = register.user_id;
							buy.accessProductDetail(user_id);
							break;
						case 3:
							System.out.print(" \t\t\t\t\t Signing  out");
							for (int j = 0; i < 10; i++) {
								System.out.print(".");
								Thread.sleep(200);}
							System.out.println("\n");
							System.out.println(
									"************************************ THANK YOU FOR CHOOSING SHOPEASY ************************************");
							System.out.println(
									"                                                Visit Again                   ");
							
							
							System.exit(0);
						}
					} while (i <= 3);

				} else {
					System.out.println(" Please enter correct Password");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
