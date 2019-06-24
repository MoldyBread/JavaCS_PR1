package com.shop.dao.impl;

import com.shop.dao.GenericDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {


    private static final String FIND_ALL = "SELECT * FROM ";

    protected final String table;
    protected final Connector connector;


    protected GenericDaoImpl(String table, Connector connector) {
        this.table = table;
        this.connector = connector;
    }

    @Override
    public void deleteById(long id) {
        try (Connection connection = connector.getConnection()) {
            //Try-with-resource

            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM " + table + " WHERE id=?");

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<T> findAll() {
        try (Connection connection = connector.getConnection()) {
            //Try-with-resources
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table);

            ResultSet resultSet = preparedStatement.executeQuery();

            return mapResultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return new ArrayList<>();
    }

    public abstract List<T> mapResultSetToList(ResultSet resultSet) throws SQLException;

    public abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

}
