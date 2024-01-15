package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.RSAUtils;

/**
 * Representa un usuario de la aplicación
 *
 * @author SVB
 * @author EPP
 */
@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idUser;
  private String username;
  private String mail;
  private String password;
  private String lastLogin;
  private String registerDate;
  private String avatarPath;

  /**
   * Constructor de la clase AppUser
   *
   * @param idUser Identificador del usuario
   * @param username Nombre de usuario
   * @param mail Correo electrónico
   * @param password Contraseña
   * @param lastLogin Último inicio de sesión
   * @param registerDate Fecha de registro
   * @param avatarPath Ruta del avatar
   */
  public AppUser(
      int idUser,
      String username,
      String mail,
      String password,
      String lastLogin,
      String registerDate,
      String avatarPath) {
    this.idUser = idUser;
    this.username = username;
    this.mail = mail;
    this.password =
        RSAUtils.cifra(password); // Cifra la contraseña utilizando RSAUtils para mayor seguridad.
    this.lastLogin = lastLogin;
    this.registerDate = registerDate;
    this.avatarPath = avatarPath;
  }

  // Descifra la contraseña para obtener el valor real
  public String getPassword() {
    return RSAUtils.descifra(password);
  }
}
