package model;

public class Movie extends NameEntity{

    private int time;
    private String type;
    private String description;

    public Movie(String firstName, int time, String type) {
        super(firstName);
        this.time = time;
        this.type = type;
    }

    public Movie(int id, String firstName, int hour, String type) {
        super(id, firstName);
        this.time = hour;
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return " "+ getId() + "\t\t\t" + getFirstName() + "\t\t\t\t\t\t" + getTime();
    }
}
