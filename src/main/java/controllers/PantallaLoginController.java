package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.dao.AppUser;
import utils.InputValidator;
import utils.LoginNotificator;
import utils.LoginValidator;
import java.util.ArrayList;
import java.util.List;

public class PantallaLoginController {
  public static List<AppUser> users = new ArrayList<>();

  @FXML private Button btnLoginEnter;

  @FXML private Button btnLoginRegister;

  @FXML private Button btnLoginWithGoogle;

  @FXML private CheckBox cbLoginRememberMe;

  @FXML private ImageView imgLoginLogo;

  @FXML private TextField txtLoginPassword;

  @FXML private TextField txtLoginUser;

  @FXML
  void btnLoginEnterPressed(ActionEvent event) {
    String userOrMail = txtLoginUser.getText();
    String password = txtLoginPassword.getText();
    LoginValidator loginValidator = new LoginValidator();
    InputValidator inputValidator = new InputValidator();
    LoginNotificator loginNotificator = new LoginNotificator();
    if (inputValidator.isEmailValid(userOrMail) || inputValidator.isUserValid(userOrMail)) {
      loginValidator.validateLogin(userOrMail, password);
    }
  }

  @FXML
  void btnLoginRegisterPressed(ActionEvent event) {}

  @FXML
  void btnLoginWithGooglePressed(ActionEvent event) {}

  @FXML
  void cbRememberMeSelected(ActionEvent event) {}
}
