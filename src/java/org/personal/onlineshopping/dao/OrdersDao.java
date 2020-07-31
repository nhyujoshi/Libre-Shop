/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.personal.onlineshopping.dao;

import org.personal.onlineshopping.model.Orders;

/**
 *
 * @author User
 */
public interface OrdersDao {
    
    int insert(Orders order) throws Exception;
    
    int count() throws Exception;
}
