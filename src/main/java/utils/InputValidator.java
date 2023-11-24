package utils;

public class InputValidator {
  public static boolean isEmailValid(String email) {
    return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
  }

  public static boolean isPasswordValid(String password) {
    return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
  }

  public static boolean isUserValid(String user) {
    return user.matches("^[a-zA-Z0-9]{4,16}$");
  }

  public static boolean isNameValid(String name) {
    return name.matches("^[a-zA-Z ]{2,50}$");
    }
}
