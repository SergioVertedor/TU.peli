package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.RSAUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa un usuario de la aplicación
 *
 * @author SVB
 * @author EPP
 */
@Entity
@AllArgsConstructor
@Table(name = "usuarios")
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int idUser;
  @Column(name = "name")
  private String username;
  @Column(name = "mail")
  private String mail;
  @Column(name = "password")
  private String password;
  @Column(name = "last_login")
  private String lastLogin;
  @Column(name = "register_date")
  private String registerDate;
  @Column(name = "avatar_path")
  private String avatarPath;
  @OneToMany(mappedBy = "user")
  private Set<Store> stores;


  @ManyToMany
  @JoinTable(
          name = "usuario_favorito",
          joinColumns = @JoinColumn(name = "id_usuario"),
          inverseJoinColumns = @JoinColumn(name = "id_obra"))
  private Set<Work> favoritos = new HashSet<>();

  @ManyToMany
  @JoinTable(
          name = "usuario_valoracion",
          joinColumns = @JoinColumn(name = "id_usuario"),
          inverseJoinColumns = @JoinColumn(name = "id_obra"))
  private Set<Work> valoraciones = new HashSet<>();

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
