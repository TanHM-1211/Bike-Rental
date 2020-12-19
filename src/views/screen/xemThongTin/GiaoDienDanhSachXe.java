package views.screen.xemThongTin;

import entity.Xe;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.thongTinBrief.GiaoDienXe;

import java.io.IOException;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */

public class GiaoDienDanhSachXe extends BaseScreenHandler{
    @FXML
    VBox mainVBox;
    @FXML
    Text loaiXe;
    @FXML
    VBox listXe;


    public void loadXe(List listXe) throws IOException{
       for (Object object: listXe){
            Xe xe = (Xe) object;
            GiaoDienXe giaoDienXe = new GiaoDienXe(Configs.XE_BRIEF_PATH, xe,this);
            this.listXe.getChildren().add(giaoDienXe.getContent());
        }
    }

    public GiaoDienDanhSachXe(Stage stage, String screenPath, String listName, List listXe) throws IOException {
        super(stage, screenPath);
        setMenu(mainVBox);
        loaiXe.setText(listName);
        loadXe(listXe);
    }
}
