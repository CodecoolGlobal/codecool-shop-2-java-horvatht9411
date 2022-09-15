package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.User;

import javax.sql.DataSource;
import java.sql.*;

public class OrderDaoJdbc implements OrderDao {

    private DataSource dataSource;

    public OrderDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int add(Order order) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO orders (user_id, name, email, city, address, zip_code, state, card_name, card_number, exp_month, exp_year, cvv) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getUserId());
            statement.setString(2, order.getName());
            statement.setString(3, order.getEmail());
            statement.setString(4, order.getCity());
            statement.setString(5, order.getAddress());
            statement.setInt(6, order.getZipCode());
            statement.setString(7, order.getState());
            statement.setString(8, order.getCardName());
            statement.setString(9, order.getCardNumber());
            statement.setString(10, order.getExpMonth());
            statement.setString(11, order.getExpYear());
            statement.setString(12, order.getCvv());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            order.setId(resultSet.getInt(1));
            return order.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
