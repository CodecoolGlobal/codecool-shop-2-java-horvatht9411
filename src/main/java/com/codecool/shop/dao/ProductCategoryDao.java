package com.codecool.shop.dao;

import com.codecool.shop.model.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    List<ProductCategory> getAll();

    ProductCategory getById(int id);

}
