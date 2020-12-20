package views.screen.thueXe;

import controller.DieuKhienThueXe;
import database.TheDAO;
import entity.The;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:53 AM , 12/16/2020
 */

public class GiaoDienChonTheThanhToan extends BaseScreenHandler {
    @FXML
    TextField the;
    @FXML
    Button xacNhan;
    @FXML
    VBox mainVBox;

    public GiaoDienChonTheThanhToan(Stage stage, String screenPath, DieuKhienThueXe dieuKhienThueXe) throws IOException {
        super(stage, screenPath);
        setMenu(mainVBox);
        this.setBController(dieuKhienThueXe);
        the.setText(Configs.GROUP_NAME);
        xacNhan.setOnMouseClicked(e->{
            The the = TheDAO.getInstance().getTheHienTai();
            dieuKhienThueXe.setThe(the);
            try {
                GiaoDienXacNhanThanhToan giaoDienXacNhanThanhToan;
                giaoDienXacNhanThanhToan = new GiaoDienXacNhanThanhToan(getStage(),Configs.THUE_XE_XAC_NHAN_PATH,dieuKhienThueXe);
                giaoDienXacNhanThanhToan.setPreviousScreen(this);
                giaoDienXacNhanThanhToan.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
}
