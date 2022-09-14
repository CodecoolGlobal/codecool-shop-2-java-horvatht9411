package com.codecool.shop.service;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import java.util.Set;

public class UserService {

    private UserDao userDao;


    public UserService() {
        DbManager dbManager = new DbManager();
        dbManager.run();
        userDao = dbManager.getUserDao();
    }

    public Set<User> getAllUsers() {
        return userDao.getAll();
    }

    public User getUserByEmail(String email) {
        return userDao.getByEmail(email);
    }

    public void addNewUser(User user) {
        userDao.add(user);
    }
}
