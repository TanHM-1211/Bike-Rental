package test;

import database.GiaoDichThanhToanDAO;
import database.TheDAO;
import entity.GiaoDichThanhToan;
import entity.The;
import subsystem.interbanksubsystem.InterbankSubsystem;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 6:07 PM , 12/19/2020
 */

public class testInterbank {
    public static void main(String args[]){
        InterbankSubsystem interbankSubsystem = new InterbankSubsystem();
        The the = TheDAO.getInstance().getTheHienTai();
        GiaoDichThanhToan giaoDichThanhToan = interbankSubsystem.pay(the, 10, "testing");
        System.out.println(giaoDichThanhToan.toString());

        GiaoDichThanhToanDAO giaoDichThanhToanDAO = GiaoDichThanhToanDAO.getInstance();
        giaoDichThanhToanDAO.save(giaoDichThanhToan);
    }
}
