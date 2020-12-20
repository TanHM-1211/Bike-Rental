package common.exception;

import views.screen.GiaoDienKetQua;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 19/12/2020, Sat
 **/
public class MaVachException extends CapstoneException{
    public MaVachException() {
        super("Mã vạch không hợp lệ");
    }
}
