package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.*;

public class PantallaLoginController {

  @FXML private Button btnLoginEnter;

  @FXML private Button btnLoginRegister;

  @FXML private Button btnLoginWithGoogle;

  @FXML private CheckBox cbLoginRememberMe;

  @FXML private ImageView imgLoginLogo;

  @FXML private PasswordField txtLoginPassword;

  @FXML private TextField txtLoginUser;

  @FXML
  void btnLoginEnterPressed(ActionEvent event) {
    String userOrMail = txtLoginUser.getText();
    String password = txtLoginPassword.getText();
    LoginValidator loginValidator = new LoginValidator();
    InputValidator inputValidator = new InputValidator();
    if (inputValidator.isEmailValid(userOrMail) || inputValidator.isUserValid(userOrMail)) {
      loginValidator.validateLogin(userOrMail, password);
    }
  }

  @FXML
  void btnLoginRegisterPressed(ActionEvent event) {
    SceneSwitch sceneSwitch = new SceneSwitch();
    try {
      sceneSwitch.switchScene("PantallaRegistro", new PantallaRegistroController());
    } catch (IOException e) {
      System.err.println("Error al cargar la ventana de registro");
    }
  }

  @FXML
  void cbRememberMeSelected(ActionEvent event) {
    if (cbLoginRememberMe.isSelected()) {
      PropertiesManager.setRemember("1");
    } else {
      PropertiesManager.setRemember("0");
    }
  }

  @FXML
  void initialize() {
    Font font = Font.loadFont(getClass().getResourceAsStream("/fonts/KronaOne-Regular.ttf"), 16);
    btnLoginEnter.setFont(font);
    btnLoginRegister.setFont(font);;
  }
}
