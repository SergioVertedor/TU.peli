package model.dao;


import jakarta.persistence.NoResultException;
import model.*;
import model.connector.HibernateUtils;
import org.hibernate.Session;

/** Clase con el DAO generico, CommonDaoImpl */
public class WorkUserStorageImpl extends CommonDAOImpl<WorkUserStorage>
    implements WorkUserStorageDAOInt {
  public WorkUserStorageImpl(Session session) {
    super(session);
  }

  /**
   * Busca WorkUserStorage por work y appUser
   * @param work
   * @param appUser
   * @return
   */
  public WorkUserStorage getWorkUserStorage(Work work, AppUser appUser) {
    HibernateUtils.openSession();
    Session session = HibernateUtils.getSession();
    session.beginTransaction();
    String hql =
        "FROM WorkUserStorage WHERE id.work.idWork="
            + work.getIdWork()
            + " AND id.user.id="
            + appUser.getIdUser();
    WorkUserStorage workUserStorage =
        session.createQuery(hql, WorkUserStorage.class).getSingleResult();
    HibernateUtils.commitTransaction();
    HibernateUtils.closeSession();
    return workUserStorage;
  }

  /**
   * Busca WorkUserStorage por work, appUser y device
   * @param work
   * @param appUser
   * @param device
   * @return
   */
  public boolean ifExists(Pelicula work, AppUser appUser, Storage device) {
    try {
      HibernateUtils.openSession();
      Session session = HibernateUtils.getSession();
      session.beginTransaction();
      String hql =
          "FROM WorkUserStorage WHERE id.work.idWork="
              + work.getIdWork()
              + " AND id.user.id="
              + appUser.getIdUser()
              + " AND id.storage.id="
              + device.getIdWorkStorage();
      WorkUserStorage workUserStorage =
          session.createQuery(hql, WorkUserStorage.class).getSingleResult();
      HibernateUtils.commitTransaction();
      HibernateUtils.closeSession();
      return workUserStorage != null;
    } catch (NoResultException e) {
      HibernateUtils.closeSession();
      return false;
    }
  }
}
