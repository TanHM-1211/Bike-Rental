package entity;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:49 AM , 12/16/2020
 */


public class Xe {
    private int id;
    private String loaiXe;
    private int bienSoXe;
    private int idBaiXe;
    private int tienCoc;
    private int trangThai;

    public Xe(){
    }

    public Xe(int id, String loaiXe, int bienSoXe, int idBaiXe, int tienCoc, int trangThai) {
        this.id = id;
        this.loaiXe = loaiXe;
        this.bienSoXe = bienSoXe;
        this.idBaiXe = idBaiXe;
        this.tienCoc = tienCoc;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public int getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(int bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public int getIdBaiXe() {
        return idBaiXe;
    }

    public void setIdBaiXe(int idBaiXe) {
        this.idBaiXe = idBaiXe;
    }

    public int getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(int tienCoc) {
        this.tienCoc = tienCoc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}


class XeDapDien extends Xe{
    private int pin;

    public XeDapDien(){
    }

    public XeDapDien(int id, String loaiXe, int bienSoXe, int idBaiXe, int tienCoc, int trangThai, int pin) {
        super(id, loaiXe, bienSoXe, idBaiXe, tienCoc, trangThai);
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
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