package Repository;

import Models.Admin;
import javafx.collections.ObservableList;

public interface AdminsRepository {
    ObservableList<Admin> getAll();

    boolean create(Admin admin);

    boolean delete(String login);

    Admin findOne(String login);
}
