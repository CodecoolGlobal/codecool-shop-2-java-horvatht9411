package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.dao.implementation.UserDaoJdbc;
import com.codecool.shop.dao.implementation.db.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.implementation.db.ProductDaoJdbc;
import com.codecool.shop.dao.implementation.db.SupplierDaoJdbc;
import com.codecool.shop.dao.implementation.mem.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.mem.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class ProductService {

    private UserDao userDao;
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;
    private Properties appProps = new Properties();


    public ProductService() {
        run();
    }

    public void run() {
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String appConfigPath = rootPath + "connection.properties";
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            LogService.log(e);
        }
        try {
            if (appProps.getProperty("dao").equals("db")) {
                setupDB();
            }
            if (appProps.getProperty("dao").equals("memory")) {
                setupMEM();
            }
        } catch (SQLException throwables) {
            System.err.println("Could not connect to the database.");
        }
    }

    private void setupDB() throws SQLException {
        DataSource dataSource = connect();
        userDao = new UserDaoJdbc(dataSource);
        productDao = new ProductDaoJdbc(dataSource);
        productCategoryDao = new ProductCategoryDaoJdbc(dataSource);
        supplierDao = new SupplierDaoJdbc(dataSource);
    }

    private void setupMEM() {
        this.productDao = ProductDaoMem.getInstance();
        this.productCategoryDao = ProductCategoryDaoMem.getInstance();
        this.supplierDao = SupplierDaoMem.getInstance();
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setDatabaseName(appProps.getProperty("database"));
        dataSource.setUser(appProps.getProperty("user"));
        dataSource.setPassword(appProps.getProperty("password"));

        System.out.println("Trying to connect...");
        dataSource.getConnection().close();
        System.out.println("Connection OK");

        return dataSource;
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

}
