package Controller;

import Models.Client;
import Repository.implementation.MySQLClientsRepository;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class RegisterClientController {
    private final Alert notify = new Alert(Alert.AlertType.NONE);

    public TextField nameTF;
    public TextField loginTF;
    public PasswordField passwordTF;
    public TextField dayTF;
    public TextField monthTF;
    public TextField yearTF;

    private void clearFields() {
        nameTF.setText("");
        loginTF.setText("");
        passwordTF.setText("");
        dayTF.setText("");
        monthTF.setText("");
        yearTF.setText("");
    }

    public void handleRegister() {
        if (nameTF.getText().isBlank() || loginTF.getText().isBlank() || passwordTF.getText().isBlank() || dayTF.getText().isBlank() ||
                monthTF.getText().isBlank() || yearTF.getText().isBlank()) {
            notify.setAlertType(Alert.AlertType.ERROR);
            notify.setTitle("Erro ao se registrar");
            notify.setHeaderText("Todos os campos são obrigatórios!");
            notify.show();
            return;
        }

        String name = nameTF.getText();
        String login = loginTF.getText();
        String password = passwordTF.getText();
        int day = Integer.parseInt(dayTF.getText());
        int month = Integer.parseInt(monthTF.getText());
        int year = Integer.parseInt(yearTF.getText());

        boolean isCreated = ClientController.getInstance(MySQLClientsRepository.getInstance()).create(new Client(name, LocalDate.of(year, month, day), login, password));

        if (!isCreated) {
            notify.setAlertType(Alert.AlertType.ERROR);
            notify.setHeaderText("O registro de novo usuário não pode ser concluído");
            notify.setTitle("Erro ao se registrar");
        } else {
            notify.setAlertType(Alert.AlertType.INFORMATION);
            notify.setHeaderText("Seu registro foi realizado com sucesso!");
            notify.setTitle("Novo registro");
            clearFields();
            ScreenController.getInstance(loginTF.getScene()).activate("cli:login");
        }
        notify.show();
    }

    public void handleCancel(ActionEvent actionEvent) {
        clearFields();
        ScreenController.getInstance(nameTF.getScene()).activate("cli:login");
    }
}
