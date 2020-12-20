package controller;

import database.*;
import entity.*;
import subsystem.interbanksubsystem.InterbankSubsystem;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:42 AM , 12/16/2020
 */

public class DieuKhienThueXe extends BaseController{
    private Xe xe;
    private NguoiDung nguoiDung = getNguoiDungHienTai();
    private The the;

    public DieuKhienThueXe(Xe xe) {
        super();
        this.xe = xe;
    }

    public The getThe() {
        return the;
    }

    public void setThe(The the) {
        this.the = the;
    }
    public Xe getXe() {
        return xe;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void thanhToanCoc() {
        XeDAO xeDAO = XeDAO.getInstance();
        GiaoDichThanhToanDAO giaoDichThanhToanDAO = GiaoDichThanhToanDAO.getInstance();
        GiaoDichThueXeDAO giaoDichThueXeDAO = GiaoDichThueXeDAO.getInstance();
        NguoiDungGiaoDichThueXeDAO nguoiDungGiaoDichThueXeDAO = NguoiDungGiaoDichThueXeDAO.getInstance();

        InterbankSubsystem interbankSubsystem = new InterbankSubsystem();
        GiaoDichThanhToan thanhToanThue = interbankSubsystem.pay(the, xe.getCoc(), "thue");
        giaoDichThanhToanDAO.save(thanhToanThue);

        BaiXe baiXeThue = xe.getBaiXe();
        GiaoDichThueXe giaoDichThueXe = giaoDichThueXeDAO.makeGiaoDichThueXeCoBan(xe, nguoiDung,baiXeThue, thanhToanThue);
        giaoDichThueXeDAO.save(giaoDichThueXe);

        xe.setTrangThai(Xe.DANG_THUE);
        xeDAO.update(xe);

        NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe = nguoiDungGiaoDichThueXeDAO.getNguoiDungGiaoDichThueXeTuongUng(nguoiDung);
        nguoiDungGiaoDichThueXe.setGiaoDichThueXe(giaoDichThueXe);
        nguoiDungGiaoDichThueXeDAO.update(nguoiDungGiaoDichThueXe);
    }

    public void mokhoa(){

    }
}
