package com.codecool.shop.controller;

import com.codecool.shop.service.ProductService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/category"})
public class CategoryController extends HttpServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        new ProductService();
        String json = new Gson().toJson((productService.getProductsForCategory(Integer.parseInt(request.getParameter("category")))));
        out.println(json);
    }
}




