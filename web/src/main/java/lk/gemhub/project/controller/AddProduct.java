package lk.gemhub.project.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.gemhub.project.model.Product;
import lk.gemhub.project.remote.ProductService;

import java.io.IOException;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
    @EJB
    private ProductService productService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("product_id"));
        String name = request.getParameter("product_name");
        Double price = Double.parseDouble(request.getParameter("starting_price"));
        String description = request.getParameter("description");

        Product product = new Product(id, name, description, price);
        productService.saveProduct(product);

        response.sendRedirect("dashboard.jsp");


    }
}
