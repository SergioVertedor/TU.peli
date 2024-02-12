package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.Getter;
import lombok.Setter;
import service.APIService;
import service.dto.Genre;
import service.dto.credits.Cast;
import service.dto.movie.Movie;
import service.dto.tv.TV;
import utils.ListStorage;

public class PaneTopController {
  @Setter @Getter private static char type;

  @FXML private ToggleGroup btnGroup;

  @FXML private ImageView imgObra00;

  @FXML private ImageView imgObra01;

  @FXML private ImageView imgObra02;

  @FXML private ImageView imgObra03;

  @FXML private ImageView imgObra04;

  @FXML private ImageView imgObra05;

  @FXML private ImageView imgObra06;

  @FXML private ImageView imgObra07;

  @FXML private Label lblDirectorGenero;

  @FXML private Label lblEstreno;

  @FXML private Label lblSinopsis;

  @FXML private Label lblTitulo;

  @FXML private Label lblTituloSinopsis;

  @FXML private RadioButton rbAllTime;

  @FXML private RadioButton rbLastTenYears;

  @FXML private RadioButton rbThisYear;

  @FXML private RadioButton rbThreeMonths;

  @FXML
  void thisYearPressed(MouseEvent event) {
    fillTopWorks(type, "year");
  }

  @FXML
  void LastTenYearsPressed(MouseEvent event) {
    fillTopWorks(type, "decade");
  }

  @FXML
  void LastThreeMonthsPressed(MouseEvent event) {
    fillTopWorks(type, "3m");
  }

  @FXML
  void allTimePressed(MouseEvent event) {
    fillTopWorks(type, null);
  }

  /**
   * Muestra la información de la obra seleccionada
   *
   * @param event
   */
  @FXML
  void onMouseEnteredTitle00(MouseEvent event) {
    var apiService = new APIService();
    if (type == 'm') {
      lblTitulo.setText(ListStorage.getTopMovies().get(0).getTitle());
      long idMovie = ListStorage.getTopMovies().get(0).getId();
      System.out.println(idMovie);
      List<Cast> credits = Arrays.stream(apiService.getMovieCredits(idMovie).getCrew()).toList();
      var directores = new ArrayList<String>();
      credits.stream()
          .filter(director -> director.getJob().equals("Director"))
          .forEach(director -> directores.add(director.getName()));
      String directorGenero = "";
      for (String director : directores) {
        directorGenero += director + " ";
      }
      int[] generos = ListStorage.getTopMovies().get(0).getGenre_ids();
      for (int i = 0; i < generos.length; i++) {
        for (Genre genero : ListStorage.getMovieGenres()) {
          if (genero.getId() == generos[i]) {
            directorGenero += genero.getName() + "\n";
          }
        }
      }
      lblDirectorGenero.setText(directorGenero);
      lblSinopsis.setText(ListStorage.getTopMovies().get(0).getOverview());

    } else if (type == 't') {
      lblTitulo.setText(ListStorage.getTopSeries().get(0).getName());
      lblDirectorGenero.setText(ListStorage.getTopSeries().get(0).getGenreIDS().toString());
      lblSinopsis.setText(ListStorage.getTopSeries().get(0).getOverview());
    }
  }

  @FXML
  void onMouseEnteredTitle01(MouseEvent event) {}

  @FXML
  void onMouseEnteredTitle02(MouseEvent event) {}

  @FXML
  void onMouseEnteredTitle03(MouseEvent event) {}

  @FXML
  void onMouseEnteredTitle04(MouseEvent event) {}

  @FXML
  void onMouseEnteredTitle05(MouseEvent event) {}

  @FXML
  void onMouseEnteredTitle06(MouseEvent event) {}

  @FXML
  void onMouseEnteredTitle07(MouseEvent event) {}

  @FXML
  void initialize() {
    // Cargar selección Top Peliculas/Series de Todos los tiempos 'imgObra00'
  }

  /**
   * Muestra las obras más populares
   *
   * @param type m = movie, t = tv
   * @param timeFrame null = all time, year = year, decade = decade, 3m = 3 months
   */
  public void fillTopWorks(char type, String timeFrame) {
    setType(type);
    var apiService = new APIService();
    String date;
    String actualYear = "" + LocalDate.now().getYear();
    String actualMonth = "" + LocalDate.now().getMonthValue();

    String url = "https://image.tmdb.org/t/p/w500";
    List<ImageView> imgViews =
        List.of(
            imgObra00, imgObra01, imgObra02, imgObra03, imgObra04, imgObra05, imgObra06, imgObra07);

    if (this.type == 'm') {
      List<Movie> movies = new ArrayList<Movie>();
      if (timeFrame == null) {
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(
              new Image(
                  url
                      + ListStorage.getTopMovies()
                          .get(imgViews.indexOf(imgObra))
                          .getPoster_path()));
        }
      } else if (timeFrame.equals("year")) {
        date = 1 + "-" + 1 + "-" + actualYear;
        movies = Arrays.stream(apiService.searchMovieByYear(date).getResults()).toList();
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + movies.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      } else if (timeFrame.equals("decade")) {
        date = 1 + "-" + 1 + "-" + (Integer.parseInt(actualYear) - 10);
        movies = Arrays.stream(apiService.searchMovieByYear(date).getResults()).toList();
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + movies.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      } else if (timeFrame.equals("3m")) {
        date = 1 + "-" + (Integer.parseInt(actualMonth) - 3) + "-" + actualYear;
        movies = Arrays.stream(apiService.searchMovieByYear(date).getResults()).toList();
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + movies.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      }
    } else if (type == 't') {
      List<TV> series;
      if (timeFrame == null) {
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(
              new Image(
                  url
                      + ListStorage.getTopSeries()
                          .get(imgViews.indexOf(imgObra))
                          .getPoster_path()));
        }
      } else if (timeFrame.equals("year")) {
        date = 1 + "-" + 1 + "-" + actualYear;
        series = Arrays.stream(apiService.searchSerieByYear(date).getResults()).toList();
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + series.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      } else if (timeFrame.equals("decade")) {
        date = 1 + "-" + 1 + "-" + (Integer.parseInt(actualYear) - 10);
        series = Arrays.stream(apiService.searchSerieByYear(date).getResults()).toList();
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + series.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      } else if (timeFrame.equals("3m")) {
        date = 1 + "-" + (Integer.parseInt(actualMonth) - 3) + "-" + actualYear;
        series = Arrays.stream(apiService.searchSerieByYear(date).getResults()).toList();
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + series.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      }
    }
  }
}
