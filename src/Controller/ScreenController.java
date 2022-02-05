package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class ScreenController {
    private final HashMap<String, Pane> screenMap = new HashMap<>();
    private static ScreenController instance;
    private final Scene main;

    private ScreenController(Scene main) {
        this.main = main;
        try {
            addScreen("adm:login", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/LoginAdmin.fxml"))));
            addScreen("cli:login", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/LoginClient.fxml"))));
            addScreen("cli:home", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/HomeClient.fxml"))));
            addScreen("cli:register", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/RegisterClient.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ScreenController getInstance(Scene main) {
        if (instance == null) {
            instance = new ScreenController(main);
        }
        return instance;
    }

    protected void addScreen(String name, Pane pane) {
        screenMap.put(name, pane);
    }

    protected void activate(String name) {
        main.setRoot(screenMap.get(name));
    }
}
