package database;

import entity.BaiXe;
import entity.GiaoDichThueXe;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:26 PM , 12/17/2020
 */

public class GiaoDichThueXeDAO implements DAO<GiaoDichThueXe> {
    private List<GiaoDichThueXe> listGiaoDichThueXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    public static GiaoDichThueXeDAO giaoDichThueXeDAO = null;

    public GiaoDichThueXeDAO(){}

    public static GiaoDichThueXeDAO getInstance(){
        if (giaoDichThueXeDAO == null){
            giaoDichThueXeDAO = new GiaoDichThueXeDAO();
        }
        return giaoDichThueXeDAO;
    }

    @Override
    public GiaoDichThueXe parse(ResultSet resultSet) {
//        try {
//            return new BaiXe(resultSet.getInt(1), resultSet.getString(2),
//                    resultSet.getString(3), resultSet.getInt(4));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public GiaoDichThueXe get(int id) {
        return null;
    }

    @Override
    public List<GiaoDichThueXe> getAll() {
        return null;
    }

    @Override
    public void save(GiaoDichThueXe giaoDichThueXe) {

    }

    @Override
    public void update(GiaoDichThueXe giaoDichThueXe, String[] params) {

    }

    @Override
    public void delete(GiaoDichThueXe giaoDichThueXe) {

    }

    @Override
    public String getInsertQuery(List<GiaoDichThueXe> list) {
        return null;
    }
}