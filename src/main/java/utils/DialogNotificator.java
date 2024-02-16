package utils;

import java.util.Objects;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AppUser;

/**
 * Clase que notifica al usuario de las notificaciones que se producen en el login
 *
 * @author SVB
 * @author EPP
 */
public class DialogNotificator {

  private static final String LOGO_PATH = "/images/logo/logo.png";

  /**
   * Notifica al usuario que el login ha sido correcto
   *
   * @param nombre Usuario que ha iniciado sesión correctamente
   */
  public void notifyLogin(String nombre) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(null);
    alert.setHeaderText("Login correcto");
    alert.setContentText("Bienvenido " + nombre);
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que el login ha sido incorrecto */
  public void notifyLoginError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(null);
    alert.setHeaderText("Login incorrecto");
    alert.setContentText("Usuario o contraseña incorrectos");
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que se ha producido un error durante la conexión con la base de datos */
  public void databaseConnectionError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(null);
    alert.setHeaderText("Error de conexión");
    alert.setContentText("Error al conectar con la base de datos");
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que hay campos vacios */
  public void notifyEmptyFields() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(null);
    alert.setHeaderText("Campos vacios");
    alert.setContentText("Por favor, rellene todos los campos");
    activateLogos(alert);
    alert.showAndWait();
  }

  /**
   * Notifica al usuario que se ha producido un error durante el proceso de registro
   *
   * @param errorMessages mensajes de error detallados
   * @param errorCount numero de errores
   */
  public void notifyRegisterError(String errorMessages, int errorCount) {
    if (errorCount == 1) {
      errorMessages = "Se ha producido " + errorCount + " error:" + errorMessages;
    } else {
      errorMessages = "Se han producido " + errorCount + " errores:" + errorMessages;
    }
    String headerError;
    if (errorCount == 1) {
      headerError = "Se ha producido " + errorCount + " error";
    } else {
      headerError = "Se han producido " + errorCount + " errores";
    }
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(null);
    alert.setHeaderText(headerError);
    // DialogPane dialogPane = alert.getDialogPane();
    Label content = new Label(errorMessages);
    VBox vbox = new VBox(content);
    // Vbox permite que el contenido se ajuste al tamaño del alert
    alert.getDialogPane().setContent(vbox);
    activateLogos(alert);
    alert.showAndWait();
  }

  /**
   * Notifica al usuario que el registro ha sido correcto
   *
   * @param usuario Usuario que se ha registrado
   */
  public void notifyRegister(AppUser usuario) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(null);
    alert.setHeaderText("Registro correcto");
    alert.setContentText("Registro completado para " + usuario.getUsername());
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que se ha producido un error durante el proceso de registro */
  public void logoutNotification() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(null);
    alert.setHeaderText("Usuario deslogeado");
    alert.setContentText("Volviendo a la pantalla de inicio.");
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que el usuario introducido no es válido */
  public void notifyInvalidUserOrMail() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(null);
    alert.setHeaderText("Usuario o email incorrectos");
    alert.setContentText("Por favor, introduzca un usuario y  email válidos");
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que el usuario introducido no es válido */
  private void activateLogos(Alert alert) {
    // LOGO ALERT
    ImageView imageView = new ImageView(new Image(LOGO_PATH));
    imageView.setFitWidth(50);
    imageView.setFitHeight(50);
    alert.setGraphic(imageView);
    // ICONO VENTANA
    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    stage
        .getIcons()
        .add(new Image(Objects.requireNonNull(this.getClass().getResource(LOGO_PATH)).toString()));
  }

  /** Notifica al usuario que se ha producido un error durante el proceso de búsqueda */
  public void searchErrorNotification() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(null);
    alert.setHeaderText("Búsqueda incorrecta");
    alert.setContentText("Por favor, introduzca un nombre válido");
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que el nombre de usuario introducido no es válido */
  public void usernameUpdateErrorNotification() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(null);
    alert.setHeaderText("Nombre de usuario incorrecto");
    alert.setContentText("Por favor, introduzca un nombre de usuario válido");
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que la contraseña introducida no es válida */
  public void passwordUpdateErrorNotification() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(null);
    alert.setHeaderText("Contraseña incorrecta");
    alert.setContentText(
        "Por favor, introduzca una contraseña válida. Debe contener al menos 8 caracteres, una mayúscula, una minúscula y un número");
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que la contraseña introducida no es válida */
  public void passwordCheckErrorNotification() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(null);
    alert.setHeaderText("Contraseña incorrecta");
    alert.setContentText("Las contraseñas no coinciden");
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que el email introducido no es válido */
  public void emailUpdateErrorNotification() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(null);
    alert.setHeaderText("Email incorrecto");
    alert.setContentText("Por favor, introduzca un email válido");
    activateLogos(alert);
    alert.showAndWait();
  }

  /** Notifica al usuario que el dispositivo ya existe */
  public void deviceExistsNotification() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(null);
    alert.setHeaderText("Dispositivo existente");
    alert.setContentText("El dispositivo ya existe");
    activateLogos(alert);
    alert.showAndWait();
  }
}
