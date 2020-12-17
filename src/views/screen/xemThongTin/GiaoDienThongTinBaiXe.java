package views.screen.xemThongTin;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
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
    ImageView bike1;
    @FXML
    ImageView bike2;
    public void setIcon(){
        setImage(this.bike1,"bike2.png");
        setImage(this.bike2,"bike2.png");
    }
    public GiaoDienThongTinBaiXe(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);

    }
}
