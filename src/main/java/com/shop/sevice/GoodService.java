package com.shop.sevice;

import com.shop.entity.Good;

import java.util.List;

public interface GoodService {
    void insert(Good item);

    void deleteById(long id);

    void updateById(Good item);

    List<Good> findAll();

    List<Good> findByPriceRange(int lowerPrice, int upperPrice);
}
