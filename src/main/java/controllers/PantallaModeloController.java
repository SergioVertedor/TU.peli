package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import utils.PaneSwitcher;

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
  void btnBuscarPressed(MouseEvent event) {}

  @FXML
  void cerrarSesionPressed(MouseEvent event) {}

  @FXML
  void imgUserPressed(MouseEvent event) {}

  @FXML
  void lblCarteleraPressed(MouseEvent event) {}

  @FXML
  void lblFilmotecaPressed(MouseEvent event) {}

  @FXML
  void lblInicioPressed(MouseEvent event) {}

  @FXML
  void lblMisListasPressed(MouseEvent event) {}

  @FXML
  void lblPeliculasPressed(MouseEvent event) {}

  @FXML
  void lblProximamentePressed(MouseEvent event) {}

  @FXML
  void lblSeriesPressed(MouseEvent event) {}

  @FXML
  void lblTopPeliculasPressed(MouseEvent event) {}

  @FXML
  void lblTopSeriesPressed(MouseEvent event) {}

  @FXML
  void logoPressed(MouseEvent event) {}

  @FXML
  void usernamePressed(MouseEvent event) {}

  @FXML
  void initialize() {
    PaneSwitcher.switchPane("PaneInicio", centralPane);
  }
}
