package views.screen.xemThongTin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;
import javafx.scene.image.Image;
import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */

public class GiaoDienThongTinXe extends BaseScreenHandler{
    @FXML
    ImageView bike;
    public void setIcon(){
        setImage(this.bike,"bike.png");
    }
    public GiaoDienThongTinXe(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);

    }
}
