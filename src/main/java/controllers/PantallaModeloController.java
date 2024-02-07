package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import thread.WorkerApiLoader;
import utils.*;

public class PantallaModeloController {

	// Panel central de carga
	@FXML	private Pane centralPane;
	
	// Otros paneles
	@FXML	private Pane paneContent;
	@FXML	private GridPane paneHeader;
	
	// Logo TU.PELI
	@FXML	private ImageView imgLogo;
	
	// ImageView para la sección seleccionada
	@FXML	private ImageView imgSection;

	// Nombre e imagen de perfil del usuario
	@FXML	private ImageView imgUser;
	@FXML	private Label lblUserName;
	
	// ELementos de búsqueda
	@FXML	private TextField txtBusqueda;
	@FXML	private ImageView btnBuscar;

	// Cerrar sesión
	@FXML	private ImageView imgClose;
	@FXML	private Label lblCerrarSesion;
	
	// Secciones barra menú 
	@FXML	private Label lblInicio;
	@FXML	private Label lblFilmoteca;
	@FXML	private Label lblPeliculas;
	@FXML	private Label lblSeries;
	@FXML	private Label lblTopPeliculas;
	@FXML	private Label lblTopSeries;
	@FXML	private Label lblCartelera;
	@FXML	private Label lblProximamente;
	@FXML	private Label lblMisListas;


	/**
	 * Genera una búsqueda con el texto insertado en txtBusqueda
	 * @param event
	 */
	@FXML
	void btnBuscarPressed(MouseEvent event) {
		PaneSwitcher.switchPane("PaneBusqueda", paneContent);
		imgSection.setImage(new Image("images/sections/Filmoteca.png"));
	}

	/**
	 * Cierra la sesión para el usuario activo
	 * @param event
	 */
	@FXML
	void cerrarSesionPressed(MouseEvent event) {
		var sw = new SceneSwitcher();
		try {
			PropertiesManager.setRememberLogin("0");
			SessionHandler.setAppUser(null);
			var dn = new DialogNotificator();
			dn.logoutNotification();
			sw.switchScene("PantallaLogin");
		} catch (IOException e) {
			System.out.println("Error al cargar la ventana de inicio de sesión");
		}
	}

	/**
	 * Navega al panel "Filmoteca"
	 * @param event
	 */
	@FXML
	void goToFilmoteca(MouseEvent event) {
		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
		imgSection.setImage(new Image("images/sections/Filmoteca.png"));
	}

	/**
	 * Navega al panel "Películas"
	 * @param event
	 */
	@FXML
	void goToPeliculas(MouseEvent event) {
		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
		imgSection.setImage(new Image("images/sections/Peliculas.png"));
		// TODO: Mostrar solo peliculas
	}

	/**
	 * Navega al panel "Series"
	 * @param event
	 */
	@FXML
	void goToSeries(MouseEvent event) {
		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
		imgSection.setImage(new Image("images/sections/Series.png"));
	// TODO: Mostrar solo series
	}

	/**
	 * Navega al panel "Top Películas"
	 * @param event
	 */
	@FXML
	void goToTopPeliculas(MouseEvent event) {
		PaneSwitcher.switchPane("PaneTop", centralPane);
		imgSection.setImage(new Image("images/sections/Peliculas.png"));
	}

	/**
	 * Navega al panel "Top Series"
	 * @param event
	 */
	@FXML
	void goToTopSeries(MouseEvent event) {
		PaneSwitcher.switchPane("PaneTop", centralPane);
		imgSection.setImage(new Image("images/sections/Series.png"));
	}

	/**
	 * Navega al panel "Cartelera"
	 * @param event
	 */
	@FXML
	void goToCartelera(MouseEvent event) {
		PaneSwitcher.switchPane("PaneCartelera", centralPane);
		imgSection.setImage(new Image("images/sections/Cartelera.png"));
	}

	/**
	 * Navega al panel "Próximamente"
	 * @param event
	 */
	@FXML
	void goToProximamente(MouseEvent event) {
		PaneSwitcher.switchPane("PaneProximamente", centralPane);
		imgSection.setImage(new Image("images/sections/Proximamente.png"));
	}

	/**
	 * Navega al panel "Mis Listas"
	 * @param event
	 */
	@FXML
	void goToMisListas(MouseEvent event) {
		PaneSwitcher.switchPane("PaneMisListas", centralPane);
		imgSection.setImage(new Image("images/sections/Favoritos.png"));
	}

	/**
	 * Navega al panel "Inicio"
	 * @param event
	 */
	@FXML
	void goToInicio(MouseEvent event) {
		PaneSwitcher.switchPane("PaneInicio", centralPane);
		// TODO: que no se vea la imagen de section
		
	}

	/**
	 * Navega al panel "Usuario"
	 * @param event
	 */
	@FXML
	void goToUserProfile(MouseEvent event) {
		PaneSwitcher.switchPane("PaneUsuario", centralPane);
		// TODO: que no se vea la imagen de section
	}

	@FXML
	void initialize() throws InterruptedException {
		PaneSwitcher.switchPane("PaneInicio", centralPane);
		imgLogo.setImage(new Image("images/logo/logo.png"));
		imgUser.setImage(new Image("images/user.png"));
		var workerThread = new WorkerApiLoader();
		workerThread.start();
	}



}
