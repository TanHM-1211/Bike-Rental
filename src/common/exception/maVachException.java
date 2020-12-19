package common.exception;

/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 19/12/2020, Sat
 **/
public class maVachException extends RuntimeException{
    public maVachException(String message) {
        super("Ma vach không hợp lệ");
    }
}
