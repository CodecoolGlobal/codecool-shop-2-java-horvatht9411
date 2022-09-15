package com.codecool.shop.model;

public class Order extends BaseModel {

    int userId;
    String email;
    String city;
    String address;
    String zipCode;
    String state;
    String cardName;
    String cardNumber;
    String expMonth;
    String expYear;
    String cvv;

    public Order(String name, int userId, String email, String city, String address, String zipCode, String state, String cardName, String cardNumber, String expMonth, String expYear, String cvv) {
        super(name);
        this.userId = userId;
        this.email = email;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.state = state;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.cvv = cvv;
    }

    public int getUserId() {
        return userId;
    }


    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public String getCvv() {
        return cvv;
    }
}
