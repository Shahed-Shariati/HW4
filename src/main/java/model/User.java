package model;

public class User extends NameEntity {

    private int roleId;
    private int isActive;
    public User()
    {}
    public User(int id,int roleId,String firstName,String lastName,int isActive ) {
        super(id,firstName,lastName);
        this.roleId = roleId;
        this.isActive = isActive;
    }
    public User(int roleId,String firstName,int isActive){

    }
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
