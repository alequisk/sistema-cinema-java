package Models;

public class Ticket implements Comparable<Ticket> {
    Session session;
    Integer seat;

    Ticket(Session session, Integer seat) {
        this.session = session;
        this.seat = seat;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    @Override
    public int compareTo(Ticket o) {
        return 0;
    }
}
