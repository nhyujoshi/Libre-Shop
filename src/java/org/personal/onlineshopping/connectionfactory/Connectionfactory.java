/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.personal.onlineshopping.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Connectionfactory {
        private static final String URL = "jdbc:mysql://localhost:3306/shoppingcart";

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

    
}
