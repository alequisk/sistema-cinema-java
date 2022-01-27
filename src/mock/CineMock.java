package mock;

import Models.Cine;

import java.util.ArrayList;
import java.util.Random;

public class CineMock {
    private final ArrayList<String> cines;

    public CineMock() {
        cines = new ArrayList<>();
        cines.add("Cinépolis Rio Mar");
        cines.add("Cinemas Benfica");
        cines.add("Centerplex Via Sul");
        cines.add("UCI Kinoplex Iguatemi Fortaleza");
        cines.add("Cinépolis Jóquei Fortaleza");
        cines.add("Centerplex Messejana");
        cines.add("UCI Parangaba");
        cines.add("Cinema do Dragão");
        cines.add("Cinépolis RioMar Kennedy");
        cines.add("Kinoplex North Shopping");
        cines.add("Centerplex Messejana");
        cines.add("Centerplex Via Sul");
        cines.add("Cinema do Dragão");
        cines.add("Cinemas Benfica");
        cines.add("Cinépolis Jóquei Fortaleza");
        cines.add("Cinépolis Rio Mar");
        cines.add("Cinépolis RioMar Kennedy");
        cines.add("Kinoplex North Shopping");
        cines.add("UCI Kinoplex Iguatemi Fortaleza");
        cines.add("UCI Parangaba");
    }

    public Cine generate() {
        return new Cine(cines.get(new Random().nextInt(cines.size())), new AddressMock().generate());
    }
}
