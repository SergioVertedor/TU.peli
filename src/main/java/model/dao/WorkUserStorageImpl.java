package model.dao;

import java.util.List;
import model.AppUser;
import model.WorkUserStorage;
import model.connector.HibernateUtils;
import org.hibernate.Session;

/** Clase con el DAO generico, CommonDaoImpl */
public class WorkUserStorageImpl extends CommonDAOImpl<WorkUserStorage> implements WorkUserStorageDAOInt {
  public WorkUserStorageImpl(Session session) {
    super(session);
  }
}
