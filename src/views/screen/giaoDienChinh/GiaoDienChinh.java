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
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.thongTinBrief.GiaoDienBaiXe;


public class GiaoDienChinh extends BaseScreenHandler {
    @FXML
    VBox mainVBox;
    @FXML
    VBox listBaiXe;
    List baiXeAll;

    public void loadBaiXe()throws IOException {
        baiXeAll = new DieuKhienBaiXe().getALLBaiXe();
        for (Object object: baiXeAll){
            BaiXe baiXe = (BaiXe) object;
            GiaoDienBaiXe giaoDienBaiXe = new GiaoDienBaiXe(Configs.BAIXE_Brief_PATH, baiXe,this);
            listBaiXe.getChildren().add(giaoDienBaiXe.getContent());
        }
    }


    public GiaoDienChinh(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
        setMenu(mainVBox);
        loadBaiXe();
    }

}
