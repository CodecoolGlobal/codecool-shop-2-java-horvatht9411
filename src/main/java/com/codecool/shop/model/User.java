package com.codecool.shop.model;

public class User extends BaseModel{
    private final String email;
    private final String password;

    public User(String name, String email, String password) {
        super(name);
        this.email = email;
        this.password = password;
    }
}
