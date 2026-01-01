package org.example.bkash3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    public TextField mobleField;

    @FXML
    public TextField nameField;

    @FXML
    public TextField pinField;
    @FXML
    public Label welcome;

    @FXML
   public void register(ActionEvent event) {
         String mobile = mobleField.getText();
         String name= nameField.getText();
         String pin = pinField.getText();
         String type = "customer";
         User user = new User(mobile,name,pin,type);
           UserService userService = new UserService();
           boolean isRegistered = userService.insert(user);
           if (isRegistered){
               welcome.setText("very good");
           }else {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("wrong");
               alert.showAndWait();
           }
    }

}