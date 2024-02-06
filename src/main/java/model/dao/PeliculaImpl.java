package model.dao;

import java.util.List;
import model.Pelicula;
import org.hibernate.Session;

/** Clase con el DAO generico, CommonDaoImpl y la interfaz WorkInt */
public class PeliculaImpl extends CommonDAOImpl<Pelicula> implements PeliculaInt {

  /**
   * Constructor de la clase
   *
   * @param session Session de la base de datos
   */
  public PeliculaImpl(Session session) {
    super(session);
  }

  /**
   * Busca Pelicula por título
   *
   * @param title
   * @return
   */
  @Override
  public List<Pelicula> searchByTitle(String title) {
    session.beginTransaction();
    String hql = "FROM Work WHERE originalTitle='" + title + "'";
    List<Pelicula> peliculas = session.createQuery(hql, Pelicula.class).list();
    session.getTransaction().commit();
    return peliculas;
  }
}
