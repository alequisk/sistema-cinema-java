package Models;

import java.util.ArrayList;
import java.util.Date;

public class Client extends Person {
    ArrayList<Ticket> purchases;

    Client(String name, Date birthday, String login, String password) {
        super(name, birthday, login, password);
    }

    public ArrayList<Ticket> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Ticket> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
