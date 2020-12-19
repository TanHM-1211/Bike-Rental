package entity;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:50 AM , 12/16/2020
 */

/*
    Doc va ghi
 */

public class GiaoDichThueXe{
    private int id;
    private Xe xe;
    private NguoiDung nguoiDung;
    private BaiXe baiXeThue;
    private BaiXe baiXeTra;
    private GiaoDichThanhToan thanhToanThue;
    private GiaoDichThanhToan thanhToanTra;
    private Integer soTien;

    public static String paramsName = "(id_giao_dich_thue_xe, id_xe, id_nguoi_dung, id_bai_xe_thue, id_bai_xe_tra, id_thanh_toan_thue, id_thanh_toan_tra, so_tien)";
    public static String name = "giao_dich_thue_xe";

    public GiaoDichThueXe(){}

    public GiaoDichThueXe(int id, Xe xe, entity.NguoiDung nguoiDung, BaiXe baiXeThue, BaiXe baiXeTra, GiaoDichThanhToan thanhToanThue, GiaoDichThanhToan thanhToanTra, Integer soTien) {
        this.id = id;
        this.xe = xe;
        this.nguoiDung = nguoiDung;
        this.baiXeThue = baiXeThue;
        this.baiXeTra = baiXeTra;
        this.thanhToanThue = thanhToanThue;
        this.thanhToanTra = thanhToanTra;
        this.soTien = soTien;
    }

    @Override
    public String toString() {
        return "GiaoDichThueXe{" +
                "idGiaoDichThueXe=" + id +
                ", xe=" + xe +
                ", nguoiDung=" + nguoiDung +
                ", baiXeThue=" + baiXeThue +
                ", baiXeTra=" + baiXeTra +
                ", thanhToanThue=" + thanhToanThue +
                ", thanhToanTra=" + thanhToanTra +
                ", soTien=" + soTien +
                '}';
    }

    public String toSQLString() {
        if (this.soTien != null)
        return "(" +
                "" + id +
                ", " + xe.getId() +
                ", " + nguoiDung.getId() +
                ", " + baiXeThue.getId() +
                ", " + baiXeTra.getId() +
                ", " + thanhToanThue.getId() +
                ", " + thanhToanTra.getThe() +
                ", " + soTien +
                ')';
        else
            return "(" +
                    "" + id +
                    ", " + xe.getId() +
                    ", " + nguoiDung.getId() +
                    ", " + baiXeThue.getId() +
                    ", null" +
                    ", " + thanhToanThue.getId() +
                    ", null" +
                    ", null" +
                    ')';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }

    public NguoiDung getNguoiDung() {
        return this.nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public BaiXe getBaiXeThue() {
        return baiXeThue;
    }

    public void setBaiXeThue(BaiXe baiXeThue) {
        this.baiXeThue = baiXeThue;
    }

    public BaiXe getBaiXeTra() {
        return baiXeTra;
    }

    public void setBaiXeTra(BaiXe baiXeTra) {
        this.baiXeTra = baiXeTra;
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

    public Integer getSoTien() {
        return soTien;
    }

    public void setSoTien(Integer soTien) {
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
