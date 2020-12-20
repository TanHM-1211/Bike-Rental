package views.screen.thongTinBrief;

import entity.Xe;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.FXMLScreenHandler;
import views.screen.xemThongTin.GiaoDienThongTinXe;
import java.io.IOException;
/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */
public class GiaoDienXe extends FXMLScreenHandler {
    @FXML
    Pane view;
    @FXML
    Text maSoXe;
    @FXML
    Text pin;
    @FXML
    ImageView bike;
    Xe xe;

    private BaseScreenHandler parentScene;

    public void setIcon(){
        setImage(this.bike,"bike.png");
    }

    public void xemThongTin(){
        try {
            GiaoDienThongTinXe giaoDienThongTinXe= new GiaoDienThongTinXe(parentScene.getStage(),Configs.THONG_TIN_XE_PATH,xe);
            giaoDienThongTinXe.setPreviousScreen(parentScene);
            giaoDienThongTinXe.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public GiaoDienXe(String screenPath, Xe xe, BaseScreenHandler parentScene) throws IOException {
        super(screenPath);
        this.xe = xe;
        this.parentScene = parentScene;
        setIcon();
        this.maSoXe.setText(String.valueOf(xe.getId()));
        if (xe.getPin()!=null){
            this.pin.setText(xe.getPin().toString());
        }else {
            this.pin.setText("Không");
        }
        view.setOnMouseClicked(e -> {
            xemThongTin();
        });
    }

}
