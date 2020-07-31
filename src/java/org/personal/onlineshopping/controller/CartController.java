/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.personal.onlineshopping.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.onlineshopping.dao.CategoryDao;
import org.personal.onlineshopping.dao.OrdersDao;
import org.personal.onlineshopping.dao.ProductDao;
import org.personal.onlineshopping.dao.impl.CategoryDaoImpl;
import org.personal.onlineshopping.dao.impl.OrderDaoImpl;
import org.personal.onlineshopping.dao.impl.ProductDaoImpl;
import org.personal.onlineshopping.model.Orders;
import org.personal.onlineshopping.model.Products;

/**
 *
 * @author User
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
    
    private final OrdersDao ordersDao = new OrderDaoImpl();
    
    private final CategoryDao categoryDao = new CategoryDaoImpl();
    
    private final ProductDao productDao = new ProductDaoImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Products products = new Products();
        products.setId(productId);
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        try {
            ordersDao.insert(new Orders(products));
            request.setAttribute("products", productDao.readall(categoryId));
            request.setAttribute("cartCount", ordersDao.count());
            request.getRequestDispatcher("/index.jsp").include(request, response);
            
        } catch (Exception ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
