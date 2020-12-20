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

/**
 * Thực hiện giao tiếp giữa controller và bảng nguoi_dung_giao_dich_thue_xe trong CSDL
 */
public class NguoiDungGiaoDichThueXeDAO implements DAO<NguoiDungGiaoDichThueXe> {
    private List<NguoiDungGiaoDichThueXe> listNguoiDungGiaoDichThueXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    private NguoiDungDAO nguoiDungDAO = NguoiDungDAO.getInstance();
    private GiaoDichThueXeDAO giaoDichThueXeDAO = GiaoDichThueXeDAO.getInstance();

    public static NguoiDungGiaoDichThueXeDAO nguoiDungGiaoDichThueXeDAO = null;

    /**
     * Khởi tạo NguoiDungGiaoDichThueXeDAO mới, đọc tất cả hàng trong bảng nguoi_dung_giao_dich_thue_xe
     */
    public NguoiDungGiaoDichThueXeDAO() {
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + NguoiDungGiaoDichThueXe.name + ";");
        try {

            while (resultSet.next()){
                listNguoiDungGiaoDichThueXe.add(parse(resultSet));
            }
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Singleton
     * @return 1 đối tượng NguoiDungGiaoDichThueXeDAO duy nhất của mỗi phiên
     */
    public static NguoiDungGiaoDichThueXeDAO getInstance(){
        if(nguoiDungGiaoDichThueXeDAO == null){
            nguoiDungGiaoDichThueXeDAO = new NguoiDungGiaoDichThueXeDAO();
        }
        return nguoiDungGiaoDichThueXeDAO;
    }

    /**
     * Xử lý 1 hàng trong CSDL và trả về NguoiDungGiaoDichThueXe tương ứng
     * @param resultSet ResultSet
     * @return  NguoiDungGiaoDichThueXe
     */
    @Override
    public NguoiDungGiaoDichThueXe parse(ResultSet resultSet) {
        try {

            NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe = new NguoiDungGiaoDichThueXe(resultSet.getInt(1),
                    nguoiDungDAO.get(resultSet.getInt(2)),
                    resultSet.getObject(3) != null ? giaoDichThueXeDAO.get(resultSet.getInt(3)) : null  // nullable
            );
            System.out.println(1);
            return nguoiDungGiaoDichThueXe;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * tạo mới 1 đối tượng NguoiDungGiaoDichThueXe
     * @param nguoiDung NguoiDung
     * @param giaoDichThueXe GiaoDichThueXe
     * @return
     */
    public NguoiDungGiaoDichThueXe makeNguoiDungGiaoDichThueXe(NguoiDung nguoiDung,
                                                               GiaoDichThueXe giaoDichThueXe){
        return new NguoiDungGiaoDichThueXe(this.listNguoiDungGiaoDichThueXe.size(), nguoiDung, giaoDichThueXe);
    }

    /**
     * Nhận vào id và trả về NguoiDungGiaoDichThueXe có id tương ứng
     * @param id int
     * @return NguoiDungGiaoDichThueXe
     */
    @Override
    public NguoiDungGiaoDichThueXe get(int id) {
        for (NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe:
             this.listNguoiDungGiaoDichThueXe) {
            if (nguoiDungGiaoDichThueXe.getId() == id) return nguoiDungGiaoDichThueXe;
        }
        return null;
    }

    /**
     * Đưa ra NguoiDungGiaoDichThueXe tương ứng của nguoiDung trong phiên hiện tại
     * @param nguoiDung NguoiDung
     * @return GiaoDichThueXe nếu nguoiDung đã từng thuê xe, null nếu nguoiDung chưa thuê xe lần nào
     */
    public NguoiDungGiaoDichThueXe getNguoiDungGiaoDichThueXeTuongUng(NguoiDung nguoiDung){
        for(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe: this.listNguoiDungGiaoDichThueXe){
//            System.out.println(nguoiDungGiaoDichThueXe.toString());
            if(nguoiDungGiaoDichThueXe.getNguoiDung().getId() == nguoiDung.getId()) return nguoiDungGiaoDichThueXe;
        }
        return null;
    }

    /**
     * Danh sách tất cả NguoiDungGiaoDichThueXe
     * @return List
     */
    @Override
    public List<NguoiDungGiaoDichThueXe> getAll() {
        return this.listNguoiDungGiaoDichThueXe;
    }

    /**
     * Lưu 1 NguoiDungGiaoDichThueXe vào CSDL
     * @param nguoiDungGiaoDichThueXe NguoiDungGiaoDichThueXe
     */
    @Override
    public void save(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe) {
        this.listNguoiDungGiaoDichThueXe.add(nguoiDungGiaoDichThueXe);
        daoManager.executeQuery("INSERT INTO " + NguoiDungGiaoDichThueXe.name + " " + NguoiDungGiaoDichThueXe.paramsName +
                " VALUES " + nguoiDungGiaoDichThueXe.toSQLString() + ";");
    }

    /**
     * Cập nhật và lưu vào CSDL 1 NguoiDungGiaoDichThueXe từ trạng thái chưa thuê sang đang thuê, hoặc đang thuê sang chưa thuê
     * @param nguoiDungGiaoDichThueXe NguoiDungGiaoDichThueXe
     */
    @Override
    public void update(NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe) {
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + NguoiDungGiaoDichThueXe.name +
                " WHERE id_nguoi_dung_giao_dich_thue_xe=" + nguoiDungGiaoDichThueXe.getId() + ";");
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
