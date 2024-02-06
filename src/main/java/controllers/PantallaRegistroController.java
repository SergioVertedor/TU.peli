package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.RegisterValidator;
import utils.SceneSwitcher;

/**
 * Controller de la vista "PantallaRegistro"
 * 
 * @author SVB
 * @author EPP
 *
 */
public class PantallaRegistroController {
	
	// Imagen logo TU.PELI
  @FXML private ImageView imgLogo;
  
  // TODO: Creo que estos no se está usando, no los ubico
  @FXML private Label lblNombre;
  @FXML private TextField txtName;
  
  // Campos usuario
  @FXML private Label lblUsuario;
  @FXML private Label lblEmail;
  @FXML  private TextField txtUserName;
  @FXML private TextField txtEmail;
  
  // Campos contraseña
  @FXML private Label lblPassword;
  @FXML private Label lblPasswordRepeat;
  @FXML  private PasswordField txtPassword;
  @FXML  private PasswordField txtPasswordRepeat;

  // Botones
  @FXML private Button btnLoginRegister;
  @FXML private Button btnVolver;

  /**
   * Método que se ejecuta cuando el usuario pulsa el botón de registro. Valida y procesa el
   * registro de un nuevo usuario utilizando RegisterValidator.
   *
   * @param event Evento de acción generado por el usuario
   */
  @FXML
  void btnRegisterNewUserPressed(ActionEvent event) {
    String username = txtUserName.getText();
    String password = txtPassword.getText();
    String passwordRepeat = txtPasswordRepeat.getText();
    String email = txtEmail.getText();
    RegisterValidator registerValidator = new RegisterValidator();
    if (registerValidator.doValidate(username, password, passwordRepeat, email)) {
      SceneSwitcher sceneSwitcher = new SceneSwitcher();
      try {
        sceneSwitcher.switchScene("PantallaLogin");
      } catch (IOException e) {
        System.err.println("Error al cargar la ventana de login");
      }
    }
  }

  /**
   * Método que vuelve a la pantalla principal.
   *
   * @param event Evento de acción generado por el usuario
   */
  @FXML
  void btnVolver(ActionEvent event) {
    SceneSwitcher sceneSwitcher = new SceneSwitcher();
    try {
      sceneSwitcher.switchScene("PantallaLogin");
    } catch (IOException e) {
      System.err.println("Error al cargar la ventana de login");
    }
  }

  /**
   * Método de inicialización que se ejecuta cuando se carga la interfaz gráfica.
   */
  @FXML
  void initialize() {
    imgLogo.setImage(new Image("images/logo/logo.png"));
  }

}
