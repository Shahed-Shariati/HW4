package controler;

import model.User;
import repository.UserRepository;
import utility.MovieList;

public class UserController {


  public User login(String userName, String password){
       User user =  UserRepository.login(userName,password);
     return  user;
   }

   public static void singUp(String roleId, String name, String userName, String passWord, String isActive)
   {
       int active = Integer.parseInt(isActive);
       int role = Integer.parseInt(roleId);
      UserRepository.singUp(role,name,userName,passWord,active);
   }

   public static void singUp(String roleId, String firstName, String lastName, String address,String userName, String password,String isActive){
      int role = Integer.parseInt(roleId);
      int active = Integer.parseInt(isActive);
      UserRepository.singUp(role,firstName,lastName,address,userName,password,active);

   }

   public static void cinemaProfit(String cinemaId){
      CinemaMovieController.cinemaProfit(cinemaId);
   }
    public static void showCinemaMovie()
    {
        CinemaMovieController.showCinemaMovie();
    }
    public static void searchByDateMovie(String date){
      CinemaMovieController.searchByDateMovie(date);
    }
    public static void searchByNameMovie(String name){
      CinemaMovieController.searchByNameMovie(name);
    }
    public static void reserveTicket(User user,String idCinemaMovie,String ticketCount)

    {
        int remind = CinemaMovieController.remindTicket(idCinemaMovie);
        if(remind > Integer.parseInt(ticketCount)) {
            String idUser = String.valueOf(user.getId());
            TicketController.reserveTicket(idUser, idCinemaMovie, ticketCount);
        }else {
            System.out.println("-----------------Zarfiat por shode--------------------");
        }

    }
}
