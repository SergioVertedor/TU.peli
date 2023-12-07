package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.*;

/**
 * Controler de la vista "PantallaLogin"
 * 
 * @author SVB
 * @author EPP
 *
 */
public class PantallaLoginController {

  @FXML private Button btnLoginEnter;

  @FXML private Button btnLoginRegister;

  @FXML private CheckBox cbLoginRememberMe;

  @FXML private ImageView imgLoginLogo;

  @FXML private PasswordField txtLoginPassword;

  @FXML private TextField txtLoginUser;

  /**
   * Método que se ejecuta cuando se presiona el botón de "Iniciar Sesión".
   * Valida la entrada del usuario y la contraseña utilizando LoginValidator e InputValidator.
   *
   * @param event Evento de acción generado por el usuario
   */
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

  /**
   * Método que se ejecuta cuando se presiona el botón de "Registrarse".
   * Redirige a la pantalla de registro utilizando SceneSwitch.
   *
   * @param event Evento de acción generado por el usuario
   */
  @FXML
  void btnLoginRegisterPressed(ActionEvent event) {
    SceneSwitcher sceneSwitcher = new SceneSwitcher();
    try {
      sceneSwitcher.switchScene("PantallaRegistro");
    } catch (IOException e) {
      System.err.println("Error al cargar la ventana de registro");
    }
  }

  /**
   * Método que se ejecuta cuando se selecciona o deselecciona la casilla de "Recordar usuario".
   * Almacena la preferencia del usuario utilizando PropertiesManager.
   *
   * @param event Evento de acción generado por el usuario
   */
  @FXML
  void cbRememberMeSelected(ActionEvent event) {
    if (cbLoginRememberMe.isSelected()) {
      PropertiesManager.setRemember("1");
    } else {
      PropertiesManager.setRemember("0");
    }
  }

  /**
   * Método de inicialización que se ejecuta cuando se carga la interfaz gráfica
   */
  @FXML
  void initialize() {
    imgLoginLogo.setImage(new Image("images/logo/logo.png"));
  }
}
