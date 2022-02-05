package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeClientController {

    @FXML
    private Label userNameLabel;

    public void setUsername() {
        userNameLabel.setText(SessionUserController.user.getName());
    }

}
