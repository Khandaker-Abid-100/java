package org.example.myproject;

import javafx.fxml.FXML;

public class LoginController {
    @FXML
    public void moveToRegistration(){

        HelloApplication.changeScene("registration");
    }
}
