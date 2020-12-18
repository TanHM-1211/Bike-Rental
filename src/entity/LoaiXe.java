package entity;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 7:48 AM , 12/18/2020
 */

public class LoaiXe {
    private int id;
    private String tenLoaiXe;
    private int giaTri;
    private int gia30pDau;
    private int giaMoi15p;

    public LoaiXe(){}

    public LoaiXe(int id, String tenLoaiXe, int giaTri, int gia30pDau, int giaMoi15p) {
        this.id = id;
        this.tenLoaiXe = tenLoaiXe;
        this.giaTri = giaTri;
        this.gia30pDau = gia30pDau;
        this.giaMoi15p = giaMoi15p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiXe() {
        return tenLoaiXe;
    }

    public void setTenLoaiXe(String tenLoaiXe) {
        this.tenLoaiXe = tenLoaiXe;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public int getGia30pDau() {
        return gia30pDau;
    }

    public void setGia30pDau(int gia30pDau) {
        this.gia30pDau = gia30pDau;
    }

    public int getGiaMoi15p() {
        return giaMoi15p;
    }

    public void setGiaMoi15p(int giaMoi15p) {
        this.giaMoi15p = giaMoi15p;
    }
}
