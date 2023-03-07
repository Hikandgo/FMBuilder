module XMLBuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;

    opens my.hikandgo.xmlbuilderapp to javafx.fxml;
    opens my.hikandgo.xmlbuilderapp.view to javafx.fxml;
    exports my.hikandgo.xmlbuilderapp;
}