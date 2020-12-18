package database;

import entity.GiaoDichThueXe;
import entity.LoaiXe;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:08 PM , 12/18/2020
 */

public class LoaiXeDAO implements DAO<LoaiXe> {
    private List<LoaiXe> listLoaiXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();

    public LoaiXeDAO() {
        super();
    }

    @Override
    public LoaiXe get(int id) {
        return null;
    }

    @Override
    public List<LoaiXe> getAll() {
        return null;
    }

    @Override
    public void save(LoaiXe loaiXe) {

    }

    @Override
    public void update(LoaiXe loaiXe, String[] params) {

    }

    @Override
    public void delete(LoaiXe loaiXe) {

    }

    @Override
    public String getInsertQuery(List<LoaiXe> list) {
        return null;
    }
}
