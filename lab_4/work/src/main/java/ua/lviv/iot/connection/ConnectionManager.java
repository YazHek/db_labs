package ua.lviv.iot.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL
            = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";

    private static final String USER = "Yazzhek";
    private static final String PASSWORD = "Yazhek5288";
    private static Connection connection = null;

    public static Connection getConnection(){

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }

        return connection;
    }

}
