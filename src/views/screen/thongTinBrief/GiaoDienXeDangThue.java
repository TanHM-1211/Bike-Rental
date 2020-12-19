package views.screen.thongTinBrief;

import entity.BaiXe;
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
    Xe xe;
    private BaseScreenHandler parentScene;


    public GiaoDienXeDangThue(String screenPath, Xe xe) throws IOException {
        super(screenPath);
        this.xe = xe;
    }

}
