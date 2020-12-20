package controller;

import common.exception.MaVachException;
import database.NguoiDungDAO;
import database.NguoiDungGiaoDichThueXeDAO;
import database.XeDAO;
import entity.GiaoDichThueXe;
import entity.NguoiDung;
import entity.NguoiDungGiaoDichThueXe;
import entity.Xe;
import views.screen.GiaoDienKetQua;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:46 AM , 12/16/2020
 */

public class BaseController {
    public  NguoiDung getNguoiDungHienTai(){
        NguoiDungDAO nguoiDungDAO = NguoiDungDAO.getInstance();
        NguoiDung nguoiDung = nguoiDungDAO.getNguoiDungHienTai();
        return nguoiDung;
    }

    public Xe layThongTinXeTheoMa(String maVach) {
        try {
            XeDAO xeDao = XeDAO.getInstance();
            Xe xe = xeDao.get(Integer.parseInt(maVach));
            return xe;
        } catch (RuntimeException ex) {
            throw new MaVachException();
        }
    }

    /**
     * Ham tinh tien thue xe
     * @param thoiDiemBatDau theo khuon "yyyy/MM/dd HH:mm:ss"
     * @param thoiDiemKetThuc theo khuon "yyyy/MM/dd HH:mm:ss"
     * @return so tien thue xe
     */
    public int tinhThoiGianThue(String thoiDiemBatDau, String thoiDiemKetThuc){
        java.util.Date temp1;
        java.util.Date temp2;
        int thueTheoPhut ;
        try {
            temp1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(thoiDiemBatDau);
            temp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(thoiDiemKetThuc);
            thueTheoPhut = (int) Math.ceil((temp2.getTime() - temp1.getTime())/60000);
            return thueTheoPhut;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int tinhThoiGianThue(GiaoDichThueXe giaoDichThueXe){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String temp1 = dtf.format(now);
        String temp2 = giaoDichThueXe.getThanhToanThue().getCreatedAt();
        System.out.println(temp1);
        System.out.println(temp2);
        return tinhThoiGianThue(temp2,temp1);
    }


    public int tinhTienThue(int thueTheoPhut, Xe xe){
        if (thueTheoPhut <= 30){
            return xe.getLoaiXe().getGia30pDau();
        }

        int sau30 = 1;
        sau30+=(int) Math.ceil((thueTheoPhut -30)/15);
        return xe.getLoaiXe().getGia30pDau() + sau30*xe.getLoaiXe().getGiaMoi15p();
    }

    public int tinhTienThue(String thoiDiemBatDau, String thoiDiemKetThuc, Xe xe){
        int thueTheoPhut = tinhThoiGianThue(thoiDiemBatDau,thoiDiemKetThuc);
        return tinhTienThue(thueTheoPhut,xe);
    }


    public int tinhTienThue(GiaoDichThueXe giaoDichThueXe){
        int thueTheoPhut = tinhThoiGianThue(giaoDichThueXe);
        Xe xe = giaoDichThueXe.getXe();
        return tinhTienThue(thueTheoPhut,xe);
    }
}
