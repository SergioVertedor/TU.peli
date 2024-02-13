package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.scene.control.TextInputDialog;

public class PaneUsuarioController {
	
	// VBox dispositivos
  @FXML private VBox vBoxDispositivos;
	
	// HBox dispositivos
	@FXML	private HBox hBoxDispositivo1;
	@FXML	private Label lblDispositivo1;
	@FXML	private ImageView imgDispositivo1;
	@FXML	private ImageView imgDeleteDisp1;
	
	// Nombre e imagen de perfil del usuario
	@FXML	private Label lblUsername;
	@FXML	private ImageView imgUser;
	
	// Otros Datos cabecera
	@FXML	private Label lblMiembroDesde;
	@FXML	private Label lblNumeroDeTitulosGuardados;
	@FXML	private Label lblUltimaConexion;
	
	// Importar y Exportar (funcionan como botones)
	@FXML	private Button lblExportar;
	@FXML	private Button lblImportar;
	
	// Campos para modificar los datos del usuario
	@FXML	private TextField txtEmail;
	@FXML	private TextField txtPass;
	@FXML	private TextField txtPass2;
	@FXML	private TextField txtUsername;
	
	// Lista de dispositivos HBox
	List<HBox> hBoxListDispositivos = new ArrayList<>();

  // Observable list
  private ObservableList<HBox> obsListDispositivos;
  
	// Botones
	@FXML	private Button btnAddDispositivo;
	@FXML	private Button btnGuardar;
	
	
	/**
	 * Edita el listado de dispositivos del usuario
	 * 
	 * @param event
	 */
	@FXML
	void btnAddDispositivoPressed(ActionEvent event) {
		String nombreDispositivo = showTextDialog();
		if (!nombreDispositivo.isEmpty()) {
			HBox newHBox = new HBox();
			Label nombre = new Label(nombreDispositivo);
			ImageView image = new ImageView("images/pcIcon.png");
			ImageView imgRemove = new ImageView("images/remove.png");
			nombre.setTextFill(Color.WHITE);
			image.setFitWidth(20);
			image.setFitHeight(20);
			imgRemove.setFitWidth(20);
			imgRemove.setFitHeight(20);
			newHBox.getChildren().addAll(image, nombre, imgRemove);
			hBoxListDispositivos.add(newHBox); 
			obsListDispositivos.add(newHBox); 
			vBoxDispositivos.getChildren().addAll(newHBox); 
		}
	}

  String showTextDialog() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Nuevo Dispositivo");
		dialog.setHeaderText("Hola");
		dialog.setContentText("Nombre del dispositivo:");
		dialog.initStyle(StageStyle.DECORATED);
		Optional<String> respuesta = dialog.showAndWait();
		return respuesta.orElse("");
	}

	/**
	 * Guarda/Modifica la información del usuario
	 * 
	 * @param event
	 */
	@FXML
	void btnGuardarPressed(ActionEvent event) {
		// TODO
	}

	/**
	 * Exportar datos
	 * 
	 * @param event
	 */
	@FXML
	void exportarDatosPressed(ActionEvent event) {
		// TODO
	}

	/**
	 * Importar datos
	 * 
	 * @param event
	 */
	@FXML
	void importarDatosPressed(ActionEvent event) {
		// TODO
	}

	@FXML
	void initialize() {
		imgUser.setImage(new Image("images/user.png"));
		hBoxListDispositivos = new ArrayList<>(); 
  	obsListDispositivos = FXCollections.observableArrayList(hBoxListDispositivos);
  	
	}

}
