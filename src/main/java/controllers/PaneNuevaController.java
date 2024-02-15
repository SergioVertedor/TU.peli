package controllers;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import lombok.Getter;
import lombok.Setter;

public class PaneNuevaController {

	@Getter @Setter private Pane centralPane;
	
	// Imagen Poster
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
	
	// Selección paises (deshabilitado)
	@FXML	private ComboBox<?> cbPais;
	
	// Vista por ultima vez (deshabilitado)
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
	
	 /**
	  * Muestra un dialogo con textField para coger la url de la imagen
	  * @return
	  */
	  String showTextDialog() {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("URL imagen");
			dialog.setHeaderText("Inserte la URL de la imagen a cargar");
			dialog.setContentText("URL:");
			dialog.initStyle(StageStyle.TRANSPARENT);
			Optional<String> respuesta = dialog.showAndWait();
			return respuesta.orElse("");
		}
	
	// TODO
	/**
	 * Rellena el comboBox con los dispositivos del usuario
	 */
	void fillComboBox() {
		ObservableList<String> dipositivosList = 
		    FXCollections.observableArrayList(
		        "",
		        ""
		    );
		cbDispositivo = new ComboBox(dipositivosList);
	}
	
	/**
	 * Insertar url de la imagen de la pelicula/serie
	 * @param event
	 */
  @FXML
  void imgPosterClicked(MouseEvent event) {
  	String urlDispositivo = showTextDialog();
  	imgPoster.setImage(new Image(urlDispositivo));
  }
	
	
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
		imgStar1.setImage(new Image("images/favUnselected"));
		imgStar2.setImage(new Image("images/favUnselected"));
		imgStar3.setImage(new Image("images/favUnselected"));
		imgStar4.setImage(new Image("images/favUnselected"));
		imgStar5.setImage(new Image("images/favUnselected"));
		// TODO: comboBox dispositivos sin seleccion
		// TODO: imagen limpia
	}


	@FXML
	public
	void initialize() {
		imgNetflix.setImage(new Image("images/streaming/Netflix.png"));
		imgHBO.setImage(new Image("images/streaming/HBOMax.png"));
		imgDisney.setImage(new Image("images/streaming/Disney.png"));
		imgPrimeVideo.setImage(new Image("images/streaming/PrimeVideo.png"));
		imgFilmin.setImage(new Image("images/streaming/Filmin.png"));
		imgAppleTV.setImage(new Image("images/streaming/AppleTV.png"));
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

}
