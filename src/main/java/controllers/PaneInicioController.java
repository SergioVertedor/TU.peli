package controllers;

import application.thread.WorkerPantallaInicio;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.Setter;
import service.APIService;
import service.dto.movie.Movie;
import service.dto.tv.TV;
import utils.ListStorage;

public class PaneInicioController {
  private final int NUM_OBRAS = 8;

  // Imagen central de la página de inicio
  @FXML private ImageView imgCentralInicio;

  // Imagenes novedades inicio
  @FXML @Setter private static ImageView imgObra01;

  @FXML @Setter private static ImageView imgObra02;

  @FXML @Setter private static ImageView imgObra03;

  @FXML @Setter private static ImageView imgObra04;

  @FXML @Setter private static ImageView imgObra05;

  @FXML @Setter private static ImageView imgObra06;

  @FXML @Setter private static ImageView imgObra07;

  @FXML @Setter private static ImageView imgObra08;

  // Imagenes secciones
  @FXML private ImageView imgFilmoteca;
  @FXML private ImageView imgPeliculas;
  @FXML private ImageView imgSeries;
  @FXML private ImageView imgCartelera;
  @FXML private ImageView imgProximamente;
  @FXML private ImageView imgFavoritos;

  // TODO: DECLARACION centralPane e imgSection del parent para cargar los
  // distintos paneles
  // Puesto así ahora mismo para que no falle
  //	Pane centralPane;
  //	ImageView imgSection;

  /**
   * Redirige la página hacia el apartado "Filmoteca"
   *
   * @param event
   */
  @FXML
  void goToFilmoteca(MouseEvent event) {
    //		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
    //		imgSection.setImage(new Image("images/sections/Filmoteca.png"));
  }

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
    //		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
    //		imgSection.setImage(new Image("images/sections/Series.png"));
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

  // Redirige al titulo seleccionado en detalle
  @FXML
  void imgObraPressed(MouseEvent event) {
    //		PaneSwitcher.switchPane("PaneMisListas", centralPane);
    // If pelicula o serie
    // imgSection.setImage(new Image("images/sections/Peliculas.png"));
    // imgSection.setImage(new Image("images/sections/Series.png"));
  }

  @FXML
  void initialize() {
    fillWorks();
//    var workerPantallaInicio = new WorkerPantallaInicio();
//    workerPantallaInicio.start();

    //		imgFilmoteca.setImage(new Image("images/sections/Filmoteca.png"));
    //		imgPeliculas.setImage(new Image("images/sections/Peliculas.png"));
    //		imgSeries.setImage(new Image("images/sections/Series.png"));
    //		imgCartelera.setImage(new Image("images/sections/Cartelera.png"));
    //		imgProximamente.setImage(new Image("images/sections/Proximamente.png"));
    //		imgFavoritos.setImage(new Image("images/sections/Favoritos.png"));
    //		imgCentralInicio.setImage(new Image("images/sections/imgInicio.png"));

    // TODO: Cargar 8 peliculas en el inicio 'imgObra00'
  }

  public static void fillWorks() {
    List<Movie> trendingMovies;
    List<TV> trendingSeries;
    APIService apiService = new APIService();
    try {
      trendingMovies = Arrays.stream(apiService.getTrendingMovies().getResults()).toList();
      trendingSeries = Arrays.stream(apiService.getTrendingSeries().getResults()).toList();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    String url = "https://image.tmdb.org/t/p/w115/";
    imgObra01.setImage(new Image(url + trendingMovies.get(0).getBackdropPath()));
    imgObra02.setImage(new Image(url + trendingSeries.get(1).getBackdropPath()));
    imgObra03.setImage(new Image(url + trendingMovies.get(2).getBackdropPath()));
    imgObra04.setImage(new Image(url + trendingSeries.get(3).getBackdropPath()));
    imgObra05.setImage(new Image(url + trendingMovies.get(4).getBackdropPath()));
    imgObra06.setImage(new Image(url + trendingSeries.get(5).getBackdropPath()));
    imgObra07.setImage(new Image(url + trendingMovies.get(6).getBackdropPath()));
    imgObra08.setImage(new Image(url + trendingSeries.get(7).getBackdropPath()));
  }
}
