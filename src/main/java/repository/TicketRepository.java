package repository;

import database.SingeltonDatabase;
import model.Ticket;
import utility.TicketList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketRepository {
    private static Connection connection = SingeltonDatabase.getInstance().getConnection();
    private static TicketList ticketList = new TicketList();
    private static PreparedStatement preparedStatement;


    public static void reserveTicket(int idCinemaMovie,int idUser)
    {
        String query = "INSERT INTO ticket (cinemamovie_id,user_id) VALUES " +
                                 " (?,?); ";
        try
        {
           preparedStatement = connection.prepareStatement(query);
           preparedStatement.setInt(1,idCinemaMovie);
           preparedStatement.setInt(2,idUser);
           preparedStatement.executeUpdate();
           preparedStatement.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static TicketList getTicketList(int cinemaId){
        ticketList.clear();
     String query = "select t.id,u.first_name,m.name,cm.date,cm.hour from cinemamovie cm" +
             "    inner join ticket t on cm.id = t.cinemamovie_id" +
             "    inner join users u on u.id = cm.cinema_id" +
             "   inner join movie m on m.id = cm.movie_id where cm.cinema_id =? ;";
     try{
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1,cinemaId);
         ResultSet resultSet = preparedStatement.executeQuery();
         while (resultSet.next()){
             ticketList.add(new Ticket(resultSet.getInt(1),
                     resultSet.getString(2),
                     resultSet.getString(3),
                     resultSet.getString(4),
                     resultSet.getString(5)));
         }

     }catch (SQLException e){
         System.out.println(e);
     }
       return ticketList;
    }
    public static String[] getTicketDateAndTime(int ticketId){
        String[] dateTime = new String[2];
        String query = "SELECT date ,hour FROM ticket" +
                    " INNER JOIN  cinemamovie c ON c.id = ticket.cinemamovie_id " +
                 "WHERE ticket.id = ?;";
        try
        {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ticketId);
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                dateTime[0] = resultSet.getString(1);
                dateTime[1] = resultSet.getString(2);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return dateTime;
    }


    public static void deleteTicket(int id){
        String query = "DELETE FROM ticket WHERE id = ?";
        try
        {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public static int getIdCinemaMovie(int idTicket){
        String query = "SELECT cinemamovie_id FROM ticket WHERE id = ?;";
        int cinemamovieID = 0;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idTicket);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                cinemamovieID = resultSet.getInt(1);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return cinemamovieID;
    }
    public static int countTicketSell(int idCinemaMovie)
    {
        int count = 0;
        String query = "SELECT count(*) FROM ticket WHERE cinemamovie_id = ?;";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idCinemaMovie);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                count = resultSet.getInt(1);
            }
        }catch (SQLException e)
        {
            System.out.println(e);
        }
        return count;
    }

}
