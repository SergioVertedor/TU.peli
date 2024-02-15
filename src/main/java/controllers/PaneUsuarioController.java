package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.scene.control.TextInputDialog;
import utils.SessionHandler;
import javafx.scene.Node;

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
	@FXML	private PasswordField txtPass;
	@FXML	private PasswordField txtPass2;
	@FXML	private TextField txtUsername;
	
	// Lista de dispositivos HBox
	List<HBox> hBoxListDispositivos = new ArrayList<>();

  // Observable list
  private ObservableList<HBox> obsListDispositivos;
  
	// Botones
	@FXML	private Button btnAddDispositivo;
	@FXML	private Button btnGuardar;
	
	// Contador de dispositivos
	int contador = 0; 
	
	/**
	 * Evento que elimina el HBox del dispositivo seleccionado al hacer click en la imagen de la papelera
	 */
	private final EventHandler<MouseEvent> removeHandler = event -> {
		Node source = (Node) event.getSource();
		HBox hboxToRemove = (HBox) source.getParent();
		vBoxDispositivos.getChildren().remove(hboxToRemove);
	};

	/**
	 * Añade un nuevo dispositivo (HBox) al listado con el nombre dado
	 * 
	 * @param event
	 */
	@FXML
	void btnAddDispositivoPressed(ActionEvent event) {
		String nombreDispositivo = showNewDispositivoDialog();
		if (!nombreDispositivo.isEmpty()) {
			HBox newHBox = new HBox(10);
			newHBox.setPrefHeight(25);
			Label id = new Label(String.valueOf(contador));
			contador++;
			id.setVisible(false);
			Label nombre = new Label(nombreDispositivo);
			nombre.setPrefWidth(190);
			ImageView image = new ImageView();
			image.setImage(new Image("images/others/pcIcon.png"));
			ImageView imgRemove = new ImageView();
			imgRemove.setImage(new Image("images/others/remove.png"));
			imgRemove.setOnMouseClicked(removeHandler);
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
	
	/**
	 * Guarda/Modifica la información del usuario
	 * 
	 * @param event
	 */
	@FXML
	void btnGuardarPressed(ActionEvent event) {
		String nombreUsuario = txtUsername.getText();
		String email = txtEmail.getText();
		String pw = txtPass.getText();
		String pwRepeat = txtPass2.getText();
		
		if(SessionHandler.getAppUser() != null) {
			showInformationDialog("Información", "Datos guardados satisfactoriamente");			
		}
		showInformationDialog("Aviso", "Error modificando los datos");			
		
		clearUserDataFields();
	}
	
 /**
  * Muestra un dialogo con textField para rescatar el nombre del nuevo dispositivo
  * @return
  */
  String showNewDispositivoDialog() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Nuevo Dispositivo");
		dialog.setHeaderText("");
		dialog.setContentText("Nombre del dispositivo:");
		dialog.initStyle(StageStyle.UNDECORATED);
		Optional<String> respuesta = dialog.showAndWait();
		return respuesta.orElse("");
	}

	

	/**
	 * Muestra un dialogo de información personalizado
	 * @param title
	 * @param content
	 */
  private void showInformationDialog(String title, String content) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle(title);
      alert.setHeaderText(null);
      alert.setContentText(content);
      
      alert.showAndWait();
  }

	private void clearUserDataFields() {
		txtUsername.clear();
		txtEmail.clear();
		txtPass.clear();
		txtPass2.clear();
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
