package com.senac.pdv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPDVFactory {

	private final static String JDBC_CONN_STRING = "jdbc:mysql://162.241.2.208:3306/wilcsfib_pdv";
	private final static String JDBC_DB_USER = "wilcsfib_pdv";
	private final static String JDBC_DB_PASSWORD = "poopdv";

	protected static Connection getConnection() {
		try {
			return DriverManager.getConnection(JDBC_CONN_STRING, JDBC_DB_USER, JDBC_DB_PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}

}
