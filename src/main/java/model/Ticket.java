package model;

public class Ticket {
    private int id;
    private String userName;//customer
    private String movieName;
    private String date;
    private String time;
    private int count;
    private int sell;

    public Ticket(int id, String userName, String movieName, String date, String time) {
        this.id = id;
        this.userName = userName;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
    }

    public Ticket(int id, String userName, String movieName, String date, String time, int count, int sell) {
        this.id = id;
        this.userName = userName;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.count = count;
        this.sell = sell;
    }

    @Override
    public String toString() {
        return  id + "\t\t  " + userName + "\t\t\t\t" + movieName + "\t\t\t" + date + "\t\t\t" + time ;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
}
