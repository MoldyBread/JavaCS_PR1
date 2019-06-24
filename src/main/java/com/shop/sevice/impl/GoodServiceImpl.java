package com.shop.sevice.impl;

import com.shop.dao.GoodsDao;
import com.shop.dao.impl.Connector;
import com.shop.dao.impl.GoodsDaoImpl;
import com.shop.entity.Good;
import com.shop.sevice.GoodService;

import java.util.List;

public class GoodServiceImpl implements GoodService {

    private GoodsDao goodsDao;

    public GoodServiceImpl(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public void insert(Good item) {
        goodsDao.insert(item);
    }

    @Override
    public void deleteById(long id) {
        goodsDao.deleteById(id);
    }

    @Override
    public void updateById(Good item) {
        goodsDao.updateById(item);
    }

    @Override
    public List<Good> findAll() {
        return goodsDao.findAll();
    }

    @Override
    public List<Good> findByPriceRange(int lowerPrice, int upperPrice) {
        return goodsDao.findByPriceRange(lowerPrice,upperPrice);
    }

    public static void main(String[] args) {
        GoodService goodService = new GoodServiceImpl(new GoodsDaoImpl(new Connector()));

        System.out.println(goodService.findByPriceRange(0,12));
    }
}
