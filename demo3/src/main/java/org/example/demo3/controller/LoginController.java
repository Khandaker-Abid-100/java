package org.example.demo3.controller;

import javafx.fxml.FXML;
import org.example.demo3.HelloApplication;

public class LoginController {
    @FXML
    public void changeToReg(){
        HelloApplication.changeScene("reg");
    }
}
