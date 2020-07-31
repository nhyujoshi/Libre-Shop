/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.personal.onlineshopping.dao;
import org.personal.onlineshopping.model.Products;
import java.util.List;

/**
 *
 * @author User
 */
public interface ProductDao {
    List<Products> readall(int categoryId) throws Exception;
}
