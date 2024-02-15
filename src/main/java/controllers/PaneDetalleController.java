package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.VBox;

public class PaneDetalleController {
  @Getter @Setter private static char type;
  @Getter @Setter private static int idWork;

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
   * Devuelve la decha seleccionda en datePciker
   */
	private String getDateVista() {
		datePicker.setOnAction(event -> {
			return datePicker.getValue().toString();
		});
	}
  

	private void mostrarMenuDispositivos() {
		Stage popupStage = new Stage();
		popupStage.initModality(Modality.APPLICATION_MODAL);
		popupStage.initStyle(StageStyle.UTILITY);
		popupStage.setTitle("Añadir a dispositivo");

		VBox popupContent = new VBox();

		// Lista de dispositivos
		List<Label> dispositivos = new ArrayList<>();
		// Datos ejemplo
		dispositivos.add(new Label("Dispositivo 1"));
		dispositivos.add(new Label("Dispositivo 2"));
		dispositivos.add(new Label("Dispositivo 3"));

		for (Label label : dispositivos) {
			popupContent.getChildren().add(label);
		}

		Scene popupScene = new Scene(popupContent, 400, 200);
		popupStage.setScene(popupScene);
		popupStage.centerOnScreen();
		popupStage.show();
	}

  
  @FXML
  void btnGuardarPressed(ActionEvent event) {

  }

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
    TVDetail detalles = apiService.getTVDetail(id);
    Credits creditos = apiService.getTVCredits(id);
    List<Cast> cast = Arrays.asList(creditos.getCast());

    // TITULO
    lblTitulo.setText(detalles.getName());
    String directorYGenero = "";
    for (int i = 0; i < detalles.getGenres().length; i++) {
      if (i == detalles.getGenres().length - 1) {
        directorYGenero += detalles.getGenres()[i].getName();
      } else {
        directorYGenero += detalles.getGenres()[i].getName() + ", ";
      }
    }
    // SUBTITULO
    lblSubtitulo.setText(directorYGenero);

    // RATING
    lblRating.setText(String.format("%.1f", detalles.getVote_average()));

    // ESTRENO Y DURACION
    try {
      lblEstrenoDuracion.setText(
          detalles.getFirst_air_date() + " - " + detalles.getEpisode_run_time()[0] + "min");
    } catch (Exception e) {
      lblEstrenoDuracion.setText(detalles.getFirst_air_date().toString());
    }
    // imgStar1.setImage();
    // imgStar2.setImage();
    // imgStar3.setImage();
    // imgStar4.setImage();
    // imgStar5.setImage();
    // lblComentario.setText("");
    // lblFechaVista.setText("");

    // SINOPSIS
    lblSinopsis.setText(detalles.getOverview());
    String url = "https://image.tmdb.org/t/p/w500";

    // IMAGENES
    imgPoster.setImage(new Image(url + detalles.getPoster_path()));
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
      if (cast.isEmpty()) {
        break;
      }
      actores.add(cast.get(i));
    }
    // TITULO
    lblTitulo.setText(detalles.getTitle());
    String directorYGenero = "";
    for (int i = 0; i < directores.size(); i++) {
      if (i == directores.size() - 1) {
        directorYGenero += directores.get(i).getName() + " - ";
      } else {
        directorYGenero += directores.get(i).getName() + ", ";
      }
    }
    for (int i = 0; i < detalles.getGenres().length; i++) {
      if (i == detalles.getGenres().length - 1) {
        directorYGenero += detalles.getGenres()[i].getName();
      } else {
        directorYGenero += detalles.getGenres()[i].getName() + ", ";
      }
    }
    // SUBTITULO
    lblSubtitulo.setText(directorYGenero);

    // RATING
    lblRating.setText(String.format("%.1f", detalles.getVote_average()));

    // ESTRENO Y DURACION
    lblEstrenoDuracion.setText(detalles.getRelease_date() + " - " + detalles.getRuntime() + "min");
    // imgStar1.setImage();
    // imgStar2.setImage();
    // imgStar3.setImage();
    // imgStar4.setImage();
    // imgStar5.setImage();
    // lblComentario.setText("");
    // lblFechaVista.setText("");

    // SINOPSIS
    lblSinopsis.setText(detalles.getOverview());
    String url = "https://image.tmdb.org/t/p/w500";

    // IMAGENES

    if (detalles.getPoster_path() == null) {
      imgPoster.setVisible(false);
    } else {
      imgPoster.setImage(new Image(url + detalles.getPoster_path()));
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
