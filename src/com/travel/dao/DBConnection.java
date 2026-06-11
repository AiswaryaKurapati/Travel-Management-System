package com.travel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/travel_management";
    private static final String USER = "root";
    private static final String PASSWORD = "Mysql@987";

    public static Connection getConnection()
            throws SQLException {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);

        }catch (ClassNotFoundException e) {
        	throw new SQLException(
                    "MySQL Driver Not Found",
                    e);
        }
    }
    public static void closeConnection(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch(Exception e) {
            e.printStackTrace();

        }
    }
}