package repository;

import database.SingeltonDatabase;
import model.CinemaMovie;
import model.Movie;
import model.Ticket;
import utility.CinemaMovieList;
import utility.MovieList;
import utility.TicketList;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CinemaMovieRepository {
    private static Connection connection = SingeltonDatabase.getInstance().getConnection();
    private static TicketList ticketList = new TicketList();
    private static PreparedStatement preparedStatement;
    private static CinemaMovieList cinemaMovieList = new CinemaMovieList();


    public static CinemaMovieList getCinemaMovieList()
    {
        cinemaMovieList.clear();
        String query = "SELECT c.id, first_name,name,date,hour,count-sell as remind  FROM users\n" +
                "          INNER JOIN cinemamovie c ON users.id = c.cinema_id\n" +
                "           INNER JOIN movie m ON m.id = c.movie_id;";

        try{
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                cinemaMovieList.add(new CinemaMovie(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6)));
//              cinemaMovieList.add(new CinemaMovie(resultSet.getString(1)
//                       ,resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getString(4),
//                        resultSet.getInt(5)));
            }
            preparedStatement.close();
            return cinemaMovieList;
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }


    public static CinemaMovieList searchByDateMovie(String date){
        cinemaMovieList.clear();
        java.sql.Date date1 = java.sql.Date.valueOf(date);
        String query = "SELECT m.id,U.first_name,  m.name,cm.date,m.time  FROM cinemamovie cm INNER JOIN movie m on m.id = cm.movie_id\n" +
                "INNER JOIN users u on u.id = cm.cinema_id\n" +
                "WHERE date = ?;";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1,date1);
             ResultSet resultSet = preparedStatement.executeQuery();
              while (resultSet.next()){
                  cinemaMovieList.add(new CinemaMovie(resultSet.getInt(1),
                          resultSet.getString(2),
                          resultSet.getString(3),
                          resultSet.getString(4),
                          resultSet.getString(5)));
              }
        }catch (SQLException e){
            System.out.println("---------------------Film not found-----------------------------");
            System.out.println(e);
        }
        return cinemaMovieList;
    }
    public static CinemaMovieList searchByNameMovie(String name) {
        cinemaMovieList.clear();
        String query = "SELECT m.id,u.first_name,m.name,c.date,c.hour FROM movie m " +
                "INNER JOIN cinemamovie c on m.id = c.movie_id " +
                "inner join users u on u.id = c.cinema_id WHERE m.name like ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cinemaMovieList.add(new CinemaMovie(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println("---------------------Film not found-----------------------------");
        }
        return cinemaMovieList;
    }
    public static void sellSet(int id,int count){
        String query = "UPDATE cinemamovie SET sell = ? WHERE id = ?";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,count);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            System.out.println(e);
        }

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
        }catch (SQLException e){
            System.out.println(e);

        }catch (ParseException e){
            System.out.println("date is wrong");
        }
    }

    public static  int remindTicket(int idCinemaMovie)
    {
        int remind = 0;
      String query = "SELECT count-cinemamovie.sell  FROM cinemamovie  WHERE id = ?;";
      try
      {
          preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1,idCinemaMovie);
          ResultSet resultSet = preparedStatement.executeQuery();
          while (resultSet.next()){
              return remind = resultSet.getInt(1);
          }
          preparedStatement.close();
      }catch (SQLException e ){
          System.out.println(e);
      }
      return remind;
    }

    public static int cinemaProfit(int cinemaId){
        int profit = 0;
        String query = "SELECT sum(sell) * 4500 FROM cinemamovie WHERE cinema_id = ?;";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,cinemaId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                profit = resultSet.getInt(1);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return profit;
    }

}
