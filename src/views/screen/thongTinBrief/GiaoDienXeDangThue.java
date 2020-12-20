package views.screen.thongTinBrief;

import controller.DieuKhienXeDangThue;
import entity.GiaoDichThueXe;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import views.screen.BaseScreenHandler;
import views.screen.FXMLScreenHandler;
import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */
public class GiaoDienXeDangThue extends FXMLScreenHandler {
    private BaseScreenHandler parentScene;
    @FXML
    Text thoiGian;
    @FXML
    Text tienThue;

    public GiaoDienXeDangThue(String screenPath, GiaoDichThueXe giaoDichThueXe) throws IOException {
        super(screenPath);
        DieuKhienXeDangThue dieuKhienXeDangThue = new DieuKhienXeDangThue();
        int time = dieuKhienXeDangThue.getThoiGianThue(giaoDichThueXe);
        int money = dieuKhienXeDangThue.tinhTienThue(time,giaoDichThueXe);
        int gio = time/60;
        int phut = time-gio*60;
        thoiGian.setText(String.valueOf(gio)+" giờ "+ String.valueOf(phut)+" phút");
        tienThue.setText(String.valueOf(money));
    }

}
