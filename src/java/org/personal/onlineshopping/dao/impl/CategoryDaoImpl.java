/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.personal.onlineshopping.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.personal.onlineshopping.model.Category;
import org.personal.onlineshopping.dao.CategoryDao;
import org.personal.onlineshopping.connectionfactory.Connectionfactory;

/**
 *
 * @author User
 */
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public List<Category> readAll() throws Exception {
        Connection connection;
        List<Category> categories = new ArrayList<>();
        final String QUERY = "SELECT *FROM categories";
        connection = Connectionfactory.getConnection();
        ResultSet rs = connection.prepareStatement(QUERY).executeQuery();
        while (rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            categories.add(category);
        }
        return categories;
    }
}
