package model.dao;

import java.util.List;
import model.AppUser;
import model.WorkUserStorageId;
import model.connector.HibernateUtils;
import org.hibernate.Session;

/** Clase con el DAO generico, CommonDaoImpl */
public class WorkUserStorageIdImpl extends CommonDAOImpl<WorkUserStorageId> implements WorkUserStorageIdInt {
  public WorkUserStorageIdImpl(Session session) {
    super(session);
  }


}
