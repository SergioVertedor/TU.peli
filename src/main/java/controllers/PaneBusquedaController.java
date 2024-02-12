package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import utils.ListStorage;

public class PaneBusquedaController {

  // NPI de que es esto
  @FXML private ResourceBundle resources;
  @FXML private URL location;

  // Elementos de búsqueda
  @FXML private TextField txtBusqueda;
  @FXML private ImageView btnBuscar;

  // Imagenes por fila 0-3 y columna 0-6
  @FXML private ImageView imgResultado00;
  @FXML private ImageView imgResultado01;
  @FXML private ImageView imgResultado02;
  @FXML private ImageView imgResultado03;
  @FXML private ImageView imgResultado04;
  @FXML private ImageView imgResultado05;
  @FXML private ImageView imgResultado06;

  @FXML private ImageView imgResultado10;
  @FXML private ImageView imgResultado11;
  @FXML private ImageView imgResultado12;
  @FXML private ImageView imgResultado13;
  @FXML private ImageView imgResultado14;
  @FXML private ImageView imgResultado15;
  @FXML private ImageView imgResultado16;

  @FXML private ImageView imgResultado20;
  @FXML private ImageView imgResultado21;
  @FXML private ImageView imgResultado22;
  @FXML private ImageView imgResultado23;
  @FXML private ImageView imgResultado24;
  @FXML private ImageView imgResultado25;
  @FXML private ImageView imgResultado26;

  // Contenedores HBox de los resultados
  @FXML private HBox line0;
  @FXML private HBox line1;
  @FXML private HBox line2;
  @FXML private HBox line3;

  // Opciones radioButton
  @FXML private ToggleGroup btnGroup;
  @FXML private RadioButton rbTodas;
  @FXML private RadioButton rbPeliculas;
  @FXML private RadioButton rbSeries;

  /**
   * Busca el titulo dado filtrando por Películas/Series o ambas opciones
   *
   * @param event
   */
  @FXML
  void btnBuscarClicked(MouseEvent event) {}

  @FXML
  void initialize() {}

  public void fillResults(char type) {

  }
}
