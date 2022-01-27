package Repository;

import Models.Client;

import java.util.ArrayList;

public interface ClientsRepository {
    ArrayList<Client> getAll();

    boolean create(Client client);

    boolean delete(Client client);
}
