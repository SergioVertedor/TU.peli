package utils;

import controllers.PantallaLoginController;
import javafx.scene.control.Alert;

/**
 * Esta clase se encarga de validar el login
 */
public class LoginValidator {
    /**
     * Este método comprueba si el usuario y la contraseña introducidos son válidos
     * @param userOrMail usuario o email introducido
     * @param password contraseña introducida
     */
  public void validateLogin(String userOrMail, String password) {
    LoginNotificator loginNotificator = new LoginNotificator();
    if (userOrMail.isEmpty() || password.isEmpty()) {
      loginNotificator.notifyEmptyFields();
    } else {
      PantallaLoginController.users.forEach(
          appUser -> {
            if (appUser.getUsername().equals(userOrMail) && appUser.getPassword().equals(password)
                || appUser.getMail().equals(userOrMail) && appUser.getPassword().equals(password)) {
              loginNotificator.notifyLogin(appUser);
            } else {
              loginNotificator.notifyLoginError();
            }
          });
    }
  }
}
