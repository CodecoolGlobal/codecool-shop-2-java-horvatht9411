package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.LogService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    private Map<Product, Integer> cart = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            WebContext context = new WebContext(request, response, request.getServletContext());

            if (session.getAttribute("cart") != null) {
                cart = (Map<Product, Integer>) session.getAttribute("cart");

                int bigTotal = 0;
                for (Product product : cart.keySet()) {
                    int itemTotal = product.getDefaultPrice() * cart.get(product);
                    bigTotal += itemTotal;
                }

                context.setVariable("cartItems", cart);
                context.setVariable("cartSize", cart.values().stream().reduce(0, Integer::sum));
                context.setVariable("bigTotal", bigTotal);
            }

            TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
            engine.process("product/checkout.html", context, response.getWriter());
        } catch (IOException e) {
            LogService.log(e);
        }
    }
}

