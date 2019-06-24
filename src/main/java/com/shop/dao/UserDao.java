package com.shop.dao;

import com.shop.entity.User;

public interface UserDao {
    User findByLoginAndPassword(String login, String password);
}
