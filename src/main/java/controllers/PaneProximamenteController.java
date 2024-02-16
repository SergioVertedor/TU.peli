package controllers;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;
import service.dto.Genre;
import service.dto.movie.Movie;
import utils.ListStorage;
import utils.PaneSwitcher;

/**
 * Clase controladora de la pantalla de proximamente
 */
public class PaneProximamenteController {

  @Getter @Setter private static Pane contentPane;
  @Getter @Setter private List<Movie> upcomingMovies = new ArrayList<>();
  // Imagenes poster
  @FXML private ImageView imgPoster00;
  @FXML private ImageView imgPoster01;
  @FXML private ImageView imgPoster02;
  @FXML private ImageView imgPoster03;
  @FXML private ImageView imgPoster10;
  @FXML private ImageView imgPoster11;
  @FXML private ImageView imgPoster12;
  @FXML private ImageView imgPoster13;

  // Fechas de estrenos
  @FXML private Label lblFecha00;
  @FXML private Label lblFecha01;
  @FXML private Label lblFecha02;
  @FXML private Label lblFecha03;
  @FXML private Label lblFecha10;
  @FXML private Label lblFecha11;
  @FXML private Label lblFecha12;
  @FXML private Label lblFecha13;

  // Generos
  @FXML private Label lblGenero00;
  @FXML private Label lblGenero01;
  @FXML private Label lblGenero02;
  @FXML private Label lblGenero03;
  @FXML private Label lblGenero10;
  @FXML private Label lblGenero11;
  @FXML private Label lblGenero12;
  @FXML private Label lblGenero13;

  // Info
  // Formato: "Director: " + director + "\nReparto: " + listaReparto string
  @FXML private Label lblInfo00;
  @FXML private Label lblInfo01;
  @FXML private Label lblInfo02;
  @FXML private Label lblInfo03;
  @FXML private Label lblInfo10;
  @FXML private Label lblInfo11;
  @FXML private Label lblInfo12;
  @FXML private Label lblInfo13;

  // Titulos
  @FXML private Label lblTitulo00;
  @FXML private Label lblTitulo01;
  @FXML private Label lblTitulo02;
  @FXML private Label lblTitulo03;
  @FXML private Label lblTitulo10;
  @FXML private Label lblTitulo11;
  @FXML private Label lblTitulo12;
  @FXML private Label lblTitulo13;

  /**
   * Metodo que se encarga de cambiar a la pantalla de detalles de la pelicula seleccionada
   *
   * @param event
   */
  @FXML
  void imgPoster00Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', upcomingMovies.get(0).getId());
  }

  /**
   * Metodo que se encarga de cambiar a la pantalla de detalles de la pelicula seleccionada
   *
   * @param event
   */
  @FXML
  void imgPoster01Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', upcomingMovies.get(1).getId());
  }

  /**
   * Metodo que se encarga de cambiar a la pantalla de detalles de la pelicula seleccionada
   *
   * @param event
   */
  @FXML
  void imgPoster02Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', upcomingMovies.get(2).getId());
  }

  /**
   * Metodo que se encarga de cambiar a la pantalla de detalles de la pelicula seleccionada
   *
   * @param event
   */
  @FXML
  void imgPoster03Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', upcomingMovies.get(3).getId());
  }

  /**
   * Metodo que se encarga de cambiar a la pantalla de detalles de la pelicula seleccionada
   *
   * @param event
   */
  @FXML
  void imgPoster10Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', upcomingMovies.get(4).getId());
  }

  /**
   * Metodo que se encarga de cambiar a la pantalla de detalles de la pelicula seleccionada
   *
   * @param event
   */
  @FXML
  void imgPoster11Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', upcomingMovies.get(5).getId());
  }

  /**
   * Metodo que se encarga de cambiar a la pantalla de detalles de la pelicula seleccionada
   *
   * @param event
   */
  @FXML
  void imgPoster12Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', upcomingMovies.get(6).getId());
  }

  /**
   * Metodo que se encarga de cambiar a la pantalla de detalles de la pelicula seleccionada
   *
   * @param event
   */
  @FXML
  void imgPoster13Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', upcomingMovies.get(7).getId());
  }

  /** Metodo que se encarga de inicializar el controlador */
  @FXML
  void initialize() {
    Platform.runLater(this::fillResults);
  }

  /** Metodo que se encarga de llenar los resultados de las peliculas proximas a estrenarse */
  public void fillResults() {
    String url = "https://image.tmdb.org/t/p/w500";
    List<ImageView> imgPosters =
        List.of(
            imgPoster00,
            imgPoster01,
            imgPoster02,
            imgPoster03,
            imgPoster10,
            imgPoster11,
            imgPoster12,
            imgPoster13);
    List<Label> lblFechas =
        List.of(
            lblFecha00,
            lblFecha01,
            lblFecha02,
            lblFecha03,
            lblFecha10,
            lblFecha11,
            lblFecha12,
            lblFecha13);
    List<Label> lblGeneros =
        List.of(
            lblGenero00,
            lblGenero01,
            lblGenero02,
            lblGenero03,
            lblGenero10,
            lblGenero11,
            lblGenero12,
            lblGenero13);
    List<Label> lblInfo =
        List.of(
            lblInfo00, lblInfo01, lblInfo02, lblInfo03, lblInfo10, lblInfo11, lblInfo12, lblInfo13);
    List<Label> lblTitulos =
        List.of(
            lblTitulo00,
            lblTitulo01,
            lblTitulo02,
            lblTitulo03,
            lblTitulo10,
            lblTitulo11,
            lblTitulo12,
            lblTitulo13);
    // Seteando imagenes
    imgPosters.forEach(
        img -> {
          img.setImage(
              new Image(
                  url
                      + ListStorage.getUpcomingMovies()
                          .get(imgPosters.indexOf(img))
                          .getPoster_path()));
          upcomingMovies.add(ListStorage.getUpcomingMovies().get(imgPosters.indexOf(img)));
        });
    // Seteando fechas de estreno
    lblFechas.forEach(
        lbl ->
            lbl.setText(
                ListStorage.getUpcomingMovies().get(lblFechas.indexOf(lbl)).getRelease_date()));
    // Seteando los generos
    for (Label lbl : lblGeneros) {
      int[] genres = ListStorage.getUpcomingMovies().get(lblGeneros.indexOf(lbl)).getGenre_ids();
      StringBuilder genero = new StringBuilder();
      for (int i = 0; i < genres.length; i++) {
        for (Genre genre : ListStorage.getMovieGenres()) {
          if (genre.getId() == genres[i]) {
            if (i == genres.length - 1) {
              genero.append(genre.getName());
            } else {
              genero.append(genre.getName()).append(", ");
            }
          }
        }
        lbl.setText(genero.toString());
      }
    }
    // Seteando la info
    for (Label lbl : lblInfo) {
      lbl.setText(ListStorage.getUpcomingMovies().get(lblInfo.indexOf(lbl)).getOverview());
    }
    // Seteando los titulos
    lblTitulos.forEach(
        lbl ->
            lbl.setText(ListStorage.getUpcomingMovies().get(lblTitulos.indexOf(lbl)).getTitle()));
  }
}
