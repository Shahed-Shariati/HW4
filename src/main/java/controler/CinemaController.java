package controler;

import model.Movie;
import model.User;
import repository.CinemaRepository;
import repository.MovieRepository;
import utility.CinemaList;

public class CinemaController {
private static CinemaList cinemaList = new CinemaList();


public static void showCinemaList()
{
    cinemaList = CinemaRepository.showCinemaList();
    cinemaList.show();


}

public static boolean checkAuthenticationAccount(User user){
    if(user.getIsActive() == 1){
        return true;
    }
    return false;
}
public static void authenticationCinema(String  id,String active){
    int act = 0;
    int idCinema = Integer.parseInt(id);
    if(active.equalsIgnoreCase("active")){
      act = 1;
        CinemaRepository.authenticationCinema(idCinema,act);
    }else if(active.equalsIgnoreCase("inactive")){
        act = 0;
        CinemaRepository.authenticationCinema(idCinema,act);
    }else {
        System.out.println("invalidation");
    }

  }
    public static void addMovieToList( String name, String time, String type)
    {
        int tim = Integer.parseInt(time);
        Movie movie = new Movie(name, tim, type);
        MovieRepository.addMovieToList(movie);
    }

    public static void deleteTicket(String ticketid){
      TicketController.deleteTicket(ticketid);
    }
    public static void showTicketList(String idCinema)
    {
        TicketController.showTicketList(idCinema);
    }
    public static void addScene(int cinemaId,String movieId,String date,String time,String count){
//        int movie = Integer.parseInt(movieId);
//        int countInt = Integer.parseInt(count);
//        MovieRepository.addScene(cinemaId,movie,date,time,countInt);
        CinemaMovieController.addScene(cinemaId,movieId,date,time,count);
    }
}
