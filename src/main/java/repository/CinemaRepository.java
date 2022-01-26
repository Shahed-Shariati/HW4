package repository;

import database.ConnectionDatabase;
import model.Cinema;
import utility.CinemaList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaRepository {
    private static Connection connection = ConnectionDatabase.getConnection();
    private static CinemaList cinemaList = new CinemaList();
    private static PreparedStatement preparedStatement;





    public static void authenticationCinema(int id,int active)
    {
        String query = "UPDATE users set isactive = ? where id = ?;";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,active);
            preparedStatement.setInt(2,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static CinemaList showCinemaList()
    {
        cinemaList.clear();
        String query = " SELECT * FROM users WHERE role_id = ?";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                cinemaList.add(new Cinema(resultSet.getInt("id"),
                                    resultSet.getString("first_name"),
                                     resultSet.getInt("isactive")));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return cinemaList;
    }


}
