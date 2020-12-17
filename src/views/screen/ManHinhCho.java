package views.screen;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ManHinhCho implements Initializable {

    @FXML
    ImageView logo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("assets/images/logo.png");
        Image image = new Image(file.toURI().toString());
        logo.setImage(image);
    }
}
