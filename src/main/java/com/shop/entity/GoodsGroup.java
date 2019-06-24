package com.shop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GoodsGroup {
    private long id;
    private final String name;
    private List<Good> goods;

    public GoodsGroup(long id, String name) {
        this.id=id;
        this.name = name;
        goods=new ArrayList<>();
    }

    public GoodsGroup(String name) {
        this.name = name;
    }

    public int getCount(){
        int count=0;
        for (Good good : goods) {
            count += good.getCount();
        }
        return count;
    }

    public long getId() {
        return id;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void addToList(Good good){
        goods.add(good);
    }

    public Good getItem(int index){
        return goods.get(index);
    }

    public void setItem(int index,Good good){
        goods.set(index,good);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsGroup that = (GoodsGroup) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(goods, that.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, goods);
    }

    @Override
    public String toString() {
        return "GoodsGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goods=" + goods +
                '}';
    }
}
