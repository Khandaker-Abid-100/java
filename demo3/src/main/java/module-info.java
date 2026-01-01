module org.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.demo3 to javafx.fxml;
    exports org.example.demo3;
    exports org.example.demo3.model;
    opens org.example.demo3.model to javafx.fxml;
    exports org.example.demo3.controller;
    opens org.example.demo3.controller to javafx.fxml;
}