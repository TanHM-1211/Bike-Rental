package database;

import entity.NguoiDung;
import entity.Xe;

import java.sql.ResultSet;
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
        daoManager.open();
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + NguoiDung.name + ";");
        try {
            while (resultSet.next()){
                this.listNguoiDung.add(parse(resultSet));
//                System.out.println(listXe.get(listXe.size()-1).toString());
            }
            resultSet.close();
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public static NguoiDungDAO getInstance(){
        if (nguoiDungDAO == null){
            nguoiDungDAO = new NguoiDungDAO();
        }
        return nguoiDungDAO;
    }

    public NguoiDung getNguoiDungHienTai(){
        return this.nguoiDungHienTai;
    }

    @Override
    public NguoiDung get(int id) {
        for (NguoiDung nguoiDung:
             this.listNguoiDung) {
            if (nguoiDung.getId() == id) return nguoiDung;
        }
        return null;
    }

    @Override
    public NguoiDung parse(ResultSet resultSet) {
        try {
            return new NguoiDung(resultSet.getInt(1));
        }catch (Exception e){
            e.printStackTrace();
        }
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
    public void update(NguoiDung nguoiDung) {

    }

    @Override
    public void delete(NguoiDung nguoiDung) {

    }

}
