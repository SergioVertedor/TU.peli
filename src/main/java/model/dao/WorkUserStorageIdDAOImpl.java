package model.dao;

import model.WorkUserStorageId;
import org.hibernate.Session;

/** Clase con el DAO generico, CommonDaoImpl */
public class WorkUserStorageIdDAOImpl extends CommonDAOImpl<WorkUserStorageId> implements WorkUserStorageIdDAOInt {
  public WorkUserStorageIdDAOImpl(Session session) {
    super(session);
  }


}
