package Repository.implementation;

import Models.Client;
import Repository.ClientsRepository;

import java.util.ArrayList;

public class LocalClientsRepository implements ClientsRepository {
    ArrayList<Client> clients;

    public LocalClientsRepository() {
        clients = new ArrayList<>();
    }

    @Override
    public ArrayList<Client> getAll() {
        return clients;
    }

    @Override
    public boolean create(Client client) {
        clients.add(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        clients.remove(client);
        return true;
    }

    @Override
    public Client findOne(String login) {
        for (Client client : clients) {
            if (client.getLogin().equals(login)) {
                return client;
            }
        }
        return null;
    }
}
