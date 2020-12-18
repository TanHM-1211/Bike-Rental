package views.screen.giaoDienChinh;
/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 17/12/2020, Thu
 **/
import java.io.IOException;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;


public class GiaoDienChinh extends BaseScreenHandler {
    @FXML
    VBox listBaiXe;
    String [] listColor = new String[]{"#e1e8f2","#e5d5eb","#f1f5d6","#d8f8d1"};
    public void loadBaiXe()throws IOException {
        for(int i=0; i<4; ++i) {
            GiaoDienBaiXe giaoDienBaiXe = new GiaoDienBaiXe(Configs.BAIXE_Brief_PATH);
            giaoDienBaiXe.setFill(listColor[i]);
            giaoDienBaiXe.setClick(this);
            listBaiXe.getChildren().add(giaoDienBaiXe.getContent());
        }
    }



    public GiaoDienChinh(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
        loadBaiXe();
    }

}
