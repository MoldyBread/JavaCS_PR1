package com.shop.sevice.impl;

import com.shop.dao.impl.Connector;
import com.shop.dao.impl.GoodsDaoImpl;
import com.shop.entity.Good;
import com.shop.sevice.GoodService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class GoodServiceImplTest {

    GoodService goodService = new GoodServiceImpl(new GoodsDaoImpl(new Connector()));

    @Test
    public void shouldReturnAllGoods() {
        List<Good> actual = goodService.findAll();
        List<Good> expected = new ArrayList<>();
        expected.add(new Good(1, "chips", 12, 15));
        expected.add(new Good(2, "peanuts", 14, 12));
        expected.add(new Good(3, "water", 9, 20));

        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnInRange() {
        List<Good> actual = goodService.findByPriceRange(10, 20);
        List<Good> expected = new ArrayList<>();
        expected.add(new Good(1, "chips", 12, 15));
        expected.add(new Good(2, "peanuts", 14, 12));

        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void shouldInsertAndDelete() {
        Good good = new Good(10, "crisps", 10, 5);
        goodService.insert(good);

        List<Good> actual = goodService.findAll();
        Assert.assertTrue(actual.contains(good));

        goodService.deleteById(10);
        actual = goodService.findAll();
        Assert.assertTrue(!actual.contains(good));
    }

    @Test
    public void shouldUpdate() throws Exception {
        Good good = new Good(10, "crisps", 10, 5);
        goodService.insert(good);

        good.setPrice(15);

        goodService.updateById(good);

        List<Good> actual = goodService.findByPriceRange(15, 15);
        Assert.assertTrue(actual.contains(good));
        goodService.deleteById(10);
    }


}