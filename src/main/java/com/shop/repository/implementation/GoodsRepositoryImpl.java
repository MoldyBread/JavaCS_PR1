package com.shop.repository.implementation;

import com.shop.entity.Good;
import com.shop.entity.GoodsGroup;
import com.shop.repository.GoodsRepository;

import java.util.List;

public class GoodsRepositoryImpl implements GoodsRepository {
    private List<GoodsGroup> goodsGroups;

    public GoodsRepositoryImpl(List<GoodsGroup> goodsGroups) {
        this.goodsGroups = goodsGroups;
    }

    @Override
    public int getAllCount() {
        int count = 0;
        for (GoodsGroup goodsGroup : goodsGroups) {
            count += goodsGroup.getCount();
        }

        return count;
    }

    @Override
    public void setPrice(int groupIndex, int goodIndex, int price) throws Exception {
        goodsGroups.get(groupIndex).getItem(goodIndex).setPrice(price);
    }

    @Override
    public void removeFromStorage(int groupIndex, int goodIndex, int count) {
        goodsGroups.get(groupIndex).getItem(goodIndex).removeFromStorage(count);
    }

    @Override
    public void addToStorage(int groupIndex, int goodIndex, int count) {
        goodsGroups.get(groupIndex).getItem(goodIndex).addToStorage(count);
    }

    @Override
    public void addGoodsGroup(String name) {
        goodsGroups.add(new GoodsGroup(name));
    }

    @Override
    public void addItemToGoodsGroup(int groupIndex, Good good) {
        goodsGroups.get(groupIndex).addToList(good);
    }
}
