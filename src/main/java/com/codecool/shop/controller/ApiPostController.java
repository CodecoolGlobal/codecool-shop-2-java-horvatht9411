package com.codecool.shop.controller;

import com.codecool.shop.model.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@WebServlet(urlPatterns = {"/api/editCart/*"})
public class ApiPostController extends HttpServlet {
    private Map<Product, Integer> cart = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        if (session.getAttribute("cart") != null) {
            cart = (Map<Product, Integer>) session.getAttribute("cart");
        }

        int productId = retrieveProductId(req);
        Product updatedProduct = cart.keySet()
                .stream()
                .filter(product -> product.getId() == productId).findFirst().orElse(null);
        String updatedQuantity = inputStreamToString(req.getInputStream());
        cart.put(updatedProduct, Integer.valueOf(updatedQuantity));

        session.setAttribute("cart", cart);

        String json = new Gson().toJson("ok");
        out.println(json);
        out.flush();
    }

    private static int retrieveProductId(HttpServletRequest req) {
        String pathInfo = req.getPathInfo();
        if (pathInfo.startsWith("/")) {
            pathInfo = pathInfo.substring(1);
        }
        return Integer.parseInt(pathInfo);
    }

    private static String inputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
        return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
    }
}
