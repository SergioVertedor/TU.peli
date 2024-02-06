package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import utils.*;

public class PantallaModeloController {

  @FXML private ResourceBundle resources;

  @FXML private URL location;

  @FXML private ImageView btnBuscar;

  @FXML private Pane centralPane;

  @FXML private ImageView imgClose;

  @FXML private ImageView imgLogo;

  @FXML private ImageView imgSection;

  @FXML private ImageView imgUser;

  @FXML private Label lblCartelera;

  @FXML private Label lblCerrarSesion;

  @FXML private Label lblFilmoteca;

  @FXML private Label lblInicio;

  @FXML private Label lblMisListas;

  @FXML private Label lblPeliculas;

  @FXML private Label lblProximamente;

  @FXML private Label lblSeries;

  @FXML private Label lblTopPeliculas;

  @FXML private Label lblTopSeries;

  @FXML private Label lblUserName1;

  @FXML private Pane paneContent;

  @FXML private GridPane paneHeader;

  @FXML private TextField txtBusqueda;

  @FXML
  void btnBuscarPressed(MouseEvent event) {
    PaneSwitcher.switchPane("PaneBusqueda", paneContent);
  }

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

  @FXML
  void imgUserPressed(MouseEvent event) {
    PaneSwitcher.switchPane("PaneUsuario", paneContent);
  }

  @FXML
  void lblCarteleraPressed(MouseEvent event) {
    PaneSwitcher.switchPane("PaneCartelera", paneContent);
  }

  @FXML
  void lblFilmotecaPressed(MouseEvent event) {}

  @FXML
  void lblInicioPressed(MouseEvent event) {
    PaneSwitcher.switchPane("PaneInicio", paneContent);
  }

  @FXML
  void lblMisListasPressed(MouseEvent event) {}

  @FXML
  void lblPeliculasPressed(MouseEvent event) {}

  @FXML
  void lblProximamentePressed(MouseEvent event) {
    PaneSwitcher.switchPane("PaneProximamente", paneContent);
  }

  @FXML
  void lblSeriesPressed(MouseEvent event) {}

  @FXML
  void lblTopPeliculasPressed(MouseEvent event) {
    PaneSwitcher.switchPane("PaneTop", paneContent);
  }

  @FXML
  void lblTopSeriesPressed(MouseEvent event) {
    PaneSwitcher.switchPane("PaneTop", paneContent);
  }

  @FXML
  void logoPressed(MouseEvent event) {
    PaneSwitcher.switchPane("PaneInicio", paneContent);
  }

  @FXML
  void usernamePressed(MouseEvent event) {
    PaneSwitcher.switchPane("PaneUsuario", paneContent);
  }

  @FXML
  void initialize() {
    PaneSwitcher.switchPane("PaneInicio", paneContent);
  }
}
