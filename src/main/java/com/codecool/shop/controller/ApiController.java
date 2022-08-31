package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/api/addToCart", "/api/cartQty", "/api/removeFromCart", "/api/deleteCart"})
public class ApiController extends HttpServlet {
    private Map<Product, Integer> cart = new HashMap<>();
    private final ProductDao productDataStore = ProductDaoMem.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String servletPath = request.getServletPath();

        switch (servletPath) {

            case "/api/addToCart":
                int productId = Integer.parseInt(request.getParameter("id"));
                Product product = productDataStore.find(productId);
                cart.put(product, cart.getOrDefault(product, 0) + 1);
                session.setAttribute("cart", cart);

                int quantity = cart.values().stream().reduce(0, Integer::sum);
                String json = new Gson().toJson(quantity);
                out.println(json);
                break;

            case "/api/cartQty":
                if (session.getAttribute("cart") != null) {
                    cart = (Map<Product, Integer>) session.getAttribute("cart");
                }
                int cartQuantity = cart.values().stream().reduce(0, Integer::sum);
                String var = new Gson().toJson(cartQuantity);
                out.println(var);
                break;
        }
        out.flush();
    }
}
