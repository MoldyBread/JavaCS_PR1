package com.shop.dao;



import com.shop.entity.GoodsGroup;

import java.util.List;

public interface GroupDao extends GenericDao<GoodsGroup>{
    List<GoodsGroup> findBetweenId(long lowerId, long upperId);
}
