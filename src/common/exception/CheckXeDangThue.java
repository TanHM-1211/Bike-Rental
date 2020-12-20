package common.exception;

import views.screen.GiaoDienKetQua;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 19/12/2020, Sat
 **/
public class CheckXeDangThue extends RuntimeException{
    public CheckXeDangThue(String message) {
        super(message);
        try {
            GiaoDienKetQua.error(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
