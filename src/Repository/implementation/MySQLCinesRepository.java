package Repository.implementation;

import Models.Cine;
import Repository.CinesRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
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
