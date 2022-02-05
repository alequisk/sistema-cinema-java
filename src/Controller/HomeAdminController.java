package Controller;

import Models.Address;
import Models.Cine;
import Repository.implementation.MySQLCinesRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HomeAdminController {
    private final Alert alert = new Alert(Alert.AlertType.NONE);
    private CineController cineController = null;

    @FXML
    private TextField cineCityTF;

    @FXML
    private TextField cineNameTF;

    @FXML
    private TextField cineNumberTF;

    @FXML
    private TextField cineStateTF;

    @FXML
    private TextField cineStreetTF;

    @FXML
    void handleCreateCine() {
        if (cineCityTF.getText().isBlank()
                || cineNameTF.getText().isBlank()
                || cineNumberTF.getText().isBlank()
                || cineStateTF.getText().isBlank()
                || cineStreetTF.getText().isBlank()) {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro ao adicionar cinema");
            alert.setHeaderText("Todos os campos sao obrigatorios");
            alert.show();
            return;
        }
        String city = cineCityTF.getText();
        String name = cineNameTF.getText();
        int number = Integer.parseInt(cineNumberTF.getText());
        String state = cineStateTF.getText();
        String street = cineStreetTF.getText();

        Address address = new Address(street, number, city, state);
        Cine cine = new Cine(name, address);

        if (cineController == null) {
            cineController = CineController.getInstance(MySQLCinesRepository.getInstance());
        }
        boolean isCreate = cineController.create(cine);
        if (isCreate) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            clearCineFields();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao adicionar cinema");
            alert.setHeaderText("O cinema não pode ser adicionado. Erro no sistema");
            alert.show();
        }
    }

    void clearCineFields() {
        cineCityTF.setText("");
        cineNameTF.setText("");
        cineNumberTF.setText("");
        cineStateTF.setText("");
        cineStreetTF.setText("");
    }
}
