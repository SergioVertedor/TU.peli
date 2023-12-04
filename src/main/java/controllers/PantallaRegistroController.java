package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import utils.RegisterValidator;

public class PantallaRegistroController {

	@FXML
	private Button btnLoginRegister;

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
	private TextField txtPassword;

	@FXML
	private TextField txtPasswordRepeat;

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

}

