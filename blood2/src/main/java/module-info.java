module org.example.blood2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.blood2 to javafx.fxml;
    exports org.example.blood2;
}