package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SupplierDaoJdbc implements SupplierDao {


    private DataSource dataSource;

    public SupplierDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Supplier supplier) {

    }

    @Override
    public Supplier find(int id) {
        return null;
    }


    @Override
    public Set<Supplier> getAll() {
        try (Connection connect = dataSource.getConnection()){
            String sql = "SELECT * FROM suppliers";
            ResultSet resultSet = connect.createStatement().executeQuery(sql);
            Set<Supplier> result = new HashSet<>();
            while (resultSet.next()){
                Supplier supplier = new Supplier(resultSet.getString(2), resultSet.getString(3));
                supplier.setId(resultSet.getInt(1));
                result.add(supplier);
            }
            return result;
        } catch (SQLException e){
            throw new RuntimeException("Error while reading all suppliers", e);
        }
    }
}
