package org.example.demo3.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.demo3.HelloApplication;
import org.example.demo3.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class DashController implements Initializable {

    @FXML
    public ListView<String> List;
    @FXML
    public TableView<User> tableView;
    @FXML
    public TableColumn<User,String> nameColumn;
    @FXML
    public TableColumn<User,String> mobileColumn;
    public void login(){
        HelloApplication.changeScene("login");
    }
    @FXML
    public Label welcome;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getName()));
        mobileColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getMobile()));
        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        userObservableList.add(HelloApplication.user);
        tableView.setItems(userObservableList);
        welcome.setText(HelloApplication.user.getName());
        ObservableList<String> listtView = FXCollections.observableArrayList();
        listtView.add("abul");
        listtView.add("Babul");
        listtView.add(HelloApplication.user.getName());
        List.setItems(listtView);
    }
}
