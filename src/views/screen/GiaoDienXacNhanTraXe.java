package views.screen;

import controller.DieuKhienTraXe;
import entity.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.giaoDienChinh.GiaoDienChinh;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */

public class GiaoDienXacNhanTraXe extends BaseScreenHandler{
    @FXML
    VBox mainVBox;
    @FXML
    Text nguoiDung;
    @FXML
    Text msx;
    @FXML
    Text time;
    @FXML
    Text baiXe;
    @FXML
    Text stk;
    @FXML
    Text tienCoc;
    @FXML
    Text tienThue;
    @FXML
    Text thanhToan;
    @FXML
    TextField IdBaiXeTra;
    @FXML
    Button xacNhan;

    public GiaoDienXacNhanTraXe(Stage stage, String screenPath, GiaoDichThueXe giaoDichThueXe) throws IOException {
        super(stage, screenPath);
        setMenu(mainVBox);

        NguoiDung nguoiDungHT = giaoDichThueXe.getNguoiDung();
        Xe xe =giaoDichThueXe.getXe();
        The the = giaoDichThueXe.getThanhToanThue().getThe();
        DieuKhienTraXe dieuKhienTraXe = new DieuKhienTraXe();

        nguoiDung.setText(String.valueOf(nguoiDungHT.getId()));
        msx.setText(String.valueOf(xe.getId()));
        baiXe.setText(xe.getBaiXe().getTenBaiXe());
        time.setText(giaoDichThueXe.getThanhToanThue().getCreatedAt());
        stk.setText(the.getId());
        tienCoc.setText(String.valueOf(xe.getCoc()));
        tienThue.setText(String.valueOf(dieuKhienTraXe.tinhTienThue(giaoDichThueXe)));
        thanhToan.setText(String.valueOf(dieuKhienTraXe.tienThua(giaoDichThueXe)));
        xacNhan.setOnMouseClicked(e->{
            BaiXe baiXeTra = dieuKhienTraXe.getBaiXe(IdBaiXeTra.getText());
            dieuKhienTraXe.TraXe(giaoDichThueXe,baiXeTra);
            try { GiaoDienChinh giaoDienChinh = new GiaoDienChinh(getStage(), Configs.HOME_PATH);
                giaoDienChinh.show();
                GiaoDienKetQua.success("Trả xe thành công");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
