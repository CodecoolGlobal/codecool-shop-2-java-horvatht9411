package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductDTO;
import com.codecool.shop.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/api/category"})
public class CategoryController extends HttpServlet {
    private final ProductDao productDataStore = ProductDaoMem.getInstance();
    private final ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
    private final SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
    ProductService productService = new ProductService(productDataStore, productCategoryDataStore, supplierDataStore);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson((productService.getProductsForCategory(Integer.parseInt(request.getParameter("category")))));
        out.println(json);
    }
}
//         further information!!
//        List<ProductDTO> products = new ArrayList<>();
//        for (Product product : categories) {
//            products.add(new ProductDTO(product.getName(), product.getDescription(), product.getDefaultPrice(), product.getDefaultCurrency(), product.getImgURL()));
//        }




