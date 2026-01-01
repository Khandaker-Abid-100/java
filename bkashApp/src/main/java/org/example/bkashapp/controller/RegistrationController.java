package org.example.bkashapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.bkashapp.HelloApplication;
import org.example.bkashapp.model.User;
import org.example.bkashapp.service.UserService;

public class RegistrationController {

    @FXML
    public TextField mobileField;

    @FXML
    public TextField nameField;

    @FXML
    public TextField pinField;

    @FXML
    void register(ActionEvent event) {
         String name = nameField.getText();
         String mobile = mobileField.getText();
         String pin = pinField.getText();
         String type = "customer";
        User user = new User(name,mobile,pin,type);
        UserService userService = new UserService();
        boolean isRegistered = userService.register(user);
        if(isRegistered){
            HelloApplication.changeScene("login");
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("register is incorrect");
            alert.showAndWait();
        }
    }
    @FXML
    public void goToLogin(ActionEvent event) {
        HelloApplication.changeScene("login");
    }

}
