package entity;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:49 AM , 12/16/2020
 */

/*
    Doc va ghi
 */
public class Xe {
    private int id;
    private LoaiXe loaiXe;
    private String bienSoXe;
    private BaiXe baiXe;
    private int trangThai;
    private Integer pin ;

    public static String paramsName = "id_xe, loai_xe, bien_so_xe, id_bai_xe, trang_thai, pin";
    public static String name = "xe";

    public static final int DANG_THUE = 1;
    public static final int CHUA_THUE = 0;
    public static final int XE_DAP_THUONG = 1;
    public static final int XE_DAP_DOI = 2;
    public static final int XE_DAP_DIEN = 3;

    public Xe(){
    }

    public Xe(int id, LoaiXe loaiXe, String bienSoXe, BaiXe baiXe, int trangThai, Integer pin) {
        this.id = id;
        this.loaiXe = loaiXe;
        this.bienSoXe = bienSoXe;
        this.baiXe = baiXe;
        this.trangThai = trangThai;
        this.pin = pin;
    }

    public String toSQLString() {
        return id +
                "," + loaiXe.getId() +
                ", '" + bienSoXe + '\'' +
                ", " + baiXe.getId() +
                ", " + trangThai +
                ", " + pin +
                "";
    }

    @Override
    public String toString() {
        return "Xe{" +
                "id=" + id +
                ", loaiXe=" + loaiXe.getTenLoaiXe() +
                ", bienSoXe='" + bienSoXe + '\'' +
                ", baiXe=" + baiXe +
                ", trangThai=" + trangThai +
                ", pin=" + pin +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public BaiXe getBaiXe() {
        return baiXe;
    }

    public void setBaiXe(BaiXe baiXe) {
        this.baiXe = baiXe;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getPin() {
        return this.pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getCoc(){
        return (int)(getLoaiXe().getGiaTri() * 0.4);
    }
}

/**
use [CapstoneProject];

INSERT INTO Xe
 (id, loaiXe, bienSoXe, idBaiXe, tienCoc, trangThai)
 VALUES
 (001,N'Xe ??p',002121,001,100000,1),
 (002,N'Xe ??p',123003,002,150000,0),
 (005,N'Xe ??p',123456,001,200000,0),
(009,N'Xe ??p',113456,002,250000,1),
(007,N'Xe ??p',155456,001,170000,0),
(011,N'Xe ??p',123156,003,210000,0);

INSERT INTO XeDapDien
 (id,pin,loaiXe, bienSoXe, idBaiXe, tienCoc, trangThai)
 VALUES
 (001,100,N'Xe ??p ?i?n',000001,001,500000,1),
 (002,50,N'Xe ??p ?i?n',121001,002,450000,0),
 (005,90,N'Xe ??p ?i?n',123346,001,600000,0),
(009,80,N'Xe ??p ?i?n',109856,002,430000,1),
(007,75,N'Xe ??p ?i?n',112456,001,630000,0),
(011,86,N'Xe ??p ?i?n',112246,003,450000,0);




 INSERT INTO GiaoDichThueXe
 (id,idXe,idNguoiDung,idBaiXeThue,thoiDiemThue,tongThoiGianDung,idTheGiaoDich,cachThue)
 VALUES
 (001,001,001,001,'20201020 12:32:10',15,'118131_group11_2020',1);
*/