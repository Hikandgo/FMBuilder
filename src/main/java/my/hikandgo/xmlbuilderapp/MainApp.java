package my.hikandgo.xmlbuilderapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import my.hikandgo.xmlbuilderapp.view.Builder407Controller;
import my.hikandgo.xmlbuilderapp.view.RootLayoutController;
import my.hikandgo.xmlbuilderapp.view.ValidatorController;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private GridPane rootLayout;

    private Button returnButton;

    private Button switchScene;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        primaryStage.setTitle("XMLBuilder 2.0");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/appIcon.jpg")));


        rootInit();
    }

    public void showBuilder() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Builder407.fxml"));
            AnchorPane builder407 = loader.load();
            Scene scene = new Scene(builder407);
            primaryStage.setScene(scene);
            primaryStage.show();

            Builder407Controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showValidator() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Validator.fxml"));
            AnchorPane validator = loader.load();
            Scene scene = new Scene(validator);
            primaryStage.setScene(scene);
            primaryStage.show();

            ValidatorController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rootInit() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            GridPane rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
