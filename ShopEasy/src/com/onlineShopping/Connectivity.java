package com.onlineShopping;

	import java.sql.Connection;
	import java.sql.SQLException;

	public interface Connectivity {

	Connection getConnectionDetail() throws SQLException;


	}



