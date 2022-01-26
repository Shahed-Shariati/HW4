package controler;

import model.CinemaMovie;
import repository.CinemaMovieRepository;
import utility.CinemaMovieList;

public class CinemaMovieController {
    private static CinemaMovieList cinemaMovieList = new CinemaMovieList();
    public static void showCinemaMovie(){
     cinemaMovieList.clear();
     cinemaMovieList =  CinemaMovieRepository.getCinemaMovieList();
     cinemaMovieList.show();

    }

    public static void cinemaProfit(String cinemaId){
        int id = Integer.parseInt(cinemaId);
        int profit = CinemaMovieRepository.cinemaProfit(id);
        System.out.println(" Cinema Profit is: "+ profit);
    }
    public static void setSell(int idCinemaMovie, int count)
    {
        CinemaMovieRepository.sellSet(idCinemaMovie,count);
    }

    public static void searchByDateMovie(String date){
        cinemaMovieList.clear();
        cinemaMovieList = CinemaMovieRepository.searchByDateMovie(date);
        cinemaMovieList.showSearch();
    }

public static void searchByNameMovie(String name){
        cinemaMovieList.clear();
        cinemaMovieList = CinemaMovieRepository.searchByNameMovie(name);
        cinemaMovieList.showSearch();
}
public static void addScene(int cinemaId,String movieId,String date,String time,String count)
{
    int movie = Integer.parseInt(movieId);
    int countInt = Integer.parseInt(count);

        CinemaMovieRepository.addScene(cinemaId, movie, date, time, countInt);

}

    public static int remindTicket(String idCinemaMovie){
        int idCinemaMovieInt = Integer.parseInt(idCinemaMovie);
      return   CinemaMovieRepository.remindTicket(idCinemaMovieInt);
    }
}
