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
        daoManager.open();
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + NguoiDungGiaoDichThueXe.name + ";");
        try {
            while (resultSet.next()){
                listNguoiDungGiaoDichThueXe.add(this.parse(resultSet));
            }
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public NguoiDungGiaoDichThueXe makeNguoiDungGiaoDichThueXe(NguoiDung nguoiDung,
                                                               GiaoDichThueXe giaoDichThueXe){
        return new NguoiDungGiaoDichThueXe(this.listNguoiDungGiaoDichThueXe.size(), nguoiDung, giaoDichThueXe);
    }

    @Override
    public NguoiDungGiaoDichThueXe get(int id) {
        for (NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe:
             this.listNguoiDungGiaoDichThueXe) {
            if (nguoiDungGiaoDichThueXe.getId() == id) return nguoiDungGiaoDichThueXe;
        }
        return null;
    }

    public NguoiDungGiaoDichThueXe getNguoiDungGiaoDichThueXeTuongUng(NguoiDung nguoiDung){
        return get(nguoiDung.getId());
    }

    @Override
    public List<NguoiDungGiaoDichThueXe> getAll() {
        return null;
    }

    @Override
    public void save(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe) {
        this.listNguoiDungGiaoDichThueXe.add(nguoiDungGiaoDichThueXe);
        daoManager.executeQuery("INSERT INTO " + NguoiDungGiaoDichThueXe.name + " " + NguoiDungGiaoDichThueXe.paramsName +
                " VALUES " + nguoiDungGiaoDichThueXe.toSQLString() + ";");
    }

    @Override
    public void update(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe) {
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + NguoiDungGiaoDichThueXe.name +
                " WHERE id_giao_dich_thue_xe=" + nguoiDungGiaoDichThueXe.getId() + ";");
        try{
            if (resultSet.next()) {

                if (nguoiDungGiaoDichThueXe.getGiaoDichThueXe() != null)
                    resultSet.updateInt("id_giao_dich_thue_xe", nguoiDungGiaoDichThueXe.getGiaoDichThueXe().getId());
                else resultSet.updateObject("id_giao_dich_thue_xe", null);
                resultSet.updateRow();
                resultSet.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe) {

    }

}
