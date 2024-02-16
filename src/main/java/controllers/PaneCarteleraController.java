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
 * Controlador de la pantalla de cartelera

 */
public class PaneCarteleraController {
  @Getter @Setter private static Pane contentPane;
  private List<Movie> nowPlayingMovies = new ArrayList<Movie>();

  // Imagenes cartelera
  @FXML private ImageView imgPoster00;
  @FXML private ImageView imgPoster01;
  @FXML private ImageView imgPoster02;
  @FXML private ImageView imgPoster03;
  @FXML private ImageView imgPoster10;
  @FXML private ImageView imgPoster11;
  @FXML private ImageView imgPoster12;
  @FXML private ImageView imgPoster13;

  // Titulo peliculas
  @FXML private Label lblTitulo00;
  @FXML private Label lblTitulo01;
  @FXML private Label lblTitulo02;
  @FXML private Label lblTitulo03;
  @FXML private Label lblTitulo10;
  @FXML private Label lblTitulo11;
  @FXML private Label lblTitulo12;
  @FXML private Label lblTitulo13;

  // Formato: "Director: " + director + "\nReparto: " + listaReparto string
  @FXML private Label lblInfo00;
  @FXML private Label lblInfo01;
  @FXML private Label lblInfo02;
  @FXML private Label lblInfo03;
  @FXML private Label lblInfo10;
  @FXML private Label lblInfo11;
  @FXML private Label lblInfo12;
  @FXML private Label lblInfo13;

  // Generos
  @FXML private Label lblGenero00;
  @FXML private Label lblGenero01;
  @FXML private Label lblGenero02;
  @FXML private Label lblGenero03;
  @FXML private Label lblGenero10;
  @FXML private Label lblGenero11;
  @FXML private Label lblGenero12;
  @FXML private Label lblGenero13;
  /**
   * Metodo que se ejecuta al hacer click en la imagen de la cartelera
   * @param event
   */
  @FXML
  void imgPoster00Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', nowPlayingMovies.get(0).getId());
  }

  /**
   * Metodo que se ejecuta al hacer click en la imagen de la cartelera
   * @param event
   */
  @FXML
  void imgPoster01Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', nowPlayingMovies.get(1).getId());
  }

  /**
   * Metodo que se ejecuta al hacer click en la imagen de la cartelera
   * @param event
   */
  @FXML
  void imgPoster02Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', nowPlayingMovies.get(2).getId());
  }

  /**
   * Metodo que se ejecuta al hacer click en la imagen de la cartelera
   * @param event
   */
  @FXML
  void imgPoster03Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', nowPlayingMovies.get(3).getId());
  }

  /**
   * Metodo que se ejecuta al hacer click en la imagen de la cartelera
   * @param event
   */
  @FXML
  void imgPoster10Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', nowPlayingMovies.get(4).getId());
  }

  /**
   * Metodo que se ejecuta al hacer click en la imagen de la cartelera
   *
   * @param event
   */
  @FXML
  void imgPoster11Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', nowPlayingMovies.get(5).getId());
  }

  /**
   * Metodo que se ejecuta al hacer click en la imagen de la cartelera
   * @param event
   */
  @FXML
  void imgPoster12Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', nowPlayingMovies.get(6).getId());
  }

  /**
   * Metodo que se ejecuta al hacer click en la imagen de la cartelera
   * @param event
   */
  @FXML
  void imgPoster13Pressed(MouseEvent event) {
    PaneSwitcher.switchToDetails("PaneDetalle", contentPane, 'm', nowPlayingMovies.get(7).getId());
  }

  /**
   * Metodo que se ejecuta al inicializar el controlador. Se ejecuta antes que el metodo
   */
  @FXML
  void initialize() {
    //    asignClickHandlers();
    Platform.runLater(this::fillInfo);
  }

  /** Asigna los click handlers a las imagenes de la cartelera */
  private void fillInfo() {
    List<ImageView> imageViews =
        List.of(
            imgPoster00,
            imgPoster01,
            imgPoster02,
            imgPoster03,
            imgPoster10,
            imgPoster11,
            imgPoster12,
            imgPoster13);
    List<Label> labelsTitulo =
        List.of(
            lblTitulo00,
            lblTitulo01,
            lblTitulo02,
            lblTitulo03,
            lblTitulo10,
            lblTitulo11,
            lblTitulo12,
            lblTitulo13);
    List<Label> labelsInfo =
        List.of(
            lblInfo00, lblInfo01, lblInfo02, lblInfo03, lblInfo10, lblInfo11, lblInfo12, lblInfo13);
    List<Label> labelsGenero =
        List.of(
            lblGenero00,
            lblGenero01,
            lblGenero02,
            lblGenero03,
            lblGenero10,
            lblGenero11,
            lblGenero12,
            lblGenero13);
    // Steamos imagenes
    String url = "https://image.tmdb.org/t/p/w500";
    imageViews.forEach(
        imageView -> {
          imageView.setImage(
              new Image(
                  url
                      + ListStorage.getNowPlayingMovies()
                          .get(imageViews.indexOf(imageView))
                          .getPoster_path()));
          nowPlayingMovies.add(
              ListStorage.getNowPlayingMovies().get(imageViews.indexOf(imageView)));
        });
    // Seteamos los titulos
    labelsTitulo.forEach(
        label -> {
          label.setText(
              ListStorage.getNowPlayingMovies().get(labelsTitulo.indexOf(label)).getTitle());
        });
    // Seteamos la info de las peliculas
    labelsInfo.forEach(
        label -> {
          label.setText(
              ListStorage.getNowPlayingMovies().get(labelsInfo.indexOf(label)).getOverview());
        });
    // Seteamos los generos
    for (Label lbl : labelsGenero) {
      int[] genres =
          ListStorage.getNowPlayingMovies().get(labelsGenero.indexOf(lbl)).getGenre_ids();
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
  }
}
