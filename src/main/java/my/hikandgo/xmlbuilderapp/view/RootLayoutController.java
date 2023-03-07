package my.hikandgo.xmlbuilderapp.view;

import javafx.fxml.FXML;
import my.hikandgo.xmlbuilderapp.MainApp;


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

    @FXML
    public void switchToValidator() {
        mainApp.showValidator();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
