package views.screen.thueXe;
import controller.DieuKhienThueXe;
import entity.NguoiDung;
import entity.The;
import entity.Xe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;
import views.screen.GiaoDienKetQua;

import java.io.IOException;
/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */

public class GiaoDienXacNhanThanhToan extends BaseScreenHandler{
    @FXML
    VBox mainVBox;
    @FXML
    Text nguoiDung;
    @FXML
    Text msx;
    @FXML
    Text loaiXe;
    @FXML
    Text bienSo;
    @FXML
    Text baiXe;
    @FXML
    Text stk;
    @FXML
    Text coc;
    @FXML
    Button xacNhan;

    public GiaoDienXacNhanThanhToan(Stage stage, String screenPath, DieuKhienThueXe dieuKhienThueXe) throws IOException {
        super(stage, screenPath);
        setMenu(mainVBox);
        NguoiDung nguoiDungHT = dieuKhienThueXe.getNguoiDung();
        Xe xe = dieuKhienThueXe.getXe();
        The the = dieuKhienThueXe.getThe();

        nguoiDung.setText(String.valueOf(nguoiDungHT.getId()));
        msx.setText(String.valueOf(xe.getId()));
        loaiXe.setText(xe.getLoaiXe().getTenLoaiXe());
        bienSo.setText(xe.getBienSoXe());
        baiXe.setText(xe.getBaiXe().getTenBaiXe());
        stk.setText(the.getId());
        coc.setText(String.valueOf(xe.getCoc()));

        xacNhan.setOnMouseClicked(e->{
            dieuKhienThueXe.thanhToanCoc();
            dieuKhienThueXe.mokhoa();
            try {
                GiaoDienKetQua.success("Thanh toán thành công");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
