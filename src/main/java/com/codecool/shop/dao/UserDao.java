package com.codecool.shop.dao;

import com.codecool.shop.model.User;

import java.util.Set;

public interface UserDao {
    Set<User> getAll();

    User getByEmail(String email);

    void add(User user);
}
