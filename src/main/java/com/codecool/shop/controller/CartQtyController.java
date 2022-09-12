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

@WebServlet(urlPatterns = {"/api/addToCart/*", "/api/cartQty", "/api/editCart/*", "/api/removeFromCart/*"})
public class CartQtyController extends HttpServlet {
    private Map<Product, Integer> cart = new HashMap<>();
    private final ProductDao productDataStore = ProductDaoMem.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = ControllerUtil.initResponse(response);
        int quantity = getCartQty();
        String var = new Gson().toJson(quantity);
        out.println(var);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = ControllerUtil.initResponse(response);

        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            cart = (Map<Product, Integer>) session.getAttribute("cart");
        }

        int productId = ControllerUtil.retrieveProductId(request);
        Product product = productDataStore.find(productId);
        cart.put(product, cart.getOrDefault(product, 0) + 1);
        session.setAttribute("cart", cart);

        int quantity = getCartQty();
        String json = new Gson().toJson(quantity);
        out.println(json);
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = ControllerUtil.initResponse(response);

        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            cart = (Map<Product, Integer>) session.getAttribute("cart");
        }

        int productId = ControllerUtil.retrieveProductId(request);
        Product updatedProduct = cart.keySet()
                .stream()
                .filter(product -> product.getId() == productId).findFirst().orElse(null);
        String updatedQuantity = ControllerUtil.inputStreamToString(request.getInputStream());
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

    private int getCartQty() {
        return cart.values().stream().reduce(0, Integer::sum);
    }
}
