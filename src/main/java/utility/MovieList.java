package utility;



import model.Movie;

import java.util.Arrays;

public class MovieList {


    private Movie[] Movies;
    int index = 0;
    public MovieList(){
        Movies =new Movie[]{};

    }

    public Movie[] getMovies() {
        return Movies;
    }

    public int getSumUnit(){
        int sum = 0;
        for (Movie item:Movies) {
        //    sum += item.getUnit();
        }
        return sum;
    }
    public boolean add(Movie element) {
        int length = Movies.length;
        Movies = Arrays.copyOf(Movies, length + 1);
        Movies[length] = element;
        return true;
    }
    public Movie get(int id){
        for (Movie item: Movies ) {
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return Movies.length == 0;
    }
    public int size(){
        return Movies.length;
    }


    public void clear()
    {
        Movies =new Movie[]{};
    }
//    public void edit(int id,String name,int unit){
//        get(id).setName(name);
//        get(id).setUnit(unit);
//    }
    public void add(int index, Movie element){
        int length = Movies.length;
        Movies = Arrays.copyOf(Movies, length + 1);
        for (int i = Movies.length - 1; i > index; i--) {
            Movies[i] = Movies[i - 1];
        }
        Movies[index] = element;
    }

    public void remove(int id)
    {
        for (int i = 0; i <Movies.length ; i++) {
            if(Movies[i].getId() == id){
                removeByIndex(i);
            }
        }
    }

    private  void removeByIndex(int index)
    {

        if(Movies.length > 0 && index <= Movies.length-1) {
            for (int arrayIndex = index; arrayIndex < Movies.length - 1; arrayIndex++) {
                Movies[arrayIndex] = Movies[arrayIndex + 1];
            }
            Movies = Arrays.copyOf(Movies, Movies.length - 1);
        }
    }

    public void addAll(Movie[] Movie){
        for (Movie item: Movie) {
            add(item);
        }
    }
//    public void showMovieComplete()
//    {
//        System.out.println("id    ||  Movie name  ||  unit ||  score  ||");
//        for (Movie Movie:Movies) {
//            System.out.println( Movie.getId()+ "\t\t\t"+ Movie.getName() +"\t\t\t\t"+    Movie.getUnit()+"\t\t\t"+   Movie.getScore());
//        }
//    }
    public void show(){
        System.out.println(" id  ||      Movie name      ||           Time");
        for (Movie Movie: Movies) {
            System.out.println(Movie);

        }
        System.out.println();
    }

    public boolean contains(Movie Movie)
    {


        for (Movie item: Movies) {
            if(item != null) {
                if (item.getId() == Movie.getId()) {

                   return true;
                }
            }
        }
        return false;
    }


//    @Override
//    public String toString() {
//        return "MyList "
//                + Arrays.toString(Movies)
//                ;
//    }

}
