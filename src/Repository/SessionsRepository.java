package Repository;

import Models.Cine;
import Models.Session;

import java.util.ArrayList;

public interface SessionsRepository {
    ArrayList<Session> getAll();

    boolean create(Session session);

    boolean delete(Session session);

    ArrayList<Session> findByMovie(String name);

    ArrayList<Session> findByCine(Cine cine);
}
