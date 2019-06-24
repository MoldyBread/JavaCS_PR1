package com.shop.old_service.implementation;

import com.shop.entity.Good;
import com.shop.repository.GoodsRepository;
import com.shop.old_service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

    private GoodsRepository goodsRepository;

    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public int getAllCount() {
        return goodsRepository.getAllCount();
    }

    @Override
    public void setPrice(int groupIndex, int goodIndex, int price) throws Exception {
        goodsRepository.setPrice(groupIndex, goodIndex, price);
    }

    @Override
    public void removeFromStorage(int groupIndex, int goodIndex, int count) {
        goodsRepository.removeFromStorage(groupIndex, goodIndex, count);
    }

    @Override
    public void addToStorage(int groupIndex, int goodIndex, int count) {
        goodsRepository.addToStorage(groupIndex, goodIndex, count);
    }

    @Override
    public void addGoodsGroup(String name) {
        goodsRepository.addGoodsGroup(name);
    }

    @Override
    public void addItemToGoodsGroup(int groupIndex, Good good) {
        goodsRepository.addItemToGoodsGroup(groupIndex, good);
    }
}
