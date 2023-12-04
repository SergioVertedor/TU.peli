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
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.InputValidator;
import utils.LoginValidator;
import utils.DialogNotificator;
import utils.SceneSwitch;

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
    DialogNotificator dialogNotificator = new DialogNotificator();
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

    // Tamaño indicado manualmente - NO FUNCIONA
//    stage.setWidth(1920);
//    stage.setHeight(1080);
    
    // Arranca maximizado
//    stage.setMaximized(false);


  }

  @FXML
  void cbRememberMeSelected(ActionEvent event) {
    if (cbLoginRememberMe.isSelected()) {
      setRemember("1");
    } else {
      setRemember("0");
    }
  }

  private void setRemember(String i) {
    Properties prop = new Properties();
    InputStream input = null;
    OutputStream output = null;
    try {
      input = new FileInputStream("config.properties");
      prop.load(input);
      prop.setProperty("remember", i);
      // save properties to project root folder
      output = new FileOutputStream("config.properties");
      prop.store(output, null);
    } catch (IOException e) {
      System.err.println("Error al cargar el archivo de configuración");
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          System.err.println("Error al cerrar el archivo de configuración");
        }
      }
      if (output != null) {
        try {
          output.close();
        } catch (IOException e) {
          System.err.println("Error al cerrar el archivo de configuración");
        }
      }
    }
  }
}
