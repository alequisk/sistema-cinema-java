package Controller;

import Models.Cine;
import Models.Movie;
import Models.Session;
import Repository.SessionsRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SessionController {
    private final SessionsRepository sessionsRepository;

    public SessionController(SessionsRepository sessionsRepository) {
        this.sessionsRepository = sessionsRepository;
    }

    public ArrayList<Session> getAll() {
        return sessionsRepository.getAll();
    }

    public boolean create(Movie movie, Cine cine, LocalDateTime release, Integer seatsQuantity) {
        Session session = new Session(movie, cine, release, seatsQuantity);
        return sessionsRepository.create(session);
    }
}
