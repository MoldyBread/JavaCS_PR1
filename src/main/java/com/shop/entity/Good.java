package com.shop.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Good {
    private long id;
    private final String name;
    private int price;
    private int count;

    public Good(long id, String name, int price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public Good(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setPrice(int price) throws Exception {
        if (price > 0)
            this.price = price;
        else
            throw new Exception("Bad price");
    }

    public void addToStorage(int count) {
        this.count += count;
    }

    public void removeFromStorage(int count) {
        if (this.count - count < 0)
            throw new ArithmeticException("It can`t be less than 0 goods in stock");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return id == good.id &&
                price == good.price &&
                count == good.count &&
                Objects.equals(name, good.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, count);
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
