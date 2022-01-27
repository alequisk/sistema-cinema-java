package Controller;

import Models.Cine;
import Models.Session;
import Repository.CinesRepository;
import Repository.SessionsRepository;

import java.util.ArrayList;

public class CineController {
    private final CinesRepository cinesRepository;
    private final SessionsRepository sessionsRepository;

    public CineController(CinesRepository cinesRepository, SessionsRepository sessionsRepository) {
        this.cinesRepository = cinesRepository;
        this.sessionsRepository = sessionsRepository;
    }

    public ArrayList<Cine> getAll() {
        return cinesRepository.getAll();
    }
    public boolean create(Cine cine) {
        return cinesRepository.save(cine);
    }
    public boolean remove(Cine cine) {
        return cinesRepository.delete(cine);
    }

    public ArrayList<Session> sessionsOf(Cine cine) {
        return sessionsRepository.findByCine(cine);
    }

}
