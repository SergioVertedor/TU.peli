package model.dao;

import model.*;

/**
 * Interfaz que implementa la clase WorkUserStorageDAOImpl
 */
public interface WorkUserStorageDAOInt extends CommonDAOInt<WorkUserStorage> {
  /**
   * Busca WorkUserStorage por work y appUser
   *
   * @param work
   * @param appUser
   * @return
   */
  public WorkUserStorage getWorkUserStorage(Work work, AppUser appUser);

  /**
   * Busca WorkUserStorage por work, appUser y device
   *
   * @param work
   * @param appUser
   * @param device
   * @return
   */
  public boolean ifExists(Pelicula work, AppUser appUser, Storage device);
}
