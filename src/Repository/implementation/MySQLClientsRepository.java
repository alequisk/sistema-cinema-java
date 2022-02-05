package Repository.implementation;

import Models.Client;
import Repository.ClientsRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class MySQLClientsRepository implements ClientsRepository {
    private static MySQLClientsRepository instance;
    private final Connection conn;

    private MySQLClientsRepository() {
        conn = MySQLConnection.getInstance().connection;
    }

    public static MySQLClientsRepository getInstance() {
        if (instance == null) {
            instance = new MySQLClientsRepository();
        }
        return instance;
    }

    @Override
    public ObservableList<Client> getAll() {
        ObservableList<Client> clientList = FXCollections.observableArrayList();
        String query = "SELECT * FROM clients;";
        Statement statement;
        ResultSet resultSet;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                clientList.add(new Client(resultSet.getString("name"), LocalDate.parse(resultSet.getString("birthday")), resultSet.getString("login"), resultSet.getString("password")));
            }
        } catch (SQLException e) {
            System.err.println("Error on List Clients!");
            e.printStackTrace();
        }
        return clientList;
    }

    @Override
    public boolean create(Client client) {
        String sql = "INSERT INTO clients(name, birthday, login, password) VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getBirthdayString());
            preparedStatement.setString(3, client.getLogin());
            preparedStatement.setString(4, client.getPassword());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error on Create Client!");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(String login) {
        String sql = "DELETE FROM clients WHERE login = ?;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Client findOne(String login) {
        String query = "SELECT * FROM clients WHERE login = ?;";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Client client = null;
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                client = new Client(resultSet.getString("name"), LocalDate.parse(resultSet.getString("birthday")), resultSet.getString("login"), resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
}
