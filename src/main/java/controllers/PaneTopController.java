package controllers;

import java.io.IOException;
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

  // Imagenes Top
  @FXML private ImageView imgObra00;
  @FXML private ImageView imgObra01;
  @FXML private ImageView imgObra02;
  @FXML private ImageView imgObra03;
  @FXML private ImageView imgObra04;
  @FXML private ImageView imgObra05;
  @FXML private ImageView imgObra06;
  @FXML private ImageView imgObra07;

  // Info titulo - detalle
  @FXML private Label lblTitulo;
  @FXML private Label lblDirectorGenero;
  @FXML private Label lblEstreno;
  @FXML private Label lblTituloSinopsis;
  @FXML private Label lblSinopsis;

  // Opciones radioButton
  @FXML private ToggleGroup btnGroup;
  @FXML private RadioButton rbAllTime;
  @FXML private RadioButton rbLastTenYears;
  @FXML private RadioButton rbThreeMonths;
  @FXML private RadioButton rbThisYear;

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
    fillTopWorks(type, "");
  }

  /**
   * Muestra la información de la obra seleccionada
   *
   * @param event
   */
  @FXML
  void onMouseEnteredTitle00(MouseEvent event) {
    fillInfo(0);
  }

  @FXML
  void onMouseEnteredTitle01(MouseEvent event) {
    fillInfo(1);
  }

  @FXML
  void onMouseEnteredTitle02(MouseEvent event) {
    fillInfo(2);
  }

  @FXML
  void onMouseEnteredTitle03(MouseEvent event) {
    fillInfo(3);
  }

  @FXML
  void onMouseEnteredTitle04(MouseEvent event) {
    fillInfo(4);
  }

  @FXML
  void onMouseEnteredTitle05(MouseEvent event) {
    fillInfo(5);
  }

  @FXML
  void onMouseEnteredTitle06(MouseEvent event) {
    fillInfo(6);
  }

  @FXML
  void onMouseEnteredTitle07(MouseEvent event) {
    fillInfo(7);
  }

  @FXML
  void initialize() {
    // Cargar selección Top Peliculas/Series de Todos los tiempos 'imgObra00'
  }

  public void fillInfo(int index) {
    var apiService = new APIService();
    if (type == 'm') {
      lblTitulo.setText(ListStorage.getTopMovies().get(index).getTitle());
      long idMovie = ListStorage.getTopMovies().get(index).getId();
      List<Cast> credits = Arrays.stream(apiService.getMovieCredits(idMovie).getCrew()).toList();
      var directores = new ArrayList<String>();
      credits.stream()
          .filter(director -> director.getJob().equals("Director"))
          .forEach(director -> directores.add(director.getName()));
      String directorGenero = "";
      for (String director : directores) {
        for (int i = 0; i < directores.size(); i++) {
          if (i == directores.size() - 1) {
            directorGenero += director + " - ";
          } else {
            directorGenero += director + ", ";
          }
        }
      }
      int[] generos = ListStorage.getTopMovies().get(index).getGenre_ids();
      for (int i = 0; i < generos.length; i++) {
        for (Genre genre : ListStorage.getMovieGenres()) {
          if (generos[i] == genre.getId()) {
            if (i == generos.length - 1) {
              directorGenero += genre.getName();
            } else {
              directorGenero += genre.getName() + ", ";
            }
          }
        }
      }
      String releaseYear = ListStorage.getTopMovies().get(index).getRelease_date();
      lblEstreno.setText(releaseYear.substring(0, 4));
      lblDirectorGenero.setText(directorGenero);
      lblSinopsis.setText(ListStorage.getTopMovies().get(index).getOverview());

    } else if (type == 't') {
      lblTitulo.setText(ListStorage.getTopSeries().get(index).getName());
      long idSerie = ListStorage.getTopSeries().get(index).getId();
      List<Cast> credits = Arrays.stream(apiService.getTVCredits(idSerie).getCrew()).toList();
      var directores = new ArrayList<String>();
      credits.stream()
          .filter(director -> director.getJob().equals("Director"))
          .forEach(director -> directores.add(director.getName()));
      String directorGenero = "";
      for (String director : directores) {
        for (int i = 0; i < directores.size(); i++) {
          if (i == directores.size() - 1) {
            directorGenero += director + " - ";
          } else {
            directorGenero += director + ", ";
          }
        }
      }
      long[] generos = ListStorage.getTopSeries().get(index).getGenre_ids();
      for (int i = 0; i < generos.length; i++) {
        for (Genre genre : ListStorage.getTvGenres()) {
          if (generos[i] == genre.getId()) {
            if (i == generos.length - 1) {
              directorGenero += genre.getName();
            } else {
              directorGenero += genre.getName() + ", ";
            }
          }
        }
      }
      String releaseYear = ListStorage.getTopSeries().get(index).getFirst_air_date();
      lblEstreno.setText(releaseYear.substring(0, 4));
      lblDirectorGenero.setText(directorGenero);
      lblSinopsis.setText(ListStorage.getTopMovies().get(index).getOverview());
    }
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
    String actualYear = "" + LocalDate.now().getYear();
    String actualMonth = "" + LocalDate.now().getMonthValue();
    String thisYear = "1-1-" + actualYear;
    String thisDecade = "1-1-" + (Integer.parseInt(actualYear) - 10);
    String threeMonths = "";
    if (timeFrame.equals("3m")) {
      if (Integer.parseInt(actualMonth) - 3 == 0) {
        threeMonths = "1-1" + actualYear;
      }
      if (Integer.parseInt(actualMonth) - 3 == -1) {
        threeMonths = "1-12-" + (Integer.parseInt(actualYear) - 1);
      }
      if (Integer.parseInt(actualMonth) - 3 == -2) {
        threeMonths = "1-11-" + (Integer.parseInt(actualYear) - 1);
      } else {
        threeMonths = "1-" + (Integer.parseInt(actualMonth) - 3) + actualYear;
      }
    }

    String url = "https://image.tmdb.org/t/p/w500";
    List<ImageView> imgViews =
        List.of(
            imgObra00, imgObra01, imgObra02, imgObra03, imgObra04, imgObra05, imgObra06, imgObra07);

    if (getType() == 'm') {
      try {
        ListStorage.setTopMovies(Arrays.stream(apiService.getTopMovies().getResults()).toList());
      } catch (IOException e) {
        System.err.println("Error al cargar las películas más populares.");
        throw new RuntimeException(e);
      }
      List<Movie> movies;
      if (timeFrame.isEmpty()) {
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(
              new Image(
                  url
                      + ListStorage.getTopMovies()
                          .get(imgViews.indexOf(imgObra))
                          .getPoster_path()));
        }
      } else if (timeFrame.equals("year")) {
        movies = Arrays.stream(apiService.searchMovieByDate(thisYear).getResults()).toList();
        ListStorage.setTopMovies(movies);
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + movies.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      } else if (timeFrame.equals("decade")) {
        movies = Arrays.stream(apiService.searchMovieByDate(thisDecade).getResults()).toList();
        ListStorage.setTopMovies(movies);
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + movies.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      } else if (timeFrame.equals("3m")) {
        movies = Arrays.stream(apiService.searchMovieByDate(threeMonths).getResults()).toList();
        ListStorage.setTopMovies(movies);
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + movies.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      }
    } else if (getType() == 't') {
      try {
        ListStorage.setTopSeries(Arrays.stream(apiService.getTopSeries().getResults()).toList());
      } catch (IOException e) {
        System.err.println("Error al cargar las películas más populares.");
        throw new RuntimeException(e);
      }
      List<TV> series;
      if (timeFrame.isEmpty()) {
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(
              new Image(
                  url
                      + ListStorage.getTopSeries()
                          .get(imgViews.indexOf(imgObra))
                          .getPoster_path()));
        }
      } else if (timeFrame.equals("year")) {
        series = Arrays.stream(apiService.searchSerieByYear(thisYear).getResults()).toList();
        ListStorage.setTopSeries(series);
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + series.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      } else if (timeFrame.equals("decade")) {
        series = Arrays.stream(apiService.searchSerieByYear(thisDecade).getResults()).toList();
        ListStorage.setTopSeries(series);
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + series.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      } else if (timeFrame.equals("3m")) {
        series = Arrays.stream(apiService.searchSerieByYear(threeMonths).getResults()).toList();
        ListStorage.setTopSeries(series);
        for (ImageView imgObra : imgViews) {
          imgObra.setImage(new Image(url + series.get(imgViews.indexOf(imgObra)).getPoster_path()));
        }
      }
    }
  }
}
