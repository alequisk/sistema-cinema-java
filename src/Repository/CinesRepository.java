package Repository;

import Models.Cine;

import java.util.ArrayList;

public interface CinesRepository {
    ArrayList<Cine> getAll();

    boolean delete(Cine cine);

    boolean save(Cine cine);
}
