package entity;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 8:42 AM , 12/18/2020
 */

/*
    Chi doc
 */
public class NguoiDung {
    private int id;
    private static NguoiDung nguoiDung = null;

    public NguoiDung() {
    }

    public NguoiDung(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static NguoiDung getInstance(){
        if (nguoiDung == null){
            nguoiDung = new NguoiDung();
        }
        return nguoiDung;
    }
}
