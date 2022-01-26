package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    private static Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String userName = "postgres";
    private static final String passWord = "123qweR";

    public static Connection getConnection()  {
        try{
           Class.forName("org.postgresql.Driver");
            return connection = DriverManager.getConnection(url,userName,passWord);
        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
       return null;
    }
}
