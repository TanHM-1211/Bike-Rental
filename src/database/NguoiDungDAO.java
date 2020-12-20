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

    /**
     * Trả về NguoiDung trong phiên hiện tại, mặc định có id = 1
     * @return NguoiDung
     */
    public NguoiDung getNguoiDungHienTai(){
        return this.nguoiDungHienTai;
    }

    /**
     * Nhận vào id và trả về NguoiDung có id tương ứng
     * @param id int
     * @return NguoiDung
     */
    @Override
    public NguoiDung get(int id) {
        for (NguoiDung nguoiDung:
             this.listNguoiDung) {
            if (nguoiDung.getId() == id) return nguoiDung;
        }
        return null;
    }

    /**
     * Xử lý 1 hàng trong CSDL và trả về NguoiDung tương ứng
     * @param resultSet ResultSet
     * @return  NguoiDung
     */
    @Override
    public NguoiDung parse(ResultSet resultSet) {
        try {
            return new NguoiDung(resultSet.getInt(1));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Danh sách tất cả NguoiDung
     * @return List
     */
    @Override
    public List<NguoiDung> getAll() {
        return this.listNguoiDung;
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
