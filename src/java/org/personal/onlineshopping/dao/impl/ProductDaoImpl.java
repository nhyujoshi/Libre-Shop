/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.personal.onlineshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.personal.onlineshopping.connectionfactory.Connectionfactory;
import org.personal.onlineshopping.dao.ProductDao;
import org.personal.onlineshopping.model.Category;
import org.personal.onlineshopping.model.Products;

/**
 *
 * @author User
 */
public class ProductDaoImpl implements ProductDao {
    
    private static Connection connection;

    private static PreparedStatement preparedStatement;
    @Override
    public List<Products> readall(int categoryId) throws Exception {
        List<Products> products = new ArrayList<>();
        final String QUERY = "SELECT *FROM products p inner join categories c on p.category_id = c.id where c.id = ?";
        connection = Connectionfactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, categoryId);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Products product = new Products();
            product.setId(rs.getInt("id"));
            Category category = new Category();
            category.setId(rs.getInt("category_id"));
            product.setCategory(category);
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setDetails(rs.getString("details"));
            product.setImage(rs.getString("image"));
            products.add(product);
        }
        return products;
    }

}
