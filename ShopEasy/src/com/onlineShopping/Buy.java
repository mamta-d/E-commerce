package com.onlineShopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Buy  {
	Scanner sc = new Scanner(System.in);
	Register register = new Register();
	PreparedStatement ps = null;
	Connection connection = null;
	char c;
	int iteam;
	int id;
	int quantity;
	int mobileId;
	int OldmobileQty;
	Cart cart = new Cart();
	
	public Buy(int id) {
		
	}

	public Buy() {
		// TODO Auto-generated constructor stub
	}

	public int accessProductDetail() throws SQLException {
		do {	
			System.out.println("\t\t\tPlease Enter product id which you want to buy");
			id = sc.nextInt();
			String sql1 = "select * from product where product_id =?";
			try {
				ConnectionTest test = new ConnectionTest();
				connection = test.getConnectionDetail();
				ps = connection.prepareStatement(sql1);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("Mobile id        = " + rs.getInt(1));
					mobileId = rs.getInt(1);//
					System.out.println("Mobile name      = " + rs.getString(2));
					System.out.println("Mobile price     = " + rs.getInt(3));
					System.out.println("Mobile Feature   =" + rs.getString(4));
					System.out.println("Mobile Quantity  = " + rs.getInt(5));
					OldmobileQty = rs.getInt(5);
					System.out.println("\n");
				}
				// System.out.println("fetch successfully...." + query.next());

				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			Buy buy = new Buy();
			System.out.println("Enter no of Items");
			iteam = sc.nextInt();
		
			cart.setRecords(id,iteam );

			buy.updateRemove(mobileId,OldmobileQty,iteam);//

			System.out.println("Do you want to continue shopping...");
			System.out.println("1.yes");
			System.out.println("2.no");
			c = sc.next().charAt(0);
		} while (c == 'Y' || c == 'y');
		System.out.println("Thank you for choosing SHOPEASY....");
		System.out.println("Product in your cart --->");
		LinkedHashMap lh=cart.getRecords();
		Set<Integer> set= lh.keySet();
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			int i=itr.next();
			System.out.println("Your Mobile Phone Id is-->" +i);
			System.out.println("You buy "+lh.get(i) +" Products");
		}
		
		return mobileId;
	}

	// ---------------------------------------------------------------------------------------------------
	public void updateRemove(int ID, int TotalQty, int BuyingQty) throws SQLException {
		ConnectionTest test = new ConnectionTest();		connection = test.getConnectionDetail();
		PreparedStatement ps = connection.prepareStatement("update product set quantity = ? where product_id=?");
		ps.setInt(1, TotalQty - BuyingQty);
		ps.setInt(2, ID);
		int i = ps.executeUpdate();

	}
	//--------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}