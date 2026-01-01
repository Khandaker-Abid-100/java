package org.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DashbordController {
//
    @FXML
    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }


    @FXML
    public TextField codeField;
@FXML
    public TextField cgpaField;
@FXML
    public TextField nameField;
@FXML
  public void save(){
     String code = codeField.getText();
     String cgpa = cgpaField.getText();
    String name = nameField.getText();
     String l = code+","+name+","+cgpa+"\n";
//    System.out.println(l);
    try{
        RandomAccessFile ref = new RandomAccessFile("dashbord.txt","rw");
        ref.seek(ref.length());
        ref.writeBytes(l);
    }catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }
    welcomeText.setText("Welcome to JavaFX Application!");
}
            public void read(){
    try{
        RandomAccessFile ref = new RandomAccessFile("dashbord.txt","r");
        String line;
        while ((line= ref.readLine())!=null){
//            System.out.println(line);
           String[] arr =  line.split(",");
           int code = Integer.parseInt(arr[0]);
           double cgpa = Double.parseDouble(arr[2]);
            System.out.println(code+" "+cgpa);
        }
    }catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }
            }
}
