package utils;

import connector.HibernateUtils;
import model.AppUser;
import model.dao.AppUserImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Esta clase se encarga de validar el login
 * 
 * @author SVB
 * @author EPP
 * 
 */
public class LoginValidator {
	/**
	 * Este método comprueba si el usuario y la contraseña introducidos son válidos
	 *
	 * @param userOrMail usuario o email introducido
	 * @param password   contraseña introducida
	 */
	public void validateLogin(String userOrMail, String password) {
		AppUserImpl appUserImpl = new AppUserImpl(HibernateUtils.getSession());
		List<AppUser> users = appUserImpl.searchAll();
		HibernateUtils.clearSession();

		DialogNotificator dialogNotificator = new DialogNotificator();
		if (userOrMail.isEmpty() || password.isEmpty()) {
			dialogNotificator.notifyEmptyFields();
		} else {
			users.forEach(appUser -> {
				if (appUser.getUsername().equalsIgnoreCase(userOrMail) && appUser.getPassword().equals(password)
						|| appUser.getMail().equalsIgnoreCase(userOrMail) && appUser.getPassword().equals(password)) {
					LocalDate fechaActual = LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String fechaFormateada = fechaActual.format(formatter);
					appUser.setLastLogin(fechaFormateada);
					dialogNotificator.notifyLogin(appUser);
				} else {
					dialogNotificator.notifyLoginError();
				}
			});
		}
	}
}
