package model.dao;

import java.util.List;
import model.AppUser;

/**
 * Interfaz con el DAO generico, CommonDaoInt y la interfaz AppUserInt

 */
public interface AppUserDAOInt extends CommonDAOInt<AppUser> {

  /**
   * Busca usuario por username
   * @param username
   * @return
   */
  public AppUser searchByUsername(final String username);

  /**
   * Busca usuario por mail
   *
   * @param mail
   * @return
   */
  public List<AppUser> searchByMail(final String mail);

}
