package model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un usuario de la aplicación
 *
 * @author SVB
 * @author EPP
 */
@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUser implements java.io.Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer idUser;

  @Column(name = "name")
  private String username;

  @Column(name = "mail")
  private String mail;

  @Column(name = "password", length = 10000)
  private String password;

  @Column(name = "last_login")
  private String lastLogin;

  @Column(name = "register_date")
  private String registerDate;

  @Column(name = "avatar_path")
  private String avatarPath;

  @OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL)
  private Set<WorkUserStorage> workUserStorages = new HashSet<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<Storage> storages = new HashSet<>();

  /**
   * Constructor de la clase AppUser
   *
   * @param username Nombre de usuario
   * @param mail Correo electrónico
   * @param password Contraseña
   * @param lastLogin Último inicio de sesión
   * @param registerDate Fecha de registro
   * @param avatarPath Ruta del avatar
   */
  public AppUser(
      String username,
      String mail,
      String password,
      String lastLogin,
      String registerDate,
      String avatarPath) {
    this.username = username;
    this.mail = mail;
    this.password = password;
    this.lastLogin = lastLogin;
    this.registerDate = registerDate;
    this.avatarPath = avatarPath;
  }
}
