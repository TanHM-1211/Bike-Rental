package views.screen.xemThongTin;

import entity.BaiXe;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */

public class GiaoDienThongTinBaiXe extends BaseScreenHandler{

    @FXML
    Text tenBaiXe;
    @FXML
    Text diaChiBaiXe;
    @FXML
    Text dienTich;
    @FXML
    ImageView bike1;
    @FXML
    ImageView bike2;
    @FXML
    MenuItem listXeDap;
    @FXML
    MenuItem listXeDapDien;
    public void setIcon(){
        setImage(this.bike1,"bike2.png");
        setImage(this.bike2,"bike2.png");
    }
    public void xemDanhSachLoaiXe(){
        GiaoDienThongTinXe giaoDienThongTinXe= null;
        try {
            giaoDienThongTinXe = new GiaoDienThongTinXe(stage, Configs.THONG_TIN_XE_PATH);
            giaoDienThongTinXe.setScreenTitle("Thong tin bai xe");
            giaoDienThongTinXe.setIcon();
            giaoDienThongTinXe.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public GiaoDienThongTinBaiXe(Stage stage, BaiXe baiXe, String screenPath) throws IOException {
        super(stage, screenPath);
        tenBaiXe.setText(baiXe.getTenBaiXe());
        diaChiBaiXe.setText(baiXe.getDiaChi());
        dienTich.setText(String.valueOf(baiXe.getDienTich()));
        listXeDap.setOnAction(e->{
            xemDanhSachLoaiXe();
        });
        listXeDapDien.setOnAction(e->{
            xemDanhSachLoaiXe();
        });
    }
}
