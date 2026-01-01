module org.example.bkash3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.bkash3 to javafx.fxml;
    exports org.example.bkash3;
}