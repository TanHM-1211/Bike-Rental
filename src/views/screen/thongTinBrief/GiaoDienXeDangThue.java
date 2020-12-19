package views.screen.thongTinBrief;

import entity.BaiXe;
import entity.GiaoDichThueXe;
import entity.NguoiDungGiaoDichThueXe;
import entity.Xe;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.FXMLScreenHandler;
import views.screen.xemThongTin.GiaoDienThongTinBaiXe;

import java.io.IOException;

public class GiaoDienXeDangThue extends FXMLScreenHandler {
    private BaseScreenHandler parentScene;


    public GiaoDienXeDangThue(String screenPath, GiaoDichThueXe giaoDichThueXe) throws IOException {
        super(screenPath);
    }

}
