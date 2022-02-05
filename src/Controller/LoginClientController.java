package Controller;

import Repository.implementation.MySQLClientsRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LoginClientController {
    private ClientController clientController = null;
    public PasswordField passwordTF;
    public TextField loginTF;


    public void handleRegister(MouseEvent mouseEvent) {
        ScreenController.getInstance(loginTF.getScene()).activate("cli:register");
    }

    public void handleLogin(ActionEvent actionEvent) throws IOException {
        if (clientController == null) {
            clientController = ClientController.getInstance(MySQLClientsRepository.getInstance());
        }
        String login = loginTF.getText();
        String password = passwordTF.getText();
        boolean loggedIn = clientController.login(login, password);

        if (!loggedIn) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Login e/ou senha incorretas!");
            alert.setTitle("Ocorreu um erro ao tentar se logar");
            alert.show();
            clearFields();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/HomeClient.fxml"));
            Parent homePage = loader.load();
            HomeClientController controller = loader.getController();
            controller.setUsername();
            Scene scene = loginTF.getScene();
            scene.setRoot(homePage);
            clearFields();
        }
    }

    private void clearFields() {
        loginTF.setText("");
        passwordTF.setText("");
    }

    public void handleAdminLogin() {
        clearFields();
        ScreenController.getInstance(loginTF.getScene()).activate("adm:login");
    }
}
