package com.shop.dao.impl;

import com.shop.dao.UserDao;
import com.shop.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    public UserDaoImpl(Connector connector) {
        super("users", connector);
    }

    @Override
    public List<User> mapResultSetToList(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void insert(User item) {

    }

    @Override
    public void updateById(User item) {

    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return new User(login,password);
    }
}
