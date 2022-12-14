package com.codecool.shop.controller;

import com.codecool.shop.config.PasswordHashing;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.User;
import com.codecool.shop.service.LogService;
import com.codecool.shop.service.UserService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationController extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        try {
            TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
            WebContext context = new WebContext(request, response, request.getServletContext());
            engine.process("registration.html", context, response.getWriter());
        } catch (IOException e) {
            LogService.log(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userData = ControllerUtil.inputStreamToString(request.getInputStream());
        List<String> userDataList = ControllerUtil.getDataList(userData);
        String userName = userDataList.get(0);
        String email = userDataList.get(1);
        String password = userDataList.get(2);
        if (isNewUser(email)) {
            try {
                byte[] salt = PasswordHashing.generateSalt();
                String hashedPassword = Arrays.toString(PasswordHashing.hashPassword(password, salt));
                String saltToSave = Arrays.toString(salt);;
                User newUser = new User(userName, email, hashedPassword, saltToSave);
                userService.addNewUser(newUser);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                throw new RuntimeException(e);
            }
            String answer = "";
            ControllerUtil.initResponse(response, answer);
        } else {
            ControllerUtil.initResponse(response, userName);
        }
    }

    private boolean isNewUser(String email) {
        User user = userService.getUserByEmail(email);
        return user == null;
    }
}
