package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PaneUsuarioController {

	// Imagenes dispositivos
	@FXML	private ImageView imgDispositivo1;
	@FXML	private ImageView imgDispositivo2;
	@FXML	private ImageView imgDispositivo3;
	@FXML	private ImageView imgDispositivo4;
	
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
	
	// Nombres de los distintos dispositivos
	@FXML	private Label lblDispositivo1;
	@FXML	private Label lblDispositivo2;
	@FXML	private Label lblDispositivo3;
	@FXML	private Label lblDispositivo4;
	
	// Campos para modificar los datos del usuario
	@FXML	private TextField txtEmail;
	@FXML	private TextField txtPass;
	@FXML	private TextField txtPass2;
	@FXML	private TextField txtUsername;

	// Botones
	@FXML	private Button btnEditarDispositivos;
	@FXML	private Button btnGuardar;
	
	
	/**
	 * Edita el listado de dispositivos del usuario
	 * 
	 * @param event
	 */
	@FXML
	void btnEditarDispositivosPressed(ActionEvent event) {
		// TODO
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
	}

}
