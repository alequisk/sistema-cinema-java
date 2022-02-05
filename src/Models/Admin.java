package Models;

import java.time.LocalDate;

public class Admin extends Person implements Comparable<Person> {
    public Admin(String name, LocalDate birthday, String login, String password) {
        super(name, birthday, login, password);
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
