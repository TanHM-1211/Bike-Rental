package entity;

import database.XeDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:49 AM , 12/16/2020
 */

/*
    Chi doc
 */
public class BaiXe{
    private int id ;
    private String tenBaiXe;
    private String diaChi;
    private int dienTich;
    public static String paramsName = "(id_bai_xe, ten_bai_xe, dia_chi, dien_tich)";
    public static String name = "bai_xe";
    public BaiXe() {
    }

    public BaiXe(int id, String tenBaiXe, String diaChi, int dienTich) {
        this.id = id;
        this.tenBaiXe = tenBaiXe;
        this.diaChi = diaChi;
        this.dienTich = dienTich;
    }

    public String toSQLSetString() {
        return  "(" + id +
                ", '" + tenBaiXe + '\'' +
                ", '" + diaChi + '\'' +
                ", " + dienTich +
                ")";
    }

    @Override
    public String toString() {
        return "BaiXe{" +
                "id=" + id +
                ", tenBaiXe='" + tenBaiXe + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", dienTich=" + dienTich +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBaiXe() {
        return tenBaiXe;
    }

    public void setTenBaiXe(String tenBaiXe) {
        this.tenBaiXe = tenBaiXe;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }



    //test

    public static List getXeTrongBai(BaiXe baiXe){
        ArrayList list = new ArrayList();
        XeDAO xeDAO = XeDAO.getInstance();
        for (Xe xe:
             xeDAO.getAll()) {
            if (xe.getBaiXe().getId() == baiXe.getId() && xe.getTrangThai() == Xe.CHUA_THUE){
                list.add(xe);
            }
        }
        return  list;
    }

    public static List getXeDapThuongTrongBai(BaiXe baiXe){
        ArrayList list = new ArrayList();
        XeDAO xeDAO = XeDAO.getInstance();
        for (Xe xe:
                xeDAO.getAll()) {
            if (xe.getBaiXe().getId() == baiXe.getId() && xe.getLoaiXe().getId() == Xe.XE_DAP_THUONG && xe.getTrangThai() == Xe.CHUA_THUE){
                list.add(xe);
            }
        }
        return  list;
    }

    public List getXeDapDienTrongBai(BaiXe baiXe){
        ArrayList list = new ArrayList();
        XeDAO xeDAO = XeDAO.getInstance();
        for (Xe xe:
                xeDAO.getAll()) {
            if (xe.getBaiXe().getId() == baiXe.getId() && xe.getLoaiXe().getId() == Xe.XE_DAP_DIEN && xe.getTrangThai() == Xe.CHUA_THUE){
                list.add(xe);
            }
        }
        return  list;
    }
}

/*
INSERT INTO BaiXe
 (id,tenBaiXe,diaChi,dienTich)
 VALUES
 (001,N'Eco B�ch Khoa',N'1 Hai B� Tr?ng H� N?i',300),
 (002,N'Eco Meo',N'1 Ho�ng Th�i H� N?i',300),
 (003,N'Eco Thai',N'12 Th�i Th?nh H� N?i',300)
 ;
 */
