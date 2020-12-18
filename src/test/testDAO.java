package test;

import database.BaiXeDAO;
import database.DAOManager;
import entity.BaiXe;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:55 AM , 12/18/2020
 */

public class testDAO {
    public static void main(String args[]){
        try{
            DAOManager daoManager= new DAOManager();
            daoManager.open();

            BaiXeDAO baiXeDAO = new BaiXeDAO();
//            listBaiXe.add(new BaiXe(1, "bai A", "dia chi 1", 10));
            baiXeDAO.save(new BaiXe(4, "bai A", "dia chi 1", 10));
            String query = baiXeDAO.getInsertQuery(baiXeDAO.getAll());
            System.out.println(query);
            daoManager.executeQuery(query);
            daoManager.close();}
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
