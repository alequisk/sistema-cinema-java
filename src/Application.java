import Controller.CineController;
import Repository.implementation.LocalCinesRepository;
import Repository.implementation.LocalSessionsRepository;
import mock.CineMock;

public class Application {
    public static void main(String[] args) {
        CineController cineController = new CineController(new LocalCinesRepository(), new LocalSessionsRepository());
        cineController.create(new CineMock().generate());
        cineController.create(new CineMock().generate());
        cineController.create(new CineMock().generate());
        System.out.println(cineController.getAll());
    }
}
