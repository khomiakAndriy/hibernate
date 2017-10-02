package com.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "user";
        String pass = "password";


        try {
            System.out.println("Connection to: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Successful connection! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
