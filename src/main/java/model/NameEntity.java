package model;

public class NameEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String address;

    public NameEntity()
    {

    }

    public NameEntity(String firstName) {
        this.firstName = firstName;
    }

    public NameEntity(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public NameEntity(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
