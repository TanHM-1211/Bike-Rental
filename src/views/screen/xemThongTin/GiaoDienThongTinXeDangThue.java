package views.screen.xemThongTin;

import entity.Xe;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */

public class GiaoDienThongTinXeDangThue extends BaseScreenHandler{
    @FXML
    VBox mainVBox;
    @FXML
    ImageView bike;
    @FXML
    Text tenBaiXe;
    @FXML
    Text loaiXe;
    @FXML
    Text pin;
    @FXML
    Text bienSo;
    @FXML
    Text tienCoc;
    @FXML
    Text phi30;
    @FXML
    Text phi15;
    public void setIcon(){
        setImage(this.bike,"bike.png");
    }
    public GiaoDienThongTinXeDangThue(Stage stage, String screenPath, Xe xe) throws IOException {
        super(stage, screenPath);
        setMenu(mainVBox);
        setIcon();
        tenBaiXe.setText(xe.getBaiXe().getTenBaiXe() + " bai xe");
        loaiXe.setText(xe.getLoaiXe().getTenLoaiXe());
        pin.setText(xe.getPin().toString());
        bienSo.setText(xe.getBienSoXe());
        tienCoc.setText(xe.getLoaiXe().getGiaTri() + "");
        phi30.setText(xe.getLoaiXe().getGia30pDau()+"");
        phi15.setText(xe.getLoaiXe().getGiaMoi15p()+"");

    }
}
