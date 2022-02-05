package Repository.implementation;

import Models.Admin;
import Repository.AdminsRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class MySQLAdminsRepository implements AdminsRepository {
    private static MySQLAdminsRepository instance;
    private final Connection conn;

    private MySQLAdminsRepository() {
        conn = MySQLConnection.getInstance().connection;
    }

    public static MySQLAdminsRepository getInstance() {
        if (instance == null) {
            instance = new MySQLAdminsRepository();
        }
        return instance;
    }

    @Override
    public ObservableList<Admin> getAll() {
        ObservableList<Admin> clientList = FXCollections.observableArrayList();
        String query = "SELECT * FROM admins;";
        Statement statement;
        ResultSet resultSet;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                clientList.add(new Admin(resultSet.getString("name"), LocalDate.parse(resultSet.getString("birthday")), resultSet.getString("login"), resultSet.getString("password")));
            }
        } catch (SQLException e) {
            System.err.println("Error on List Admins!");
            e.printStackTrace();
        }
        return clientList;
    }

    @Override
    public boolean create(Admin admin) {
        String sql = "INSERT INTO admins(name, birthday, login, password) VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getBirthdayString());
            preparedStatement.setString(3, admin.getLogin());
            preparedStatement.setString(4, admin.getPassword());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error on Create Admin!");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(String login) {
        String sql = "DELETE FROM admins WHERE login = ?;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error on Update Admin!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Admin findOne(String login) {
        String query = "SELECT * FROM admins WHERE login = ? LIMIT 1;";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Admin admin = null;
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                admin = new Admin(resultSet.getString("name"), LocalDate.parse(resultSet.getString("birthday")), resultSet.getString("login"), resultSet.getString("password"));
        } catch (SQLException e) {
            System.err.println("Error on find one Admin!");
            e.printStackTrace();
        }
        return admin;
    }
}
