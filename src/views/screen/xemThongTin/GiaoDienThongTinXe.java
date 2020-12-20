package views.screen.xemThongTin;

import controller.DieuKhienThueXe;
import controller.DieuKhienXeDangThue;
import entity.GiaoDichThueXe;
import entity.Xe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.GiaoDienXacNhanTraXe;
import views.screen.thongTinBrief.GiaoDienXeDangThue;
import views.screen.thueXe.GiaoDienChonTheThanhToan;

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

    public void setThueXe(){
        tenBaiXe.setText("Bai xe: " + xe.getBaiXe().getTenBaiXe());
        buton2.setVisible(true);
        buton2.setText("Thuê Xe");
        buton2.setOnMouseClicked(e->{
            try {
                GiaoDienChonTheThanhToan giaoDienChonTheThanhToan;
                giaoDienChonTheThanhToan= new GiaoDienChonTheThanhToan(getStage(),Configs.THUE_XE_CHON_THE_PATH,new DieuKhienThueXe(xe));
                giaoDienChonTheThanhToan.setPreviousScreen(this);
                giaoDienChonTheThanhToan.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    public void setDangThue(GiaoDichThueXe giaoDichThueXe) {
        tenBaiXe.setText("Xe đang được thuê:");
        buton1.setVisible(true);
        buton1.setText("Tạm dừng");
        buton2.setVisible(true);
        buton2.setText("Trả xe");
        try {
            GiaoDienXeDangThue giaoDienXeDangThue = new GiaoDienXeDangThue(Configs.THONG_TIN_XE_DANG_THUE_PATH, giaoDichThueXe);
            mainVBox.getChildren().add(giaoDienXeDangThue.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        buton2.setOnMouseClicked(e->{
            try {
                GiaoDienXacNhanTraXe giaoDienXacNhanTraXe;
                giaoDienXacNhanTraXe = new GiaoDienXacNhanTraXe(getStage(),Configs.TRAXE_PATH);
                giaoDienXacNhanTraXe.setPreviousScreen(this);
                giaoDienXacNhanTraXe.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    public void checkThongTin(){
        DieuKhienXeDangThue dieuKhienXeDangThue= new DieuKhienXeDangThue();
        GiaoDichThueXe giaoDichThueXe = dieuKhienXeDangThue.getGiaoDichHienTai();
        if (giaoDichThueXe==null && xe.getTrangThai()==Xe.CHUA_THUE)
            setThueXe();
        else {
            if (giaoDichThueXe != null && giaoDichThueXe.getXe() == xe)
                setDangThue(giaoDichThueXe);

        }
    }
    public GiaoDienThongTinXe(Stage stage, String screenPath, Xe xe) throws IOException {
        super(stage, screenPath);
        this.xe = xe;
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
        buton1.setVisible(false);
        buton2.setVisible(false);
        checkThongTin();
    }
}
