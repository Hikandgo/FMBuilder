package my.hikandgo.xmlbuilderapp.view;

import javafx.fxml.FXML;
import my.hikandgo.xmlbuilderapp.MainApp;

import java.io.IOException;

public class RootLayoutController {

    @FXML
    private MainApp mainApp;

    public RootLayoutController() {

    }
    @FXML
    private void initialize() {

    }

    @FXML
    public void switchToBuilder() {
        mainApp.showBuilder();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
