package model;

public class CinemaMovie {
    private int id;
    private String cinemaName;
    private String movieName;
    private String date;
    private String time;
    private int count;
    private int sell;
    private int remind;

    public CinemaMovie(int id, String cinemaName, String movieName, String date, String time) {
        this.id = id;
        this.cinemaName = cinemaName;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
    }

    public CinemaMovie(int id, String cinemaName, String movieName, String date, String time, int remind) {
        this.id = id;
        this.cinemaName = cinemaName;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.remind = remind;
    }


    public CinemaMovie(String cinemaName, String movieName, String date, String time, int remind) {
        this.cinemaName = cinemaName;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.remind = remind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return  id + "\t\t" + cinemaName + "\t\t\t\t" + movieName + "\t\t\t" + date + "\t\t\t" + time + "\t\t\t" + remind;
    }
}