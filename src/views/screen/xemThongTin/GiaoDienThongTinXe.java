package views.screen.xemThongTin;

import entity.Xe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import javafx.scene.image.Image;
import views.screen.thongTinBrief.GiaoDienXeDangThue;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */

public class GiaoDienThongTinXe extends BaseScreenHandler{
    @FXML
    VBox mainVBox;
    @FXML
    ImageView bike;
    @FXML
    Text tenBaiXe;
    @FXML
    Text loaiXe;
    @FXML
    Text pin;
    @FXML
    Text bienSo;
    @FXML
    Text tienCoc;
    @FXML
    Text phi30;
    @FXML
    Text phi15;
    @FXML
    Button buton1;
    @FXML
    Button buton2;

    private  Xe xe;

    public void setIcon(){
        setImage(this.bike,"bike.png");
    }
    public void setBasicScene(){
        setMenu(mainVBox);
        setIcon();
        tenBaiXe.setText(xe.getBaiXe().getTenBaiXe() + " bai xe");

        loaiXe.setText(xe.getLoaiXe().getTenLoaiXe());
        if (xe.getPin()!=null){
            pin.setText(xe.getPin().toString());
        }else {
            pin.setText("Không");
        }
        bienSo.setText(xe.getBienSoXe());
        tienCoc.setText(xe.getLoaiXe().getGiaTri() + "");
        phi30.setText(xe.getLoaiXe().getGia30pDau()+"");
        phi15.setText(xe.getLoaiXe().getGiaMoi15p()+"");
    }

    public GiaoDienThongTinXe(Stage stage, String screenPath, Xe xe, AnchorPane content) throws IOException {
        super(stage, screenPath);
        this.xe = xe;
        setBasicScene();
        tenBaiXe.setText("Xe đang được thuê:");
        buton1.setText("Tạm dừng");
        buton2.setText("Trả xe");
        GiaoDienXeDangThue giaoDienXeDangThue = new GiaoDienXeDangThue(Configs.THONG_TIN_XE_DANG_THUE_PATH, null);
        mainVBox.getChildren().add(giaoDienXeDangThue.getContent());
    }

    public GiaoDienThongTinXe(Stage stage, String screenPath, Xe xe) throws IOException {
        super(stage, screenPath);
        this.xe = xe;
        setBasicScene();
        if (xe.getTrangThai()==Xe.CHUA_THUE) {
            tenBaiXe.setText("Bai xe: " + xe.getBaiXe().getTenBaiXe());
            buton1.setVisible(false);
            buton2.setText("Thuê Xe");
        }else {

        }
    }
}
