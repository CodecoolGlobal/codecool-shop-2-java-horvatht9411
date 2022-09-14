package com.codecool.shop.model;

public class User extends BaseModel{
    private final String email;
    private final byte[] hashedPassword;
    private final byte[] salt;

    public User(String name, String email, byte[] hashedPassword, byte[] salt) {
        super(name);
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getHashedPassword() {
        return hashedPassword;
    }

    public byte[] getSalt() {
        return salt;
    }
}
