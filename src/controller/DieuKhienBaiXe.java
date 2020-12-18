package controller;

import entity.BaiXe;
<<<<<<< HEAD

=======
import entity.Xe;

import java.util.ArrayList;
>>>>>>> main
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
<<<<<<< HEAD
        return new BaiXe().getAll();
    }
=======
        return BaiXe.getAll();
    }
    public List getLoaiXe(String loaiXe){
        List listAllXe = BaiXe.getXe();
        ArrayList xeTheoLoai = new ArrayList();
        for(Object object: listAllXe){
            Xe xe = (Xe) object;
            if (xe.getLoaiXe().getTenLoaiXe().equals(loaiXe)){
                xeTheoLoai.add(xe);
            }
        }
        return xeTheoLoai;

    }

>>>>>>> main
}
