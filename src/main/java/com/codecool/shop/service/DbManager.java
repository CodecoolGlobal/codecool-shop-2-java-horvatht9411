package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.dao.implementation.db.UserDaoJdbc;
import com.codecool.shop.dao.implementation.db.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.implementation.db.ProductDaoJdbc;
import com.codecool.shop.dao.implementation.db.SupplierDaoJdbc;
import com.codecool.shop.dao.implementation.mem.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.mem.ProductDaoMem;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;


public class DbManager {

    private UserDao userDao;
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;

    private final Properties appProps = new Properties();

    public DbManager() {
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

        if (appProps.getProperty("dao").equals("db")) {
            try {
                setupDB();
            } catch (SQLException throwables) {
                System.err.println("Could not connect to the database.");
            }
        }
        if (appProps.getProperty("dao").equals("memory")) {
            setupMEM();
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

    public UserDao getUserDao() {
        return userDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public ProductCategoryDao getProductCategoryDao() {
        return productCategoryDao;
    }

    public SupplierDao getSupplierDao() {
        return supplierDao;
    }

}
