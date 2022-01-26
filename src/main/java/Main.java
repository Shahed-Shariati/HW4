import database.CreateTable;
import utility.ApplicationRun;
import utility.Menu;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();

        ApplicationRun applicationRun = new ApplicationRun();
        applicationRun.runApplication();
    }
}
