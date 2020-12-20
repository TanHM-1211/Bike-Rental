package controller;

import database.BaiXeDAO;
import entity.BaiXe;
import entity.GiaoDichThueXe;
import entity.Xe;
import utils.Configs;
import views.screen.xemThongTin.GiaoDienThongTinXe;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:46 AM , 12/16/2020
 */

public class DieuKhienBaiXe extends BaseController{

    public DieuKhienBaiXe() {
    }
    public List getAllBaiXe(){
        return BaiXeDAO.getInstance().getAll();
    }


}
