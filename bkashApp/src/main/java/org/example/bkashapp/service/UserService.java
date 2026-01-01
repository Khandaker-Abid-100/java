package org.example.bkashapp.service;

import org.example.bkashapp.model.User;

import java.sql.*;

public class UserService {
    public boolean register(User user){
  try {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bkashApp","root","Aa1!Bb2@");
    Statement statement = connection.createStatement();
    String query = "INSERT INTO user VALUE('"+user.getName()+"','"+user.getMobile()+"','"+user.getPin()+"','"+user.getType()+"');" ;
    statement.execute(query);
    return true;
     }catch (SQLException e){
    e.printStackTrace();
    }
  return false;
    }
    public User login(String mobile,String pin){
      try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bkashApp","root","Aa1!Bb2@");
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM user WHERE mobile = '"+mobile+"' and pin= '"+pin+"';";
        ResultSet resultSet =statement.executeQuery(query);
        while (resultSet.next()){
       String name = resultSet.getString("name");
       String mobileNumber = resultSet.getString("mobile");
       String type = resultSet.getString("type");
       return new User(name,mobile,type);
        }
      }catch (SQLException e){
        e.printStackTrace();
      }
      return null;
      }
}
