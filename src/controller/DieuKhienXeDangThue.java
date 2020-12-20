package controller;

import database.NguoiDungGiaoDichThueXeDAO;
import entity.GiaoDichThueXe;
import entity.NguoiDung;
import entity.NguoiDungGiaoDichThueXe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 20/12/2020, Sun
 **/
public class DieuKhienXeDangThue extends BaseController {

    public GiaoDichThueXe getGiaoDichHienTai() {
        NguoiDung nguoiDung = getNguoiDungHienTai();
        NguoiDungGiaoDichThueXeDAO nguoiDungGiaoDichThueXeDAO = NguoiDungGiaoDichThueXeDAO.getInstance();
        NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe = nguoiDungGiaoDichThueXeDAO.getNguoiDungGiaoDichThueXeTuongUng(nguoiDung);
        return nguoiDungGiaoDichThueXe.getGiaoDichThueXe();
    }

    public int getThoiGianThue(GiaoDichThueXe giaoDichThueXe){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String temp1 = dtf.format(now);
        String temp2 = giaoDichThueXe.getThanhToanThue().getCreatedAt();
        System.out.println(temp1);
        System.out.println(temp2);
        return tinhThoiGianThue(temp2,temp1);
    }

    public int tinhTienThue(int thueTheoPhut, GiaoDichThueXe giaoDichThueXe){
        return super.tinhTienThue(thueTheoPhut,giaoDichThueXe.getXe());
    }
}
