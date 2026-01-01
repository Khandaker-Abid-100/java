package org.example.blood2;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    public TableView<User> tableView;
    @FXML
    public TableColumn<User,String> nameColumn;
    @FXML
    public TableColumn<User,String> mobileColumn;
    @FXML
    public TableColumn<User,String> ageColumn;
    @FXML
    public TableColumn<User,String> cgpaColumn;
    @FXML
    public TableColumn<User,String> bioField;
    @FXML
    public TableColumn<User,String> bloodField;

    @FXML
    public Label nameField;
    @FXML
    public ListView<String> ListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getName()));
        mobileColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getMobile()));
         ageColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getAge()));
        cgpaColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCgpa()));
        bioField.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getBio()));
        bloodField.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getBloodGroup()));
        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        userObservableList.add(new User("abul","123","678","3.5","30","hiiiii","B+"));
        userObservableList.add(HelloApplication.loggeduser);
        tableView.setItems(userObservableList);
        nameField.setText(HelloApplication.loggeduser.getName());
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add(HelloApplication.loggeduser.getName());
        ListView.setItems(list);
    }
}
