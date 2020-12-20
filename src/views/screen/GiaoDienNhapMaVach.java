package views.screen;
import controller.BaseController;
import entity.GiaoDichThueXe;
import entity.Xe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.xemThongTin.GiaoDienThongTinXe;
import java.io.IOException;
/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:53 AM , 12/16/2020
 */

public class GiaoDienNhapMaVach extends BaseScreenHandler {
    @FXML
    VBox mainVBox;
    @FXML
    TextField maVach;
    @FXML
    Button xacNhan;

    private Xe xe;
    public void xacNhan(String maVach){
        BaseController baseController = new BaseController();
        Xe xe = baseController.layThongTinXeTheoMa(maVach);
        if (xe==null){
            return;
        }
        try {
            GiaoDienThongTinXe giaoDienThongTinXe = new GiaoDienThongTinXe(this.stage,Configs.THONG_TIN_XE_PATH, xe);
            giaoDienThongTinXe.setPreviousScreen(this);
            giaoDienThongTinXe.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public GiaoDienNhapMaVach(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        setMenu(mainVBox);
        maVach.setOnKeyPressed(e->{
            if (e.getCode().equals(KeyCode.ENTER)){
                xacNhan(maVach.getText());
            }
        });
        xacNhan.setOnMouseClicked(e->{
            xacNhan(maVach.getText());
        });
    }
}
