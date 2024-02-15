package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;
import lombok.Setter;
import model.*;
import model.connector.HibernateUtils;
import model.dao.PeliculaImpl;
import model.dao.SerieDAOImpl;
import model.dao.WorkUserStorageImpl;
import org.jetbrains.annotations.NotNull;
import service.APIService;
import service.dto.credits.Cast;
import service.dto.credits.Credits;
import service.dto.movie.MovieDetail;
import service.dto.tv.TVDetail;
import utils.SessionHandler;

public class PaneDetalleController {
  @Getter @Setter private static char type;
  @Getter @Setter private static int idWork;
  private int totalEstrellas = 0;
  private Stage popupStage;
  private Storage device;
  private String deviceName;

  private TVDetail tvDetail;

  private MovieDetail movieDetails;

  // Botones
  @FXML private Button btnAdd;
  @FXML private Button btnTrailer;
  @FXML private Button btnGuardar;

  // Poster película
  @FXML private ImageView imgPoster;

  // Detalles pelicula/serie
  @FXML private Label lblSinopsis;
  @FXML private Label lblSubtitulo;
  @FXML private Label lblTitulo;
  @FXML private Label lblTituloSinopsis;
  @FXML private Label lblComentario;
  @FXML private Label lblEstrenoDuracion;
  @FXML private Label lblRating;

  // Reparto
  @FXML private Label lblReparto;
  @FXML private Label lblReparto0;
  @FXML private Label lblReparto1;
  @FXML private Label lblReparto2;
  @FXML private Label lblReparto3;

  // Imagenes reparto
  @FXML private ImageView imgReparto0;
  @FXML private ImageView imgReparto1;
  @FXML private ImageView imgReparto2;
  @FXML private ImageView imgReparto3;

  // Estrellas valoracion
  @FXML private ImageView imgStar1;
  @FXML private ImageView imgStar2;
  @FXML private ImageView imgStar3;
  @FXML private ImageView imgStar4;
  @FXML private ImageView imgStar5;

  // Plataformas streaming
  @FXML private ImageView streaming01;
  @FXML private ImageView streaming02;
  @FXML private ImageView streaming03;
  @FXML private ImageView streaming04;
  @FXML private ImageView streaming05;
  @FXML private ImageView streaming06;

  // Otras imágenes
  @FXML private ImageView imgLike;
  @FXML private ImageView imgPen;

  // Última vez vista
  @FXML private DatePicker datePicker;

  /**
   * Devuelve la fecha seleccionada en el DatePicker.
   *
   * @return La fecha seleccionada como una cadena.
   */
  private String getDateVista() {
    LocalDate selectedDate = datePicker.getValue();
    if (selectedDate != null) {
      return selectedDate.toString();
    } else {
      return LocalDate.now().toString();
    }
  }

  /** Método que obtiene el dispositivo seleccionado */
  private final EventHandler<MouseEvent> selectedHandler =
      event -> {
        Node source = (Node) event.getSource();
        if (source instanceof Label) {
          Label dispositivoSeleccionado = (Label) source;
          deviceName = dispositivoSeleccionado.getText();
          popupStage.close();
        }
      };

  private void mostrarMenuDispositivos() {
    popupStage = new Stage();
    popupStage.initModality(Modality.APPLICATION_MODAL);
    popupStage.initStyle(StageStyle.UTILITY);
    popupStage.setTitle("Añadir a dispositivo");

    VBox popupContent = new VBox();

    // Lista de dispositivos
    List<Label> dispositivos = new ArrayList<>();
    // Datos ejemplo
    SessionHandler.getAppUser()
        .getStorages()
        .forEach(
            storage -> {
              Label label = new Label(storage.getStorageName());
              popupContent.getChildren().add(label);
              label.setOnMouseClicked(selectedHandler);
            });
    Scene popupScene = new Scene(popupContent, 400, 200);
    popupStage.setScene(popupScene);
    popupStage.centerOnScreen();
    popupStage.show();
  }

  @FXML
  void savePressed(Event event) {
    boolean fav;
    int valoracion;
    String comentario;
    String fechaVista;

    if (imgLike.getImage().getUrl().contains("likeSelected")) {
      fav = true;
    } else {
      fav = false;
    }
    valoracion = totalEstrellas;
    comentario = lblComentario.getText();
    fechaVista = getDateVista();
    SessionHandler.getAppUser()
        .getStorages()
        .forEach(
            storage -> {
              if (storage.getStorageName().equals(deviceName)) {
                device = storage;
              }
            });

    Pelicula work = null;
    Serie serie = null;
    if (type == 'm') {
      work =
          new Pelicula(
              movieDetails.getTitle(),
              movieDetails.getRelease_date(),
              Integer.parseInt(String.valueOf(movieDetails.getRuntime())),
              lblSinopsis.getText(),
              movieDetails.getBackdrop_path(),
              movieDetails.getPoster_path(),
              Double.parseDouble(lblRating.getText()),
              LocalDate.now(),
              "",
              "");
      PeliculaImpl peliculaImpl = new PeliculaImpl(HibernateUtils.getSession());
      peliculaImpl.insert(work);
      peliculaImpl.update(work);
      WorkUserStorageId id = new WorkUserStorageId(work, SessionHandler.getAppUser(), device);
      WorkUserStorage workUserStorage =
          new WorkUserStorage(id, valoracion, comentario, true, fav, fechaVista);
      WorkUserStorageImpl workUserStorageImpl =
          new WorkUserStorageImpl(HibernateUtils.getSession());
      workUserStorageImpl.insert(workUserStorage);
      workUserStorageImpl.update(workUserStorage);
    } else if (type == 't') {
      serie = getSerie();
      SerieDAOImpl serieImpl = new SerieDAOImpl(HibernateUtils.getSession());

      serieImpl.insert(serie);
      serieImpl.update(serie);
    }
    WorkUserStorageId id = new WorkUserStorageId(serie, SessionHandler.getAppUser(), device);
    WorkUserStorage workUserStorage =
        new WorkUserStorage(id, valoracion, comentario, true, fav, fechaVista);
    WorkUserStorageImpl workUserStorageImpl = new WorkUserStorageImpl(HibernateUtils.getSession());
    workUserStorageImpl.insert(workUserStorage);
    workUserStorageImpl.update(workUserStorage);
  }

  @NotNull
  private Serie getSerie() {
    Serie serie;
    serie =
        new Serie(
            tvDetail.getName(),
            tvDetail.getFirst_air_date(),
            Integer.parseInt(String.valueOf(tvDetail.getEpisode_run_time()[0])),
            tvDetail.getOverview(),
            tvDetail.getBackdrop_path(),
            tvDetail.getPoster_path(),
            tvDetail.getVote_average(),
            null,
            "",
            "",
            null,
            null,
            null);
    return serie;
  }

  @FXML
  void btnGuardarPressed(ActionEvent event) {}

  /**
   * 'Añadir a'
   *
   * @param event
   */
  @FXML
  void btnAddPressed(ActionEvent event) {
    mostrarMenuDispositivos();
  }

  @FXML
  void btnTrailerPressed(ActionEvent event) {}

  @FXML
  void changePuntuacionPressed(MouseEvent event) {}

  @FXML
  void escribirComentario(MouseEvent event) {}

  @FXML
  void changePuntuacionPressed00(MouseEvent event) {
    clearStars();
    List<ImageView> estrellas = Arrays.asList(imgStar1, imgStar2, imgStar3, imgStar4, imgStar5);
    for (int i = 0; i < estrellas.size(); i++) {
      if (i <= 0) {
        if (estrellas.get(i).getImage().getUrl().contains("favUnselected"))
          estrellas.get(i).setImage(new Image("/images/others/favSelected.png"));
        totalEstrellas = 1;
      } else {
        if (estrellas.get(i).getImage().getUrl().contains("favSelected"))
          estrellas.get(i).setImage(new Image("/images/others/favUnselected.png.png"));
      }
    }
  }

  @FXML
  void changePuntuacionPressed01(MouseEvent event) {
    clearStars();
    List<ImageView> estrellas = Arrays.asList(imgStar1, imgStar2, imgStar3, imgStar4, imgStar5);
    for (int i = 0; i < estrellas.size(); i++) {
      if (i <= 1) {
        if (estrellas.get(i).getImage().getUrl().contains("favUnselected"))
          estrellas.get(i).setImage(new Image("/images/others/favSelected.png"));
        totalEstrellas = 2;
      } else {
        if (estrellas.get(i).getImage().getUrl().contains("favSelected"))
          estrellas.get(i).setImage(new Image("/images/others/favUnselected.png.png"));
      }
    }
  }

  @FXML
  void changePuntuacionPressed02(MouseEvent event) {
    clearStars();
    List<ImageView> estrellas = Arrays.asList(imgStar1, imgStar2, imgStar3, imgStar4, imgStar5);
    for (int i = 0; i < estrellas.size(); i++) {
      if (i <= 2) {
        if (estrellas.get(i).getImage().getUrl().contains("favUnselected"))
          estrellas.get(i).setImage(new Image("/images/others/favSelected.png"));
        totalEstrellas = 3;
      } else {
        if (estrellas.get(i).getImage().getUrl().contains("favSelected"))
          estrellas.get(i).setImage(new Image("/images/others/favUnselected.png.png"));
      }
    }
  }

  @FXML
  void changePuntuacionPressed03(MouseEvent event) {
    clearStars();
    List<ImageView> estrellas = Arrays.asList(imgStar1, imgStar2, imgStar3, imgStar4, imgStar5);
    for (int i = 0; i < estrellas.size(); i++) {
      if (i <= 3) {
        if (estrellas.get(i).getImage().getUrl().contains("favUnselected"))
          estrellas.get(i).setImage(new Image("/images/others/favSelected.png"));
        totalEstrellas = 4;
      } else {
        if (estrellas.get(i).getImage().getUrl().contains("favSelected"))
          estrellas.get(i).setImage(new Image("/images/others/favUnselected.png.png"));
      }
    }
  }

  @FXML
  void changePuntuacionPressed04(MouseEvent event) {
    clearStars();
    List<ImageView> estrellas = Arrays.asList(imgStar1, imgStar2, imgStar3, imgStar4, imgStar5);
    for (int i = 0; i < estrellas.size(); i++) {
      if (i <= 4) {
        if (estrellas.get(i).getImage().getUrl().contains("favUnselected"))
          estrellas.get(i).setImage(new Image("/images/others/favSelected.png"));
        totalEstrellas = 5;
      } else {
        if (estrellas.get(i).getImage().getUrl().contains("favSelected"))
          estrellas.get(i).setImage(new Image("/images/others/favUnselected.png.png"));
      }
    }
  }

  @FXML
  void favouritePressed(MouseEvent event) {
    if (imgLike.getImage().getUrl().contains("likeUnselected")) {
      imgLike.setImage(new Image("/images/others/likeSelected.png"));
    } else imgLike.setImage(new Image("/images/others/likeUnselected.png"));
  }

  @FXML
  void initialize() {
    datePicker.setValue(LocalDate.now());
  }

  public void fillUserPreferences() {
    // TODO
  }

  private void clearStars() {
    List<ImageView> estrellas = Arrays.asList(imgStar1, imgStar2, imgStar3, imgStar4, imgStar5);
    estrellas.forEach(
        estrella -> {
          if (estrella.getImage().getUrl().contains("favSelected")) {
            estrella.setImage(new Image("/images/others/favUnselected.png"));
          }
        });
  }

  public void fillInfo(int id) {
    if (type == 'm') {
      Platform.runLater(() -> fillMovieInfo(id));
    } else {
      Platform.runLater(() -> fillSerieInfo(id));
    }
  }

  private void fillSerieInfo(int id) {
    var apiService = new APIService();
    tvDetail = apiService.getTVDetail(id);
    Credits creditos = apiService.getTVCredits(id);
    List<Cast> cast = Arrays.asList(creditos.getCast());

    // TITULO
    lblTitulo.setText(tvDetail.getName());
    String directorYGenero = "";
    for (int i = 0; i < tvDetail.getGenres().length; i++) {
      if (i == tvDetail.getGenres().length - 1) {
        directorYGenero += tvDetail.getGenres()[i].getName();
      } else {
        directorYGenero += tvDetail.getGenres()[i].getName() + ", ";
      }
    }
    // SUBTITULO
    lblSubtitulo.setText(directorYGenero);

    // RATING
    lblRating.setText(String.format("%.1f", tvDetail.getVote_average()));

    // ESTRENO Y DURACION
    try {
      lblEstrenoDuracion.setText(
          tvDetail.getFirst_air_date() + " - " + tvDetail.getEpisode_run_time()[0] + "min");
    } catch (Exception e) {
      lblEstrenoDuracion.setText(tvDetail.getFirst_air_date().toString());
    }
    // imgStar1.setImage();
    // imgStar2.setImage();
    // imgStar3.setImage();
    // imgStar4.setImage();
    // imgStar5.setImage();
    // lblComentario.setText("");
    // lblFechaVista.setText("");

    // SINOPSIS
    lblSinopsis.setText(tvDetail.getOverview());
    String url = "https://image.tmdb.org/t/p/w500";

    // IMAGENES
    imgPoster.setImage(new Image(url + tvDetail.getPoster_path()));
    List<ImageView> imgReparto =
        (Arrays.asList(imgReparto0, imgReparto1, imgReparto2, imgReparto3));
    imgReparto.forEach(
        img -> {
          try {
            if (Optional.ofNullable(cast.get(imgReparto.indexOf(img))).isEmpty()) {
              img.setVisible(false);
            } else {
              img.setImage(new Image(url + cast.get(imgReparto.indexOf(img)).getProfile_path()));
            }
          } catch (Exception e) {
            img.setVisible(false);
          }
        });
    List<Label> lblReparto = (Arrays.asList(lblReparto0, lblReparto1, lblReparto2, lblReparto3));
    lblReparto.forEach(
        lbl -> {
          lbl.setText(cast.get(lblReparto.indexOf(lbl)).getName());
        });
    /**
     * List<ImageView> streamingIcon = (Arrays.asList( streaming01, streaming02, streaming03,
     * streaming04, streaming05, streaming06)); WatchProvider streaming =
     * apiService.getMovieWatchProviders(id); List<Flatrate> proveedores =
     * Arrays.asList(streaming.getResults()[0].getFlatrate()); ; final String urlOriginalSize =
     * "https://image.tmdb.org/t/p/original"; try { proveedores.forEach( proveedor -> {
     * streamingIcon .get(proveedores.indexOf(proveedor)) .setImage(new Image(urlOriginalSize +
     * proveedor.getLogo_path())); }); } catch (Exception e) {
     *
     * <p>}*
     */
  }

  private void fillMovieInfo(int id) {
    var apiService = new APIService();
    movieDetails = apiService.getMovieDetails(id);
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
      if (cast.isEmpty()) {
        break;
      }
      actores.add(cast.get(i));
    }
    // TITULO
    lblTitulo.setText(movieDetails.getTitle());
    String directorYGenero = "";
    for (int i = 0; i < directores.size(); i++) {
      if (i == directores.size() - 1) {
        directorYGenero += directores.get(i).getName() + " - ";
      } else {
        directorYGenero += directores.get(i).getName() + ", ";
      }
    }
    for (int i = 0; i < movieDetails.getGenres().length; i++) {
      if (i == movieDetails.getGenres().length - 1) {
        directorYGenero += movieDetails.getGenres()[i].getName();
      } else {
        directorYGenero += movieDetails.getGenres()[i].getName() + ", ";
      }
    }
    // SUBTITULO
    lblSubtitulo.setText(directorYGenero);

    // RATING
    lblRating.setText(String.format("%.1f", movieDetails.getVote_average()));

    // ESTRENO Y DURACION
    lblEstrenoDuracion.setText(
        movieDetails.getRelease_date() + " - " + movieDetails.getRuntime() + "min");
    // imgStar1.setImage();
    // imgStar2.setImage();
    // imgStar3.setImage();
    // imgStar4.setImage();
    // imgStar5.setImage();
    // lblComentario.setText("");
    // lblFechaVista.setText("");

    // SINOPSIS
    lblSinopsis.setText(movieDetails.getOverview());
    String url = "https://image.tmdb.org/t/p/w500";

    // IMAGENES

    if (movieDetails.getPoster_path() == null) {
      imgPoster.setVisible(false);
    } else {
      imgPoster.setImage(new Image(url + movieDetails.getPoster_path()));
    }
    List<ImageView> imgReparto =
        (Arrays.asList(imgReparto0, imgReparto1, imgReparto2, imgReparto3));
    imgReparto.forEach(
        img -> {
          if (actores.isEmpty()) {
            img.setVisible(false);
          } else {
            img.setImage(new Image(url + actores.get(imgReparto.indexOf(img)).getProfile_path()));
          }
        });
    List<Label> lblReparto = (Arrays.asList(lblReparto0, lblReparto1, lblReparto2, lblReparto3));
    lblReparto.forEach(
        lbl -> {
          if (actores.isEmpty()) {
            lbl.setVisible(false);
          } else {
            lbl.setText(actores.get(lblReparto.indexOf(lbl)).getName());
          }
        });
    List<ImageView> streamingIcon =
        (Arrays.asList(
            streaming01, streaming02, streaming03, streaming04, streaming05, streaming06));

    if(this.movieDetails.getTitle().equals(PeliculaImpl.getMovieTitle(id))) {
      this.movieDetails = PeliculaImpl.getMovie(id);
    }
    /**
     * WatchProvider streaming = apiService.getMovieWatchProviders(id); for (int i = 0; i <
     * streamingIcon.size(); i++) { try { if (i <
     * streaming.getResults().getEs().getFlatrate().length) { streamingIcon .get(i) .setImage( new
     * Image(url + streaming.getResults().getEs().getFlatrate()[i].getLogo_path())); } else {
     * streamingIcon.get(i).setVisible(false); } } catch (Exception e) {
     * streamingIcon.get(i).setVisible(false); } }*
     */
  }
}
