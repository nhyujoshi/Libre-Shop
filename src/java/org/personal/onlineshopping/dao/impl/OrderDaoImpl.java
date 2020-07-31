/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.personal.onlineshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.personal.onlineshopping.connectionfactory.Connectionfactory;

import org.personal.onlineshopping.dao.OrdersDao;
import org.personal.onlineshopping.model.Orders;

public class OrderDaoImpl implements OrdersDao {

    private static Connection connection;

    private static PreparedStatement preparedStatement;

    @Override
    public int insert(Orders order) throws Exception {
        final String QUERY = "INSERT INTO orders (product_id, quantity, price) VALUES (?,?,?)";
        connection = Connectionfactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, order.getProducts().getId());
        preparedStatement.setInt(2, 12);
        preparedStatement.setDouble(3, 120);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int count() throws Exception {
        final String QUERY = "select count(*) as count from orders";
        connection = Connectionfactory.getConnection();
        ResultSet rs = connection.prepareStatement(QUERY).executeQuery();
        rs.next();
        return rs.getInt("count");
    }

}
