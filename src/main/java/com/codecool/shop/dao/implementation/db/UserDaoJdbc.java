package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.UserDao;

import javax.sql.DataSource;

public class UserDaoJdbc implements UserDao {

    private DataSource dataSource;

    public UserDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
