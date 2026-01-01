package org.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class DressListController implements Initializable {
    @FXML
    TableView<Dress> DressListTable;
    @FXML
    TableColumn<Dress,String> dressName;

    public void changeToDressCollection(){

        HelloApplication.changeScene("dressCollection");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
