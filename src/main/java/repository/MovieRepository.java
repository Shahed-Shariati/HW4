package repository;

import database.ConnectionDatabase;
import model.Cinema;
import model.Movie;
import utility.CinemaList;
import utility.MovieList;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class MovieRepository {
    private static Connection connection = ConnectionDatabase.getConnection();
    private static MovieList movieList = new MovieList();
    private static PreparedStatement preparedStatement;

    public static MovieList showMovieList()
    {
        movieList.clear();
        String query = " SELECT * FROM movie ";
        try{
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                movieList.add(new Movie(resultSet.getInt("id"),
                                        resultSet.getString("name"),
                                        resultSet.getInt("time"),
                                        resultSet.getString("type")));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return movieList;
    }

    public static void addScene(int cinemaId,int movieId,String date, String hour,int count){
        Date date1;
        Date time;
        Time sqlTime;
        java.sql.Date sqlDate;


        String query = "INSERT INTO cinemamovie(cinema_id, movie_id, date, hour , count,sell) " +
                       "VALUES (?,?,?,?,?,?)";
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm");
            time = formatTime.parse(hour);
            date1 = formatDate.parse(date);
            sqlTime = new Time(time.getTime());
            sqlDate = new java.sql.Date(date1.getTime());
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,cinemaId);
            preparedStatement.setInt(2,movieId);
            preparedStatement.setDate(3, sqlDate );
            preparedStatement.setTime(4,sqlTime);
            preparedStatement.setInt(5,count);
            preparedStatement.setInt(6,0);
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException | ParseException e){
            System.out.println(e);
        }
    }

public static MovieList searchByDateMovie()
{
    return movieList;
}

public static MovieList searchByNameMovie(String name){
        movieList.clear();
        String query = "select * from movie where name like ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                movieList.add(new Movie(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)));
            }
        }catch (SQLException e){
            System.out.println("---------------------Film not found-----------------------------");
        }
        return movieList;
}




















   public static void addMovieToList(Movie movie )
   {
       String query ="INSERT INTO movie (name, time, type) VALUES (?,?,?);";
       try {
           preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1,movie.getFirstName());
           preparedStatement.setInt(2,movie.getTime());
           preparedStatement.setString(3,movie.getType());
           preparedStatement.execute();
           preparedStatement.close();

       }catch (SQLException e){
           System.out.println(e);
       }
   }

}
