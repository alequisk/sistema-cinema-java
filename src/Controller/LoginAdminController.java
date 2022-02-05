package Controller;

import Repository.implementation.MySQLAdminsRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginAdminController {
    private final Alert alert = new Alert(Alert.AlertType.NONE);
    private AdminController adminController = null;
    @FXML
    private TextField loginTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    void handleLogin() {
        if (adminController == null) {
            adminController = AdminController.getInstance(MySQLAdminsRepository.getInstance());
        }
        String login = loginTF.getText();
        String password = passwordTF.getText();

        if (login.isBlank() || password.isBlank()) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Todos os campos são obrigatórios");
            alert.setTitle("Erro ao tentar se logar");
        }
        boolean loggedIn = adminController.login(login, password);

        if (!loggedIn) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setHeaderText("Login e/ou senha incorretas!");
            alert.setTitle("Erro ao tentar se logar");
            alert.show();
            clearFields();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/HomeAdmin.fxml"));
            Parent homePage;
            try {
                homePage = loader.load();
                Scene scene = loginTF.getScene();
                scene.setRoot(homePage);
            } catch (IOException e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Erro do sistema");
                alert.setHeaderText("Ocorreu um erro incomum no sistema. Por favor, reinicie o programa para que funcione corretamente.");
                alert.show();
                e.printStackTrace();
            }
            clearFields();
        }
    }

    private void clearFields() {
        loginTF.setText("");
        passwordTF.setText("");
    }

    @FXML
    private void handleLoginClient(ActionEvent event) {
        ScreenController.getInstance(loginTF.getScene()).activate("cli:login");
        clearFields();
    }
}
