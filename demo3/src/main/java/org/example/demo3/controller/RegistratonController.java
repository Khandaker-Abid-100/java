package org.example.demo3.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.demo3.HelloApplication;
import org.example.demo3.model.User;
import org.example.demo3.service.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistratonController implements Initializable {
    @FXML
    public TextField nameField;
    @FXML
    public TextField mobileField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public ToggleGroup gender;
    @FXML
    public ChoiceBox<String> selectField;
    @FXML
    public CheckBox agreeCheckBox;

    @FXML
    public TextArea Text;
    @FXML
    public Label button;
           @FXML
           public void register(){
               String mobile = mobileField.getText();
               String name = nameField.getText();
               String password = passwordField.getText();
               String bloodGroup= selectField.getValue();
               String text= Text.getText();
               boolean agree= agreeCheckBox.isSelected();
               RadioButton chooseGender = (RadioButton) gender.getSelectedToggle();
               String getGender = chooseGender.getText();
               HelloApplication.user = new User(name,password,mobile);
               UserService userService = new UserService();
               userService.insert(HelloApplication.user);
               button.setText("registration done");
               HelloApplication.changeScene("dash");
               System.out.println(name+","+mobile+","+password+","+bloodGroup+","+text+","+agree+","+getGender);
           }


    public void changeToLog(){
        HelloApplication.changeScene("login");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("i am abid");
        ObservableList<String> bloodGroup = FXCollections.observableArrayList();
        bloodGroup.add("AB+");
        bloodGroup.add("AB-");
        bloodGroup.add("B-");
        bloodGroup.add("B+");
        bloodGroup.add("A+");
        bloodGroup.add("A-");
        selectField.setItems(bloodGroup);
    }
}
