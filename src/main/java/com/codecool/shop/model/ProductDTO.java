package com.codecool.shop.model;

import java.util.Currency;

public class ProductDTO extends BaseModel{

    int defaultPrice;
    Currency defaultCurrency;
    String imgURL;


    public ProductDTO(String name, String description, int defaultPrice, Currency defaultCurrency, String imgURL) {
        super(name, description);
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = defaultCurrency;
        this.imgURL = imgURL;
    }
}
