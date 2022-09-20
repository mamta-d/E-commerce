package com.onlineShopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowUser  {
	PreparedStatement ps = null;
	Connection connection = null;

	public void user() {

		try {
			ConnectionTest test = new ConnectionTest();
			connection = test.getConnectionDetail();
			ps = connection.prepareStatement("select * from user  ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Mobile Name      = " + rs.getString(1));
				System.out.println("Mobile Number    = " + rs.getString(2));
				System.out.println("Mobile Email-Id  = " + rs.getString(3));
				System.out.println("Password         = " + rs.getString(4));
				
				System.out.println("-----------------------------------------------------------------------");
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
