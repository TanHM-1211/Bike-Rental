package common.exception;

import views.screen.GiaoDienKetQua;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 20/12/2020, Sun
 **/
public class CapstoneException extends RuntimeException{
    public CapstoneException(String message) {
        super(message);
        try {
            GiaoDienKetQua.error(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
