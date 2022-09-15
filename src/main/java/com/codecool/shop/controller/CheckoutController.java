package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderDetail;
import com.codecool.shop.model.Product;

import com.codecool.shop.model.User;
import com.codecool.shop.service.LogService;
import com.codecool.shop.service.ProductService;
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
    ProductService productService = new ProductService();

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO: implement saving with existing user
        HttpSession session = request.getSession();
        int userId;
        if (session.getAttribute("user") != null) {
            var user = (User) session.getAttribute("user");
            userId = user.getId();
        } else {
            userId = 0;
        }
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String address = request.getParameter("address");
        String zipCode = request.getParameter("zip");
        String state = request.getParameter("state");
        String cardName = request.getParameter("cardname");
        String cardNumber = request.getParameter("cardnumber");
        String expMonth = request.getParameter("expmonth");
        String expYear = request.getParameter("expyear");
        String cvv = request.getParameter("cvv");
        Order order = new Order(name, userId, email, city, address, zipCode, state, cardName, cardNumber, expMonth, expYear, cvv);
        int cartId = productService.saveOrder(order);
        if (session.getAttribute("cart") != null){
            Map<Product, Integer> products = (Map<Product, Integer>) session.getAttribute("cart");
            for (Map.Entry<Product, Integer> product : products.entrySet()) {
            OrderDetail orderDetail = new OrderDetail(product.getKey().getId(), product.getValue(), cartId);
            productService.saveOrderDetails(orderDetail);
        }
            ((Map<?, ?>) session.getAttribute("cart")).clear();
        }
        response.sendRedirect("/confirm");
    }

}

