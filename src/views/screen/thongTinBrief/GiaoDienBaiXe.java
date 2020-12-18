package views.screen.thongTinBrief;

import entity.BaiXe;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.FXMLScreenHandler;
import views.screen.xemThongTin.GiaoDienThongTinBaiXe;

import java.io.IOException;

public class GiaoDienBaiXe extends FXMLScreenHandler {
    @FXML
    Pane view;
    @FXML
    Text tenBaiXe;
    @FXML
    Text diaChi;

    BaiXe baiXe;
    private BaseScreenHandler parentScene;

    public void xemThongTin(){
        try {
            GiaoDienThongTinBaiXe giaoDienThongTinBaiXe= new GiaoDienThongTinBaiXe(parentScene.getStage(),Configs.THONG_TIN_BAI_XE_PATH,baiXe);
            giaoDienThongTinBaiXe.setPreviousScreen(parentScene);
            giaoDienThongTinBaiXe.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public GiaoDienBaiXe(String screenPath, BaiXe baixe, BaseScreenHandler parentScene) throws IOException {
        super(screenPath);
        this.baiXe = baixe;
        this.parentScene = parentScene;
        tenBaiXe.setText(baiXe.getTenBaiXe());
        diaChi.setText(baiXe.getDiaChi());
        view.setOnMouseClicked(e -> {
            xemThongTin();
        });
    }

}
