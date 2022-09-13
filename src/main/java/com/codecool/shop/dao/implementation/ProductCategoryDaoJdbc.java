package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
                ProductCategory productCategory = new ProductCategory(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                productCategory.setId(resultSet.getInt(1));
                result.add(productCategory);
            }
            return result;
        } catch (SQLException e){
            throw new RuntimeException("Error while reading all product category", e);
        }
    }

    @Override
    public ProductCategory getById(int id) {
        try (Connection connect = dataSource.getConnection()){
            String sql = "SELECT * FROM productcategory WHERE id = ? ";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()){
                return null;
            }
            ProductCategory productCategory = new ProductCategory(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            productCategory.setId(resultSet.getInt(1));
            return productCategory;
        } catch (SQLException e){
            throw new RuntimeException("Error while reading product by Id", e);
        }
    }
}
