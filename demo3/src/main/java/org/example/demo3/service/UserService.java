package org.example.demo3.service;

import org.example.demo3.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
    public void insert(User user){
        try{
         Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost/blood"
                 ,"root","Aa1!Bb2@");
            Statement statement = connection.createStatement();
            String quary = "INSERT INTO user value('"+user.getName()+"','"+user.getPassword()+
                    "','"+user.getMobile()+"')";
                statement.execute(quary);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
