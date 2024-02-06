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

/**
 * Controller de la vista "PantallaLogin"
 *
 * @author SVB
 * @author EPP
 */
public class PantallaLoginController {

  @FXML private Button btnLoginEnter;

  @FXML private Button btnLoginRegister;

  @FXML private CheckBox cbLoginRememberMe;

  @FXML private ImageView imgLoginLogo;

  @FXML private PasswordField txtLoginPassword;

  @FXML private TextField txtLoginUser;

  /**
   * Método que se ejecuta cuando se presiona el botón de "Iniciar Sesión". Valida la entrada del
   * usuario y la contraseña utilizando LoginValidator e InputValidator.
   *
   * @param event Evento de acción generado por el usuario
   */
  @FXML
  void btnLoginEnterPressed(ActionEvent event) {
    var dialogNotificator = new DialogNotificator();
    String userOrMail = txtLoginUser.getText();
    String password = txtLoginPassword.getText();
    if (userOrMail.isEmpty() || password.isEmpty()) {
      dialogNotificator.notifyEmptyFields();
      return;
    }
    LoginValidator loginValidator = new LoginValidator();
    InputValidator inputValidator = new InputValidator();
    if (inputValidator.isEmailValid(userOrMail) || inputValidator.isUserValid(userOrMail)) {
      if (loginValidator.validateLogin(userOrMail, password)) {
        dialogNotificator.notifyLogin(txtLoginUser.getText());
        var sceneSwitcher = new SceneSwitcher();
          try {
              sceneSwitcher.switchScene("PantallaModelo");
          } catch (IOException e) {
            System.err.println("Error al cargar la ventana de inicio");
          }
      } else {
        dialogNotificator.notifyLoginError();
        txtLoginPassword.clear();
      }
    }
  }

  /**
   * Método que se ejecuta cuando se presiona el botón de "Registrarse". Redirige a la pantalla de
   * registro utilizando SceneSwitch.
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
      PropertiesManager.setRememberLogin("1");
    } else {
      PropertiesManager.setRememberLogin("0");
    }
  }

  /** Método de inicialización que se ejecuta cuando se carga la interfaz gráfica */
  @FXML
  void initialize() {
    imgLoginLogo.setImage(new Image("images/logo/logo.png"));
  }
}
