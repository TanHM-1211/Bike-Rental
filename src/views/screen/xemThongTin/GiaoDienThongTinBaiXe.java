package views.screen.xemThongTin;

import entity.BaiXe;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;

import java.io.IOException;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:52 AM , 12/16/2020
 */

public class GiaoDienThongTinBaiXe extends BaseScreenHandler{
    @FXML
    VBox mainVBox;
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
    private BaiXe baiXe;

    public void setIcon(){
        setImage(this.bike1,"bike2.png");
        setImage(this.bike2,"bike2.png");
    }
    public void xemDanhSachLoaiXe(String listName){
        try {
            List listXe = BaiXe.getXeTrongBai(baiXe);
            GiaoDienDanhSachXe giaoDienDanhSachXe = new GiaoDienDanhSachXe(stage, Configs.DANH_SACH_XE_PATH, listName, listXe);
            giaoDienDanhSachXe.setPreviousScreen(this);
            giaoDienDanhSachXe.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    public GiaoDienThongTinBaiXe(Stage stage, String screenPath, BaiXe baiXe) throws IOException {
        super(stage, screenPath);
        this.baiXe = baiXe;
        setMenu(mainVBox);
        tenBaiXe.setText(baiXe.getTenBaiXe());
        diaChiBaiXe.setText(baiXe.getDiaChi());
        dienTich.setText(String.valueOf(baiXe.getDienTich()));
        listXeDap.setOnAction(e->{
            xemDanhSachLoaiXe("Bãi 01: Xe đạp");
        });
        listXeDapDien.setOnAction(e->{
            xemDanhSachLoaiXe("Bãi 01: Xe đạp điện");
        });
    }
}
