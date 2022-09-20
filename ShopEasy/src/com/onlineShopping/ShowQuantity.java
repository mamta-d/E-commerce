package com.onlineShopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowQuantity {
	PreparedStatement ps = null;
	Connection connection = null;

	public void quanity() {

		try {
			ConnectionTest test = new ConnectionTest();
			connection = test.getConnectionDetail();
			ps = connection.prepareStatement("select name,quantity from product  ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Mobile name      = " + rs.getString(1));
				System.out.println("Mobile Quantity  = " + rs.getInt(2));
				System.out.println("-----------------------------------------------------------------------");
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
