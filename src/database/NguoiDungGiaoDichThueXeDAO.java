package database;

import entity.NguoiDung;
import entity.NguoiDungGiaoDichThueXe;

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
    public NguoiDungGiaoDichThueXe get(int id) {
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
    public void update(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe, String[] params) {

    }

    @Override
    public void delete(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe) {

    }

    @Override
    public String getInsertQuery(List<NguoiDungGiaoDichThueXe> list) {
        return null;
    }
}
