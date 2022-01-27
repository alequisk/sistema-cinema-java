package Repository.implementation;

import Models.Cine;
import Models.Session;
import Repository.SessionsRepository;

import java.util.ArrayList;

public class LocalSessionsRepository implements SessionsRepository {
    ArrayList<Session> sessions = new ArrayList<>();

    @Override
    public ArrayList<Session> getAll() {
        return sessions;
    }

    @Override
    public boolean create(Session session) {
        sessions.add(session);
        return true;
    }

    @Override
    public boolean delete(Session session) {
        return sessions.remove(session);
    }

    @Override
    public ArrayList<Session> findByMovie(String name) {
        ArrayList<Session> filteredSessions = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getMovie().getName().equals(name)) {
                filteredSessions.add(session);
            }
        }
        return filteredSessions;
    }

    @Override
    public ArrayList<Session> findByCine(Cine cine) {
        ArrayList<Session> filteredSession = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getCine().equals(cine)) {
                filteredSession.add(session);
            }
        }
        return filteredSession;
    }
}
