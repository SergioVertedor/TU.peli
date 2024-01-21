package model.dao;

import java.util.List;
import model.AppUser;

public interface AppUserDAOInt extends CommonDaoInt<AppUser> {

  /**
   * Busca usuario por nombre
   *
   * @param username
   * @return
   */
  public List<AppUser> searchByUsername(final String username);

  /**
   * Busca usuario por mail
   *
   * @param mail
   * @return
   */
  public List<AppUser> searchByMail(final String mail);
}
