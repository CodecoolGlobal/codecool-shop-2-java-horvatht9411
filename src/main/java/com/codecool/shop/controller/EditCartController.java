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

@WebServlet(urlPatterns = {"/api/editCart/*", "/api/removeFromCart/*"})
public class EditCartController extends HttpServlet {
    private Map<Product, Integer> cart = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = ControllerUtil.initResponse(response);
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            cart = (Map<Product, Integer>) session.getAttribute("cart");
        }

        int productId = ControllerUtil.retrieveProductId(request);
        Product updatedProduct = cart.keySet()
                .stream()
                .filter(product -> product.getId() == productId).findFirst().orElse(null);
        String updatedQuantity = inputStreamToString(request.getInputStream());
        cart.put(updatedProduct, Integer.valueOf(updatedQuantity));

        session.setAttribute("cart", cart);

        assert updatedProduct != null;
        int itemTotal = calculateItemTotal(updatedProduct);
        int bigTotal = calculateBigTotal();
        int[] totals = {itemTotal, bigTotal};
        String json = new Gson().toJson(totals);
        out.println(json);
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = ControllerUtil.initResponse(response);
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            cart = (Map<Product, Integer>) session.getAttribute("cart");
        }
        int productId = ControllerUtil.retrieveProductId(request);
        Product deletedProduct = cart.keySet()
                .stream()
                .filter(item -> item.getId() == productId).findFirst().orElse(null);
        cart.remove(deletedProduct);
        session.setAttribute("cart", cart);
        int bigTotal = calculateBigTotal();
        String data = new Gson().toJson(bigTotal);
        out.println(data);
        out.flush();
    }

    private static String inputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
        return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
    }

    private int calculateItemTotal(Product product) {
        return product.getDefaultPrice() * cart.get(product);
    }

    private int calculateBigTotal() {
        int bigTotal = 0;
        for (Product product : cart.keySet()) {
            int itemTotal = calculateItemTotal(product);
            bigTotal += itemTotal;
        }
        return bigTotal;
    }
}