package views.screen.giaoDienChinh;
/**
 * Project Ecobike System
 * User: Nhom 11
 *
 * @since : 17/12/2020, Thu
 **/
import java.io.IOException;
import java.util.logging.Logger;

import javafx.fxml.Initializable;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;


public class GiaoDienChinh extends BaseScreenHandler {

    public static Logger LOGGER = Utils.getLogger(GiaoDienChinh.class.getName());



    public GiaoDienChinh(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
    }

}
