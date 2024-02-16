package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import model.AppUser;
import model.connector.HibernateUtils;
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
  public boolean validateLogin(String userOrMail, String password) {
    // La Clase AtomicBoolean actúa como variable booleana que puede ser modificada atómicamente.
    // Esto significa que las operaciones de lectura y escritura se realizan en una sola operación
    // atómica. Esto evita que otros hilos lean un valor intermedio o incompleto. Y permite que
    // se pueda declarar dentro de un lambda. (Que ha sido el caso).
    AtomicBoolean resultado = new AtomicBoolean(false);
    var appUserImpl = new AppUserImpl(HibernateUtils.getSession());
    // Obtenemos todos los usuarios de la base de datos
    List<AppUser> users = appUserImpl.searchAll();
    var dialogNotificator = new DialogNotificator();
    // Comprobamos que los campos no estén vacíos
    if (userOrMail.isEmpty() || password.isEmpty()) {
      dialogNotificator.notifyEmptyFields();
    } else {
      users.stream()
          .filter(
              appUser ->
                  appUser.getUsername().equalsIgnoreCase(userOrMail)
                      || appUser.getMail().equalsIgnoreCase(userOrMail))
          .forEach(
              appUser -> {
                // Desciframos la contraseña del usuario en lista
                String pw = RSAUtils.descifra(appUser.getPassword());
                // Comprobamos si el usuario o el email introducido coinciden con la contraseña
                // descifrada
                if (appUser.getUsername().equalsIgnoreCase(userOrMail) && pw.equals(password)
                    || appUser.getMail().equalsIgnoreCase(userOrMail) && pw.equals(password)) {
                  var fechaActual = LocalDate.now();
                  // Formateamos la fecha actual
                  var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                  String fechaFormateada = fechaActual.format(formatter);
                  // Actualizamos la fecha de último login
                  appUser.setLastLogin(fechaFormateada);
                  appUserImpl.update(appUser);
                  // Si el usuario ha marcado la casilla de "Recordar usuario", guardamos el usuario
                  // en
                  // el fichero de propiedades
                  if (PropertiesManager.getRememberLogin() == 1) {
                    PropertiesManager.setUser(appUser.getUsername());
                  }
                  // Guardamos el usuario en la sesión
                  SessionHandler.setAppUser(appUser);

                  resultado.set(true);
                }
              });
    }
    return resultado.get();
  }

  /**
   * Este método comprueba si el usuario y la contraseña introducidos son válidos
   * @param userName
   * @param password
   * @param email
   * @return
   */
  public boolean updateUser(String userName, String password, String email) {
    AtomicBoolean resultado = new AtomicBoolean(false);
    var appUserImpl = new AppUserImpl(HibernateUtils.getSession());
    // Obtenemos todos los usuarios de la base de datos
    List<AppUser> users = appUserImpl.searchAll();
    var dialogNotificator = new DialogNotificator();
    // Comprobamos que los campos no estén vacíos
    if (userName.isEmpty() || password.isEmpty() && email.isEmpty() || password.isEmpty()) {
      dialogNotificator.notifyEmptyFields();
    } else {
      users.stream()
          .filter(
              appUser ->
                  appUser.getUsername().equalsIgnoreCase(userName)
                      || appUser.getMail().equalsIgnoreCase(email))
          .forEach(
              appUser -> {
                // Desciframos la contraseña del usuario en lista
                String pw = RSAUtils.descifra(appUser.getPassword());
                // Comprobamos si el usuario o el email introducido coinciden con la contraseña
                // descifrada
                if (appUser.getUsername().equalsIgnoreCase(userName) && pw.equals(password)
                    || appUser.getMail().equalsIgnoreCase(email) && pw.equals(password)) {
                  resultado.set(true);
                }
              });
    }
    return resultado.get();
  }
}
