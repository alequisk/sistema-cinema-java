import Controller.ScreenController;
import Repository.implementation.MySQLConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("View/LoginClient.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(Objects.requireNonNull(root));
        ScreenController.getInstance(scene);

        stage.setTitle("Sistema de gerenciamento de ingressos de cinema");
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        MySQLConnection.getInstance().close();
    }
}
