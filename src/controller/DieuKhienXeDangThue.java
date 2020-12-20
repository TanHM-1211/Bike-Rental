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

}
