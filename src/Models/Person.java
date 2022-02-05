package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    protected String name;
    private String login;
    private String password;
    private LocalDate birthday;

    public Person(String name, LocalDate birthday, String login, String password) {
        this.name = name;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayString() {
        return birthday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}