/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.personal.onlineshopping.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.onlineshopping.dao.CategoryDao;
import org.personal.onlineshopping.dao.ProductDao;
import org.personal.onlineshopping.dao.impl.CategoryDaoImpl;
import org.personal.onlineshopping.dao.impl.ProductDaoImpl;

/**
 *
 * @author User
 */
@WebServlet(name = "ProductController", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

    private final ProductDao productDao = new ProductDaoImpl();
    
    private final CategoryDao categoryDao = new CategoryDaoImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int categoryId = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("categories", categoryDao.readAll());
            request.setAttribute("products", productDao.readall(categoryId));
        } catch (Exception ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
