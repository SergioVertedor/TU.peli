package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.*;

public class PantallaLoginController {

  @FXML private Button btnLoginEnter;

  @FXML private Button btnLoginRegister;

  @FXML private CheckBox cbLoginRememberMe;

  @FXML private ImageView imgLoginLogo;

  @FXML private PasswordField txtLoginPassword;

  @FXML private TextField txtLoginUser;

  @FXML
  void btnLoginEnterPressed(ActionEvent event) {
    String userOrMail = txtLoginUser.getText();
    String password = txtLoginPassword.getText();
    LoginValidator loginValidator = new LoginValidator();
    InputValidator inputValidator = new InputValidator();
    if (inputValidator.isEmailValid(userOrMail) || inputValidator.isUserValid(userOrMail)) {
      loginValidator.validateLogin(userOrMail, password);
    }
  }

  @FXML
  void btnLoginRegisterPressed(ActionEvent event) {
    SceneSwitcher sceneSwitcher = new SceneSwitcher();
    try {
      sceneSwitcher.switchScene("PantallaRegistro");
    } catch (IOException e) {
      System.err.println("Error al cargar la ventana de registro");
    }
  }

  @FXML
  void cbRememberMeSelected(ActionEvent event) {
    if (cbLoginRememberMe.isSelected()) {
      PropertiesManager.setRemember("1");
    } else {
      PropertiesManager.setRemember("0");
    }
  }

  @FXML
  void initialize() {
   imgLoginLogo.setImage(new Image("images/logo/logo.png"));;
  }
}
