package entity;

import java.util.Date;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:50 AM , 12/16/2020
 */

public class GiaoDichThueXe {
    private int id;
    private int idXe;
    private int idNguoiDung;
    private int idBaiXeThue;
    private int IdBaiXeTra;
    private Date thoiDiemThue;
    private Date thoiDiemTra;
    private int tongThoiGianDung;
    private String idTheGiaoDich;
    private int cachThue;

    public GiaoDichThueXe(){}

    public GiaoDichThueXe(int id, int idXe, int idNguoiDung, int idBaiXeThue, int idBaiXeTra, Date thoiDiemThue, Date thoiDiemTra, int tongThoiGianDung, String idTheGiaoDich, int cachThue) {
        this.id = id;
        this.idXe = idXe;
        this.idNguoiDung = idNguoiDung;
        this.idBaiXeThue = idBaiXeThue;
        IdBaiXeTra = idBaiXeTra;
        this.thoiDiemThue = thoiDiemThue;
        this.thoiDiemTra = thoiDiemTra;
        this.tongThoiGianDung = tongThoiGianDung;
        this.idTheGiaoDich = idTheGiaoDich;
        this.cachThue = cachThue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return IdBaiXeTra;
    }

    public void setIdBaiXeTra(int idBaiXeTra) {
        IdBaiXeTra = idBaiXeTra;
    }

    public Date getThoiDiemThue() {
        return thoiDiemThue;
    }

    public void setThoiDiemThue(Date thoiDiemThue) {
        this.thoiDiemThue = thoiDiemThue;
    }

    public Date getThoiDiemTra() {
        return thoiDiemTra;
    }

    public void setThoiDiemTra(Date thoiDiemTra) {
        this.thoiDiemTra = thoiDiemTra;
    }

    public int getTongThoiGianDung() {
        return tongThoiGianDung;
    }

    public void setTongThoiGianDung(int tongThoiGianDung) {
        this.tongThoiGianDung = tongThoiGianDung;
    }

    public String getIdTheGiaoDich() {
        return idTheGiaoDich;
    }

    public void setIdTheGiaoDich(String idTheGiaoDich) {
        this.idTheGiaoDich = idTheGiaoDich;
    }

    public int getCachThue() {
        return cachThue;
    }

    public void setCachThue(int cachThue) {
        this.cachThue = cachThue;
    }
}

/*

 INSERT INTO GiaoDichThueXe
 (id,idXe,idNguoiDung,idBaiXeThue,idBaiXeTra,thoiDiemThue,thoiDiemTra,tongThoiGianDung,idTheGiaoDich,cachThue)
 VALUES
 (002,003,001,001,003,'20201120 09:15:20','20201120 15:5:20',15,'118131_group11_2020',1),
 (003,009,001,001,002,'20201130 13:32:20','20201130 17:15:20',15,'118131_group11_2020',1);
 */
