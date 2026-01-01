package org.example.bkash3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
    public boolean insert(User user){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bkash3","root","Aa1!Bb2@");
            Statement statement = connection.createStatement();
            String q = "INSERT INTO user VALUE('"+user.getName()+"','"+user.getMobile()+"','"+user.getPin()+"','"+user.getType()+"');";
            statement.execute(q);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
