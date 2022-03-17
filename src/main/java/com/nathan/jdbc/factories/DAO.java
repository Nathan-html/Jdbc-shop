package com.nathan.jdbc.factories;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T, ID> {

    List<T> getAll() throws SQLException;

    T getById(ID id) throws SQLException;

    void save(T t) throws SQLException;

    void update(T t, String[] params);

    void delete(T t);

    void deleteById(ID id);
}
