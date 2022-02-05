package Repository;

import Models.Client;
import javafx.collections.ObservableList;

public interface ClientsRepository {
    ObservableList<Client> getAll();

    boolean create(Client client);

    boolean delete(String login);

    Client findOne(String login);
}
