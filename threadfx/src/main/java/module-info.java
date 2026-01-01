module org.example.threadfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.threadfx to javafx.fxml;
    exports org.example.threadfx;
}