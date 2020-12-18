package views.screen.giaoDienChinh;
/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 17/12/2020, Thu
 **/
import java.io.IOException;
import java.util.List;

import controller.DieuKhienBaiXe;
import entity.BaiXe;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.baiXe.GiaoDienBaiXe;


public class GiaoDienChinh extends BaseScreenHandler {
    @FXML
    VBox listBaiXe;
    List baiXeAll;
    String [] listColor = new String[]{"#e1e8f2","#e5d5eb","#f1f5d6","#d8f8d1"};
    public void loadBaiXe()throws IOException {
        baiXeAll = new DieuKhienBaiXe().getALLBaiXe();
        for (Object object: baiXeAll){
            BaiXe baiXe = (BaiXe) object;
            GiaoDienBaiXe giaoDienBaiXe = new GiaoDienBaiXe(Configs.BAIXE_Brief_PATH, baiXe);
            giaoDienBaiXe.setClick(this);
            listBaiXe.getChildren().add(giaoDienBaiXe.getContent());
        }
    }



    public GiaoDienChinh(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
        loadBaiXe();
    }

}
