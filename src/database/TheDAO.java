package database;

import entity.NguoiDungGiaoDichThueXe;
import entity.The;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:09 PM , 12/18/2020
 */

public class TheDAO implements DAO<The> {
    private List<The> listThe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();

    public TheDAO() {
        super();
    }

    @Override
    public The get(int id) {
        return null;
    }

    @Override
    public List<The> getAll() {
        return null;
    }

    @Override
    public void save(The the) {

    }

    @Override
    public void update(The the, String[] params) {

    }

    @Override
    public void delete(The the) {

    }

    @Override
    public String getInsertQuery(List<The> list) {
        return null;
    }
}
