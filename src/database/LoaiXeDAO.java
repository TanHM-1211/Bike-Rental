package database;

import entity.BaiXe;
import entity.GiaoDichThueXe;
import entity.LoaiXe;

import java.sql.ResultSet;
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
    public static LoaiXeDAO loaiXeDAO = null;

    public LoaiXeDAO() {
        daoManager.open();
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + LoaiXe.name + ";");
        try {
            while (resultSet.next()){
                listLoaiXe.add(parse(resultSet));
            }
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static LoaiXeDAO getInstance(){
        if(loaiXeDAO == null){
            loaiXeDAO = new LoaiXeDAO();
        }
        return loaiXeDAO;
    }

    @Override
    public LoaiXe parse(ResultSet resultSet) {
        try {
            return new LoaiXe(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LoaiXe get(int id) {
        for (LoaiXe loaiXe:
                this.listLoaiXe) {
            if (loaiXe.getId() == id) return loaiXe;
        }
        return null;
    }

    @Override
    public List<LoaiXe> getAll() {
        return this.listLoaiXe;
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
