package database;

import entity.GiaoDichThanhToan;
import entity.NguoiDung;
import entity.NguoiDungGiaoDichThueXe;
import entity.Xe;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:25 PM , 12/17/2020
 */

/**
 * Thực hiện giao tiếp giữa controller và bảng xe trong CSDL
 */
public class XeDAO implements DAO<Xe> {
    private List<Xe> listXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    private LoaiXeDAO loaiXeDAO = LoaiXeDAO.getInstance();
    private BaiXeDAO baiXeDAO = BaiXeDAO.getInstance();
    public static XeDAO xeDAO = null;

    /**
     * Khởi tạo XeDAO mới, đọc tất cả hàng trong bảng xe
     */
    public XeDAO() {
        LoaiXeDAO loaiXeDAO = LoaiXeDAO.getInstance();
        BaiXeDAO baiXeDAO = BaiXeDAO.getInstance();
        daoManager.open();
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + Xe.name + ";");
        try {
            while (resultSet.next()){
                listXe.add(parse(resultSet));
//                System.out.println(listXe.get(listXe.size()-1).toString());
            }
            resultSet.close();
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    /**
     * Singleton
     * @return 1 đối tượng XeDAO duy nhất của mỗi phiên
     */
    public static XeDAO getInstance(){
        if (xeDAO == null){
            xeDAO = new XeDAO();
        }
        return xeDAO;
    }

    /**
     * Xử lý 1 hàng trong CSDL và trả về Xe tương ứng
     * @param resultSet ResultSet
     * @return  Xe
     */
    @Override
    public Xe parse(ResultSet resultSet) {
        try {
            return new Xe(resultSet.getInt(1),
                    loaiXeDAO.get(resultSet.getInt(2)),
                    resultSet.getString(3),
                    baiXeDAO.get(resultSet.getInt(4)),
                    resultSet.getInt(5),
                    resultSet.getObject(6) != null ? resultSet.getInt(6) : null);  //  pin: null neu la xe dap, Integer neu la xe dap dien
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Nhận vào id và trả về Xe có id tương ứng
     * @param id int
     * @return Xe
     */
    @Override
    public Xe get(int id) {
        for (Xe xe:
                this.listXe) {
            if (xe.getId() == id) return xe;
        }
        return null;
    }

    public Xe getXeTuongUng(NguoiDung nguoiDung){
        NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe = NguoiDungGiaoDichThueXeDAO.getInstance().getNguoiDungGiaoDichThueXeTuongUng(nguoiDung);
        if (nguoiDungGiaoDichThueXe.getGiaoDichThueXe() != null) return nguoiDungGiaoDichThueXe.getGiaoDichThueXe().getXe();
        return null;
    }

    /**
     * Danh sách tất cả Xe
     * @return List
     */
    @Override
    public List<Xe> getAll() {
        return this.listXe;
    }

    @Override
    public void save(Xe xe) { }

    /**
     * Cập nhật và lưu vào CSDL 1 Xe đã đổi trang_thai và bai_xe
     * @param xe Xe
     */
    @Override
    public void update(Xe xe) {
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + Xe.name +
                " WHERE id_xe=" + xe.getId() + ";");
        try{
            resultSet.next();
            resultSet.updateInt("trang_thai", xe.getTrangThai());
            resultSet.updateInt("id_bai_xe", xe.getBaiXe().getId());
            resultSet.updateRow();
            resultSet.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Xe xe) {
        listXe.remove(xe);
    }

}
