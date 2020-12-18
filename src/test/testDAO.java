package test;

import database.BaiXeDAO;
import database.DAOManager;
import database.Utils;
import entity.BaiXe;

import java.sql.ResultSet;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:55 AM , 12/18/2020
 */

public class testDAO {
    public static void main(String args[]){
        try{
            DAOManager daoManager= DAOManager.getInstance();
            daoManager.open();

            BaiXeDAO baiXeDAO = new BaiXeDAO();
//            listBaiXe.add(new BaiXe(1, "bai A", "dia chi 1", 10));
//            baiXeDAO.save(new BaiXe(4, "bai A", "dia chi 1", 10));
//            String query = Utils.getGetQuery(BaiXe.name, "*", null);
//            System.out.println(query);
//            ResultSet rs = daoManager.executeQuery(query);
//            rs.absolute(3);
//            System.out.println(rs.getInt(1) + "  " + rs.getString(2)
//                    + "  " + rs.getString(3));
//            rs.updateString(2, "bai B");
//            rs.updateRow();

            for (BaiXe baiXe:
                 baiXeDAO.getAll()) {
                System.out.println(baiXe.toString());
            }
//            Thread.sleep(100000);
            daoManager.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
