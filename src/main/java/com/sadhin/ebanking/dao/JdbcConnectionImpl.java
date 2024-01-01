package com.sadhin.ebanking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionImpl {
    public static Connection connection=null;
    private  void jdbcConnectionImpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/e-banking";
            String username = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  Connection getConnection(){
        if(connection==null){
            jdbcConnectionImpl();
        }
        return connection;
    }
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
