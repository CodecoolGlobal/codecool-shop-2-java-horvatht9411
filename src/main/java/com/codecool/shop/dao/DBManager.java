package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.implementation.ProductDaoJdbc;
import com.codecool.shop.dao.implementation.SupplierDaoJdbc;
import com.codecool.shop.dao.implementation.UserDaoJdbc;
import com.codecool.shop.dao.implementation.mem.SupplierDaoMem;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DBManager {

    private UserDao userDao;
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;


    public void run() {
        try {
            setup();
        } catch (SQLException throwables){
            System.err.println("Could not connect to the database.");
            return;
        }
    }

    private void setup() throws SQLException {
        DataSource dataSource = connect();
        userDao = new UserDaoJdbc();
        productDao = new ProductDaoJdbc();
        productCategoryDao = new ProductCategoryDaoJdbc();
        supplierDao = new SupplierDaoJdbc();
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
}
