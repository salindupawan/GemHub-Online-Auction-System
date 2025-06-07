package lk.gemhub.project.controller;

import com.google.gson.Gson;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.gemhub.project.model.Product;
import lk.gemhub.project.remote.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class LoadProducts extends HttpServlet {
    @EJB
    private ProductService productService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> products = productService.getProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
