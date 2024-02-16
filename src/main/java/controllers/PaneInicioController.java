package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import utils.ListStorage;

/**
 * Controlador de la página de inicio

 */
public class PaneInicioController {
  private static Pane centralPane;
  private final int NUM_OBRAS = 8;

  // Imagen central de la página de inicio
  @FXML private ImageView imgCentralInicio;

  // Imagenes novedades inicio
  @FXML private ImageView imgObra01;
  @FXML private ImageView imgObra02;
  @FXML private ImageView imgObra03;
  @FXML private ImageView imgObra04;
  @FXML private ImageView imgObra05;
  @FXML private ImageView imgObra06;
  @FXML private ImageView imgObra07;
  @FXML private ImageView imgObra08;

  /**
   * Redirige la página hacia el apartado "Películas"
   *
   * @param event
   */
  @FXML
  void goToPeliculas(MouseEvent event) {
    //		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
    //		imgSection.setImage(new Image("images/sections/Peliculas.png"));
  }

  /**
   * Redirige la página hacia el apartado "Series"
   *
   * @param event
   */
  @FXML
  void goToSeries(MouseEvent event) {
    // PaneSwitcher.switchFilmotecaPane("PaneBusqueda", PantallaModeloController.getCentralPane(),
    // 't');
  }

  /**
   * Redirige la página hacia el apartado "Cartelera"
   *
   * @param event
   */
  @FXML
  void goToCartelera(MouseEvent event) {
    //		PaneSwitcher.switchPane("PaneCartelera", centralPane);
    //		imgSection.setImage(new Image("images/sections/Cartelera.png"));
  }

  /**
   * Redirige la página hacia el apartado "Proximamente"
   *
   * @param event
   */
  @FXML
  void goToProximamente(MouseEvent event) {
    //		PaneSwitcher.switchPane("PaneProximamente", centralPane);
    //		imgSection.setImage(new Image("images/sections/Proximamente.png"));
  }

  /**
   * Redirige la página hacia el apartado "Mis listas"
   *
   * @param event
   */
  @FXML
  void goToMisListas(MouseEvent event) {
    //		PaneSwitcher.switchPane("PaneMisListas", centralPane);
    //		imgSection.setImage(new Image("images/sections/Favoritos.png"));
  }

  /**
   * Redirige la página hacia el apartado "Top Películas"
   *
   * @param event
   */
  @FXML
  void imgObraPressed(MouseEvent event) {}

  /** Inicializa la página de inicio */
  @FXML
  void initialize() {
    Platform.runLater(this::setImages);
  }

  /** Establece las imágenes de las obras en la página de inicio */
  private void setImages() {
    String url = "https://image.tmdb.org/t/p/w500";
    this.imgObra01.setImage(
        new Image(url + ListStorage.getTrendingMovies().get(0).getPoster_path()));
    this.imgObra02.setImage(
        new Image(url + ListStorage.getTrendingSeries().get(0).getPoster_path()));
    this.imgObra03.setImage(
        new Image(url + ListStorage.getTrendingMovies().get(1).getPoster_path()));
    this.imgObra04.setImage(
        new Image(url + ListStorage.getTrendingSeries().get(1).getPoster_path()));
    this.imgObra05.setImage(
        new Image(url + ListStorage.getTrendingMovies().get(2).getPoster_path()));
    this.imgObra06.setImage(
        new Image(url + ListStorage.getTrendingSeries().get(2).getPoster_path()));
    this.imgObra07.setImage(
        new Image(url + ListStorage.getTrendingMovies().get(3).getPoster_path()));
    this.imgObra08.setImage(
        new Image(url + ListStorage.getTrendingSeries().get(3).getPoster_path()));
  }
}
