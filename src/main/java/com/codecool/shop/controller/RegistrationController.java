package com.codecool.shop.controller;

import com.codecool.shop.config.PasswordHashing;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.User;
import com.codecool.shop.service.LogService;
import com.codecool.shop.service.UserService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationController extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");

            TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
            WebContext context = new WebContext(request, response, request.getServletContext());
            engine.process("registration.html", context, response.getWriter());
        } catch (IOException e) {
            LogService.log(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            byte[] salt = PasswordHashing.generateSalt();
            byte[] hashedPassword = PasswordHashing.hashPassword(password, salt);
            User newUser = new User(name, email, hashedPassword, salt);
            userService.addNewUser(newUser);
            System.out.println(Arrays.toString(salt));
            System.out.println(Arrays.toString(hashedPassword));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/login");
    }
}
