package com.shop.dao;

import com.shop.entity.GoodsGroup;

import java.util.List;

public interface GenericDao<T> {
    void insert(T item);
    void deleteById(long id);
    void updateById(T item);
    List<T> findAll();
}
