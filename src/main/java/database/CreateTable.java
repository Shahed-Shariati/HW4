package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
   private Connection connection;
   private PreparedStatement preparedStatement;
    public CreateTable() {
        this.connection = ConnectionDatabase.getConnection();
        createTableRole();

        createTableUser();
        createTableMovie();
        createTableCinemaMovie();
        createTableTicket();
     //  insertIntoRole();
      // insertIntoUser();
    }


    private void insertIntoUser()
    {
        String query = "insert into users( role_id, first_name, last_name, user_name, password,isactive) values (1,'admin','admin','admin','admin',1);";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("userinsert");
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    private void insertIntoRole()
    {
        String insertQuery = "insert into role(role_name) values ('admin'),('user'),('cinema');";
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            System.out.println(e);
        }
    }
    private void createTableCinemaMovie()
    {
        String createTableCinemaMovieQuery = "create table if not exists cinemamovie(\n" +
                "    id serial primary key ,\n" +
                "    cinema_id int not null ,\n" +
                "    movie_id int not null ,\n" +
                "    date date,\n" +
                "    time time,\n" +
                "    count int,\n" +
                "sell int \n," +
                "    foreign key (cinema_id) references users(id),\n" +
                "    foreign key (movie_id) references movie(id)\n" +
                "\n" +
                ");";
        try{
            preparedStatement = connection.prepareStatement(createTableCinemaMovieQuery);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    private void createTableTicket()
    {
        String createTableTicketQuery = "create table if not exists ticket(\n" +
                "    id serial primary key ,\n" +
                "    cinemamovie_id int not null,\n" +
                "    foreign key (cinemamovie_id) references cinemamovie(id)\n" +
                "\n" +
                ");";
        try
        {
            preparedStatement = connection.prepareStatement(createTableTicketQuery);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            System.out.println(e);
        }
    }
    private void createTableMovie()
    {
        String createTableMovieQuery = "create table if not exists movie(\n" +
                "    id serial primary key ,\n" +
                "    name varchar(100) unique,\n" +
                "    time int,\n" +
                "    type varchar(100),\n" +
                "    description varchar(800)\n" +
                ");";
        try {
            preparedStatement = connection.prepareStatement(createTableMovieQuery);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            System.out.println(e);
        }
    }
    private void createTableUser(){
        String createTableUserQuery ="CREATE TABLE IF NOT EXISTS users(\n" +
                "    id SERIAL primary key ,\n" +
                "    role_id INTEGER ,\n" +
                "    first_name VARCHAR(100),\n" +
                "    last_name VARCHAR (100),\n" +
                "    user_name VARCHAR (100),\n" +
                "    password VARCHAR (100),\n" +
                "    isActive int,\n"+
                "    FOREIGN KEY (role_id) REFERENCES role(id)\n" +
                ");";
        try {
            preparedStatement = connection.prepareStatement(createTableUserQuery);
            preparedStatement.execute();
            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void createTableRole(){
        String createTableRoleQuery = "CREATE TABLE IF NOT EXISTS role(\n" +
                "    id SERIAL PRIMARY KEY ,\n" +
                "    role_name VARCHAR (50)\n" +
                ");";
        try {
            preparedStatement = connection.prepareStatement(createTableRoleQuery);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            System.out.println(e);
        }

    }
}
