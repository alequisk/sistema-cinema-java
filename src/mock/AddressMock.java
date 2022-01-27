package mock;

import Models.Address;

import java.util.ArrayList;
import java.util.Random;

public class AddressMock {
    private final ArrayList<Address> address;

    public AddressMock() {
        address = new ArrayList<>();
        address.add(new Address("Barros dos Santos", 1435, "Canindé", "Ceará"));
        address.add(new Address("Rua Coronel Segundo", 310, "Crato", "Ceará"));
        address.add(new Address("Rua 749", 53, "Fortaleza", "Ceará"));
        address.add(new Address("Rua Maria de Lourdes Moraes", 313, "Crato", "Ceará"));
        address.add(new Address("Vila Henrique Gabriel", 11, "Fortaleza", "Ceará"));
        address.add(new Address("Avenida Independência", 35, "Fortaleza", "Ceará"));
        address.add(new Address("Rua de Pedestre E19", 165, "Caucaia", "Ceará"));
        address.add(new Address("Avenida Sapucaia Condomínio 4 Bloco 4", 74, "Fortaleza", "Ceará"));
        address.add(new Address("Rua Miguel Bispo", 330, "Amaniutuba", "Ceará"));
        address.add(new Address("Vila São Luiz", 51, "Fortaleza", "Ceará"));
        address.add(new Address("Rua Rosita Silva Araújo", 73, "Fortaleza", "Ceará"));
    }

    public Address generate() {
        return address.get(new Random().nextInt(address.size()));
    }
}
