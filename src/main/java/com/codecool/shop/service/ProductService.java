package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.implementation.ProductDaoJdbc;
import com.codecool.shop.dao.implementation.SupplierDaoJdbc;
import com.codecool.shop.dao.implementation.UserDaoJdbc;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class ProductService {

    private UserDao userDao;
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;

    public ProductService() {
        run();
    }

    private void setup() throws SQLException {
        DataSource dataSource = connect();
        userDao = new UserDaoJdbc(dataSource);
        productDao = new ProductDaoJdbc(dataSource);
        productCategoryDao = new ProductCategoryDaoJdbc(dataSource);
        supplierDao = new SupplierDaoJdbc(dataSource);
    }


    public void run() {
        try {
            setup();
        } catch (SQLException throwables){
            System.err.println("Could not connect to the database.");
            return;
        }
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setDatabaseName(System.getenv("DB_NAME"));
        dataSource.setUser(System.getenv("DB_USER"));
        dataSource.setPassword(System.getenv("DB_PASSWORD"));

        System.out.println("Trying to connect...");
        dataSource.getConnection().close();
        System.out.println("Connection OK");

        return dataSource;
    }


    public List<Product> getProductsForCategory(int categoryId) {
        return productDao.getByCategory(categoryId);
    }

    public List<Product> getProductsForSupplier(int supplierId) {
        return productDao.getBySupplier(supplierId);
    }

    public List<Product> getAllProduct() {
        return productDao.getAll();
    }

    public Product findProduct(int productId){ return productDao.getById(productId); }

    public List<ProductCategory> getAllProductCategory() {
        return productCategoryDao.getAll();
    }

    public Set<Supplier> getAllSupplier() {
        return supplierDao.getAll();
    }

}
