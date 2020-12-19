package database;

import entity.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:09 PM , 12/18/2020
 */

public class NguoiDungGiaoDichThueXeDAO implements DAO<NguoiDungGiaoDichThueXe> {
    private List<NguoiDungGiaoDichThueXe> listNguoiDungGiaoDichThueXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    public static NguoiDungGiaoDichThueXeDAO nguoiDungGiaoDichThueXeDAO = null;

    public NguoiDungGiaoDichThueXeDAO() {
        super();
    }

    public static NguoiDungGiaoDichThueXeDAO getInstance(){
        if(nguoiDungGiaoDichThueXeDAO == null){
            nguoiDungGiaoDichThueXeDAO = new NguoiDungGiaoDichThueXeDAO();
        }
        return nguoiDungGiaoDichThueXeDAO;
    }

    @Override
    public NguoiDungGiaoDichThueXe parse(ResultSet resultSet) {
        NguoiDungDAO nguoiDungDAO = NguoiDungDAO.getInstance();
        GiaoDichThueXeDAO giaoDichThueXeDAO = GiaoDichThueXeDAO.getInstance();
        try {
            return new NguoiDungGiaoDichThueXe(resultSet.getInt(1), nguoiDungDAO.get(resultSet.getInt(2)),
                    resultSet.getObject(3) != null ? giaoDichThueXeDAO.get(resultSet.getInt(3)) : null  // nullable
            );
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NguoiDungGiaoDichThueXe get(int id) {
        return null;
    }

    public NguoiDungGiaoDichThueXe getNguoiDungGiaoDichThueXeTuongUng(NguoiDung nguoiDung){
        ResultSet resultSet = this.daoManager.executeQuery("SELECT * FROM " + NguoiDungGiaoDichThueXe.name +
                " WHERE id_nguoi_dung=" + nguoiDung.getId() + ";");
        try {
            resultSet.next();
            return parse(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<NguoiDungGiaoDichThueXe> getAll() {
        return null;
    }

    @Override
    public void save(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe) {

    }

    @Override
    public void update(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe) {

    }

    @Override
    public void delete(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe) {

    }

    @Override
    public String getInsertQuery(List<NguoiDungGiaoDichThueXe> list) {
        return null;
    }
}
