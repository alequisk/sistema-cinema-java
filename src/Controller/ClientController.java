package Controller;

import Models.Client;
import Repository.ClientsRepository;

public class ClientController {
    //TODO: buyTicket
    //TODO: loadMyPurchases
    private static ClientController instance;
    private final ClientsRepository clientsRepository;

    private ClientController(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public static ClientController getInstance(ClientsRepository clientsRepository) {
        if (instance == null) {
            instance = new ClientController(clientsRepository);
        }
        return instance;
    }

    public boolean login(String login, String password) {
        Client client = clientsRepository.findOne(login);
        if (client == null || !client.getPassword().equals(password)) {
            return false;
        }
        SessionUserController.user = client;
        SessionUserController.isAdmin = false;
        return true;
    }

    public boolean create(Client client) {
        return clientsRepository.create(client);
    }


//    public ArrayList<Ticket> getAll(String login) {
//        return clientsRepository.getAll();
//    }

}
