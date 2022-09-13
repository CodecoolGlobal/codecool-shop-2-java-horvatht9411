package com.codecool.shop.dao.implementation.mem;


import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoMem implements ProductDao {

    private List<Product> data = new ArrayList<>();
    private static ProductDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private ProductDaoMem() {
    }

    public static ProductDaoMem getInstance() {
        if (instance == null) {
            instance = new ProductDaoMem();
        }
        return instance;
    }

    @Override
    public List<Product> getAll() {
        return data;
    }

    @Override
    public List<Product> getBySupplier(Supplier supplier) {
        return data.stream().filter(t -> t.getSupplierMem().equals(supplier)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByCategory(ProductCategory category) {
        return data.stream().filter(t -> t.getProductCategoryMem().equals(category)).collect(Collectors.toList());
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public void add(Product product) {
        product.setId(data.size() + 1);
        data.add(product);
    }


}
