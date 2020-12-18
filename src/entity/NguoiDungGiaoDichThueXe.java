package entity;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 8:42 AM , 12/18/2020
 */

public class NguoiDungGiaoDichThueXe {
    private int id;
    private NguoiDung nguoiDung;
    private GiaoDichThueXe giaoDichThueXe;

    public NguoiDungGiaoDichThueXe() {
    }

    public NguoiDungGiaoDichThueXe(int id, NguoiDung nguoiDung) {
        this.id = id;
        this.nguoiDung = nguoiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public GiaoDichThueXe getGiaoDichThueXe() {
        return giaoDichThueXe;
    }

    public void setGiaoDichThueXe(GiaoDichThueXe giaoDichThueXe) {
        this.giaoDichThueXe = giaoDichThueXe;
    }
}
