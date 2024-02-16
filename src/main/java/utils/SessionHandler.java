package utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.AppUser;
import model.connector.HibernateUtils;
import model.dao.AppUserImpl;

/**
 * Clase que maneja la sesión del usuario.
 */
public class SessionHandler {
  @Getter @Setter private static AppUser appUser;

  public void loadUser() {
    AppUserImpl appUserImpl = new AppUserImpl(HibernateUtils.getSession());
    appUser = appUserImpl.searchById(appUser.getIdUser());
  }

}
