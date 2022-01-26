package model;

import utility.MovieList;

public class Cinema extends NameEntity {

    private MovieList movieList;
    private int isActive;
    private double balance;

    public MovieList getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieList movieList) {
        this.movieList = movieList;
    }

    public Cinema(int id, String firstName, int isActive) {
        super(id, firstName);
        this.isActive = isActive;
    }

    public Cinema(int id, String firstName, String lastName, int isActive) {
        super(id, firstName, lastName);
        this.isActive = isActive;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return  " "+ getId() + "\t\t\t" + getFirstName() + "\t\t\t\t" + getIsActive() ;

    }

//     System.out.println(" id  ||  course name  ||  unit  || score ");
//        for (Course course:courseList.getCourses()) {
//        System.out.println(course.getId() + " \t\t\t" + course.getName() + "\t\t\t\t"+ course.getUnit()+"\t\t"+course.getScore() );
//    }
}
