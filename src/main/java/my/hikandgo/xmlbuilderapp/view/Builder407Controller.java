package my.hikandgo.xmlbuilderapp.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.DirectoryChooser;
import javafx.util.converter.IntegerStringConverter;
import my.hikandgo.xmlbuilderapp.MainApp;
import my.hikandgo.xmlbuilderapp.models.Builder407model;
import my.hikandgo.xmlbuilderapp.service.Builder407;
import my.hikandgo.xmlbuilderapp.service.TargetFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.UnaryOperator;

public class Builder407Controller {

    @FXML
    private TextField path;
    @FXML
    private TextField textLog;
    @FXML
    private TextField DATE_MSG;
    @FXML
    private TextField DATE_REQ;
    @FXML
    private TextField DATE_GET_REQ;
    @FXML
    private TextField DATE_ORDER;
    @FXML
    private TextField DATE_PROLONG;
    @FXML
    public ProgressBar progressBar;
    @FXML
    private Button inkDMSG;
    @FXML
    private Button dekDMSG;
    @FXML
    private Button inkREQ;
    @FXML
    private Button dekREQ;
    @FXML
    private Button inkGET_REQ;
    @FXML
    private Button dekGET_REQ;
    @FXML
    private Button inkORDER;
    @FXML
    private Button dekORDER;
    @FXML
    private Button inkPROL;
    @FXML
    private Button dekPROL;
    @FXML
    private MainApp mainApp;
    public Builder407Controller() {

    }
    @FXML
    private void initialize() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([0-9][0-9]*)?")) {
                return change;
            }
            return null;
        };
        DATE_MSG.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, filter));
        DATE_REQ.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, filter));
        DATE_GET_REQ.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, filter));
        DATE_ORDER.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, filter));
        DATE_PROLONG.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, filter));
    }

    @FXML
    private void handleInputPath() {
        String inputString = path.getText();
        Path inputPath = Path.of(inputString);
        Builder407model model = new Builder407model(
                Integer.parseInt(DATE_MSG.getText()),
                Integer.parseInt(DATE_REQ.getText()),
                Integer.parseInt(DATE_GET_REQ.getText()),
                Integer.parseInt(DATE_ORDER.getText()),
                Integer.parseInt(DATE_PROLONG.getText())
        );
        try {
            if (Files.exists(inputPath)) {
                TargetFolder folder = new TargetFolder(inputPath);
                Builder407.buildActualDate(folder.getTargetFilesList(), folder.getSecondFilesList(), model);
                textLog.setText("Актуализация КИДов выполнена");
            } else {
                textLog.setText("Введённого каталога не существует");
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }

    @FXML
    private void folderChoise() {
        try {
            DirectoryChooser directory = new DirectoryChooser();
            this.path.setText(directory.showDialog(mainApp.getPrimaryStage()).getAbsolutePath());
        } catch (NullPointerException e) {
            textLog.setText("Выберите или введите абсолютный путь к папке с КИДами 407");
        }

    }

    @FXML
    public void onClickDec(ActionEvent event) {
        if (event.getSource().equals(inkDMSG)) {
            int count = Integer.parseInt(DATE_MSG.getText()) + 1;
            DATE_MSG.setText(String.valueOf(count));
        }
        if (event.getSource().equals(dekDMSG)) {
            int count = Integer.parseInt(DATE_MSG.getText()) - 1;
            DATE_MSG.setText(String.valueOf(count));
        }
        if (event.getSource().equals(inkREQ)) {
            int count = Integer.parseInt(DATE_REQ.getText()) + 1;
            DATE_REQ.setText(String.valueOf(count));
        }
        if (event.getSource().equals(dekREQ)) {
            int count = Integer.parseInt(DATE_REQ.getText()) - 1;
            DATE_REQ.setText(String.valueOf(count));
        }
        if (event.getSource().equals(inkGET_REQ)) {
            int count = Integer.parseInt(DATE_GET_REQ.getText()) + 1;
            DATE_GET_REQ.setText(String.valueOf(count));
        }
        if (event.getSource().equals(dekGET_REQ)) {
            int count = Integer.parseInt(DATE_GET_REQ.getText()) - 1;
            DATE_GET_REQ.setText(String.valueOf(count));
        }
        if (event.getSource().equals(inkORDER)) {
            int count = Integer.parseInt(DATE_ORDER.getText()) + 1;
            DATE_ORDER.setText(String.valueOf(count));
        }
        if (event.getSource().equals(dekORDER)) {
            int count = Integer.parseInt(DATE_ORDER.getText()) - 1;
            DATE_ORDER.setText(String.valueOf(count));
        }
        if (event.getSource().equals(inkPROL)) {
            int count = Integer.parseInt(DATE_PROLONG.getText()) + 1;
            DATE_PROLONG.setText(String.valueOf(count));
        }
        if (event.getSource().equals(dekPROL)) {
            int count = Integer.parseInt(DATE_PROLONG.getText()) - 1;
            DATE_PROLONG.setText(String.valueOf(count));
        }
    }

    @FXML
    public void returnToRoot() {
        mainApp.rootInit();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
