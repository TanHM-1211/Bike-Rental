package controller;

import entity.Xe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:48 AM , 12/16/2020
 */

public class DieuKhienTraXe extends BaseController {
    public DieuKhienTraXe() {
    }

    /**
     * Ham tinh tien thue xe
     * @param thoiDiemBatDau theo khuon "yyyy/MM/dd HH:mm:ss"
     * @param thoiDiemKetThuc theo khuon "yyyy/MM/dd HH:mm:ss"
     * @return so tien thue xe
     */
    public int  tinhTienThue(String thoiDiemBatDau, String thoiDiemKetThuc, Xe xe){
        java.util.Date temp1;
        java.util.Date temp2;
        int thueTheoPhut ;
        try {
            temp1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    .parse(thoiDiemBatDau);
            temp2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    .parse(thoiDiemKetThuc);
            thueTheoPhut = (int) Math.ceil((temp2.getTime() - temp1.getTime())/60000);
        } catch (ParseException e){
            return 0;
        }
        if (thueTheoPhut <= 30){
            return xe.getLoaiXe().getGia30pDau();
        }

        int sau30 = 1;
        sau30+=(int) Math.ceil((thueTheoPhut -30)/15);
        return xe.getLoaiXe().getGia30pDau() + sau30*xe.getLoaiXe().getGiaMoi15p();
    }

    public int tienThua(int tienCoc, int tienThue){
        return tienCoc - tienThue;
    }
}
