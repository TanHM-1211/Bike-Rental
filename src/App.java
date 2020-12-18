import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.Configs;

import views.screen.giaoDienChinh.GiaoDienChinh;

import views.screen.GiaoDienXacNhanTraXe;
import views.screen.thueXe.GiaoDienXacNhanThanhToan;
import views.screen.xemThongTin.GiaoDienThongTinBaiXe;
import views.screen.xemThongTin.GiaoDienThongTinXeDangThue;



import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 16/12/2020, Wed
 **/
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // initialize the scene
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(Configs.SPLASH_SCREEN_PATH));
            StackPane root = (StackPane)loader.load();
            primaryStage.setTitle("ECOBIKE");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

            // Load splash screen with fade in effect
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            // Finish splash with fade out effect
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), root);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            // After fade in, start fade out
            fadeIn.play();
            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            // After fade out, load actual content
            fadeOut.setOnFinished((e) -> {
                try {
                    GiaoDienChinh giaoDienChinh = new GiaoDienChinh(primaryStage, Configs.HOME_PATH);
                    giaoDienChinh.setScreenTitle("Start screen");
                    giaoDienChinh.show();


//                    GiaoDienBaiXe giaoDienNhapMaVach = new GiaoDienBaiXe(primaryStage, Configs.MAVACH_PATH);
//                    giaoDienNhapMaVach.setScreenTitle("Nhap ma vach");
//                    giaoDienNhapMaVach.show();

//                    GiaoDienThongTinXe giaoDienThongTinXe = new GiaoDienThongTinXe(primaryStage, Configs.THUEXE_THONGTINXE_PATH);
//                    giaoDienThongTinXe.setScreenTitle("Thong tin xe");
//                    giaoDienThongTinXe.setIcon();
//                    giaoDienThongTinXe.show();

//                    GiaoDienChonTheThanhToan giaoDienChonTheThanhToan = new GiaoDienChonTheThanhToan(primaryStage, Configs.THUEXE_CHONTHE_PATH);
//                    giaoDienChonTheThanhToan.setScreenTitle("Chon the");
//                    giaoDienChonTheThanhToan.show();

//                    GiaoDienXacNhanThanhToan giaoDienXacNhanThanhToan = new GiaoDienXacNhanThanhToan(primaryStage, Configs.THUEXE_XACNHAN_PATH);
//                    giaoDienXacNhanThanhToan.setScreenTitle("Xac Nhan");
//                    giaoDienXacNhanThanhToan.show();

//                    GiaoDienThongTinBaiXe giaoDienThongTinBaiXe = new GiaoDienThongTinBaiXe(primaryStage, Configs.THONGTIN_BAIXE_PATH);
//                    giaoDienThongTinBaiXe.setScreenTitle("Thong tin bai xe");
//                    giaoDienThongTinBaiXe.setIcon();
//                    giaoDienThongTinBaiXe.show();

//                    GiaoDienThongTinXeDangThue giaoDienThongTinXe = new GiaoDienThongTinXeDangThue(primaryStage, Configs.TRAXE_THONGTINXE_PATH);
//                    giaoDienThongTinXe.setScreenTitle("Thong tin xe");
//                    giaoDienThongTinXe.setIcon();
//                    giaoDienThongTinXe.show();

//                    GiaoDienXacNhanTraXe giaoDienXacNhanTraXe = new GiaoDienXacNhanTraXe(primaryStage, Configs.THUEXE_XACNHAN_PATH);
//                    giaoDienXacNhanTraXe.show();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}