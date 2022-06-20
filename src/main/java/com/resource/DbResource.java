package com.resource;

import java.sql.Connection;
import java.sql.DriverManager;

//this is generic class to connect db
public class DbResource {

	public static Connection getDbConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_avm_db", "root", "root");

			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
}
