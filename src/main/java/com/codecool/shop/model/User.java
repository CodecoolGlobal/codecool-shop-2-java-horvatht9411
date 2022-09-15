package com.codecool.shop.model;

public class User extends BaseModel{
    private final String email;
    private final String hashedPassword;
    private final String salt;

    public User(String name, String email, String hashedPassword, String salt) {
        super(name);
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getSalt() {
        return salt;
    }
}
