package utils;

import connector.HibernateUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.AppUser;
import model.dao.AppUserImpl;

/**
 * Esta clase se encarga de validar el login
 *
 * @author SVB
 * @author EPP
 */
public class LoginValidator {
  /**
   * Este método comprueba si el usuario y la contraseña introducidos son válidos
   *
   * @param userOrMail usuario o email introducido
   * @param password contraseña introducida
   */
  public void validateLogin(String userOrMail, String password) {
    var appUserImpl = new AppUserImpl(HibernateUtils.getSession());
    List<AppUser> users = appUserImpl.searchAll();
    var dialogNotificator = new DialogNotificator();
    if (userOrMail.isEmpty() || password.isEmpty()) {
      dialogNotificator.notifyEmptyFields();
    } else {

      users.forEach(
          appUser -> {
            String pw = RSAUtils.descifra(appUser.getPassword());
            if (appUser.getUsername().equalsIgnoreCase(userOrMail) && pw.equals(password)
                || appUser.getMail().equalsIgnoreCase(userOrMail) && pw.equals(password)) {
              var fechaActual = LocalDate.now();
              var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
              String fechaFormateada = fechaActual.format(formatter);
              appUser.setLastLogin(fechaFormateada);
              appUserImpl.updateLastLogin(appUser);
              dialogNotificator.notifyLogin(appUser);
            } else {
              dialogNotificator.notifyLoginError();
            }
          });
    }
  }
}
