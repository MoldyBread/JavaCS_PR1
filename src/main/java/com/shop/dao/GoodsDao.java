package com.shop.dao;

import com.shop.entity.Good;

import java.util.List;

public interface GoodsDao extends GenericDao<Good> {
    Good findById(long id);

    List<Good> findByPriceRange(int lowerPrice, int upperPrice);
}
