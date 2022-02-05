package Repository.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static MySQLConnection instance;
    public Connection connection;

    private MySQLConnection(String hostname, String database, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + hostname + "/" + database + "?user=" + username + "&password=" + password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error to connect MySQL!");
            e.printStackTrace();
        }
    }

    public static MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection("localhost:3306", "cine", "root", "mysql");
        }
        return instance;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error to close MySQL connection!");
            e.printStackTrace();
        }
    }

}
