package com.shop.dao.impl;

import com.shop.dao.GroupDao;
import com.shop.entity.GoodsGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl extends GenericDaoImpl<GoodsGroup> implements GroupDao {

    public GroupDaoImpl(Connector connector) {
        super("ggroups", connector);
    }

    @Override
    public List<GoodsGroup> mapResultSetToList(ResultSet resultSet) throws SQLException {
        List<GoodsGroup> groups = new ArrayList<>();

        while (resultSet.next()) {
            groups.add(mapResultSetToEntity(resultSet));
        }

        return groups;
    }

    @Override
    public GoodsGroup mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");

        return new GoodsGroup(id, name);
    }

    @Override
    public List<GoodsGroup> findBetweenId(long lowerId, long upperId) {
        try (Connection connection = connector.getConnection()) {
            //Try-with-resources
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM ggroups WHERE id >=? AND id<=?");


            preparedStatement.setLong(1,lowerId);
            preparedStatement.setLong(2,upperId);

            ResultSet resultSet = preparedStatement.executeQuery();

            return mapResultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return new ArrayList<>();
    }


    @Override
    public void insert(GoodsGroup item) {
        try (Connection connection = connector.getConnection()) {
            //Try-with-resource

            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT ggroups(id,name) VALUES (?,?)");


            preparedStatement.setLong(1,item.getId());
            preparedStatement.setString(2,item.getName());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateById(GoodsGroup item) {
        try (Connection connection = connector.getConnection()) {
            //Try-with-resource

            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE ggroups SET name=? WHERE id=?");


            preparedStatement.setLong(2,item.getId());
            preparedStatement.setString(1,item.getName());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
