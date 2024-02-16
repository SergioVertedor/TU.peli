package controllers;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;
import model.WorkUserStorage;
import model.connector.HibernateUtils;
import model.dao.WorkUserStorageImpl;
import utils.PaneSwitcher;

public class PaneMisListasController {

  @Getter @Setter private Pane centralPane;

  // Imagenes Añadidas Recientemente
  @FXML private ImageView imgReciente00;
  @FXML private ImageView imgReciente01;
  @FXML private ImageView imgReciente02;
  @FXML private ImageView imgReciente03;
  @FXML private ImageView imgReciente04;
  @FXML private ImageView imgReciente05;
  @FXML private ImageView imgReciente06;
  @FXML private ImageView imgReciente07;
  @FXML private ImageView imgReciente08;
  @FXML private ImageView imgReciente09;
  @FXML private ImageView imgReciente10;
  @FXML private ImageView imgReciente11;
  @FXML private ImageView imgReciente12;
  @FXML private ImageView imgReciente13;

  // Imagenes Mis Peliculas
  @FXML private ImageView imgPelicula00;
  @FXML private ImageView imgPelicula01;
  @FXML private ImageView imgPelicula02;
  @FXML private ImageView imgPelicula03;
  @FXML private ImageView imgPelicula04;
  @FXML private ImageView imgPelicula05;
  @FXML private ImageView imgPelicula06;

  // Titulos Mis Peliculas
  @FXML private Label tituloPelicula00;
  @FXML private Label tituloPelicula01;
  @FXML private Label tituloPelicula02;
  @FXML private Label tituloPelicula03;
  @FXML private Label tituloPelicula04;
  @FXML private Label tituloPelicula05;
  @FXML private Label tituloPelicula06;

  // Director Mis Peliculas
  @FXML private Label directorPelicula00;
  @FXML private Label directorPelicula01;
  @FXML private Label directorPelicula02;
  @FXML private Label directorPelicula03;
  @FXML private Label directorPelicula04;
  @FXML private Label directorPelicula05;
  @FXML private Label directorPelicula06;

  // Imagenes Mis Series
  @FXML private ImageView imgSerie00;
  @FXML private ImageView imgSerie01;
  @FXML private ImageView imgSerie02;
  @FXML private ImageView imgSerie03;
  @FXML private ImageView imgSerie04;
  @FXML private ImageView imgSerie05;
  @FXML private ImageView imgSerie06;

  // Titulos Mis Series
  @FXML private Label tituloSerie00;
  @FXML private Label tituloSerie01;
  @FXML private Label tituloSerie03;
  @FXML private Label tituloSerie02;
  @FXML private Label tituloSerie04;
  @FXML private Label tituloSerie05;
  @FXML private Label tituloSerie06;

  // Temporadas Mis Series
  @FXML private Label temporadasSerie00;
  @FXML private Label temporadasSerie01;
  @FXML private Label temporadasSerie02;
  @FXML private Label temporadasSerie03;
  @FXML private Label temporadasSerie04;
  @FXML private Label temporadasSerie05;
  @FXML private Label temporadasSerie06;

  // Imagenes Favoritos
  @FXML private ImageView imgFav00;
  @FXML private ImageView imgFav01;
  @FXML private ImageView imgFav02;
  @FXML private ImageView imgFav03;
  @FXML private ImageView imgFav04;
  @FXML private ImageView imgFav05;
  @FXML private ImageView imgFav06;

  // Titulos Favoritos
  @FXML private Label tituloFav00;
  @FXML private Label tituloFav01;
  @FXML private Label tituloFav02;
  @FXML private Label tituloFav03;
  @FXML private Label tituloFav04;
  @FXML private Label tituloFav05;
  @FXML private Label tituloFav06;

  // Subtitulo Favoritos
  // Películas: Director
  // series: x temporadas
  @FXML private Label subtituloFav00;
  @FXML private Label subtituloFav01;
  @FXML private Label subtituloFav02;
  @FXML private Label subtituloFav03;
  @FXML private Label subtituloFav04;
  @FXML private Label subtituloFav05;
  @FXML private Label subtituloFav06;

  // Ver más
  @FXML private Label lblVerMasFavoritos;
  @FXML private Label lblVerMasPeliculas;
  @FXML private Label lblVerMasSeries;

  @FXML
  void addMisPeliculasPressed(MouseEvent event) {
    // NO SE PORQUE PERO NO FURULA
    // Cannot invoke "javafx.scene.layout.Pane.getChildren()" because "centralPane" is null
    PaneSwitcher.switchToNueva("PaneNueva", centralPane);
  }

  @FXML
  void addMisSeriesPressed(MouseEvent event) {
    // NO SE PORQUE PERO NO FURULA
    // Cannot invoke "javafx.scene.layout.Pane.getChildren()" because "centralPane" is null
    PaneSwitcher.switchToNueva("PaneNueva", centralPane);
  }

  /**
   * Te redirige al detalle de la película o serie
   *
   * @param event
   */
  @FXML
  void goToTitulo(MouseEvent event) {}

  /**
   * Ver todas Mis Películas
   *
   * @param event
   */
  @FXML
  void verTodasMisPeliculas(MouseEvent event) {
    // TODO: Para el futuro
  }

  /**
   * Ver todas Mis Series
   *
   * @param event
   */
  @FXML
  void verTodasMisSeries(MouseEvent event) {
    // TODO: Para el futuro
  }

  /**
   * Ver todos Mis Favoritos
   *
   * @param event
   */
  @FXML
  void verTodosMisFavoritos(MouseEvent event) {
    // TODO: Para el futuro
  }

  @FXML
  void initialize() {
    ;
    fillContent();
  }

  private void fillContent() {
    WorkUserStorageImpl workUserStorage = new WorkUserStorageImpl(HibernateUtils.getSession());
    List<WorkUserStorage> listas = workUserStorage.searchAll();
    if (!listas.isEmpty()) {
      fillFavourites(listas);
      fillMovies(listas);
      fillSeries(listas);
      fillRecents(listas);
    }
  }

  private void fillRecents(List<WorkUserStorage> listas) {}

  private void fillSeries(List<WorkUserStorage> listas) {
    List<ImageView> imgSeries =
        List.of(imgSerie00, imgSerie01, imgSerie02, imgSerie03, imgSerie04, imgSerie05, imgSerie06);
    List<Label> tituloSeries =
        List.of(
            tituloSerie00,
            tituloSerie01,
            tituloSerie02,
            tituloSerie03,
            tituloSerie04,
            tituloSerie05,
            tituloSerie06);
  }

  private void fillMovies(List<WorkUserStorage> listas) {}

  private void fillFavourites(List<WorkUserStorage> listas) {}
}
