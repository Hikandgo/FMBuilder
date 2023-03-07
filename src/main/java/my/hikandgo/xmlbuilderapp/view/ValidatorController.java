package my.hikandgo.xmlbuilderapp.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import my.hikandgo.xmlbuilderapp.MainApp;
import my.hikandgo.xmlbuilderapp.service.XsdValidator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.IOException;
import java.util.List;

import static my.hikandgo.xmlbuilderapp.constants.XsdPaths.SV_794_1;
import static my.hikandgo.xmlbuilderapp.constants.XsdPaths.SV_794_2;

public class ValidatorController {

    @FXML
    private MainApp mainApp;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField pathXml;
    @FXML
    private TextArea textLog;
    private String xsdPath;

    public ValidatorController() {

    }
    @FXML
    private void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList(
                SV_794_1.getDocName(),
                SV_794_2.getDocName()
        );
        comboBox.setItems(list);
        comboBox.setValue(SV_794_1.getDocName());
        String xsdPath;
    }


    @FXML
    private void getValidate() throws IOException, SAXException {
        String pathToXsd = null;

        if (pathXml.getText() == null || pathToXsd == null) {
            textLog.setText("Введите путь!");
        }

        if (xsdPath.equals(SV_794_1.getDocName())) {
            pathToXsd = SV_794_1.getXsdPath();
        } else if (xsdPath.equals(SV_794_2.getDocName())) {
            pathToXsd = SV_794_2.getXsdPath();
        }

        XsdValidator validator = new XsdValidator();
        List<SAXParseException> list = validator.isValid(pathToXsd, pathXml.getText());
        if (list.size() == 0) {
            textLog.setText("Все оки-доки!");
        } else {
            for (SAXParseException el: list) {
                textLog.setText(el.getLocalizedMessage());
            }

        }
    }

    @FXML
    public void returnToRoot() {
        mainApp.rootInit();
    }

    @FXML
    public void setTextCombo() {
        comboBox.setOnAction(e -> xsdPath = (comboBox.getValue()));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
