package org.example.blood2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {
    @FXML
    public TextField nameField;
    @FXML
    public TextField mobileField;
    @FXML
    public TextField passwordField;
    @FXML
    public TextArea bioText;
    @FXML
    public ToggleGroup gender;
    @FXML
    public CheckBox agreeCheckBox;
    @FXML
    public ChoiceBox<String> bloodgroupList;
    @FXML
    public TextField ageField;
    @FXML
    public TextField cgpaField;

    @FXML
    void register(ActionEvent event) {
        String name = nameField.getText();
        String age = ageField.getText();
        String cgpa = cgpaField.getText();
        String mobile = mobileField.getText();
        String password = passwordField.getText();
        String bio = bioText.getText();
        String bloodGroup = bloodgroupList.getValue();
        boolean agree = agreeCheckBox.isSelected();
        RadioButton gen = (RadioButton) gender.getSelectedToggle();
        String gender = gen.getText();

        User user = new User(name,mobile,password,cgpa,age,bio,bloodGroup);
        HelloApplication.loggeduser = user;
         HelloApplication.changeScene("dashboard");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> bloodGroup = FXCollections.observableArrayList();
        bloodGroup.add("A+");
        bloodGroup.add("B+");
        bloodGroup.add("AB+");
        bloodGroup.add("O+");
        bloodGroup.add("B-");
        bloodGroup.add("AB-");
        bloodGroup.add("O-");
        bloodgroupList.setItems(bloodGroup);

    }
}
