package edu.unl.raikes.gigscheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection factory to connect between SQL and Java.
 *
 */
public class ConnectionFactory {
    private static String connectionString = "jdbc:mysql://20.55.108.210/rseal2_gigs?useSSL=false&serverTimezone=UTC";
    private static String username = "rseal2";
    private static String password = "huskers";

    /**
     * Getting a connection.
     * 
     * @return connection.
     * @throws SQLException is an exception in case it doesn't work.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);
    }
}
