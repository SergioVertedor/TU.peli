package utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.AppUser;

/**
 * Clase que notifica al usuario de las notificaciones que se producen en el login
 * 
 * @author SVB
 * @author EPP
 * 
 */
public class DialogNotificator {

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
    Image logo = new Image("./images/logo/logo.png"); // Cambia "ruta/del/archivo/logo.png" a la ruta de tu archivo de imagen
    ImageView imageView = new ImageView(logo);
    imageView.setFitWidth(50); // Ajusta el ancho de la imagen según lo necesites
    imageView.setFitHeight(50); // Ajusta la altura de la imagen según lo necesites

    // Establecer el logo como gráfico en el diálogo
    alert.setGraphic(imageView);

    alert.showAndWait();
  }

  /** Notifica al usuario que el login ha sido incorrecto */
  public void notifyLoginError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(null);
    alert.setHeaderText("Login incorrecto");
    alert.setContentText("Usuario o contraseña incorrectos");
    Image logo = new Image("./images/logo/logo.png"); // Cambia "ruta/del/archivo/logo.png" a la ruta de tu archivo de imagen
    ImageView imageView = new ImageView(logo);
    imageView.setFitWidth(50); // Ajusta el ancho de la imagen según lo necesites
    imageView.setFitHeight(50); // Ajusta la altura de la imagen según lo necesites

    // Establecer el logo como gráfico en el diálogo
    alert.setGraphic(imageView);

    alert.showAndWait();
  }


  public void databaseConnectionError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(null);
    alert.setHeaderText("Error de conexión");
    alert.setContentText("Error al conectar con la base de datos");
    Image logo = new Image("./images/logo/logo.png"); // Cambia "ruta/del/archivo/logo.png" a la ruta de tu archivo de imagen
    ImageView imageView = new ImageView(logo);
    imageView.setFitWidth(50); // Ajusta el ancho de la imagen según lo necesites
    imageView.setFitHeight(50); // Ajusta la altura de la imagen según lo necesites

    // Establecer el logo como gráfico en el diálogo
    alert.setGraphic(imageView);

    alert.showAndWait();
  }

  /** Notifica al usuario que hay campos vacios */
  public void notifyEmptyFields() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(null);
    alert.setHeaderText("Campos vacios");
    alert.setContentText("Por favor, rellene todos los campos");
    Image logo = new Image("./images/logo/logo.png"); // Cambia "ruta/del/archivo/logo.png" a la ruta de tu archivo de imagen
    ImageView imageView = new ImageView(logo);
    imageView.setFitWidth(50); // Ajusta el ancho de la imagen según lo necesites
    imageView.setFitHeight(50); // Ajusta la altura de la imagen según lo necesites

    // Establecer el logo como gráfico en el diálogo
    alert.setGraphic(imageView);

    alert.showAndWait();
  }

  /** Notifica al usuario que se ha producido un error en tiempo de ejecución */
  public void notifyRuntimeException() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Exception Dialog");
    alert.setHeaderText("Look, an Exception Dialog");
    alert.setContentText("Error en tiempo de ejecución!");

    Exception ex = new RuntimeException("Error en tiempo de ejecución!");

    // Crear un contenido expansible para mostrar la traza de la excepción
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    ex.printStackTrace(pw);
    String exceptionText = sw.toString();

    Label label = new Label("The exception stacktrace was:");

    TextArea textArea = new TextArea(exceptionText);
    textArea.setEditable(false);
    textArea.setWrapText(true);

    textArea.setMaxWidth(Double.MAX_VALUE);
    textArea.setMaxHeight(Double.MAX_VALUE);
    GridPane.setVgrow(textArea, Priority.ALWAYS);
    GridPane.setHgrow(textArea, Priority.ALWAYS);

    GridPane expContent = new GridPane();
    expContent.setMaxWidth(Double.MAX_VALUE);
    expContent.add(label, 0, 0);
    expContent.add(textArea, 0, 1);

    // Establece el contenido expansible en un cuadro de diálogo
    alert.getDialogPane().setExpandableContent(expContent);
    Image logo = new Image("./images/logo/logo.png"); // Cambia "ruta/del/archivo/logo.png" a la ruta de tu archivo de imagen
    ImageView imageView = new ImageView(logo);
    imageView.setFitWidth(50); // Ajusta el ancho de la imagen según lo necesites
    imageView.setFitHeight(50); // Ajusta la altura de la imagen según lo necesites

    // Establecer el logo como gráfico en el diálogo
    alert.setGraphic(imageView);

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
    Image logo = new Image("./images/logo/logo.png"); // Cambia "ruta/del/archivo/logo.png" a la ruta de tu archivo de imagen
    ImageView imageView = new ImageView(logo);
    imageView.setFitWidth(50); // Ajusta el ancho de la imagen según lo necesites
    imageView.setFitHeight(50); // Ajusta la altura de la imagen según lo necesites

    // Establecer el logo como gráfico en el diálogo
    alert.setGraphic(imageView);

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
    Image logo = new Image("./images/logo/logo.png"); // Cambia "ruta/del/archivo/logo.png" a la ruta de tu archivo de imagen
    ImageView imageView = new ImageView(logo);
    imageView.setFitWidth(50); // Ajusta el ancho de la imagen según lo necesites
    imageView.setFitHeight(50); // Ajusta la altura de la imagen según lo necesites

    // Establecer el logo como gráfico en el diálogo
    alert.setGraphic(imageView);

    alert.showAndWait();
  }

  public void logoutNotification() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(null);
    alert.setHeaderText("Usuario deslogeado");
    alert.setContentText("Volviendo a la pantalla de inicio.");
    Image logo = new Image("./images/logo/logo.png"); // Cambia "ruta/del/archivo/logo.png" a la ruta de tu archivo de imagen
    ImageView imageView = new ImageView(logo);
    imageView.setFitWidth(50); // Ajusta el ancho de la imagen según lo necesites
    imageView.setFitHeight(50); // Ajusta la altura de la imagen según lo necesites

    // Establecer el logo como gráfico en el diálogo
    alert.setGraphic(imageView);

    alert.showAndWait();
  }
}
