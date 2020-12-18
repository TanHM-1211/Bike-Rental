package views.screen;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Configs;
import views.screen.giaoDienChinh.GiaoDienChinh;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:51 AM , 12/16/2020
 */

public class GiaoDienMenu extends FXMLScreenHandler{
    @FXML
    ImageView logo;
    @FXML
    ImageView back;
    @FXML
    MenuButton menu;
    @FXML
    ImageInput menuImg;
    @FXML
    MenuItem home;
    @FXML
    MenuItem thueXe;
    @FXML
    MenuItem xeDangThue;
    @FXML
    MenuItem traXe;

    private BaseScreenHandler parentScene;

    public void setIcon(){
        setImage(this.logo,"logo.png");
        setImage(this.back, "back.png");
        File file = new File(Configs.IMAGE_PATH+"menu.png");
        Image image = new Image(file.toURI().toString());
        menuImg.setSource(image);

    }

    public void setClick(){
        home.setOnAction(e ->{
            try {
                GiaoDienChinh giaoDienChinh = new GiaoDienChinh(parentScene.getStage(), Configs.HOME_PATH);
                giaoDienChinh.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        thueXe.setOnAction(e ->{
            System.out.println("thue xe");
        });
        traXe.setOnAction(e ->{
            System.out.println("tra xe");
        });
        xeDangThue.setOnAction(e ->{
            System.out.println("xe dang thue");
        });
        back.setOnMouseClicked(e ->{
            if (parentScene.getPreviousScreen()!=null)
                parentScene.getPreviousScreen().show();
        });
    }
    public GiaoDienMenu(String screenPath, BaseScreenHandler parentScene) throws IOException{
        super(screenPath);
        this.parentScene = parentScene;
        setIcon();
        setClick();
    }
}
