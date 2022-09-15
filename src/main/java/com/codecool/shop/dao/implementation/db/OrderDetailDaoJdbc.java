package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.OrderDetailDao;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderDetail;

import javax.sql.DataSource;
import java.sql.*;

public class OrderDetailDaoJdbc implements OrderDetailDao {

    private DataSource dataSource;

    public OrderDetailDaoJdbc(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Override
        public void add(OrderDetail orderDetail) {
            try (Connection conn = dataSource.getConnection()) {
                String sql = "INSERT INTO orderdetails (product_id, quantity, order_id) VALUES (?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, orderDetail.getProductId());
                statement.setInt(2, orderDetail.getQuantity());
                statement.setInt(3, orderDetail.getCartId());
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                orderDetail.setId(resultSet.getInt(1));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
