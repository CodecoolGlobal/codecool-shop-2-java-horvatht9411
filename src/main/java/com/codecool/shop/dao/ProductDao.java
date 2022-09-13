package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;
import java.util.Objects;

public interface ProductDao {

    List<Product> getAll();
    List<Product> getBySupplier(Supplier supplier);
    List<Product> getByCategory(ProductCategory category);

    Product getById(int id);

    void add(Product product);
}
