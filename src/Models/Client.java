package Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client extends Person implements Comparable<Person> {
    ArrayList<Ticket> purchases;

    public Client(String name, LocalDate birthday, String login, String password) {
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

    @Override
    public int compareTo(Person person) {
        return this.getName().compareTo(person.getName());
    }
}
