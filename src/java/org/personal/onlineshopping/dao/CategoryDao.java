/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.personal.onlineshopping.dao;

import java.util.List;
import org.personal.onlineshopping.model.Category;

/**
 *
 * @author User
 */
public interface CategoryDao {
    
    List<Category> readAll() throws Exception;
    
}
