package utility;



import model.CinemaMovie;

import java.util.Arrays;

public class CinemaMovieList {

    private static String dotted = "---------------------------------------------------------";
    private CinemaMovie[] cinemaMovies;
    int index = 0;
    public CinemaMovieList(){
        cinemaMovies =new CinemaMovie[]{};

    }

    public CinemaMovie[] getCinemaMovies() {
        return cinemaMovies;
    }

    public int getSumUnit(){
        int sum = 0;
        for (CinemaMovie item: cinemaMovies) {
        //   sum += item.getUnit();
        }
        return sum;
    }
    public boolean add(CinemaMovie element) {
        int length = cinemaMovies.length;
        cinemaMovies = Arrays.copyOf(cinemaMovies, length + 1);
        cinemaMovies[length] = element;
        return true;
    }
    public CinemaMovie get(int id){
        for (CinemaMovie item: cinemaMovies) {
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return cinemaMovies.length == 0;
    }
    public int size(){
        return cinemaMovies.length;
    }


    public void clear()
    {
        cinemaMovies =new CinemaMovie[]{};
    }
//    public void edit(int id,String name,int unit){
//        get(id).setName(name);
//        get(id).setUnit(unit);
//    }
    public void add(int index, CinemaMovie element){
        int length = cinemaMovies.length;
        cinemaMovies = Arrays.copyOf(cinemaMovies, length + 1);
        for (int i = cinemaMovies.length - 1; i > index; i--) {
            cinemaMovies[i] = cinemaMovies[i - 1];
        }
        cinemaMovies[index] = element;
    }

    public void remove(int id)
    {
        for (int i = 0; i < cinemaMovies.length ; i++) {
            if(cinemaMovies[i].getId() == id){
                removeByIndex(i);
            }
        }
    }

    private  void removeByIndex(int index)
    {

        if(cinemaMovies.length > 0 && index <= cinemaMovies.length-1) {
            for (int arrayIndex = index; arrayIndex < cinemaMovies.length - 1; arrayIndex++) {
                cinemaMovies[arrayIndex] = cinemaMovies[arrayIndex + 1];
            }
            cinemaMovies = Arrays.copyOf(cinemaMovies, cinemaMovies.length - 1);
        }
    }

    public void addAll(CinemaMovie[] CinemaMovie){
        for (CinemaMovie item: CinemaMovie) {
            add(item);
        }
    }
//    public void showCinemaMovieComplete()
//    {
//        System.out.println("id    ||  CinemaMovie name  ||  unit ||  score  ||");
//        for (CinemaMovie CinemaMovie:CinemaMovies) {
//            System.out.println( CinemaMovie.getId()+ "\t\t\t"+ CinemaMovie.getName() +"\t\t\t\t"+    CinemaMovie.getUnit()+"\t\t\t"+   CinemaMovie.getScore());
//        }
//    }
    public void showSearch()
    {
        System.out.println("id  ||   Cinema name   ||   Filme Name   ||      date      ||        time      ");
        for (CinemaMovie cin:cinemaMovies) {
            System.out.println(cin.getId() + "\t\t" +cin.getCinemaName() + "\t\t\t\t" + cin.getMovieName() + "\t\t\t" + cin.getDate() + "\t\t\t" + cin.getTime() + "\t\t\t" );
        }
    }
    public void show(){
        System.out.println("id  ||   Cinema name   ||   Filme Name   ||      date      ||        time      ||    Ticket ");

//        for (int i = 0; i <cinemaMovies.length ; i++) {
//            System.out.print(i+1 +"    ");
//            System.out.println(cinemaMovies[i]);
//        }

        for (CinemaMovie cin: cinemaMovies) {
            if(cin != null) {
                System.out.println(cin);
            }
        }
        System.out.println(dotted);
    }

    public boolean contains(CinemaMovie CinemaMovie)
    {


        for (CinemaMovie item: cinemaMovies) {
            if(item != null) {
                if (item.getId() == CinemaMovie.getId()) {

                   return true;
                }
            }
        }
        return false;
    }


//    @Override
//    public String toString() {
//        return "MyList "
//                + Arrays.toString(CinemaMovies)
//                ;
//    }

}
