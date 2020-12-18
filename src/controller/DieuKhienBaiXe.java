package controller;

import entity.BaiXe;

import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:46 AM , 12/16/2020
 */

public class DieuKhienBaiXe {
    public DieuKhienBaiXe() {
    }
    public List getALLBaiXe(){
        return new BaiXe().getAll();
    }
}
