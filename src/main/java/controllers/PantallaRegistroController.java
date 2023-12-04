package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.RegisterValidator;

public class PantallaRegistroController {

	@FXML
	private Button btnLoginRegister;

	@FXML
	private Button btnVolver;

	@FXML
	private ImageView imgLoginLogo;

	@FXML
	private Label lblEmail;

	@FXML
	private Label lblEresNuevoPorAqui;

	@FXML
	private Label lblNombre;

	@FXML
	private Label lblPassword;

	@FXML
	private Label lblPasswordRepeat;

	@FXML
	private Label lblUsuario;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtName;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private PasswordField txtPasswordRepeat;

	@FXML
	private TextField txtUserName;

	/**
	 * Este método se ejecuta cuando el usuario pulsa el botón de registro
	 * 
	 * @param event evento
	 */
	@FXML
	void btnRegisterNewUserPressed(ActionEvent event) {
		String username = txtUserName.getText();
		String password = txtPassword.getText();
		String passwordRepeat = txtPasswordRepeat.getText();
		String email = txtEmail.getText();
		RegisterValidator registerValidator = new RegisterValidator();
		registerValidator.doValidate(username, password, passwordRepeat, email);
	}

	/**
	 * Vuelve a la pantalla principal
	 * 
	 * @param event
	 */
	@FXML
	void btnVolver(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/PantallaLogin.fxml"));
		Parent root = null; // Carga pantalla principal
		try {
			root = loader.load();
		} catch (IOException e) {
			System.err.println("Error al cargar la ventana login desde registro");
		}

		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		Scene scene = new Scene(root);
		stage.setScene(scene);

		// Asignar icono
		Image icon = new Image("resources/images/logo/logo.png");
		stage.getIcons().add(icon);

		// Poner titulo a la ventana
		stage.setTitle("TU.PELI");
		stage.showAndWait();
	}

}
