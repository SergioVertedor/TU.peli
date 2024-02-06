package controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import utils.PaneSwitcher;

public class PaneInicioController {

    @FXML private ImageView imgCartelera;

    @FXML private ImageView imgFavoritos;

    @FXML private ImageView imgFilmoteca;

    @FXML private ImageView imgCentralInicio;

    @FXML private ImageView imgObra00;

    @FXML private ImageView imgObra01;

    @FXML private ImageView imgObra02;
    
    @FXML private ImageView imgObra03;
    
    @FXML private ImageView imgObra04;
    
    @FXML private ImageView imgObra05;
    
    @FXML private ImageView imgObra06;
    
    @FXML private ImageView imgObra07;

    @FXML private ImageView imgPeliculas;

    @FXML private ImageView imgProximamente;

    @FXML private ImageView imgSeries;
    
    // TODO: DECLARACION centralPane e imgSection del parent para cargar los distintos paneles
    // Puesto así ahora mismo para que no falle
    Pane centralPane; 
    ImageView imgSection;

    /**
     * Redirige la página hacia el apartado "Filmoteca"
     * @param event
     */
    @FXML
    void goToFilmoteca(MouseEvent event) {
    	PaneSwitcher.switchPane("PaneBusqueda", centralPane);
  		imgSection.setImage(new Image("images/sections/Filmoteca.png"));
  	}
    
    /**
     * Redirige la página hacia el apartado "Películas"
     * @param event
     */
    @FXML
    void goToPeliculas(MouseEvent event) {
    	PaneSwitcher.switchPane("PaneBusqueda", centralPane);
  		imgSection.setImage(new Image("images/sections/Peliculas.png"));
  	}
    
    /**
     * Redirige la página hacia el apartado "Series"
     * @param event
     */
    @FXML
    void goToSeries(MouseEvent event) {
  		PaneSwitcher.switchPane("PaneBusqueda", centralPane);
  		imgSection.setImage(new Image("images/sections/Series.png"));
  	}

    /**
     * Redirige la página hacia el apartado "Cartelera"
     * @param event
     */
    @FXML
    void goToCartelera(MouseEvent event) {
  		PaneSwitcher.switchPane("PaneCartelera", centralPane);
  		imgSection.setImage(new Image("images/sections/Cartelera.png"));
  	}

    /**
     * Redirige la página hacia el apartado "Proximamente"
     * @param event
     */
    @FXML
    void goToProximamente(MouseEvent event) {
  		PaneSwitcher.switchPane("PaneProximamente", centralPane);
  		imgSection.setImage(new Image("images/sections/Proximamente.png"));
  	}

    /**
     * Redirige la página hacia el apartado "Mis listas"
     * @param event
     */
    @FXML
    void goToMisListas(MouseEvent event) {
  		PaneSwitcher.switchPane("PaneMisListas", centralPane);
  		imgSection.setImage(new Image("images/sections/Favoritos.png"));
  	}

    // Redirige al titulo seleccionado en detalle
    @FXML
    void imgObraPressed(MouseEvent event) {
  		PaneSwitcher.switchPane("PaneMisListas", centralPane);
  		// If pelicula o serie
  		//imgSection.setImage(new Image("images/sections/Peliculas.png"));
  		//imgSection.setImage(new Image("images/sections/Series.png"));
  	}
    
    @FXML
    void initialize() {
    	imgFilmoteca.setImage(new Image("images/sections/Filmoteca.png"));
    	imgPeliculas.setImage(new Image("images/sections/Peliculas.png"));
    	imgSeries.setImage(new Image("images/sections/Series.png"));
    	imgCartelera.setImage(new Image("images/sections/Cartelera.png"));
    	imgProximamente.setImage(new Image("images/sections/Proximamente.png"));
    	imgFavoritos.setImage(new Image("images/sections/Favoritos.png"));
    	imgCentralInicio.setImage(new Image("images/sections/imgInicio.png"));
    	
    	// TODO: Cargar 8 peliculas en el inicio 'imgObra00'

    }
   

}
