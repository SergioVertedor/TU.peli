package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import model.Storage;
import model.connector.HibernateUtils;
import model.dao.AppUserImpl;
import utils.*;
import utils.SessionHandler;

/**
 * Controlador de la vista de usuario

 */
public class PaneUsuarioController {

  // VBox dispositivos
  @FXML private VBox vBoxDispositivos;
  // HBox dispositivos
  @FXML private HBox hBoxDispositivo1;
  @FXML private Label lblDispositivo1;
  @FXML private ImageView imgDispositivo1;
  @FXML private ImageView imgDeleteDisp1;
  // Nombre e imagen de perfil del usuario
  @FXML private Label lblUsername;
  @FXML private ImageView imgUser;
  // Otros Datos cabecera
  @FXML private Label lblMiembroDesde;
  @FXML private Label lblNumeroDeTitulosGuardados;
  @FXML private Label lblUltimaConexion;
  // Importar y Exportar (funcionan como botones)
  @FXML private Button lblExportar;
  @FXML private Button lblImportar;
  // Campos para modificar los datos del usuario
  @FXML private TextField txtEmail;
  @FXML private PasswordField txtPass;
  @FXML private PasswordField txtPass2;
  @FXML private TextField txtUsername;
  // Lista de dispositivos HBox
  List<HBox> hBoxListDispositivos = new ArrayList<>();
  // Observable list
  private ObservableList<HBox> obsListDispositivos;
  // Botones
  @FXML private Button btnAddDispositivo;
  @FXML private Button btnGuardar;
  // Contador de dispositivos
  int contador = 0;

  /**
   * Evento que elimina el HBox del dispositivo seleccionado al hacer click en la imagen de la
   * papelera
   */
  private final EventHandler<MouseEvent> removeHandler =
      event -> {
        Node source = (Node) event.getSource();
        HBox hboxToRemove = (HBox) source.getParent();
        vBoxDispositivos.getChildren().remove(hboxToRemove);
      };

  /**
   * Añade un nuevo dispositivo (HBox) al listado con el nombre dado
   *
   * @param event
   */
  @FXML
  void btnAddDispositivoPressed(ActionEvent event) {
    String nombreDispositivo = showTextDialog();
    AtomicBoolean existe = new AtomicBoolean(false);
    SessionHandler.getAppUser()
        .getStorages()
        .forEach(
            storage -> {
              if (storage.getStorageName().equals(nombreDispositivo)) {
                existe.set(true);
              }
            });
    if (!existe.get()) {
      if (!nombreDispositivo.isEmpty()) {
        deviceManager(nombreDispositivo);
        AppUserImpl appUserImpl = new AppUserImpl(HibernateUtils.getSession());
        Storage storage = new Storage(nombreDispositivo, SessionHandler.getAppUser());
        SessionHandler.getAppUser().getStorages().add(storage);
        appUserImpl.update(SessionHandler.getAppUser());
      }
    } else {
      DialogNotificator dialogNotificator = new DialogNotificator();
      dialogNotificator.deviceExistsNotification();
    }
  }

  /**
   * Añade un nuevo dispositivo (HBox) al listado con el nombre dado
   *
   * @param nombreDispositivo
   */
  private void deviceManager(String nombreDispositivo) {
    HBox newHBox = new HBox(10);
    newHBox.setPrefHeight(25);
    Label nombre = new Label(nombreDispositivo);
    nombre.setPrefWidth(190);
    ImageView image = new ImageView();
    image.setImage(new Image("images/others/pcIcon.png"));
    ImageView imgRemove = new ImageView();
    imgRemove.setImage(new Image("images/others/remove.png"));
    imgRemove.setOnMouseClicked(removeHandler);
    nombre.setTextFill(Color.WHITE);
    image.setFitWidth(20);
    image.setFitHeight(20);
    imgRemove.setFitWidth(20);
    imgRemove.setFitHeight(20);
    newHBox.getChildren().addAll(image, nombre, imgRemove);
    hBoxListDispositivos.add(newHBox);
    obsListDispositivos.add(newHBox);
    vBoxDispositivos.getChildren().addAll(newHBox);
  }

  /**
   * Muestra un dialogo con textField para rescatar el nombre del nuevo dispositivo
   *
   * @return
   */
  String showTextDialog() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Nuevo Dispositivo");
    dialog.setHeaderText("");
    dialog.setContentText("Nombre del dispositivo:");
    dialog.initStyle(StageStyle.UNDECORATED);
    Optional<String> respuesta = dialog.showAndWait();
    return respuesta.orElse("");
  }

  /**
   * Guarda/Modifica la información del usuario
   *
   * @param event
   */
  @FXML
  void btnGuardarPressed(ActionEvent event) {
    DialogNotificator dialogNotificator = new DialogNotificator();
    LoginValidator loginValidator = new LoginValidator();
    InputValidator inputValidator = new InputValidator();

    String nombreUsuario = "";
    String email = "";
    String pw = "";
    String pwRepeat = "";

    boolean isValid = true;
    if (inputValidator.isUserValid(txtUsername.getText())) {
      nombreUsuario = txtUsername.getText();
    } else {
      dialogNotificator.usernameUpdateErrorNotification();
      isValid = false;
    }
    if (inputValidator.isEmailValid(txtEmail.getText())) {
      email = txtEmail.getText();
    } else {
      dialogNotificator.emailUpdateErrorNotification();
      isValid = false;
    }
    if (inputValidator.isPasswordValid(txtPass.getText())) {
      pw = txtPass.getText();
    } else {
      dialogNotificator.passwordUpdateErrorNotification();
      isValid = false;
    }
    if (inputValidator.isPasswordValid(txtPass2.getText())) {
      pwRepeat = txtPass2.getText();
      if (!pw.equals(pwRepeat)) {
        dialogNotificator.passwordCheckErrorNotification();
        isValid = false;
      }
    } else {
      isValid = false;
    }

    if (isValid) {
      SessionHandler.getAppUser().setUsername(nombreUsuario);
      SessionHandler.getAppUser().setMail(email);
      SessionHandler.getAppUser().setPassword(RSAUtils.cifra(pw));

      AppUserImpl appUserImpl = new AppUserImpl(HibernateUtils.getSession());
      appUserImpl.update(SessionHandler.getAppUser());
    }
  }

  /**
   * Exportar datos
   *
   * @param event
   */
  @FXML
  void exportarDatosPressed(ActionEvent event) {}

  /**
   * Importar datos
   *
   * @param event
   */
  @FXML
  void importarDatosPressed(ActionEvent event) {}

  @FXML
  void initialize() {
    Platform.runLater(
        () -> {
          fillComponents();
          fillUserData();
        });
  }

  /** Rellena los campos con los datos del usuario */
  private void fillUserData() {
    lblUsername.setText(SessionHandler.getAppUser().getUsername());
    txtUsername.setText(SessionHandler.getAppUser().getUsername());
    txtEmail.setText(SessionHandler.getAppUser().getMail());
    lblMiembroDesde.setText("Miembro desde: " + SessionHandler.getAppUser().getRegisterDate());
    int numWorks = 0;
    if (!Optional.ofNullable(SessionHandler.getAppUser().getStorages()).isEmpty()) {
      // TODO
    }
    lblNumeroDeTitulosGuardados.setText("En lista: " + numWorks + " títulos");
    lblUltimaConexion.setText("Última conexión: " + SessionHandler.getAppUser().getLastLogin());
    SessionHandler.getAppUser()
        .getStorages()
        .forEach(storage -> deviceManager(storage.getStorageName()));
  }

  /** Rellena los componentes con las imágenes y los datos necesarios */
  public void fillComponents() {
    imgUser.setImage(new Image("images/user.png"));
    hBoxListDispositivos = new ArrayList<>();
    obsListDispositivos = FXCollections.observableArrayList(hBoxListDispositivos);
  }
}
