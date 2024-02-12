package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PaneCartelera {

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
     * Asigna el mismo manejador de eventos a todos los ImageViews
     */
    void asignClickHandlers() {
    	setClickHandler(imgPoster00);
    	setClickHandler(imgPoster01);
    	setClickHandler(imgPoster02);
    	setClickHandler(imgPoster03);
    	setClickHandler(imgPoster10);
    	setClickHandler(imgPoster11);
    	setClickHandler(imgPoster12);
    	setClickHandler(imgPoster13);
    }  
    
    /**
     * Asigna un manejador de eventos al ImageView
     * @param imageView
     */
		private void setClickHandler(ImageView imageView) {
			imageView.setOnMouseClicked(event -> handleImageViewClick(imageView));
		}

		/**
		 * Redirige la página hacia el detalle de la pelicula clicada 
		 * @param clickedImageView
		 */
		private void handleImageViewClick(ImageView clickedImageView) {
			// TODO: goToPelicula()
		}

		@FXML
		void initialize() {
			// TODO: Busqueda 8 elementos cartelera
			
			asignClickHandlers();
		}

}
