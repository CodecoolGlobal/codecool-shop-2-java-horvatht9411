package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoJdbc implements ProductCategoryDao {

    private DataSource dataSource;

    public ProductCategoryDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<ProductCategory> getAll() {
        try (Connection connect = dataSource.getConnection()){
            String sql = "SELECT * FROM productcategory";
            ResultSet resultSet = connect.createStatement().executeQuery(sql);
            List<ProductCategory> result = new ArrayList<>();
            while (resultSet.next()){
                ProductCategory author = new ProductCategory(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                author.setId(resultSet.getInt(1));
                result.add(author);
            }
            return result;
        } catch (SQLException e){
            throw new RuntimeException("Error while reading all product category", e);
        }
    }
}
