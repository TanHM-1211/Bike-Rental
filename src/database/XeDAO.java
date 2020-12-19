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


public class XeDAO implements DAO<Xe> {
    private List<Xe> listXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    public static XeDAO xeDAO = null;

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

    public static XeDAO getInstance(){
        if (xeDAO == null){
            xeDAO = new XeDAO();
        }
        return xeDAO;
    }

    @Override
    public Xe parse(ResultSet resultSet) {
        LoaiXeDAO loaiXeDAO = LoaiXeDAO.getInstance();
        BaiXeDAO baiXeDAO = BaiXeDAO.getInstance();
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

    @Override
    public List<Xe> getAll() {
        return listXe;
    }

    @Override
    public void save(Xe xe) {
        this.listXe.add(xe);
    }

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
