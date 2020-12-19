package database;

import entity.LoaiXe;
import entity.NguoiDungGiaoDichThueXe;
import entity.The;

import java.sql.ResultSet;
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
    private The theHienTai;
    public static TheDAO theDAO = null;

    public TheDAO() {
        this.theHienTai = The.getInstance();
    }

    public static TheDAO getInstance(){
        if (theDAO == null){
            theDAO = new TheDAO();
        }
        return theDAO;
    }

    @Override
    public The parse(ResultSet resultSet) {
        return null;
    }

    public The getTheHienTai(){
        return this.theHienTai;
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
