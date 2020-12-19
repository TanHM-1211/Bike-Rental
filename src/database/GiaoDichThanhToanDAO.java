package database;

import entity.BaiXe;
import entity.GiaoDichThanhToan;
import entity.Xe;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:08 PM , 12/18/2020
 */

public class GiaoDichThanhToanDAO implements DAO<GiaoDichThanhToan> {
    private List<GiaoDichThanhToan> listGiaoDichThanhToan = new ArrayList<GiaoDichThanhToan>();
    private DAOManager daoManager = DAOManager.getInstance();
    public static GiaoDichThanhToanDAO giaoDichThanhToanDAO = null;

    public GiaoDichThanhToanDAO() {
    }

    public static GiaoDichThanhToanDAO getInstance()
    {
        if(giaoDichThanhToanDAO == null){
            giaoDichThanhToanDAO = new GiaoDichThanhToanDAO();
        }
        return giaoDichThanhToanDAO;
    }

    @Override
    public GiaoDichThanhToan parse(ResultSet resultSet) {
//        try {
//            return new BaiXe(resultSet.getInt(1), resultSet.getString(2),
//                    resultSet.getString(3), resultSet.getInt(4));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public GiaoDichThanhToan get(int id) {
        return null;
    }

    @Override
    public List<GiaoDichThanhToan> getAll() {
        return null;
    }

    @Override
    public void save(GiaoDichThanhToan giaoDichThanhToan) {

    }

    @Override
    public void update(GiaoDichThanhToan giaoDichThanhToan, String[] params) {

    }

    @Override
    public void delete(GiaoDichThanhToan giaoDichThanhToan) {

    }

    @Override
    public String getInsertQuery(List<GiaoDichThanhToan> list) {
        return null;
    }
}
