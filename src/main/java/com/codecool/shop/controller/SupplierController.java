package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.service.ProductService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/supplier"})
public class SupplierController extends HttpServlet {

    private final ProductDao productDataStore = ProductDaoMem.getInstance();
    private final ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
    private final SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
    ProductService productService = new ProductService(productDataStore, productCategoryDataStore, supplierDataStore);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson((productService.getProductsForSupplier(Integer.parseInt(request.getParameter("supplier")))));
        out.println(json);
    }
}


