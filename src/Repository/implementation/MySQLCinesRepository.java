package Repository.implementation;

import Models.Address;
import Models.Cine;
import Repository.CinesRepository;

import java.sql.*;
import java.util.ArrayList;

public class MySQLCinesRepository implements CinesRepository {
    private static MySQLCinesRepository instance;
    private final Connection conn;

    private MySQLCinesRepository() {
        conn = MySQLConnection.getInstance().connection;
    }

    public static MySQLCinesRepository getInstance() {
        if (instance == null) {
            instance = new MySQLCinesRepository();
        }
        return instance;
    }

    @Override
    public ArrayList<Cine> getAll() {
        String query = "SELECT * FROM cines;";
        ResultSet resultSet;
        Statement statement;
        ArrayList<Cine> cineArrayList = new ArrayList<>();
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Address address = new Address(resultSet.getString("street"), resultSet.getInt("number"), resultSet.getString("city"), resultSet.getString("uf"));
                cineArrayList.add(new Cine(resultSet.getString("name"), address));
            }
        } catch (SQLException e) {
            System.err.println("Error on list Cines!");
            e.printStackTrace();
        }
        return cineArrayList;
    }

    @Override
    public boolean delete(Cine cine) {
        return false;
    }

    @Override
    public boolean save(Cine cine) {
        String sql = "INSERT INTO cines (name, street, city, number, uf) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, cine.getName());
            preparedStatement.setString(2, cine.getAddress().getStreet());
            preparedStatement.setString(3, cine.getAddress().getCity());
            preparedStatement.setInt(4, cine.getAddress().getNumber());
            preparedStatement.setString(5, cine.getAddress().getState());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
