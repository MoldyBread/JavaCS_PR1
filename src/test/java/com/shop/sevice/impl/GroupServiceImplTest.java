package com.shop.sevice.impl;

import com.shop.dao.impl.Connector;
import com.shop.dao.impl.GroupDaoImpl;
import com.shop.entity.GoodsGroup;
import com.shop.sevice.GroupService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class GroupServiceImplTest {

    GroupService groupService = new GroupServiceImpl(new GroupDaoImpl(new Connector()));

    @Test
    public void shouldReturnAllGroups() {
        List<GoodsGroup> actual = groupService.findAll();
        List<GoodsGroup> expected = new ArrayList<>();
        expected.add(new GoodsGroup(2, "beverages"));
        expected.add(new GoodsGroup(1, "Snacks"));
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnInRange() {
        List<GoodsGroup> actual = groupService.findBetweenId(1, 1);
        List<GoodsGroup> expected = new ArrayList<>();
        expected.add(new GoodsGroup(1, "Snacks"));

        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void shouldInsertAndDelete() {
        GoodsGroup goodsGroup = new GoodsGroup(10, "NOT_NULL_NAME");
        groupService.insert(goodsGroup);

        List<GoodsGroup> actual = groupService.findAll();
        Assert.assertTrue(actual.contains(goodsGroup));

        groupService.deleteById(10);
        actual = groupService.findAll();
        Assert.assertTrue(!actual.contains(goodsGroup));
    }

    @Test
    public void shouldUpdate() throws Exception {
        GoodsGroup goodsGroup = new GoodsGroup(10, "NOT_NULL_NAME");
        groupService.insert(goodsGroup);

        GoodsGroup goodsGroup1 = new GoodsGroup(10, "NOT_NULL_NAME2");

        groupService.updateById(goodsGroup);

        List<GoodsGroup> actual = groupService.findBetweenId(10, 10);
        Assert.assertTrue(actual.contains(goodsGroup));
        groupService.deleteById(10);
    }

}