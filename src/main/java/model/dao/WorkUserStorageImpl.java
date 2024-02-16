package model.dao;

import java.util.List;
import model.AppUser;
import model.Work;
import model.WorkUserStorage;
import model.connector.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

/** Clase con el DAO generico, CommonDaoImpl */
public class WorkUserStorageImpl extends CommonDAOImpl<WorkUserStorage> implements WorkUserStorageDAOInt {
  public WorkUserStorageImpl(Session session) {
    super(session);
  }

  public WorkUserStorage getWorkUserStorage(Work work, AppUser appUser) {
    HibernateUtils.openSession();
    Session session = HibernateUtils.getSession();
    session.beginTransaction();
    String hql = "FROM WorkUserStorage WHERE id.work.idWork=" + work.getIdWork() + " AND id.user.id=" + appUser.getIdUser();
    WorkUserStorage workUserStorage = session.createQuery(hql, WorkUserStorage.class).getSingleResult();
    HibernateUtils.commitTransaction();
    HibernateUtils.closeSession();
    return workUserStorage;
  }
}
