package Models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Session implements Comparable<Session> {
    Movie movie;
    Cine cine;
    LocalDateTime release;
    ArrayList<Client> seats;

    public Session(Movie movie, Cine cine, LocalDateTime date, Integer seatsQuantity) {
        this.movie = movie;
        this.cine = cine;
        this.release = date;
        seats = new ArrayList<>();
        for (int i = 0; i < seatsQuantity; ++i) {
            seats.add(null);
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public Cine getCine() {
        return cine;
    }

    public LocalDateTime getRelease() {
        return release;
    }

    @Override
    public String toString() {
        return movie + ":" + cine;
    }

    @Override
    public int compareTo(Session session) {
        return this.release.compareTo(session.getRelease());
    }
}
