package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PaneNuevaController {


	// Imagen Poster
	// TODO: Mejor generar una ventana con acceso a text para insertar un enlace a la imagen
	@FXML	private ImageView imgPoster;

	// Imagenes estrella puntuación
	@FXML	private ImageView imgStar1;
	@FXML	private ImageView imgStar2;
	@FXML	private ImageView imgStar3;
	@FXML	private ImageView imgStar4;
	@FXML	private ImageView imgStar5;

	// Eleccion Pelicula/Serie
	@FXML	private RadioButton rbPelicula;
	@FXML	private RadioButton rbSerie;
	
	// Información sobre el nuevo registro
	@FXML	private TextField txtTitulo;
	@FXML	private TextField txtAnno;
	@FXML	private TextField txtCompania;
	@FXML	private TextField txtDirector;
	@FXML	private TextField txtGenero;
	@FXML	private TextField txtReparto;
	@FXML	private TextField txtSinopsis;
	
	@FXML	private TextArea txtComentarios;
	
	// Selección paises 
	@FXML	private ComboBox<?> cbPais;
	
	// TODO: CAMBIAR A JCaledar !!!
	@FXML	private ComboBox<?> cbVistaUltimaVez;

	// Elección entre dispositivos guardados por el usuario
	@FXML	private ComboBox<?> cbDispositivo;
	
	// Imagenes plataformas de streaming
	@FXML	private ImageView imgNetflix;
	@FXML	private ImageView imgHBO;
	@FXML	private ImageView imgDisney;
	@FXML	private ImageView imgFilmin;
	@FXML	private ImageView imgPrimeVideo;
	@FXML	private ImageView imgAppleTV;
	
	// Selección plataformas de streaming
	@FXML	private CheckBox cbNetflix;
	@FXML	private CheckBox cbHBO;
	@FXML	private CheckBox cbDisney;
	@FXML	private CheckBox cbPrimeVideo;
	@FXML	private CheckBox cbFilmin;
	@FXML	private CheckBox cbAppleTV;
	
	// Botones
	@FXML	private Button btnGuardar;
	@FXML	private Button btnRestablecer;
	
	
	@FXML
	void btnGuardarPressed(ActionEvent event) {
		
	}

	@FXML
	void btnRestablecerPressed(ActionEvent event) {
		txtTitulo.setText("");
		txtAnno.setText("");
		txtCompania.setText("");
		txtDirector.setText("");
		txtGenero.setText("");
		txtReparto.setText("");
		txtSinopsis.setText("");
		txtComentarios.setText("");
		cbNetflix.setSelected(false);
		cbHBO.setSelected(false);
		cbDisney.setSelected(false);
		cbPrimeVideo.setSelected(false);
		cbFilmin.setSelected(false);
		cbAppleTV.setSelected(false);
		// TODO: Imagenes de estrella
		// TODO: comboBox vacios
		// TODO: imagen limpia
	}


	@FXML
	void initialize() {
		// No las tenemos aún
		imgNetflix.setImage(new Image("images/streaming/Netflix.png"));
		imgHBO.setImage(new Image("images/streaming/HBO.png"));
		imgDisney.setImage(new Image("images/streaming/Disney.png"));
		imgPrimeVideo.setImage(new Image("images/streaming/PrimeVideo.png"));
		imgFilmin.setImage(new Image("images/streaming/Filmin.png"));
		imgAppleTV.setImage(new Image("images/streaming/ApplelTV.png"));

	}

}
