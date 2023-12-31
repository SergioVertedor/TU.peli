package model.dao;

import utils.RSAUtils;

/**
 * Representa un usuario de la aplicación
 * 
 * @author SVB
 * @author EPP
 *
 */
public class AppUser {

	private int id_user;
	private String username;
	private String mail;
	private String password;
	private String last_login;
	private String register_date;
	private String avatar_path;

	/**
	 * Constructor
	 * 
	 * @param id_user
	 * @param username
	 * @param mail
	 * @param password
	 * @param last_login
	 * @param register_date
	 * @param avatar_path
	 */
	public AppUser(int id_user, String username, String mail, String password, String last_login, String register_date,
			String avatar_path) {
		this.id_user = id_user;
		this.username = username;
		this.mail = mail;
		this.password = RSAUtils.cifra(password); // Cifra la contraseña utilizando RSAUtils para mayor seguridad.
		this.last_login = last_login;
		this.register_date = register_date;
		this.avatar_path = avatar_path;
	}

	public int getId_user() {
		return id_user;
	}

	public String getUsername() {
		return username;
	}

	public String getMail() {
		return mail;
	}

	// Descifra la contraseña para obtener el valor real
	public String getPassword() {
		return RSAUtils.descifra(password);
	}

	public String getLast_login() {
		return last_login;
	}

	public String getRegister_date() {
		return register_date;
	}

	public String getAvatar_path() {
		return avatar_path;
	}

	// Actualiza la fecha de último inicio de sesión
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
}
