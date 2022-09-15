package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDaoJdbc implements UserDao {

    private DataSource dataSource;

    public UserDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Set<User> getAll() {
        try (Connection connect = dataSource.getConnection()) {
            String sql = "SELECT * FROM users";
            ResultSet resultSet = connect.createStatement().executeQuery(sql);
            Set<User> result = new HashSet<>();
            while (resultSet.next()) {
                User user = new User(resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5));
                user.setId(resultSet.getInt(1));
                result.add(user);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading all users", e);
        }
    }

    @Override
    public User getByEmail(String email) {
        try (Connection connect = dataSource.getConnection()) {
            String sql = "SELECT * FROM users WHERE email = ? ";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            User user = new User(resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5));
            user.setId(resultSet.getInt(1));
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading user by Email", e);
        }
    }

    @Override
    public void add(User user) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO users (name, email, password, salt) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getHashedPassword());
            statement.setString(4, user.getSalt());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            user.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
