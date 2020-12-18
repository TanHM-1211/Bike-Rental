package views.screen.xemThongTin;

import entity.BaiXe;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */

public class GiaoDienThongTinBaiXe extends BaseScreenHandler{

    @FXML
    Text tenBaiXe;
    @FXML
    Text diaChiBaiXe;
    @FXML
    Text dienTich;
    @FXML
    ImageView bike1;
    @FXML
    ImageView bike2;
    public void setIcon(){
        setImage(this.bike1,"bike2.png");
        setImage(this.bike2,"bike2.png");
    }
    public GiaoDienThongTinBaiXe(Stage stage, BaiXe baiXe, String screenPath) throws IOException {
        super(stage, screenPath);
        tenBaiXe.setText(baiXe.getTenBaiXe());
        diaChiBaiXe.setText(baiXe.getDiaChi());
        dienTich.setText(String.valueOf(baiXe.getDienTich()));
    }
}
