package views.screen;

import common.exception.CheckXeDangThue;
import common.exception.MaVachException;
import controller.BaseController;
import controller.DieuKhienXeDangThue;
import entity.GiaoDichThueXe;
import entity.Xe;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Configs;
import views.screen.giaoDienChinh.GiaoDienChinh;
import views.screen.xemThongTin.GiaoDienThongTinXe;

import java.io.File;
import java.io.IOException;

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
    ImageView qr;
    @FXML
    MenuButton menu;
    @FXML
    ImageInput menuImg;
    @FXML
    MenuItem home;
    @FXML
    MenuItem xeDangThue;
    @FXML

    private BaseScreenHandler parentScene;

    public void setIcon(){
        setImage(this.logo,"logo.png");
        setImage(this.back, "back.png");
        setImage(this.qr, "qr.png");
        File file = new File(Configs.IMAGE_PATH+"menu.png");
        Image image = new Image(file.toURI().toString());
        menuImg.setSource(image);

    }

    public void setClick(){
        home.setOnAction(e ->{
            try {
                GiaoDienChinh giaoDienChinh = new GiaoDienChinh(parentScene.getStage(), Configs.HOME_PATH);
                giaoDienChinh.setPreviousScreen(parentScene);
                giaoDienChinh.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        xeDangThue.setOnAction(e ->{
            DieuKhienXeDangThue dieuKhienXeDangThue= new DieuKhienXeDangThue();
            GiaoDichThueXe giaoDichThueXe = dieuKhienXeDangThue.getGiaoDichHienTai();
            try{
                Xe xe = giaoDichThueXe.getXe();
                try {
                    GiaoDienThongTinXe giaoDienThongTinXe = new GiaoDienThongTinXe(parentScene.getStage(),Configs.THONG_TIN_XE_PATH, xe);
                    giaoDienThongTinXe.setPreviousScreen(parentScene);
                    giaoDienThongTinXe.show();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (RuntimeException ex) {
                ex.printStackTrace();
                throw new CheckXeDangThue();
            }
        });
        back.setOnMouseClicked(e ->{
            if (parentScene.getPreviousScreen()!=null)
                parentScene.getPreviousScreen().show();
        });
        qr.setOnMouseClicked(e ->{
            try {
                GiaoDienNhapMaVach giaoDienNhapMaVach = new GiaoDienNhapMaVach(parentScene.getStage(), Configs.MAVACH_PATH);
                giaoDienNhapMaVach.setPreviousScreen(parentScene);
                giaoDienNhapMaVach.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
    public GiaoDienMenu(String screenPath, BaseScreenHandler parentScene) throws IOException{
        super(screenPath);
        this.parentScene = parentScene;
        setIcon();
        setClick();
    }
}
