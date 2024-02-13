package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import service.APIService;
import utils.ListStorage;

public class PaneBusquedaController {

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

  @FXML private ImageView imgResultado27;
  @FXML private ImageView imgResultado28;
  @FXML private ImageView imgResultado29;
  @FXML private ImageView imgResultado30;
  @FXML private ImageView imgResultado31;
  @FXML private ImageView imgResultado32;
  @FXML private ImageView imgResultado33;



  // Contenedores HBox de los resultados
  @FXML private HBox line0;
  @FXML private HBox line1;
  @FXML private HBox line2;
  @FXML private HBox line3;

  // Opciones radioButton
  @FXML private ToggleGroup btnGroup;
  @FXML private RadioButton rbPeliculas;
  @FXML private RadioButton rbSeries;

  /**
   * Busca el titulo dado filtrando por Películas/Series o ambas opciones
   *
   * @param event
   */
  @FXML
  void btnBuscarClicked(MouseEvent event) {

  }

  @FXML
  void initialize() {
    Platform.runLater(this::fillInitialResults);
  }



  public void fillInitialResults() {
String url = "https://image.tmdb.org/t/p/w500";
     List<ImageView> row1 =
            List.of(
                    imgResultado00,
                    imgResultado01,
                    imgResultado02,
                    imgResultado03,
                    imgResultado04,
                    imgResultado05,
                    imgResultado06);
     List<ImageView> row2 =
            List.of(
                    imgResultado10,
                    imgResultado11,
                    imgResultado12,
                    imgResultado13,
                    imgResultado14,
                    imgResultado15,
                    imgResultado16);
     List<ImageView> row3 =
            List.of(
                    imgResultado20,
                    imgResultado21,
                    imgResultado22,
                    imgResultado23,
                    imgResultado24,
                    imgResultado25,
                    imgResultado26);
     List<ImageView> row4 =
            List.of(
                    imgResultado27,
                    imgResultado28,
                    imgResultado29,
                    imgResultado30,
                    imgResultado31,
                    imgResultado32,
                    imgResultado33);
    for (int i = 0; i < 7; i++) {
      row1.get(i).setImage(new Image(url + ListStorage.getTrendingMovies().get(i).getPoster_path()));
      row3.get(i).setImage(new Image(url + ListStorage.getTrendingMovies().get(i + 7).getPoster_path()));
      row2.get(i).setImage(new Image(url + ListStorage.getTrendingSeries().get(i).getPoster_path()));
      row4.get(i).setImage(new Image(url + ListStorage.getTrendingSeries().get(i + 7).getPoster_path()));
    }
  }
}
