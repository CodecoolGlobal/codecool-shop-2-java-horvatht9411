package com.codecool.shop.model;

import java.util.Currency;

public class Product extends BaseModel {

    private int defaultPrice;
    private Currency defaultCurrency;
    private int productCategory;
    private int supplier;
    private ProductCategory productCategoryMem;
    private Supplier supplierMem;
    private String imgURL;

    public Product(String name, int defaultPrice, String currencyString, String description, String imageUrl, int productCategory, int supplier) {
        super(name, description);
        this.setPrice(defaultPrice, currencyString);
        this.setSupplier(supplier);
        this.setProductCategory(productCategory);
        this.setImageURL(imageUrl);
    }

    public Product(String name, int defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier, String imageUrl) {
        super(name, description);
        this.setPrice(defaultPrice, currencyString);
        this.setSupplierMem(supplier);
        this.setProductCategoryMem(productCategory);
        this.setImageURL(imageUrl);
    }


    public int getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(int defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getPrice() {
        return this.defaultPrice + " " + this.defaultCurrency.toString();
    }

    public void setPrice(int price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    public int getSupplier() {
        return supplier;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }

    public void setImageURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public ProductCategory getProductCategoryMem() {
        return productCategoryMem;
    }

    public Supplier getSupplierMem() {
        return supplierMem;
    }

    public void setProductCategoryMem(ProductCategory productCategoryMem) {
        this.productCategoryMem = productCategoryMem;
    }

    public void setSupplierMem(Supplier supplierMem) {
        this.supplierMem = supplierMem;
    }

    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$d, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "supplier: %6$s, " +
                        "imgURL: %7$s",

                this.id,
                this.name,
                this.defaultPrice,
                this.defaultCurrency.toString(),
                this.productCategory,
                this.supplier,
                this.imgURL);
    }
}
