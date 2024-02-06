package controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import utils.PaneSwitcher;

public class PaneInicioController {

    @FXML
    private ImageView imgCartelera;

    @FXML
    private ImageView imgFavoritos;

    @FXML
    private ImageView imgFilmoteca;

    @FXML
    private ImageView imgInicio;

    @FXML
    private ImageView imgObra01;

    @FXML
    private ImageView imgObra2;

    @FXML
    private ImageView imgObra3;

    @FXML
    private ImageView imgObra4;

    @FXML
    private ImageView imgObra5;

    @FXML
    private ImageView imgObra6;

    @FXML
    private ImageView imgObra7;

    @FXML
    private ImageView imgObra8;

    @FXML
    private ImageView imgPeliculas;

    @FXML
    private ImageView imgProximamente;

    @FXML
    private ImageView imgSeries;
    
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
   

}
