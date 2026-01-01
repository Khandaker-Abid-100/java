package org.example.bkashapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.bkashapp.HelloApplication;
import org.example.bkashapp.model.User;
import org.example.bkashapp.service.UserService;

public class LoginController {

    @FXML
    private TextField mobileField;

    @FXML
    private TextField pinField;

    @FXML
    void login(ActionEvent event) {
      String mobile = mobileField.getText();
      String pin = pinField.getText();
        UserService userService = new UserService();
        User user = userService.login(mobile,pin);
        if (user!=null){
            HelloApplication.changeScene("dashboard");
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Mobile or password is incorrect");
            alert.showAndWait();
        }
    }


}
