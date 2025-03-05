package engg1420group2.universitymanagementsystem.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseConnection {

    public Connection databaselink;

    public Connection getDBConnection() {
        String url = "jdbc:sqlite:C:/Users/egank/IdeaProjects/StudentManagement/src/main/resources/data.sqlite";

        try {
            databaselink = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite database");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaselink;
    }


}
