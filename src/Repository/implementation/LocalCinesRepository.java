package Repository.implementation;

import Models.Cine;
import Repository.CinesRepository;

import java.util.ArrayList;

public class LocalCinesRepository implements CinesRepository {
    private final ArrayList<Cine> cines;

    public LocalCinesRepository() {
        cines = new ArrayList<>();
    }

    @Override
    public ArrayList<Cine> getAll() {
        return cines;
    }

    @Override
    public boolean delete(Cine cine) {
        return cines.remove(cine);
    }

    @Override
    public boolean save(Cine cine) {
        return cines.add(cine);
    }
}
