package database;

import entity.LoaiXe;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:08 PM , 12/18/2020
 */

/**
 * Thực hiện giao tiếp giữa controller và bảng loai_xe trong CSDL
 */
public class LoaiXeDAO implements DAO<LoaiXe> {
    private List<LoaiXe> listLoaiXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    public static LoaiXeDAO loaiXeDAO = null;

    /**
     * Khởi tạo GiaoDichThueXeDAO mới, đọc tất cả hàng trong bảng loai_xe
     */
    public LoaiXeDAO() {
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

    /**
     * Singleton
     * @return 1 đối tượng LoaiXeDAO  duy nhất của mỗi phiên
     */
    public static LoaiXeDAO getInstance(){
        if(loaiXeDAO == null){
            loaiXeDAO = new LoaiXeDAO();
        }
        return loaiXeDAO;
    }

    /**
     * Xử lý 1 hàng trong CSDL và trả về LoaiXe tương ứng
     * @param resultSet ResultSet
     * @return  LoaiXe
     */
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

    /**
     * Nhận vào id và trả về LoaiXe có id tương ứng
     * @param id int
     * @return LoaiXe
     */
    @Override
    public LoaiXe get(int id) {
        for (LoaiXe loaiXe:
                this.listLoaiXe) {
            if (loaiXe.getId() == id) return loaiXe;
        }
        return null;
    }

    /**
     * Danh sách tất cả LoaiXe
     * @return List
     */
    @Override
    public List<LoaiXe> getAll() {
        return this.listLoaiXe;
    }

    @Override
    public void save(LoaiXe loaiXe) {

    }

    @Override
    public void update(LoaiXe loaiXe) {

    }

    @Override
    public void delete(LoaiXe loaiXe) {

    }

}
