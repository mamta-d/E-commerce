package com.onlineShopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PurchasingHistory {
	PreparedStatement ps = null;
	Connection connection = null;
	public void userHistory() {
		Scanner sc= new Scanner(System.in);
		System.out.println("\t\t\t\tEnter user Id ");
		int id=sc.nextInt();
		try {
			ConnectionTest test = new ConnectionTest();
			connection = test.getConnectionDetail();
			ps = connection.prepareStatement("select name from user where user_id= ?   ");
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println(" User Name    = "+rs.getString(1));
				}

			ps = connection.prepareStatement("select order_id,product_ids from orders where user_id=?");
            ps.setInt(1, id);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				
				System.out.println(" Order Id       = "+rs1.getInt(1));
				System.out.println(" Product Id     = "+rs1.getString(2));
				System.out.println("------------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

}
}