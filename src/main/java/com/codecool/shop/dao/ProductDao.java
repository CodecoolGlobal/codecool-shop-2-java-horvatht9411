package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public interface ProductDao {

    List<Product> getAll();
    List<Product> getBySupplier(int supplier);
    List<Product> getByCategory(int category);

    Product getById(int id);

}
