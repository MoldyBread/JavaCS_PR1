package com.shop.dao.impl;

import com.shop.dao.GoodsDao;
import com.shop.entity.Good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends GenericDaoImpl<Good> implements GoodsDao {


    public GoodsDaoImpl(Connector connector) {
        super("goods", connector);
    }

    @Override
    public List<Good> mapResultSetToList(ResultSet resultSet) throws SQLException {
        List<Good> goods = new ArrayList<>();

        while (resultSet.next()) {
            goods.add(mapResultSetToEntity(resultSet));
        }

        return goods;
    }

    @Override
    public Good mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        int price = resultSet.getInt("price");
        int count = resultSet.getInt("count");

        return new Good(id, name, price, count);
    }

    @Override
    public Good findById(long id){
        return new Good(id,"Some good",12,12);
    }

    @Override
    public List<Good> findByPriceRange(int lowerPrice, int upperPrice) {
        try (Connection connection = connector.getConnection()) {
            //Try-with-resources
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM goods WHERE price>=? AND price<=?");


            preparedStatement.setInt(1, lowerPrice);
            preparedStatement.setInt(2, upperPrice);

            ResultSet resultSet = preparedStatement.executeQuery();

            return mapResultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return new ArrayList<>();
    }

    @Override
    public void insert(Good item) {
        try (Connection connection = connector.getConnection()) {
            //Try-with-resource

            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT goods(id,name,price,count,groupid) VALUES (?,?,?,?,?)");


            preparedStatement.setLong(1,item.getId());
            preparedStatement.setString(2,item.getName());
            preparedStatement.setInt(3,item.getPrice());
            preparedStatement.setInt(4,item.getCount());
            preparedStatement.setInt(5,1);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateById(Good item) {
        try (Connection connection = connector.getConnection()) {
            //Try-with-resource

            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE goods SET name=?,price=?,count=? WHERE id=?");


            preparedStatement.setLong(4,item.getId());
            preparedStatement.setString(1,item.getName());
            preparedStatement.setInt(2,item.getPrice());
            preparedStatement.setInt(3,item.getCount());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
