package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;
import service.APIService;
import service.dto.movie.Movie;
import service.dto.movie.MovieSearchResult;
import service.dto.tv.TV;
import service.dto.tv.TVSearchResult;
import utils.ListStorage;
import utils.PaneSwitcher;

public class PaneBusquedaController {
  @Getter @Setter private Pane centralPane;
  private List<Movie> movies = new ArrayList<Movie>();
  private List<TV> series = new ArrayList<TV>();
  private static char type;
  // Elementos de búsqueda
  @FXML private ImageView imgResultado00;
  @FXML private ImageView imgResultado01;
  @FXML private ImageView imgResultado02;
  @FXML private ImageView imgResultado03;
  @FXML private ImageView imgResultado04;
  @FXML private ImageView imgResultado10;
  @FXML private ImageView imgResultado11;
  @FXML private ImageView imgResultado12;
  @FXML private ImageView imgResultado13;
  @FXML private ImageView imgResultado14;
  @FXML private ImageView imgResultado20;
  @FXML private ImageView imgResultado21;
  @FXML private ImageView imgResultado22;
  @FXML private ImageView imgResultado23;
  @FXML private ImageView imgResultado24;
  @FXML private ImageView imgResultado30;
  @FXML private ImageView imgResultado31;
  @FXML private ImageView imgResultado32;
  @FXML private ImageView imgResultado33;
  @FXML private ImageView imgResultado34;

  @FXML
  void imageViewPressed00(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(0).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(0).getId());
    }
  }

  @FXML
  void imageViewPressed01(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(1).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(1).getId());
    }
  }

  @FXML
  void imageViewPressed02(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(2).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(2).getId());
    }
  }

  @FXML
  void imageViewPressed03(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(3).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(3).getId());
    }
  }

  @FXML
  void imageViewPressed04(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(4).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(4).getId());
    }
  }

  @FXML
  void imageViewPressed10(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(5).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(5).getId());
    }
  }

  @FXML
  void imageViewPressed11(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(6).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(6).getId());
    }
  }

  @FXML
  void imageViewPressed12(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(7).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(7).getId());
    }
  }

  @FXML
  void imageViewPressed13(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(8).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(8).getId());
    }
  }

  @FXML
  void imageViewPressed14(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(9).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(9).getId());
    }
  }

  @FXML
  void imageViewPressed20(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(10).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(10).getId());
    }
  }

  @FXML
  void imageViewPressed21(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(11).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(11).getId());
    }
  }

  @FXML
  void imageViewPressed22(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(12).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(12).getId());
    }
  }

  @FXML
  void imageViewPressed23(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(13).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(13).getId());
    }
  }

  @FXML
  void imageViewPressed24(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(14).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(14).getId());
    }
  }

  @FXML
  void imageViewPressed30(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(15).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(15).getId());
    }
  }

  @FXML
  void imageViewPressed31(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(16).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(16).getId());
    }
  }

  @FXML
  void imageViewPressed32(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(17).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(17).getId());
    }
  }

  @FXML
  void imageViewPressed33(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(18).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(18).getId());
    }
  }

  @FXML
  void imageViewPressed34(MouseEvent event) {
    if ((type == 'm')) {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, movies.get(19).getId());
    } else {
      PaneSwitcher.switchToDetails("PaneDetalle", centralPane, type, series.get(19).getId());
    }
  }

  @FXML
  void initialize() {
    Platform.runLater(this::fillInitialResults);
  }

  public void fillFilmoteca(char type) {
    PaneBusquedaController.type = type;
    if (type == 'm') {
      fillMovies();
    } else if (type == 't') {
      fillSeries();
    }
  }

  public void fillSearchResults(String type, String search) {

    if (type == "ms") {
      fillMovieSearchResults(search);
      ;
    } else if (type == "ts") {
       fillSerieSearchResults(search);
    }
  }

  private void fillSerieSearchResults(String search) {
    this.series.clear();
    List<ImageView> imagenes =
            List.of(
                    imgResultado00,
                    imgResultado01,
                    imgResultado02,
                    imgResultado03,
                    imgResultado04,
                    imgResultado10,
                    imgResultado11,
                    imgResultado12,
                    imgResultado13,
                    imgResultado14,
                    imgResultado20,
                    imgResultado21,
                    imgResultado22,
                    imgResultado23,
                    imgResultado24,
                    imgResultado30,
                    imgResultado31,
                    imgResultado32,
                    imgResultado33,
                    imgResultado34);
    this.type = 't';
    APIService apiService = new APIService();
    TVSearchResult resultados = apiService.searchSerie(search);
    List<TV> resultadosBusqueda = Arrays.stream(resultados.getResults()).toList();

    String url = "https://image.tmdb.org/t/p/w500";
    imagenes.forEach(
            imagen -> {
              int index = imagenes.indexOf(imagen);
              if (index < resultadosBusqueda.size()) {
                if (resultadosBusqueda.get(index).getPoster_path() != null) {
                  imagen.setImage(new Image(url + resultadosBusqueda.get(index).getPoster_path()));
                  series.add(resultadosBusqueda.get(index));
                }

              }
            });
  }

  private void fillMovieSearchResults(String search) {
    this.movies.clear();
    List<ImageView> imgViews =
        List.of(
            imgResultado00,
            imgResultado01,
            imgResultado02,
            imgResultado03,
            imgResultado04,
            imgResultado10,
            imgResultado11,
            imgResultado12,
            imgResultado13,
            imgResultado14,
            imgResultado20,
            imgResultado21,
            imgResultado22,
            imgResultado23,
            imgResultado24,
            imgResultado30,
            imgResultado31,
            imgResultado32,
            imgResultado33,
            imgResultado34);
    type = 'm';
    APIService apiService = new APIService();
    MovieSearchResult resultados = apiService.searchMovie(search);
    List<Movie> resultadosBusqueda = Arrays.stream(resultados.getResults()).toList();

    String url = "https://image.tmdb.org/t/p/w500";
    imgViews.forEach(
            imagen -> {
              int index = imgViews.indexOf(imagen);
              if (index < resultadosBusqueda.size()) {
                if (resultadosBusqueda.get(index).getPoster_path() != null) {
                  imagen.setImage(new Image(url + resultadosBusqueda.get(index).getPoster_path()));
                  movies.add(resultadosBusqueda.get(index));
                }
              }
            });
  }

  private void fillSeries() {
    this.series.clear();
    List<ImageView> imgViews =
        List.of(
            imgResultado00,
            imgResultado01,
            imgResultado02,
            imgResultado03,
            imgResultado04,
            imgResultado10,
            imgResultado11,
            imgResultado12,
            imgResultado13,
            imgResultado14,
            imgResultado20,
            imgResultado21,
            imgResultado22,
            imgResultado23,
            imgResultado24,
            imgResultado30,
            imgResultado31,
            imgResultado32,
            imgResultado33,
            imgResultado34);
    String url = "https://image.tmdb.org/t/p/w500";
    imgViews.forEach(
        image -> {
          if (ListStorage.getTrendingSeries().get(imgViews.indexOf(image)).getPoster_path()
              == null) {
            image.setVisible(false);
          } else {
            image.setImage(
                new Image(
                    url
                        + ListStorage.getTrendingSeries()
                            .get(imgViews.indexOf(image))
                            .getPoster_path()));
            series.add(ListStorage.getTrendingSeries().get(imgViews.indexOf(image)));
          }
        });
  }

  private void fillMovies() {
    this.movies.clear();
    List<ImageView> imgViews =
        List.of(
            imgResultado00,
            imgResultado01,
            imgResultado02,
            imgResultado03,
            imgResultado04,
            imgResultado10,
            imgResultado11,
            imgResultado12,
            imgResultado13,
            imgResultado14,
            imgResultado20,
            imgResultado21,
            imgResultado22,
            imgResultado23,
            imgResultado24,
            imgResultado30,
            imgResultado31,
            imgResultado32,
            imgResultado33,
            imgResultado34);
    String url = "https://image.tmdb.org/t/p/w500";
    imgViews.forEach(
        image -> {
          if (ListStorage.getTrendingMovies().get(imgViews.indexOf(image)).getPoster_path()
              == null) {
            image.setVisible(false);
          } else {
            image.setImage(
                new Image(
                    url
                        + ListStorage.getTrendingMovies()
                            .get(imgViews.indexOf(image))
                            .getPoster_path()));
            movies.add(ListStorage.getTrendingMovies().get(imgViews.indexOf(image)));
          }
        });
  }

  public void fillInitialResults() {
    String url = "https://image.tmdb.org/t/p/w500";
    List<ImageView> row1 =
        List.of(imgResultado00, imgResultado01, imgResultado02, imgResultado03, imgResultado04);
    List<ImageView> row2 =
        List.of(imgResultado10, imgResultado11, imgResultado12, imgResultado13, imgResultado14);
    List<ImageView> row3 =
        List.of(imgResultado20, imgResultado21, imgResultado22, imgResultado23, imgResultado24);
    List<ImageView> row4 =
        List.of(imgResultado30, imgResultado31, imgResultado32, imgResultado33, imgResultado34);

    for (int i = 0; i < 5; i++) {
      row1.get(i)
          .setImage(new Image(url + ListStorage.getTrendingMovies().get(i).getPoster_path()));
      row3.get(i)
          .setImage(new Image(url + ListStorage.getTrendingMovies().get(i + 5).getPoster_path()));
      row2.get(i)
          .setImage(new Image(url + ListStorage.getTrendingSeries().get(i + 10).getPoster_path()));
      row4.get(i)
          .setImage(new Image(url + ListStorage.getTrendingSeries().get(i + 15).getPoster_path()));
    }
  }
}
