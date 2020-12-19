package views.screen;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import utils.Configs;

import java.io.IOException;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:53 AM , 12/16/2020
 */

public class GiaoDienKetQua extends BaseScreenHandler {


    @FXML
    ImageView tickicon;

    @FXML
    Label message;


    public GiaoDienKetQua(Stage stage) throws IOException{
        super(stage, Configs.RESULT_PATH);
    }

    private static GiaoDienKetQua popup(String message, String imageName, Boolean undecorated) throws IOException{
        GiaoDienKetQua popup = new GiaoDienKetQua(new Stage());
        if (undecorated) popup.stage.initStyle(StageStyle.UNDECORATED);
        popup.message.setText(message);
        if (undecorated==false){
            popup.message.setTextFill(Color.RED);
        }
        popup.setImage(imageName);
        return popup;
    }

    public static void success(String message) throws IOException{
        popup(message, "tickgreen.png", true).show(true);
    }

    public static void error(String message) throws IOException{
        popup(message, "tickerror.png", false).show(false);
    }

    public static GiaoDienKetQua loading(String message) throws IOException{
        return popup(message, Configs.IMAGE_PATH + "/" + "loading.gif", true);
    }

    public void setImage(String path) {
        super.setImage(tickicon, path);
    }

    public void show(Boolean autoclose) {
        super.show();
        if (autoclose) close(0.8);
    }

    public void show(double time) {
        super.show();
        close(time);
    }

    public void close(double time){
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
    }
}
