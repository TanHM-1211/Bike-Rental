package entity;

import java.util.Date;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:50 AM , 12/16/2020
 */

/*
    Doc va ghi
 */

public class GiaoDichThueXe{
    private int idGiaoDichThueXe;
    private int idXe;
    private int idNguoiDung;
    private int idBaiXeThue;
    private int idBaiXeTra;
    private GiaoDichThanhToan thanhToanThue;
    private GiaoDichThanhToan thanhToanTra;
    private int soTien;

    public static String paramsName = "";
    public static String name = "giao_dich_thue_xe";

    public GiaoDichThueXe(){}

    public GiaoDichThueXe(int idGiaoDichThueXe, int idXe, int idNguoiDung, int idBaiXeThue, GiaoDichThanhToan thanhToanThue) {
        this.idGiaoDichThueXe = idGiaoDichThueXe;
        this.idXe = idXe;
        this.idNguoiDung = idNguoiDung;
        this.idBaiXeThue = idBaiXeThue;
        this.thanhToanThue = thanhToanThue;
    }

    @Override
    public String toString() {
        if (this.thanhToanTra != null)
            return "(" +
                    "idGiaoDichThueXe=" + idGiaoDichThueXe +
                    ", idXe=" + idXe +
                    ", idNguoiDung=" + idNguoiDung +
                    ", idBaiXeThue=" + idBaiXeThue +
                    ", idBaiXeTra=" + idBaiXeTra +
                    ", thanhToanThue=" + thanhToanThue +
                    ", thanhToanTra=" + thanhToanTra +
                    ", soTien=" + soTien +
                    '}';
        else
            return "(" +
                "idGiaoDichThueXe=" + idGiaoDichThueXe +
                ", idXe=" + idXe +
                ", idNguoiDung=" + idNguoiDung +
                ", idBaiXeThue=" + idBaiXeThue +
                ", idBaiXeTra=" + idBaiXeTra +
                ", thanhToanThue=" + thanhToanThue +
                ", thanhToanTra=" + thanhToanTra +
                ", soTien=" + soTien +
                '}';
    }

    public int getIdGiaoDichThueXe() {
        return idGiaoDichThueXe;
    }

    public void setIdGiaoDichThueXe(int idGiaoDichThueXe) {
        this.idGiaoDichThueXe = idGiaoDichThueXe;
    }

    public int getIdXe() {
        return idXe;
    }

    public void setIdXe(int idXe) {
        this.idXe = idXe;
    }

    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public int getIdBaiXeThue() {
        return idBaiXeThue;
    }

    public void setIdBaiXeThue(int idBaiXeThue) {
        this.idBaiXeThue = idBaiXeThue;
    }

    public int getIdBaiXeTra() {
        return idBaiXeTra;
    }

    public void setIdBaiXeTra(int idBaiXeTra) {
        this.idBaiXeTra = idBaiXeTra;
    }

    public GiaoDichThanhToan getThanhToanThue() {
        return thanhToanThue;
    }

    public void setThanhToanThue(GiaoDichThanhToan thanhToanThue) {
        this.thanhToanThue = thanhToanThue;
    }

    public GiaoDichThanhToan getThanhToanTra() {
        return thanhToanTra;
    }

    public void setThanhToanTra(GiaoDichThanhToan thanhToanTra) {
        this.thanhToanTra = thanhToanTra;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }
}

/*

 INSERT INTO GiaoDichThueXe
 (id,idXe,idNguoiDung,idBaiXeThue,idBaiXeTra,thoiDiemThue,thoiDiemTra,tongThoiGianDung,idTheGiaoDich,cachThue)
 VALUES
 (002,003,001,001,003,'20201120 09:15:20','20201120 15:5:20',15,'118131_group11_2020',1),
 (003,009,001,001,002,'20201130 13:32:20','20201130 17:15:20',15,'118131_group11_2020',1);
 */
