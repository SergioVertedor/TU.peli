package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import utils.PaneSwitcher;

public class PantallaModeloController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView btnBuscar;

	@FXML
	private Pane centralPane;

	@FXML
	private ImageView imgClose;

	@FXML
	private ImageView imgLogo;

	@FXML
	private ImageView imgSection;

	@FXML
	private ImageView imgUser;

	@FXML
	private Label lblCartelera;

	@FXML
	private Label lblCerrarSesion;

	@FXML
	private Label lblFilmoteca;

	@FXML
	private Label lblInicio;

	@FXML
	private Label lblMisListas;

	@FXML
	private Label lblPeliculas;

	@FXML
	private Label lblProximamente;

	@FXML
	private Label lblSeries;

	@FXML
	private Label lblTopPeliculas;

	@FXML
	private Label lblTopSeries;

	@FXML
	private Label lblUserName1;

	@FXML
	private Pane paneContent;

	@FXML
	private GridPane paneHeader;

	@FXML
	private TextField txtBusqueda;

	@FXML
	void btnBuscarPressed(MouseEvent event) {
	}

	//goToPerfilUsuario
	@FXML
	void imgUserPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneUsuario", centralPane);
		// TODO: que no se vea la imagen de section
	}

	@FXML
	void cerrarSesionPressed(MouseEvent event) {
	}

	// goToInicio REPETIDO
	@FXML
	void lblInicioPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneInicio", centralPane);
		// TODO: que no se vea la imagen de section
	}

	// goToFilmoteca
	@FXML
	void lblFilmotecaPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
		imgSection.setImage(new Image("images/sections/Filmoteca.png"));
	}

	// goToPeliculas
	@FXML
	void lblPeliculasPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
		imgSection.setImage(new Image("images/sections/Peliculas.png"));
	}

	// goToSeries
	@FXML
	void lblSeriesPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
		imgSection.setImage(new Image("images/sections/Series.png"));
	}

	// goToTopPeliculas
	@FXML
	void lblTopPeliculasPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneTop", centralPane);
		imgSection.setImage(new Image("images/sections/Peliculas.png"));
	}

	// goToTopSeries
	@FXML
	void lblTopSeriesPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneTop", centralPane);
		imgSection.setImage(new Image("images/sections/Series.png"));
	}

	// goToCartelera
	@FXML
	void lblCarteleraPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneCartelera", centralPane);
		imgSection.setImage(new Image("images/sections/Cartelera.png"));
	}

	// goToProximamente
	@FXML
	void lblProximamentePressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneProximamente", centralPane);
		imgSection.setImage(new Image("images/sections/Proximamente.png"));
	}

	// goToMisListas
	@FXML
	void lblMisListasPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneMisListas", centralPane);
		imgSection.setImage(new Image("images/sections/Favoritos.png"));
	}

	// goToInicio REPETIDO
	@FXML
	void logoPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneInicio", centralPane);
		// TODO: que no se vea la imagen de section
	}

	// goToPerfilUsuario REPETIDO
	@FXML
	void usernamePressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneUsuario", centralPane);
		// TODO: que no se vea la imagen de section
	}

	@FXML
	void initialize() {
		PaneSwitcher.switchPane("PaneInicio", centralPane);
		imgLogo.setImage(new Image("images/logo/logo.png"));
		imgUser.setImage(new Image("images/user.png"));
	}
}
