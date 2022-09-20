package com.onlineShopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Buy {
	Scanner sc = new Scanner(System.in);
	Register register = new Register();
	PreparedStatement ps = null;
	Connection connection = null;
	Statement st = null;
	ResultSet rs = null;
	char c;
	int iteam;
	int id;
	int quantity;
	int mobileId;
	int OldmobileQty;
	String productName;
	int price=0;
	Cart cart = new Cart();

	public int accessProductDetail(int UserID) throws SQLException {
//Select data from which user enter id-----------------------------------------------		
		do {
			System.out.println("\t\t\t\tPlease Enter product ID");
			id = sc.nextInt();
			String sql1 = "select * from product where product_id =?";
			try {
				ConnectionTest test = new ConnectionTest();
				connection = test.getConnectionDetail();
				ps = connection.prepareStatement(sql1);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("Mobile id        = " + rs.getInt(1));
					mobileId = rs.getInt(1);//
					System.out.println("Mobile name       = " + rs.getString(2));
					productName = rs.getString(2);
					System.out.println("Mobile price      = " + rs.getInt(3));
					price = rs.getInt(3);
					System.out.println("Mobile Feature    =" + rs.getString(4));
					System.out.println("Mobiles In Stock  = " + rs.getInt(5));
					OldmobileQty = rs.getInt(5);
					System.out.println("\n");
				}

				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			Buy buy = new Buy();
			System.out.println("\t\t\t\tEnter no of Items");
			iteam = sc.nextInt();
			cart.setRecords(id, iteam);
			System.out.println("Do you want to continue shopping...");
			System.out.println("1.yes");
			System.out.println("2.no");
			price = 0 + price;
			c = sc.next().charAt(0);
		} while (c == 'Y' || c == 'y');

//linkesHashMap Implementation----------------------------------------------------------------------

		System.out.println("\t\t\t\tProduct in your cart\n\n");
		LinkedHashMap lh = cart.getRecords();
		Set<Integer> set = lh.keySet();
		Iterator<Integer> itr = set.iterator();

		while (itr.hasNext()) {
			int i = itr.next();
			System.out.println("Your Mobile Phone Id is = \n" + i);
			System.out.println("You buy " + lh.get(i) + " Products");
			System.out.println("--------------------------------------------------------------------");
		}

//code for order confirmation----------------------------------------------------------------------		

		System.out.println("\t\t\t\tCONFIRM YOUR ORDER");
		System.out.println("1.Yes");
		System.out.println("1.No");
		char ch = sc.next().charAt(0);
		if (ch == 'Y' || ch == 'y') {
			Buy buy = new Buy();
			buy.updateRemove(mobileId, OldmobileQty, iteam);
			buy.confirmOrder(lh, UserID);
			System.out.println(
					"************************************ THANK YOU FOR CHOOSING SHOPEASY ************************************");
			System.out.println("                                                 Visit Again                   ");
		} else {

			System.out.println(
					"************************************ THANK YOU FOR CHOOSING SHOPEASY ************************************");
			System.out.println("                                                 Visit Again                   ");
		}

		return mobileId;

	}
	// ---------------------------------------------------------------------------------------------------

	public void updateRemove(int ID, int TotalQty, int BuyingQty) throws SQLException {
		ConnectionTest test = new ConnectionTest();
		connection = test.getConnectionDetail();
		PreparedStatement ps = connection.prepareStatement("update product set quantity = ? where product_id=?");
		ps.setInt(1, TotalQty - BuyingQty);
		ps.setInt(2, ID);
		int i = ps.executeUpdate();

	}
	// --------------------------------------------------------------------------------

	public void confirmOrder(Map<Integer, Integer> map, int UserID) throws SQLException {
		ConnectionTest test = new ConnectionTest();
		connection = test.getConnectionDetail();
		String productIds = "";
		int totalPrice=0;
		for (int productId : map.keySet()) {
			String temp = "";
			for (int i = map.get(productId); i > 0; i--) {
				temp += productId + " ";

			}
			
			productIds+=temp;
			ps=connection.prepareStatement("select price from product where product_id=?");
			ps.setInt(1,productId);
			rs=ps.executeQuery();
			if(rs.next()) {
				totalPrice +=rs.getInt(1)*map.get(productId);
			}
			rs.close();
		}
		
		Register r= new Register();
		ps= connection.prepareStatement("insert into orders (user_id,product_ids)values(?,?)");
		ps.setInt(1,UserID);
		ps.setString(2, productIds.trim());
		int i=ps.executeUpdate();
		System.out.println("Total Price is  Rs. "+totalPrice);
	}

}