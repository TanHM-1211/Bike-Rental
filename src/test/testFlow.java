package test;

import database.*;
import entity.*;
import subsystem.interbanksubsystem.InterbankSubsystem;

import java.util.Random;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 10:18 PM , 12/19/2020
 */

public class testFlow {
    public static void main(String args[]){
        Random rd = new Random(22);
        DAOManager daoManager = DAOManager.getInstance();
        NguoiDungDAO nguoiDungDAO = NguoiDungDAO.getInstance();
        XeDAO xeDAO = XeDAO.getInstance();
        BaiXeDAO baiXeDAO = BaiXeDAO.getInstance();
        GiaoDichThanhToanDAO giaoDichThanhToanDAO = GiaoDichThanhToanDAO.getInstance();
        GiaoDichThueXeDAO giaoDichThueXeDAO = GiaoDichThueXeDAO.getInstance();
        TheDAO theDAO = TheDAO.getInstance();
        NguoiDungGiaoDichThueXeDAO nguoiDungGiaoDichThueXeDAO = NguoiDungGiaoDichThueXeDAO.getInstance();

        daoManager.open();
        NguoiDung nguoiDung = nguoiDungDAO.getNguoiDungHienTai();
        InterbankSubsystem interbankSubsystem = new InterbankSubsystem();
        The the = TheDAO.getInstance().getTheHienTai();

        // thue xe
        NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe = nguoiDungGiaoDichThueXeDAO.getNguoiDungGiaoDichThueXeTuongUng(nguoiDung);
        if (nguoiDungGiaoDichThueXe == null){

            nguoiDungGiaoDichThueXe = nguoiDungGiaoDichThueXeDAO.makeNguoiDungGiaoDichThueXe(nguoiDung, null);
            nguoiDungGiaoDichThueXeDAO.save(nguoiDungGiaoDichThueXe);
        }

        if (nguoiDungGiaoDichThueXe.getGiaoDichThueXe() == null){
            Xe xe = xeDAO.getAll().get(rd.nextInt(xeDAO.getAll().size()-1));

            GiaoDichThanhToan thanhToanThue = interbankSubsystem.pay(the, (int)(xe.getLoaiXe().getGiaTri() * 0.4), "thue");
            giaoDichThanhToanDAO.save(thanhToanThue);
            BaiXe baiXeThue = xe.getBaiXe();

            GiaoDichThueXe giaoDichThueXe = giaoDichThueXeDAO.makeGiaoDichThueXeCoBan(xe, nguoiDung,
                    baiXeThue, thanhToanThue);
            giaoDichThueXeDAO.save(giaoDichThueXe);

            xe.setTrangThai(Xe.DANG_THUE);
            xeDAO.update(xe);

            nguoiDungGiaoDichThueXe.setGiaoDichThueXe(giaoDichThueXe);
            nguoiDungGiaoDichThueXeDAO.update(nguoiDungGiaoDichThueXe);
        }

        // tra xe
        Xe xe = xeDAO.getXeTuongUng(nguoiDung);
        GiaoDichThueXe giaoDichThueXe = giaoDichThueXeDAO.getGiaoDichThueXeTuongUng(nguoiDung);
        GiaoDichThanhToan thanhToanTra = interbankSubsystem.refund(the, (int)(xe.getLoaiXe().getGiaTri() * 0.4) - 1, "tra");
        giaoDichThanhToanDAO.save(thanhToanTra);
        BaiXe baiXeTra = baiXeDAO.getAll().get(rd.nextInt(baiXeDAO.getAll().size()));

        xe.setBaiXe(baiXeTra);
        xe.setTrangThai(Xe.CHUA_THUE);
        xeDAO.update(xe);

        giaoDichThueXe.setBaiXeTra(baiXeTra);
        giaoDichThueXe.setThanhToanTra(thanhToanTra);
        giaoDichThueXe.setSoTien(1);
        giaoDichThueXeDAO.update(giaoDichThueXe);

        nguoiDungGiaoDichThueXe.setGiaoDichThueXe(null);
        nguoiDungGiaoDichThueXeDAO.update(nguoiDungGiaoDichThueXe);
    }
}
