package com.shop.sevice.impl;

import com.shop.dao.GroupDao;
import com.shop.dao.impl.Connector;
import com.shop.dao.impl.GroupDaoImpl;
import com.shop.entity.GoodsGroup;
import com.shop.sevice.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    private GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void insert(GoodsGroup item) {
        groupDao.insert(item);
    }

    @Override
    public void deleteById(long id) {
        groupDao.deleteById(id);
    }

    @Override
    public void updateById(GoodsGroup item) {
        groupDao.updateById(item);
    }

    @Override
    public List<GoodsGroup> findAll() {
        return groupDao.findAll();
    }

    @Override
    public List<GoodsGroup> findBetweenId(long lowerId, long upperId) {
        return groupDao.findBetweenId(lowerId,upperId);
    }

    public static void main (String[] args) {
        GroupService groupService = new GroupServiceImpl(new GroupDaoImpl(new Connector()));

        GoodsGroup goodsGroup = new GoodsGroup(1,"Snacks");
        groupService.updateById(goodsGroup);
    }
}
