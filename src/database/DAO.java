package database;

import entity.Xe;

import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 4:25 PM , 12/17/2020
 */

public interface DAO<T> {

    T get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);

    String getInsertQuery(List<T> list);


}
