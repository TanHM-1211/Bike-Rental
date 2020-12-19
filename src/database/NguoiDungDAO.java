package database;

import entity.LoaiXe;
import entity.NguoiDung;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:09 PM , 12/18/2020
 */

public class NguoiDungDAO implements DAO<NguoiDung> {
    private List<NguoiDung> listNguoiDung = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    private NguoiDung nguoiDungHienTai;
    public static NguoiDungDAO nguoiDungDAO = null;

    public NguoiDungDAO() {
        this.nguoiDungHienTai = NguoiDung.getInstance();
    }

    public static NguoiDungDAO getInstance(){
        if (nguoiDungDAO == null){
            nguoiDungDAO = new NguoiDungDAO();
        }
        return nguoiDungDAO;
    }

    @Override
    public NguoiDung get(int id) {
        return null;
    }

    @Override
    public List<NguoiDung> getAll() {
        return null;
    }

    @Override
    public void save(NguoiDung nguoiDung) {

    }

    @Override
    public void update(NguoiDung nguoiDung, String[] params) {

    }

    @Override
    public void delete(NguoiDung nguoiDung) {

    }

    @Override
    public String getInsertQuery(List<NguoiDung> list) {
        return null;
    }
}
