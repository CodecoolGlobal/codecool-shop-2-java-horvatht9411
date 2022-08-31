//package com.codecool.shop.controller;
//
//import com.codecool.shop.dao.ProductDao;
//import com.codecool.shop.dao.implementation.ProductDaoMem;
//import com.codecool.shop.model.Product;
//import com.google.gson.Gson;
//import org.thymeleaf.context.WebContext;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet(urlPatterns = {
//        "/api/category",
////        "/api/asztalokesszekek",
////        "/api/aprocikkek",
////        "/api/bankstick&rodpod",
////        "/api/csalik",
////        "/api/dobozok",
////        "/api/eteteskellekei",
////        "/api/fejlampak",
////        "/api/horgaszbotok",
////        "/api/kapasjelzok",
////        "/api/kiegeszitok",
////        "/api/konyvek",
////        "/api/meritoszakok",
////        "/api/orsok",
////        "/api/ruhazat",
////        "/api/satrak",
////        "/api/tapogatorud",
////        "/api/taskak",
////        "/api/vasarlasiutalvány"
//        })
//public class CategoryController extends HttpServlet {
//
//    private final Map<Product, Integer> cart = new HashMap<>();
//    private final ProductDao productDataStore = ProductDaoMem.getInstance();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        HttpSession session = request.getSession();
//        String servletPath = request.getServletPath();
//        System.out.println(request);
//
//        switch (servletPath) {
//
//            case "/api/category":
//                int category = Integer.parseInt(request.getParameter("category"));
//                WebContext context = new WebContext(request, response, request.getServletContext());
//                context.setVariable("category", productService.getProductCategory(1));
//                Product product = productDataStore.find(productId);
//                cart.put(product, cart.getOrDefault(product, 0) + 1);
//                session.setAttribute("cart", cart);
//
//                int quantity = cart.values().stream().reduce(0, Integer::sum);
//                String json = new Gson().toJson(quantity);
//                out.println(json);
//                break;
//
////            case "/api/asztalokesszekek":
////                break;
////            case "/api/aprocikkek":
////                break;
////            case "/api/bankstick&rodpod":
////                break;
////            case "/api/csalik":
////                System.out.println(request);
////                break;
////            case "/api/dobozok":
////                break;
////            case "/api/eteteskellekei":
////                break;
////            case "/api/fejlampak":
////                break;
////            case "/api/horgaszbotok":
////                break;
////            case "/api/kapasjelzok":
////                break;
////            case "/api/kiegeszitok":
////                break;
////            case "/api/konyvek":
////                break;
////            case "/api/meritoszakok":
////                break;
////            case "/api/orsok":
////                break;
////            case "/api/ruhazat":
////                break;
////            case "/api/satrak":
////                break;
////            case "/api/tapogatorud":
////                break;
////            case "/api/taskak":
////                break;
////            case "/api/vasarlasiutalvány":
////                break;
////            default:
////                break;
//
//        }
//        out.flush();
//    }
//}
//
