package org.example.demo4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DressCollectionController implements Initializable {
    @FXML
    public TextField dressName;
    @FXML
   public   PasswordField discountField;
    @FXML
   public ChoiceBox<String> dressType, dressSize;
    @FXML
   public ColorPicker dressColor;
    @FXML
    public Slider price;
    @FXML
    public TextArea dressdes;
    @FXML
   public DatePicker date;
    @FXML
   public  Spinner<Integer> quality;
    @FXML
  public  ImageView uploadImage;
    @FXML
  public  CheckBox Boost;
    @FXML
    public ToggleGroup gender;

    @FXML
    private Label welcomeText;



    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> dressTypeList = FXCollections.observableArrayList();
        dressTypeList.add("Hoodie");
        dressTypeList.add("Sweater");
        dressType.setItems(dressTypeList);
        dressType.setValue("select an option");
        ObservableList<String> dressSizeList = FXCollections.observableArrayList();
        dressSizeList.add("Small");
        dressSizeList.add("medium");
        dressSizeList.add("Large");
        dressSize.setItems(dressSizeList);
        dressSize.setValue("select an option");
        quality.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,500));
        price.getValue();
        price.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int currentPrice = (int) price.getValue();

            }
        });
    }
    @FXML
    public void save(){
        String name = dressName.getText();
        String des = dressdes.getText();
        String dressTypenew = dressType.getValue();
        LocalDate dateNew = date.getValue();
        boolean agree = Boost.isSelected();
        int currp = (int) price.getValue();
        RadioButton genderRadio = (RadioButton) gender.getSelectedToggle();
        String gender = genderRadio.getText();
        String l = name+","+des;
        System.out.println(name +","+des +","+dressTypenew +","+agree +","+gender+","+dateNew.toString()+","+currp);

        try{
            RandomAccessFile ref = new RandomAccessFile("dressDetails.txt","rw");
            ref.seek(ref.length());
            ref.writeBytes(l);
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void changeToDresslist(){
HelloApplication.changeScene("dressList");
    }
}
