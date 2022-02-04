package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginClientController {
    public PasswordField passwordTF;
    public TextField loginTF;

    public void handleRegister(MouseEvent mouseEvent) {
        System.out.println("Entered to register");
    }

    public void handleLogin(ActionEvent actionEvent) {
        System.out.println(loginTF.getText());
    }
}
