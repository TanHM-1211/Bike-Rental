package views.screen;
import database.XeDAO;
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


    public void xacNhan(String maVach){
        System.out.println(maVach);
        XeDAO xeDao = XeDAO.getInstance();
        Xe  xe = xeDao.getAll().get(0);
        try {
            GiaoDienThongTinXe giaoDienThongTinXe= new GiaoDienThongTinXe(this.getStage(),Configs.THONG_TIN_XE_PATH,xe);
            giaoDienThongTinXe.setPreviousScreen(this);
            giaoDienThongTinXe.show();
        } catch (IOException ex) {
            ex.printStackTrace();
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
