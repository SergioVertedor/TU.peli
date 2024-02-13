package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PaneUsuarioController {
	
	// VBox dispositivos
  @FXML private VBox vBoxDispositivos;
	
	// HBox dispositivos
	@FXML	private HBox hBoxDispositivo1;
	@FXML	private HBox hBoxDispositivo2;
	@FXML	private HBox hBoxDispositivo3;
	@FXML	private HBox hBoxDispositivo4;
	@FXML	private HBox hBoxDispositivo5;

	// Imagenes dispositivos
	@FXML	private ImageView imgDispositivo1;
	@FXML	private ImageView imgDispositivo2;
	@FXML	private ImageView imgDispositivo3;
	@FXML	private ImageView imgDispositivo4;
	@FXML	private ImageView imgDispositivo5;
	
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
	@FXML	private Label lblDispositivo5;
	
	// Imagenes eliminar dispositivo
	@FXML	private ImageView imgDeleteDisp1;
	@FXML	private ImageView imgDeleteDisp2;
	@FXML	private ImageView imgDeleteDisp3;
	@FXML	private ImageView imgDeleteDisp4;
	@FXML	private ImageView imgDeleteDisp5;
	
	// Campos para modificar los datos del usuario
	@FXML	private TextField txtEmail;
	@FXML	private TextField txtPass;
	@FXML	private TextField txtPass2;
	@FXML	private TextField txtUsername;
	
	// Lista de dispositivos HBox
	List<HBox> hBoxListDispositivos = new ArrayList<>();

  // Observable list
  private ObservableList<Map<ImageView, String>> obsListDispositivos;
  
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
		if(btnEditarDispositivos.getText().equals("Editar dispositivos")) {
//			listDispositivos.setEditable(true);
			btnEditarDispositivos.setText("Guardar cambios");
		} else {
//			listDispositivos.setEditable(false);
			// Guardar cambios
		}
	}
	

  @FXML
  void imgDeleteDisp1Pressed(MouseEvent event) {

  }

  @FXML
  void imgDeleteDisp2Pressed(MouseEvent event) {

  }

  @FXML
  void imgDeleteDisp3Pressed(MouseEvent event) {

  }

  @FXML
  void imgDeleteDisp4Pressed(MouseEvent event) {

  }

  @FXML
  void imgDeleteDisp5Pressed(MouseEvent event) {

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

  	obsListDispositivos = FXCollections.observableArrayList();
	}

}
