package controler;

import model.Movie;
import model.User;
import repository.MovieRepository;
import utility.MovieList;

public class MovieController {
    private static MovieList movieList = new MovieList();

    public static void searchByNameMovie(String name) {
        movieList.clear();
        movieList = MovieRepository.searchByNameMovie(name);
        movieList.show();
    }
    public static void showMovieList()
    {
         movieList = MovieRepository.showMovieList();
         movieList.show();

    }

    public static void addMovieToList( String name, String time, String type)
    {
            int tim = Integer.parseInt(time);
            Movie movie = new Movie(name, tim, type);
            MovieRepository.addMovieToList(movie);
    }
}
