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

    public static NguoiDung getInstance(){
        if (nguoiDung == null){
            nguoiDung = new NguoiDung(1);
        }
        return nguoiDung;
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

}
