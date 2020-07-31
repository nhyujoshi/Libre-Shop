/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.onlineshopping.controller.CategoryController;
import org.personal.onlineshopping.dao.CategoryDao;
import org.personal.onlineshopping.dao.ProductDao;
import org.personal.onlineshopping.dao.impl.CategoryDaoImpl;
import org.personal.onlineshopping.dao.impl.ProductDaoImpl;

/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/"})
public class DefaultController extends HttpServlet {
    
    private final CategoryDao categoryDao = new CategoryDaoImpl();
    
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("categories", categoryDao.readAll());
            request.setAttribute("products", productDao.readall(1));
        } catch (Exception ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
