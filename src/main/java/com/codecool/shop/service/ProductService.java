package com.codecool.shop.service;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.*;

import java.util.List;
import java.util.Set;

public class ProductService {

    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;

    private OrderDao orderDao;


    public ProductService() {
        DbManager manager = new DbManager();
        manager.run();
        productDao = manager.getProductDao();
        productCategoryDao = manager.getProductCategoryDao();
        supplierDao = manager.getSupplierDao();
        orderDao = manager.getOrderDao();

    }


    public List<Product> getProductsForCategory(int categoryId) {
        var category = productCategoryDao.getById(categoryId);
        return productDao.getByCategory(category);
    }

    public List<Product> getProductsForSupplier(int supplierId) {
        var supplier = supplierDao.getById(supplierId);
        return productDao.getBySupplier(supplier);
    }

    public List<Product> getAllProduct() {
        return productDao.getAll();
    }

    public Product findProduct(int productId) {
        return productDao.getById(productId);
    }

    public List<ProductCategory> getAllProductCategory() {
        return productCategoryDao.getAll();
    }

    public Set<Supplier> getAllSupplier() {
        return supplierDao.getAll();
    }

    public int saveOrder(Order order) {
        return orderDao.add(order);
    }
}
