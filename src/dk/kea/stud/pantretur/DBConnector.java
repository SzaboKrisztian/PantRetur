package dk.kea.stud.pantretur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection = null;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String database = "Recycling";
    private static String host = "jdbc:mysql://localhost:3306/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static Connection connect(String username, String password) {
        System.out.println("--Connecting to the MySQL JDBC");

        try {
            connection = DriverManager.getConnection(host, username, password);
            System.out.println("--MySQL Connection established.");
        } catch (SQLException e) {
            System.out.println("--MySQL Connection failed.");
            e.printStackTrace();
        }

        return connection;
    }
}
