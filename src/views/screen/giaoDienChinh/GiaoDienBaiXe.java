package views.screen.giaoDienChinh;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.FXMLScreenHandler;
import views.screen.xemThongTin.GiaoDienThongTinBaiXe;

import javax.swing.plaf.PanelUI;
import java.io.IOException;

public class GiaoDienBaiXe extends FXMLScreenHandler {
    @FXML
    Rectangle rectangle;
    @FXML
    Text view1;
    @FXML
    Text view2;
    private BaseScreenHandler parentScene;

    public void setFill(String c){
        rectangle.setFill(Color.web(c));
    }
    public void xemThongTin(){
        GiaoDienThongTinBaiXe giaoDienThongTinBaiXe = null;
        try {
            giaoDienThongTinBaiXe = new GiaoDienThongTinBaiXe(parentScene.getStage(), Configs.THONGTIN_BAIXE_PATH);
            giaoDienThongTinBaiXe.setScreenTitle("Thong tin bai xe");
            giaoDienThongTinBaiXe.setIcon();
            giaoDienThongTinBaiXe.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void setClick(BaseScreenHandler parentScene)throws IOException {
        this.parentScene = parentScene;
        view1.setOnMouseClicked(e -> {
            xemThongTin();
        });
        view2.setOnMouseClicked(e -> {
            xemThongTin();
        });
    }

    public void setParentScene(BaseScreenHandler parentScene) {
        this.parentScene = parentScene;
    }
    public GiaoDienBaiXe(String screenPath) throws IOException {
        super(screenPath);
    }

}
