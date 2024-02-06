package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PaneDetalleController {

	@FXML	private ImageView imgPen;
	
	// Poster
	@FXML	private ImageView imgPoster;
	
	@FXML	private Label lblTitulo;
	// Formato subtitulo: 'Director · Genero'
	@FXML	private Label lblSubtitulo;
	
	// Puntuación media usuarios
	@FXML	private Label lblRating;
	
	// Bandera pais 
	@FXML	private ImageView imgPais;
	
	// Formato estrenoDuracion para series: 'Estreno · x temporadas' (1980 · 1h15min)
	@FXML	private Label lblEstrenoDuracion;
	
	// Guardado en favoritos (corazon)
	@FXML	private ImageView imgLike;
	
	// Plataformas de Streaming
	@FXML	private ImageView imgNetflix;
	@FXML	private ImageView imgHBO;
	@FXML	private ImageView imgDisney;
	@FXML	private ImageView imgPrimeVideo;
	@FXML	private ImageView imgFilmin;
	@FXML	private ImageView imgAppleTV;
	
	// Boton 'Añadir a...'
	@FXML private Button btnAdd;
	
	// Ver trailer
	@FXML private Button btnTrailer;
	
	// Puntuacion estrellas
	@FXML private ImageView imgStar1;
	@FXML	private ImageView imgStar2;
	@FXML	private ImageView imgStar3;
	@FXML	private ImageView imgStar4;
	@FXML	private ImageView imgStar5;

	@FXML	private Label lblComentario;
	@FXML	private Label lblFechaVista;
	
	// Sinopsis
	@FXML	private Label lblTituloSinopsis;
	@FXML	private Label lblSinopsis;
	
	// Imagenes del reparto
	@FXML	private ImageView imgReparto1;
	@FXML	private ImageView imgReparto2;
	@FXML	private ImageView imgReparto4;
	
	// Actores y actrices de reparto (nombre y apellido)
	@FXML	private Label lblReparto0;
	@FXML	private Label lblReparto1;
	@FXML	private Label lblReparto2;
	@FXML	private Label lblReparto3;

	
	@FXML	
	void btnAddPressed(ActionEvent event) {

	}

	/**
	 * Redigire al trailer de la película o serie
	 * @param event
	 */
	@FXML
	void btnTrailerPressed(ActionEvent event) {

	}

	/**
	 * Permite al usuario agregar un comentario a la película 
	 * @param event
	 */
	@FXML
	void escribirComentario(MouseEvent event) {
		// TODO: no existe un textBox para recoger el comentario, lo hago mas adelante
	}

	/**
	 * Guarda la puntuación seleccionada
	 * @param event
	 */
	@FXML
	void changePuntuacionPressed(MouseEvent event) {

	}

	/**
	 * Cambia el estado de like/unlike
	 * @param event
	 */
	@FXML
	void imgLikePressed(MouseEvent event) {
		
	}

	@FXML
	void initialize() {
		// Información sobre la obra seleccionada
	}

}
