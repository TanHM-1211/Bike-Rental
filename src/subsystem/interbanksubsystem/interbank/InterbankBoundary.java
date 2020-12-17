package subsystem.interbanksubsystem.interbank;

import subsystem.interbanksubsystem.utils.HttpConnector;

import java.io.IOException;

public class InterbankBoundary {
    String query(String url, String data) {
        String respond = null;
        try {
            respond = HttpConnector.post(url, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respond;
    }
}
