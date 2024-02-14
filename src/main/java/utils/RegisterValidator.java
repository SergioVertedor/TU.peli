package utils;

import model.connector.HibernateUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.AppUser;
import model.dao.AppUserImpl;

/**
 * Clase que realiza la validación de los datos introducidos por el usuario durante el proceso de
 * registro
 *
 * @author SVB
 * @author EPP
 */
public class RegisterValidator {
  /**
   * Este método valida los datos introducidos por el usuario en el registro
   *
   * @param username nombre de usuario
   * @param password contraseña
   * @param passwordRepeat contraseña repetida
   * @param email email
   * @return
   */
  public boolean doValidate(String username, String password, String passwordRepeat, String email) {

    InputValidator inputValidator = new InputValidator();
    int errorCount = 0;
    StringBuilder errorMessages = new StringBuilder();

    // Validación de duplicados de nombre de usuario y correo electrónico.
    AppUserImpl appUserImpl = new AppUserImpl(HibernateUtils.getSession());
    List<AppUser> users = appUserImpl.searchAll();

    for (AppUser user : users) {
      if (user.getUsername().equals(username)) {
        errorMessages.append("\nEl usuario introducido ya existe");
        errorCount++;
      }
      if (user.getMail().equals(email)) {
        errorMessages.append("\nEl email introducido ya existe");
        errorCount++;
      }
    }

    // Validación de formato de nombre de usuario, contraseña y correo electrónico
    if (!inputValidator.isUserValid(username)) {
      errorMessages.append(errorUsername());
      errorCount++;
    }
    if (!inputValidator.isPasswordValid(password)) {
      errorMessages.append(errorPassword());
      errorCount++;
    }
    if (!inputValidator.isEmailValid(email)) {
      errorMessages.append(errorEmail());
      errorCount++;
    }

    // Validación de coincidencia de contraseñas
    if (!password.equals(passwordRepeat)) {
      errorMessages.append(errorPasswordRepeat());
      errorCount++;
    }

    DialogNotificator dialogNotificator = new DialogNotificator();

    // Notificación de errores o registro exitoso
    if (errorCount > 0) {
      dialogNotificator.notifyRegisterError(errorMessages.toString(), errorCount);
      return false;
    } else {
      LocalDate fechaActual = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      String fechaFormateada = fechaActual.format(formatter);
      AppUser usuario = new AppUser(username, email, RSAUtils.cifra(password), "", fechaFormateada, "");
      appUserImpl = new AppUserImpl(HibernateUtils.getSession());
      appUserImpl.insert(usuario);
      dialogNotificator.notifyRegister(usuario);
      return true;
    }
  }

  /**
   * Este método devuelve un mensaje de error si el usuario introducido no es válido
   *
   * @return mensaje de error
   */
  private String errorPasswordRepeat() {
    return "\nLas contraseñas no coinciden";
  }

  /**
   * Este método devuelve un mensaje de error si el email introducido no es válido
   *
   * @return mensaje de error
   */
  private String errorEmail() {
    return "\nEl email introducido no es válido";
  }

  /**
   * Este método devuelve un mensaje de error si la contraseña introducida no es válida
   *
   * @return mensaje de error
   */
  private String errorPassword() {
    return "\nLa contraseña introducida no es válida. Debe tener entre 8 y 16 caracteres, al menos una mayúscula, una minúscula y un número";
  }

  /**
   * Este método devuelve un mensaje de error si el usuario introducido no es válido
   *
   * @return mensaje de error
   */
  private String errorUsername() {
    return "\nEl usuario introducido no es válido. Debe tener entre 4 y 16 caracteres alfanuméricos";
  }
}
