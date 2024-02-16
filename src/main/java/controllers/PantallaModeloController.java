package controllers;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import lombok.Getter;
import utils.*;

/**
 * Controlador de la pantalla de inicio

 */
public class PantallaModeloController {
  @FXML private BorderPane borderPane;
  // Panel central de carga
  @FXML @Getter private Pane centralPane;
  // Otros paneles
  @FXML private Pane paneContent;
  @FXML private GridPane paneHeader;
  // Logo TU.PELI
  @FXML private ImageView imgLogo;
  // ImageView para la sección seleccionada
  @FXML private ImageView imgSection;
  // Nombre e imagen de perfil del usuario
  @FXML private ImageView imgUser;
  @FXML private Label lblUserName;
  // Elementos de búsqueda
  @FXML private TextField txtBusqueda;
  @FXML private ImageView btnBuscar;
  @FXML private ToggleGroup toggle;
  @FXML private RadioButton rbPeliculas;
  @FXML private RadioButton rbSeries;
  // Cerrar sesión
  @FXML private ImageView imgClose;
  @FXML private Label lblCerrarSesion;
  // Secciones barra menú
  @FXML private Label lblInicio;
  @FXML private Label lblPeliculas;
  @FXML private Label lblSeries;
  @FXML private Label lblTopPeliculas;
  @FXML private Label lblTopSeries;
  @FXML private Label lblCartelera;
  @FXML private Label lblProximamente;
  @FXML private Label lblMisListas;

  /**
   * Cambia el panel central de la aplicación por el panel de inicio
   *
   * @param event
   */
  @FXML
  void buscadorOnKeyPressed(KeyEvent event) {
    if (event.getCode().equals(KeyCode.ENTER)
        || event.getCharacter().getBytes()[0] == '\n'
        || event.getCharacter().getBytes()[0] == '\r') {
      String type;
      if (rbPeliculas.isSelected()) {
        type = "ms";
      } else {
        type = "ts";
      }
      InputValidator iv = new InputValidator();
      if (!iv.isNameValid(txtBusqueda.getText())) {
        DialogNotificator dn = new DialogNotificator();
        dn.searchErrorNotification();
        return;
      }
      PaneSwitcher.switchResultPane("PaneBusqueda", centralPane, type, txtBusqueda.getText());
    }
  }

  /**
   * Genera una búsqueda con el texto insertado en txtBusqueda
   *
   * @param event
   */
  @FXML
  void btnBuscarPressed(MouseEvent event) {
    String type;
    if (rbPeliculas.isSelected()) {
      type = "ms";
    } else {
      type = "ts";
    }
    InputValidator iv = new InputValidator();
    if (!iv.isNameValid(txtBusqueda.getText())) {
      DialogNotificator dn = new DialogNotificator();
      dn.searchErrorNotification();
      return;
    }
    PaneSwitcher.switchResultPane("PaneBusqueda", centralPane, type, txtBusqueda.getText());
  }

  /**
   * Cierra la sesión para el usuario activo
   *
   * @param event
   */
  @FXML
  void cerrarSesionPressed(MouseEvent event) {
    var sw = new SceneSwitcher();
    try {
      PropertiesManager.setRememberLogin("0");
      SessionHandler.setAppUser(null);
      var dn = new DialogNotificator();
      dn.logoutNotification();
      sw.switchScene("PantallaLogin");
    } catch (IOException e) {
      System.out.println("Error al cargar la ventana de inicio de sesión");
    }
  }

  /**
   * Navega al panel "Películas"
   *
   * @param event
   */
  @FXML
  void goToPeliculas(MouseEvent event) {
    PaneSwitcher.switchFilmotecaPane("PaneBusqueda", centralPane, 'm');
    imgSection.setImage(new Image("images/sections/Peliculas.png"));
  }

  /**
   * Navega al panel "Series"
   *
   * @param event
   */
  @FXML
  void goToSeries(MouseEvent event) {
    PaneSwitcher.switchFilmotecaPane("PaneBusqueda", centralPane, 't');
    imgSection.setImage(new Image("images/sections/Series.png"));
  }

  /**
   * Navega al panel "Top Películas"
   *
   * @param event
   */
  @FXML
  void goToTopPeliculas(MouseEvent event) {
    PaneSwitcher.switchTopPane("PaneTop", centralPane, 'm');
    imgSection.setImage(new Image("images/sections/Peliculas.png"));
  }

  /**
   * Navega al panel "Top Series"
   *
   * @param event
   */
  @FXML
  void goToTopSeries(MouseEvent event) {
    PaneSwitcher.switchTopPane("PaneTop", centralPane, 't');
    imgSection.setImage(new Image("images/sections/Series.png"));
  }

  /**
   * Navega al panel "Cartelera"
   *
   * @param event
   */
  @FXML
  void goToCartelera(MouseEvent event) {
    PaneSwitcher.switchInTheaterPane("PaneCartelera", centralPane);
    imgSection.setImage(new Image("images/sections/Cartelera.png"));
  }

  /**
   * Navega al panel "Próximamente"
   *
   * @param event
   */
  @FXML
  void goToProximamente(MouseEvent event) {
    PaneSwitcher.switchUpcomingPane("PaneProximamente", centralPane);
    imgSection.setImage(new Image("images/sections/Proximamente.png"));
  }

  /**
   * Navega al panel "Mis Listas"
   *
   * @param event
   */
  @FXML
  void goToMisListas(MouseEvent event) {
    PaneSwitcher.switchPane("PaneMisListas", centralPane);
    imgSection.setImage(new Image("images/sections/Favoritos.png"));
  }

  /**
   * Navega al panel "Inicio"
   *
   * @param event
   */
  @FXML
  void goToInicio(MouseEvent event) {
    PaneSwitcher.switchPane("PaneInicio", centralPane);
    imgSection.setImage(null);
  }

  /**
   * Navega al panel "Usuario"
   *
   * @param event
   */
  @FXML
  void goToUserProfile(MouseEvent event) {
    PaneSwitcher.switchPane("PaneUsuario", centralPane);
    imgSection.setImage(null);
  }

  /**
   * Inicializa la pantalla de inicio
   *
   * @throws InterruptedException
   */
  @FXML
  void initialize() throws InterruptedException {
    PaneSwitcher.switchPane("PaneInicio", centralPane);
    Platform.runLater(this::fillContent);
    Platform.runLater(this::loadUser);
  }

  /** Carga el usuario activo en la sesión */
  private void loadUser() {
    SessionHandler sessionHandler = new SessionHandler();
    sessionHandler.loadUser();
  }

  /** Rellena los elementos de la pantalla de inicio */
  private void fillContent() {
    imgLogo.setImage(new Image("images/logo/logo.png"));
    imgUser.setImage(new Image("images/user.png"));
    lblUserName.setText(SessionHandler.getAppUser().getUsername());
  }
}
