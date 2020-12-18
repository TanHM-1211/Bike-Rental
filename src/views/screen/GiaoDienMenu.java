package views.screen;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Configs;
import views.screen.giaoDienChinh.GiaoDienChinh;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:51 AM , 12/16/2020
 */

public class GiaoDienMenu  implements Initializable{
    @FXML
    ImageView logo;
    @FXML
    ImageView back;
    @FXML
    MenuButton menu;
    @FXML
    MenuItem home;
    @FXML
    MenuItem thueXe;
    @FXML
    MenuItem xeDangThue;
    @FXML
    MenuItem traXe;

    private BaseScreenHandler parentScene;

    public void setImage(ImageView imv, String path){
        File file = new File(Configs.IMAGE_PATH+path);
        Image img = new Image(file.toURI().toString());
        imv.setImage(img);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // set logo icon
        setImage(this.logo,"logo.png");
        // set back icon
        setImage(this.back, "back.png");
        //set menu icon
        ImageView imageMenu;
        File file = new File(Configs.IMAGE_PATH+"menu.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        menu.setGraphic(imageView);

        home.setOnAction(e ->{

        });

    }
}
