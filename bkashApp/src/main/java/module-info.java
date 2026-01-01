module org.example.bkashapp {
    requires javafx.controls;
    requires javafx.fxml;
requires java.sql;

    opens org.example.bkashapp to javafx.fxml;
    exports org.example.bkashapp;
    exports org.example.bkashapp.controller;
    opens org.example.bkashapp.controller to javafx.fxml;
}