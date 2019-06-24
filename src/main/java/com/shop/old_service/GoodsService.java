package com.shop.old_service;

import com.shop.entity.Good;

public interface GoodsService {
    int getAllCount();

    void setPrice(int groupIndex, int goodIndex, int price) throws Exception;

    void removeFromStorage(int groupIndex, int goodIndex, int count);

    void addToStorage(int groupIndex, int goodIndex, int count);

    void addGoodsGroup(String name);

    void addItemToGoodsGroup(int groupIndex, Good good);
}
