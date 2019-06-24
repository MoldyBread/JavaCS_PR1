package com.shop.sevice;

import com.shop.entity.GoodsGroup;

import java.util.List;

public interface GroupService {
    void insert(GoodsGroup item);

    void deleteById(long id);

    void updateById(GoodsGroup item);

    List<GoodsGroup> findAll();

    List<GoodsGroup> findBetweenId(long lowerId, long upperId);
}
