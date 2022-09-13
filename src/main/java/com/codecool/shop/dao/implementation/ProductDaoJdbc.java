package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public List<Product> getAll() {

        try (Connection connect = dataSource.getConnection()){
            String sql = "SELECT * FROM product";
            ResultSet resultSet = connect.createStatement().executeQuery(sql);
            return getProducts(resultSet);
        } catch (SQLException e){
            throw new RuntimeException("Error while reading all product", e);
        }
    }


    @Override
    public List<Product> getBySupplier(Supplier supplier) {
        try (Connection connect = dataSource.getConnection()){
            String sql = "SELECT * FROM product WHERE supplier_id=?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, supplier.getId());
            ResultSet resultSet = statement.executeQuery();
            return getProducts(resultSet);
        } catch (SQLException e){
            throw new RuntimeException("Error while reading all product by supplier", e);
        }
    }

    private List<Product> getProducts(ResultSet resultSet) throws SQLException {
        List<Product> result = new ArrayList<>();
        while (resultSet.next()){
            Product product = new Product(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getInt(8));
            product.setId(resultSet.getInt(1));
            result.add(product);
        }
        return result;
    }

    @Override
    public List<Product> getByCategory(ProductCategory category) {
        try (Connection connect = dataSource.getConnection()){
            String sql = "SELECT * FROM product WHERE category_id = ? ";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, category.getId());
            ResultSet resultSet = statement.executeQuery();
            return getProducts(resultSet);
        } catch (SQLException e){
            throw new RuntimeException("Error while reading all product by category", e);
        }
    }

    @Override
    public Product getById(int id) {
        try (Connection connect = dataSource.getConnection()){
            String sql = "SELECT * FROM product WHERE id = ? ";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()){
                return null;
            }
            Product product = new Product(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getInt(8));
            product.setId(resultSet.getInt(1));
            return product;
        } catch (SQLException e){
            throw new RuntimeException("Error while reading product by Id", e);
        }
    }
}
