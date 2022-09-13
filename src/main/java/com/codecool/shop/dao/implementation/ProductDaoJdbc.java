package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbc implements ProductDao {

    private DataSource dataSource;

    public ProductDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        return null;
    }


    @Override
    public List<Product> getAll() {

        try (Connection connect = dataSource.getConnection()){
            String sql = "SELECT * FROM product";
            ResultSet resultSet = connect.createStatement().executeQuery(sql);
            List<Product> result = new ArrayList<>();
            while (resultSet.next()){
                Product product = new Product(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getInt(8));
                product.setId(resultSet.getInt(1));
                result.add(product);
            }
            return result;
        } catch (SQLException e){
            throw new RuntimeException("Error while reading all product", e);
        }
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
