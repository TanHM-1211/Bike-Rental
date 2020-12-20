package database;

import entity.BaiXe;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * BaiXe: Nhom 11
 * Create at 4:26 PM , 12/17/2020
 */

/**
 * Thực hiện giao tiếp giữa controller và bảng bai_xe trong CSDL
 */
public class BaiXeDAO implements DAO<BaiXe> {
    private List<BaiXe> listBaiXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    public static BaiXeDAO baiXeDAO = null;

    /**
     * Khởi tạo BaiXeDAO mới, đọc tất cả hàng trong bảng bai_xe
     */
    public BaiXeDAO() {
        daoManager.open();
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + BaiXe.name + ";");
        try {
            while (resultSet.next()){
                listBaiXe.add(parse(resultSet));
            }
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Singleton
     * @return 1 đối tượng BaiXeDAO duy nhất của mỗi phiên
     */
    public static BaiXeDAO getInstance(){
        if (baiXeDAO == null){
            baiXeDAO = new BaiXeDAO();
        }
        return baiXeDAO;
    }

    /**
     * Xử lý 1 hàng trong CSDL và trả về BaiXe tương ứng
     * @param resultSet ResultSet
     * @return  BaiXe
     */
    @Override
    public BaiXe parse(ResultSet resultSet) {
        try {
        return new BaiXe(resultSet.getInt(1), resultSet.getString(2),
                resultSet.getString(3), resultSet.getInt(4));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Nhận vào id và trả về BaiXe có id tương ứng
     * @param id int
     * @return BaiXe
     */
    @Override
    public BaiXe get(int id) {
        for (BaiXe baiXe:
             listBaiXe) {
            if (baiXe.getId() == id) return baiXe;
        }
        return null;
    }

    /**
     * Danh sách tất cả BaiXe
     * @return List
     */
    @Override
    public List<BaiXe> getAll() {
        return listBaiXe;
    }

    @Override
    public void save(BaiXe baiXe) {
//        listBaiXe.add(baiXe);
    }

    @Override
    public void update(BaiXe baiXe) {
    }

    @Override
    public void delete(BaiXe baiXe) {
    }

}
