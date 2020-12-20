package controller;

import common.exception.BaiXeException;
import common.exception.MaVachException;
import database.*;
import entity.*;
import subsystem.interbanksubsystem.InterbankSubsystem;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:48 AM , 12/16/2020
 */

public class DieuKhienTraXe extends BaseController {
    public DieuKhienTraXe() {
    }

    public BaiXe getBaiXe(String  IdBaiXe){
        try {
            BaiXeDAO xeDao = BaiXeDAO.getInstance();
            BaiXe baiXe = xeDao.get(Integer.parseInt(IdBaiXe));
            return baiXe;
        } catch (RuntimeException ex) {
            throw new BaiXeException();
        }
    }
    public void TraXe(GiaoDichThueXe giaoDichThueXe, BaiXe baiXeTra){
        NguoiDungDAO nguoiDungDAO = NguoiDungDAO.getInstance();
        XeDAO xeDAO = XeDAO.getInstance();
        BaiXeDAO baiXeDAO = BaiXeDAO.getInstance();
        GiaoDichThanhToanDAO giaoDichThanhToanDAO = GiaoDichThanhToanDAO.getInstance();
        GiaoDichThueXeDAO giaoDichThueXeDAO = GiaoDichThueXeDAO.getInstance();
        NguoiDungGiaoDichThueXeDAO nguoiDungGiaoDichThueXeDAO = NguoiDungGiaoDichThueXeDAO.getInstance();

        InterbankSubsystem interbankSubsystem = new InterbankSubsystem();
        Xe xe = giaoDichThueXe.getXe();
        The the = giaoDichThueXe.getThanhToanThue().getThe();
        GiaoDichThanhToan thanhToanTra;
        int tienThua = tienThua(giaoDichThueXe);
        if (tienThua>0) {
            thanhToanTra = interbankSubsystem.refund(the, tienThua(giaoDichThueXe), "tra");
        }else{
            thanhToanTra = interbankSubsystem.pay(the, - tienThua(giaoDichThueXe), "tra");
        }
        System.out.println(thanhToanTra.toString());

        xe.setBaiXe(baiXeTra);
        xe.setTrangThai(Xe.CHUA_THUE);
        xeDAO.update(xe);

        giaoDichThueXe.setBaiXeTra(baiXeTra);
        giaoDichThueXe.setThanhToanTra(thanhToanTra);
        giaoDichThueXe.setSoTien(1);
        giaoDichThueXeDAO.update(giaoDichThueXe);

        NguoiDung nguoiDung = giaoDichThueXe.getNguoiDung();
        NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe = nguoiDungGiaoDichThueXeDAO.getNguoiDungGiaoDichThueXeTuongUng(nguoiDung);
        nguoiDungGiaoDichThueXe.setGiaoDichThueXe(null);
        nguoiDungGiaoDichThueXeDAO.update(nguoiDungGiaoDichThueXe);
    }

    public int tienThua(GiaoDichThueXe giaoDichThueXe){
        int tienCoc = giaoDichThueXe.getThanhToanThue().getAmount();
        int tienThue = tinhTienThue(giaoDichThueXe);
        return -tienCoc-tienThue;
    }
}
