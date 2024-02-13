package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.Getter;
import lombok.Setter;
import service.APIService;
import service.dto.credits.Cast;
import service.dto.credits.Credits;
import service.dto.movie.MovieDetail;
import service.dto.tv.TVDetail;

public class PaneDetalleController {
  @Getter @Setter private static char type;
  @Getter @Setter private static int idWork;

  @FXML private ImageView imgPen;

  // Poster
  @FXML private ImageView imgPoster;

  @FXML private Label lblTitulo;
  // Formato subtitulo: 'Director · Genero'
  @FXML private Label lblSubtitulo;

  // Puntuación media usuarios
  @FXML private Label lblRating;

  // Bandera pais
  @FXML private ImageView imgPais;

  // Formato estrenoDuracion para series: 'Estreno · x temporadas' (1980 · 1h15min)
  @FXML private Label lblEstrenoDuracion;

  // Guardado en favoritos (corazon)
  @FXML private ImageView imgLike;

  // Plataformas de Streaming
  @FXML private ImageView imgNetflix;
  @FXML private ImageView imgHBO;
  @FXML private ImageView imgDisney;
  @FXML private ImageView imgPrimeVideo;
  @FXML private ImageView imgFilmin;
  @FXML private ImageView imgAppleTV;

  // Boton 'Añadir a...'
  @FXML private Button btnAdd;

  // Ver trailer
  @FXML private Button btnTrailer;

  // Puntuacion estrellas
  @FXML private ImageView imgStar1;
  @FXML private ImageView imgStar2;
  @FXML private ImageView imgStar3;
  @FXML private ImageView imgStar4;
  @FXML private ImageView imgStar5;

  @FXML private Label lblComentario;
  @FXML private Label lblFechaVista;

  // Sinopsis
  @FXML private Label lblTituloSinopsis;
  @FXML private Label lblSinopsis;

  // Imagenes del reparto
  @FXML private ImageView imgReparto1;
  @FXML private ImageView imgReparto2;
  @FXML private ImageView imgReparto3;
  @FXML private ImageView imgReparto4;

  // Actores y actrices de reparto (nombre y apellido)
  @FXML private Label lblReparto0;
  @FXML private Label lblReparto1;
  @FXML private Label lblReparto2;
  @FXML private Label lblReparto3;

  @FXML
  void btnAddPressed(ActionEvent event) {}

  /**
   * Redigire al trailer de la película o serie
   *
   * @param event
   */
  @FXML
  void btnTrailerPressed(ActionEvent event) {}

  /**
   * Permite al usuario agregar un comentario a la película
   *
   * @param event
   */
  @FXML
  void escribirComentario(MouseEvent event) {
    // TODO: no existe un textBox para recoger el comentario, lo hago mas adelante
  }

  /**
   * Guarda la puntuación seleccionada
   *
   * @param event
   */
  @FXML
  void changePuntuacionPressed(MouseEvent event) {}

  /**
   * Cambia el estado de like/unlike
   *
   * @param event
   */
  @FXML
  void imgLikePressed(MouseEvent event) {}

  @FXML
  void initialize() {
    Platform.runLater(() -> fillInfo(idWork));
  }

  public void fillInfo(int id) {
    if (type == 'm') {
      fillMovieInfo(id);
    } else {
      fillSerieInfo(id);
    }

  }

  private void fillSerieInfo(int id) {
    var apiService = new APIService();
    TVDetail detalles = apiService.getTVDetail(id);
    Credits creditos = apiService.getTVCredits(id);
    List<Cast> crew = Arrays.asList(creditos.getCrew());
    List<Cast> cast = Arrays.asList(creditos.getCast());
    var actores = new ArrayList<Cast>();
    for (int i = 0; i < 4; i++) {
      actores.add(cast.get(i));
    }
    lblTitulo.setText(detalles.getName());
    String genero = "";
    for (int i = 0; i < detalles.getGenres().length; i++) {
      if (i == detalles.getGenres().length - 1) {
        genero += detalles.getGenres()[i].getName();
      } else {
        genero += detalles.getGenres()[i].getName() + ", ";
      }
    }
    lblSubtitulo.setText(genero);
    lblRating.setText(String.valueOf(detalles.getVoteAverage()));
    // imgPais.setImage(detalles.getProductionCountries()[0].getName());
    lblEstrenoDuracion.setText(detalles.getFirstAirDate() + " - " + detalles.getNumberOfSeasons() + "temporadas");
    // imgLike.setImage();
    // imgNetflix.setImage();
    // imgHBO.setImage();
    // imgDisney.setImage();
    // imgPrimeVideo.setImage();
    // imgFilmin.setImage();
    // imgAppleTV.setImage();
    // imgStar1.setImage();
    // imgStar2.setImage();
    // imgStar3.setImage();
    // imgStar4.setImage();
    // imgStar5.setImage();
    // lblComentario.setText("");
    // lblFechaVista.setText("");
    lblTituloSinopsis.setText(detalles.getOverview());
    String url = "https://image.tmdb.org/t/p/w500";
    List<ImageView> imgReparto = (Arrays.asList(imgReparto1, imgReparto2, imgReparto3, imgReparto4));
    imgReparto.forEach(img -> img.setImage(new Image(url + actores.get(imgReparto.indexOf(img)).getProfilePath())));
List<Label> lblReparto = (Arrays.asList(lblReparto0, lblReparto1, lblReparto2, lblReparto3));
    lblReparto.forEach(lbl -> lbl.setText(actores.get(lblReparto.indexOf(lbl)).getName()));
  }

  private void fillMovieInfo(int id) {
    var apiService = new APIService();
    MovieDetail detalles = apiService.getMovieDetails(id);
    Credits creditos = apiService.getMovieCredits(id);
    List<Cast> crew = Arrays.asList(creditos.getCrew());
    var directores = new ArrayList<Cast>();
    for (Cast c : crew) {
      if (c.getJob().equals("Director")) {
        directores.add(c);
      }
    }
    List<Cast> cast = Arrays.asList(creditos.getCast());
    var actores = new ArrayList<Cast>();
    for (int i = 0; i < 4; i++) {
      actores.add(cast.get(i));
    }
    lblTitulo.setText(detalles.getTitle());
    String directorYGenero = "";
    for (int i = 0; i < directores.size(); i++) {
      if (i == directores.size() - 1) {
        directorYGenero += " - ";
      } else {
        directorYGenero += ", ";
      }
    }
    for (int i = 0; i < detalles.getGenres().length; i++) {
      if (i == detalles.getGenres().length - 1) {
        directorYGenero += detalles.getGenres()[i].getName();
      } else {
        directorYGenero += detalles.getGenres()[i].getName() + ", ";
      }
    }
    lblSubtitulo.setText(directorYGenero);
    lblRating.setText(String.valueOf(detalles.getVoteAverage()));
    // imgPais.setImage(detalles.getProductionCountries()[0].getName());
    lblEstrenoDuracion.setText(detalles.getReleaseDate() + " - " + detalles.getRuntime() + "min");
    // imgLike.setImage();
    // imgNetflix.setImage();
    // imgHBO.setImage();
    // imgDisney.setImage();
    // imgPrimeVideo.setImage();
    // imgFilmin.setImage();
    // imgAppleTV.setImage();
    // imgStar1.setImage();
    // imgStar2.setImage();
    // imgStar3.setImage();
    // imgStar4.setImage();
    // imgStar5.setImage();
    // lblComentario.setText("");
    // lblFechaVista.setText("");
    lblTituloSinopsis.setText(detalles.getOverview());
    String url = "https://image.tmdb.org/t/p/w500";
    List<ImageView> imgReparto =
            (Arrays.asList(imgReparto1, imgReparto2, imgReparto3, imgReparto4));
    imgReparto.forEach(
            img -> {
              img.setImage(new Image(url + actores.get(imgReparto.indexOf(img)).getProfilePath()));
            });
    List<Label> lblReparto = (Arrays.asList(lblReparto0, lblReparto1, lblReparto2, lblReparto3));
    lblReparto.forEach(
            lbl -> {
              lbl.setText(actores.get(lblReparto.indexOf(lbl)).getName());
            });
  }
}
