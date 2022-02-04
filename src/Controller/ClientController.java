package Controller;

import Models.Client;
import Repository.ClientsRepository;

public class ClientController {
    //TODO: buyTicket
    //TODO: loadMyPurchases
    ClientsRepository clientsRepository;

    public ClientController(ClientsRepository clientsRepository) {

        this.clientsRepository = clientsRepository;
    }

    Client login(String login, String password) {
        Client client = clientsRepository.findOne(login);
        if (client == null || !client.getPassword().equals(password)) {
            return null;
        }
        return client;
    }

}
