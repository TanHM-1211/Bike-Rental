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

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:46 AM , 12/16/2020
 */

public class BaseController {
    public GiaoDichThueXe getGiaoDichHienTai() {
        NguoiDungDAO nguoiDungDAO = NguoiDungDAO.getInstance();
        NguoiDung nguoiDung = nguoiDungDAO.getNguoiDungHienTai();

        NguoiDungGiaoDichThueXeDAO nguoiDungGiaoDichThueXeDAO = NguoiDungGiaoDichThueXeDAO.getInstance();
        NguoiDungGiaoDichThueXe nguoiDungGiaoDichThueXe = nguoiDungGiaoDichThueXeDAO.getNguoiDungGiaoDichThueXeTuongUng(nguoiDung);
        return nguoiDungGiaoDichThueXe.getGiaoDichThueXe();
    }

    public Xe layThongTinXeTheoMa(String maVach) {
        try {
            XeDAO xeDao = XeDAO.getInstance();
            Xe xe = xeDao.get(Integer.parseInt(maVach));
            return xe;
        } catch (RuntimeException ex) {
            throw new MaVachException("Mã vạch không hợp lệ");
        }
    }
}
