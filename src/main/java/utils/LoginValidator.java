package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Esta clase se encarga de validar el login */
public class LoginValidator {
  /**
   * Este método comprueba si el usuario y la contraseña introducidos son válidos
   *
   * @param userOrMail usuario o email introducido
   * @param password contraseña introducida
   */
  public void validateLogin(String userOrMail, String password) {
    DialogNotificator dialogNotificator = new DialogNotificator();
    if (userOrMail.isEmpty() || password.isEmpty()) {
      dialogNotificator.notifyEmptyFields();
    } else {
      ListStorage.users.forEach(
          appUser -> {
            if (appUser.getUsername().equals(userOrMail) && appUser.getPassword().equals(password)
                || appUser.getMail().equals(userOrMail) && appUser.getPassword().equals(password)) {
              LocalDate fechaActual = LocalDate.now();
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
              String fechaFormateada = fechaActual.format(formatter);
              appUser.setLast_login(fechaFormateada);
              dialogNotificator.notifyLogin(appUser);
            } else {
              dialogNotificator.notifyLoginError();
            }
          });
    }
  }
}
