package utils;

import controllers.PantallaLoginController;
import model.dao.AppUser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisterValidator {


  /**
   * Este método valida los datos introducidos por el usuario en el registro
   * @param username nombre de usuario
   * @param password contraseña
   * @param passwordRepeat contraseña repetida
   * @param email email
   */
  public void doValidate(String username, String password, String passwordRepeat, String email) {
    InputValidator inputValidator = new InputValidator();
    int errorCount = 0;
    StringBuilder errorMessages = new StringBuilder();
    if (!inputValidator.isUserValid(username)) {
      errorMessages.append(errorUsername());
      errorCount++;
      if (!inputValidator.isPasswordValid(password)) {
        errorMessages.append(errorPassword());
        errorCount++;
      }
      if (!inputValidator.isEmailValid(email)) {
        errorMessages.append(errorEmail());
        errorCount++;
      }
      if (!password.equals(passwordRepeat)) {
        errorMessages.append(errorPasswordRepeat());
        errorCount++;
      }
    }
    dialogNotificator dialogNotificator = new dialogNotificator();
    if (errorCount > 0) {
      dialogNotificator.notifyRegisterError(errorMessages.toString(), errorCount);
    } else {
      LocalDate fechaActual = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String fechaFormateada = fechaActual.format(formatter);
      AppUser usuario = new AppUser(1, username, email, password, "", fechaFormateada, "");
      PantallaLoginController.users.add(usuario);
      dialogNotificator.notifyRegister(usuario);
    }
  }

  /**
   * Este método devuelve un mensaje de error si el usuario introducido no es válido
   * @return mensaje de error
   */
  private String errorPasswordRepeat() {
    return "\nLas contraseñas no coinciden";
  }

  /**
   * Este método devuelve un mensaje de error si el email introducido no es válido
   * @return mensaje de error
   */
  private String errorEmail() {
    return "\nEl email introducido no es válido";
  }

  /**
   * Este método devuelve un mensaje de error si la contraseña introducida no es válida
   * @return mensaje de error
   */
  private String errorPassword() {
    return "\nLa contraseña introducida no es válida. Debe tener entre 8 y 16 caracteres, al menos una mayúscula, una minúscula y un número";
  }

  /**
   * Este método devuelve un mensaje de error si el usuario introducido no es válido
   * @return mensaje de error
   */
  private String errorUsername() {
    return "\nEl usuario introducido no es válido. Debe tener entre 4 y 16 caracteres alfanuméricos";
  }
}