package com.codecool.shop.controller;

import com.codecool.shop.config.PasswordHashing;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.User;
import com.codecool.shop.service.LogService;
import com.codecool.shop.service.UserService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private final UserService userService = new UserService();
    private User user;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");

            TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
            WebContext context = new WebContext(request, response, request.getServletContext());
            engine.process("login.html", context, response.getWriter());
        } catch (IOException e) {
            LogService.log(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userData = ControllerUtil.inputStreamToString(request.getInputStream());
        List<String> userDataList = ControllerUtil.getDataList(userData);
        String email = userDataList.get(0);
        String password = userDataList.get(1);
        try {
            String answer = String.valueOf(isValidLogin(email, password, request));
            ControllerUtil.initResponse(response, answer);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
//        session.invalidate();
        session.removeAttribute("user");
        ((Map<?, ?>) session.getAttribute("cart")).clear();
    }

    private boolean isValidLogin(String email, String password, HttpServletRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException {
        User registeredUser = userService.getUserByEmail(email);
        if (registeredUser != null) {
            byte[] salt = PasswordHashing.stringMatrixToHash(registeredUser.getSalt());
            String savePassword = registeredUser.getHashedPassword();
            String loginPassword = Arrays.toString(PasswordHashing.hashPassword(password, salt));
            if (savePassword.equals(loginPassword)) {
                HttpSession session = request.getSession();
                if (session.getAttribute("user") == null) {
                    user = registeredUser;
                    session.setAttribute("user", user);
                }
                return true;
            }
            return false;
        }
        return false;
    }

}
