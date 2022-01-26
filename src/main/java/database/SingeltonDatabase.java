package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingeltonDatabase {
    private   Connection connection;
    private static SingeltonDatabase instance;
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String userName = "postgres";
    private static final String passWord = "123qweR";
    private static PreparedStatement preparedStatement;
    private SingeltonDatabase() {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,userName,passWord);
        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
    }

    public static SingeltonDatabase getInstance()
    {
        try {
            if(instance == null){
                return  instance = new SingeltonDatabase();
            }else if(instance.getConnection().isClosed()) {
                return instance = new SingeltonDatabase();
            }
        }catch (SQLException e){}
        return instance;
    }

    public  Connection getConnection() {
        return connection;
    }
}
