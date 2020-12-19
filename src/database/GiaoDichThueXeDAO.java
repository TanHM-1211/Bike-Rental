package database;

import entity.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:26 PM , 12/17/2020
 */

public class GiaoDichThueXeDAO implements DAO<GiaoDichThueXe> {
    private List<GiaoDichThueXe> listGiaoDichThueXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    private NguoiDungDAO nguoiDungDAO = NguoiDungDAO.getInstance();
    private XeDAO xeDAO = XeDAO.getInstance();
    private BaiXeDAO baiXeDAO = BaiXeDAO.getInstance();
    private GiaoDichThanhToanDAO giaoDichThanhToanDAO = GiaoDichThanhToanDAO.getInstance();
    public static GiaoDichThueXeDAO giaoDichThueXeDAO = null;

    public GiaoDichThueXeDAO(){
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + GiaoDichThueXe.name + ";");
        try {
            while (resultSet.next()){
                listGiaoDichThueXe.add(this.parse(resultSet));
            }
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static GiaoDichThueXeDAO getInstance(){
        if (giaoDichThueXeDAO == null){
            giaoDichThueXeDAO = new GiaoDichThueXeDAO();
        }
        return giaoDichThueXeDAO;
    }

    @Override
    public GiaoDichThueXe parse(ResultSet resultSet) {
        try {
            return new GiaoDichThueXe(resultSet.getInt(1),
                    xeDAO.get(resultSet.getInt(2)),
                    nguoiDungDAO.get(resultSet.getInt(3)),
                    baiXeDAO.get(resultSet.getInt(4)),
                    resultSet.getObject(5) != null ? baiXeDAO.get(resultSet.getInt(5)): null,
                    giaoDichThanhToanDAO.get(resultSet.getInt(6)),
                    resultSet.getObject(7) != null ? giaoDichThanhToanDAO.get(resultSet.getInt(7)): null,
                    resultSet.getObject(8) != null ? resultSet.getInt(8): null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public GiaoDichThueXe makeGiaoDichThueXeCoBan(Xe xe, NguoiDung nguoiDung, BaiXe baiXeThue, GiaoDichThanhToan giaoDichThanhToanThue){
        return new GiaoDichThueXe(this.listGiaoDichThueXe.size(), xe, nguoiDung, baiXeThue, null, giaoDichThanhToanThue,
                null, null);
    }

    @Override
    public GiaoDichThueXe get(int id) {
        for (GiaoDichThueXe giaoDichThueXe:
                this.listGiaoDichThueXe) {
            if (giaoDichThueXe.getId() == id) return giaoDichThueXe;
        }
        return null;
    }

    @Override
    public List<GiaoDichThueXe> getAll() {
        return this.listGiaoDichThueXe;
    }

    public GiaoDichThueXe getGiaoDichThueXeTuongUng(NguoiDung nguoiDung){
        NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe = NguoiDungGiaoDichThueXeDAO.getInstance().getNguoiDungGiaoDichThueXeTuongUng(nguoiDung);
        if (nguoiDungGiaoDichThueXe != null)
            return nguoiDungGiaoDichThueXe.getGiaoDichThueXe();
        else return null;
    }

    @Override
    public void save(GiaoDichThueXe giaoDichThueXe) {
        this.listGiaoDichThueXe.add(giaoDichThueXe);
        daoManager.executeQuery("INSERT INTO " + GiaoDichThueXe.name + " " + GiaoDichThueXe.paramsName +
                " VALUES " + giaoDichThueXe.toSQLString() + ";");
    }

    /*
    update giao dich hoan chinh
     */
    @Override
    public void update(GiaoDichThueXe giaoDichThueXe) {
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + GiaoDichThueXe.name +
                " WHERE id_giao_dich_thue_xe=" + giaoDichThueXe.getId() + ";");
        try{
            resultSet.next();
            resultSet.updateInt("id_bai_xe_tra", giaoDichThueXe.getBaiXeTra().getId());
            resultSet.updateInt("id_thanh_toan_tra", giaoDichThueXe.getThanhToanTra().getId());
            resultSet.updateInt("so_tien", giaoDichThueXe.getSoTien());
            resultSet.updateRow();
            resultSet.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(GiaoDichThueXe giaoDichThueXe) {

    }

}