package views.screen;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Configs;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 16/12/2020, Wed
 **/
public class GiaoDienFlash  implements Initializable {
    @FXML
    ImageView logo;
    @FXML
    ImageView ecobike;

    public void setImage(ImageView imv, String path){
        File file = new File(Configs.IMAGE_PATH+path);
        Image img = new Image(file.toURI().toString());
        imv.setImage(img);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImage(this.logo,"logo.png");
        setImage(this.ecobike,"ecobike.png");
    }
}
