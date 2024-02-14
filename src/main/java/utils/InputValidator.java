package utils;

/**
 * Esta clase contiene métodos para validar los datos introducidos por el
 * usuario
 * 
 * @author SVB
 * @author EPP
 * 
 */
public class InputValidator {

	/**
	 * Este método comprueba si el email introducido es válido
	 *
	 * @param email email introducido
	 * @return true si el email es válido, false si no lo es
	 */
	public boolean isEmailValid(String email) {
		return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
	}

	/**
	 * Este método comprueba si la contraseña introducida es válida
	 *
	 * @param password contraseña introducida
	 * @return true si la contraseña es válida, false si no lo es
	 */
	public boolean isPasswordValid(String password) {
		return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,16}$");
	}

	/**
	 * Este método comprueba si el usuario introducido es válido
	 *
	 * @param user usuario introducido
	 * @return true si el usuario es válido, false si no lo es
	 */
	public boolean isUserValid(String user) {
		return user.matches("^[a-zA-Z0-9]{4,16}$");
	}

	/**
	 * Este método comprueba si el nombre introducido es válido
	 *
	 * @param name nombre introducido
	 * @return true si el nombre es válido, false si no lo es
	 */
	public boolean isNameValid(String name) {
		return name.matches("^[a-zA-Z 0-9,.-]{2,50}$");
	}
}
