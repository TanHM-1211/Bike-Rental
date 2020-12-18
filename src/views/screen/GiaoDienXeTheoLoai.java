package views.screen;

import entity.BaiXe;
import entity.Xe;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import utils.Configs;
import views.screen.xemThongTin.GiaoDienThongTinBaiXe;
import views.screen.xemThongTin.GiaoDienThongTinXe;

import java.io.IOException;

public class GiaoDienXeTheoLoai extends FXMLScreenHandler{
    private BaseScreenHandler parentScene;

    @FXML
    Pane thongTinXe;
    @FXML
    Text maSoXe;
    @FXML
    Text pin;
    Xe xe;
    public void xemThongTin(){
        GiaoDienThongTinXe giaoDienThongTinXe = null;
        try {
            giaoDienThongTinXe = new GiaoDienThongTinXe(parentScene.getStage(), Configs.THONG_TIN_XE_PATH);
            giaoDienThongTinXe.setScreenTitle("Thong tin xe xe");
            giaoDienThongTinXe.setIcon();
            giaoDienThongTinXe.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void setClick(BaseScreenHandler parentScene)throws IOException {
        this.parentScene = parentScene;
        thongTinXe.setOnMouseClicked(e -> {
            xemThongTin();
        });
    }
    public GiaoDienXeTheoLoai(String screenPath, Xe xe) throws IOException{
        super(screenPath);
        this.xe = xe;
        pin.setText(String.valueOf(xe.getPin()) + "%");
        maSoXe.setText(String.valueOf(xe.getId()));

    }

}
