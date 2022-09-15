package com.codecool.shop.controller;

import com.codecool.shop.model.Product;
import com.codecool.shop.service.LogService;
import com.codecool.shop.service.ProductService;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/api/cartQty", "/api/editCart/*"})
public class CartQtyController extends HttpServlet {
    private final ProductService productService = new ProductService();
    private Map<Product, Integer> cart = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            int quantity = getCartQty();
            ControllerUtil.initResponse(response, quantity);
        } catch (NullPointerException e) {
            LogService.log(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("cart") != null) {
                cart = (Map<Product, Integer>) session.getAttribute("cart");
            }

            int productId = ControllerUtil.retrieveProductId(request);
            Product product = productService.findProduct(productId);
            checkCart(productId, product);

            session.setAttribute("cart", cart);
            System.out.println(cart);

            int quantity = getCartQty();
            ControllerUtil.initResponse(response, quantity);
        } catch (NullPointerException e) {
            LogService.log(e);
        }
    }

    private void checkCart(int productId, Product product) {
        if (!cart.isEmpty()) {
            for (Map.Entry<Product, Integer> item : cart.entrySet()) {
                if (item.getKey().getId() == productId) {
                    var value = item.getValue();
                    item.setValue(value + 1);
                }
            }
            int counter = 0;
            for (Product item : cart.keySet()) {
                if (item.getId() == productId) {
                    counter++;
                }
            }
            if (counter == 0) cart.put(product, 1);
        } else {
            cart.put(product, 1);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("cart") != null) {
                cart = (Map<Product, Integer>) session.getAttribute("cart");
            }
            int productId = ControllerUtil.retrieveProductId(request);
            Product updatedProduct = cart.keySet().stream().filter(product -> product.getId() == productId).findFirst().orElse(null);
            String updatedQuantity = ControllerUtil.inputStreamToString(request.getInputStream());
            cart.put(updatedProduct, Integer.valueOf(updatedQuantity));

            session.setAttribute("cart", cart);

            assert updatedProduct != null;
            int itemTotal = calculateItemTotal(updatedProduct);
            int bigTotal = calculateBigTotal();
            int[] totals = {itemTotal, bigTotal};
            ControllerUtil.initResponse(response, totals);
        } catch (NullPointerException | IOException e) {
            LogService.log(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("cart") != null) {
                cart = (Map<Product, Integer>) session.getAttribute("cart");
            }
            int productId = ControllerUtil.retrieveProductId(request);
            Product deletedProduct = cart.keySet().stream().filter(item -> item.getId() == productId).findFirst().orElse(null);
            cart.remove(deletedProduct);
            session.setAttribute("cart", cart);
            int bigTotal = calculateBigTotal();
            ControllerUtil.initResponse(response, bigTotal);
        } catch (NullPointerException e) {
            LogService.log(e);
        }
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
