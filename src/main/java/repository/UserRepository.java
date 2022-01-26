package repository;

import database.ConnectionDatabase;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private static Connection connection = ConnectionDatabase.getConnection();
    private static PreparedStatement preparedStatement;

    public static User login(String userName, String password){
        String query = " SELECT * FROM users";
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if(resultSet.getString("user_name").equals(userName) && resultSet.getString("password").equals(password)){
                    User user = new User(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(7));
                    return user;
                }
            }

        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }


    public static void singUp(int rolId,String name,String userName,String passWord,int isActive)
    {
        String query = "INSERT INTO users(role_id,first_name,user_name,password,isactive)" +
                "VALUES (?,?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,rolId);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,userName);
            preparedStatement.setString(4,passWord);
            preparedStatement.setInt(5,isActive);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            System.out.println(e);

        }
    }


    public static void singUp(int rolId,String firstName,String lastName,String address, String userName,String passWord,int isActive){
          String query = "INSERT INTO users(role_id,first_name,last_name,user_name,password,isactive) " +
                                                    "VALUES (?,?,?,?,?,?);";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,rolId);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,lastName);
            preparedStatement.setString(4,userName);
            preparedStatement.setString(5,passWord);
            preparedStatement.setInt(6,isActive);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            System.out.println(e);

        }

    }
}
