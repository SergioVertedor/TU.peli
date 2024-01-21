package model.dao;

import model.Work;
import org.hibernate.Session;

import java.util.List;

/** Clase con el DAO generico, CommonDaoImpl y la interfaz WorkInt */
public class WorkImpl extends CommonDaoImpl<Work> implements WorkInt {

  /**
   * Constructor de la clase
   *
   * @param session Session de la base de datos
   */
  public WorkImpl(Session session) {
    super(session);
  }

  /**
   * Busca Work por título
   *
   * @param title Título de la obra
   * @return Work con el título dado
   */
  @Override
  public List<Work> searchByTitle(String title) {
    session.beginTransaction();
    String hql = "FROM Work WHERE originalTitle='" + title + "'";
    List<Work> works = session.createQuery(hql, Work.class).list();
    session.getTransaction().commit();
    return works;
  }
}
