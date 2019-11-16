package com.senac.pdv.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuelson
 */
public class ConnectionPDVFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://162.241.2.208:3306/wilcsfib_pdv2";
    private static final String USER = "wilcsfib_pdv";
    private static final String PASS = "poopdv";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPDVFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPDVFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPDVFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}



/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPDVFactory {

	private final static String JDBC_CONN_STRING = "jdbc:mysql://162.241.2.208:3306/wilcsfib_pdv2";
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
*/