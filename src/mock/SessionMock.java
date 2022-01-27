package mock;

import Models.Session;

import java.time.LocalDateTime;

public class SessionMock {
    private int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public Session generate() {
        return new Session(new MovieMock().generate(), new CineMock().generate(), LocalDateTime.of(createRandomIntBetween(2000, 2022), createRandomIntBetween(1, 12), createRandomIntBetween(1, 28), createRandomIntBetween(1, 23), createRandomIntBetween(0, 59)), createRandomIntBetween(10, 30));
    }
}
