package model.dao;

import java.util.List;

import model.Pelicula;
import model.connector.HibernateUtils;
import org.hibernate.Session;
import service.dto.movie.MovieDetail;

/** Clase con el DAO generico, CommonDaoImpl y la interfaz WorkInt */
public class PeliculaDAOImpl extends CommonDAOImpl<Pelicula> implements PeliculaDAOInt {

  /**
   * Constructor de la clase
   *
   * @param session Session de la base de datos
   */
  public PeliculaDAOImpl(Session session) {
    super(session);
  }
  /**
   * Busca Pelicula por titulo
   * @return Pelicula
   */
  public static Pelicula getMovieFromTitle(String title) {
    HibernateUtils.openSession();
    Session session = HibernateUtils.getSession();
    session.beginTransaction();
    String hql = "FROM Work WHERE originalTitle='" + title + "'";
    Pelicula work = session.createQuery(hql, Pelicula.class).getSingleResult();
    session.getTransaction().commit();
    return work;
  }

  /**
   * Busca Pelicula por id
   * @param id id de la pelicula
   * @return Pelicula
   */
  public static MovieDetail getMovie(int id) {
    HibernateUtils.openSession();
    Session session = HibernateUtils.getSession();
    session.beginTransaction();
    String hql = "FROM Work WHERE id=" + id;
    MovieDetail movie = session.createQuery(hql, MovieDetail.class).getSingleResult();
    HibernateUtils.commitTransaction();
    HibernateUtils.closeSession();
    return movie;
  }

  /**
   * Busca Pelicula por título
   *
   * @param title
   * @return
   */
  @Override
  public List<Pelicula> searchByTitle(String title) {
    HibernateUtils.openSession();
    HibernateUtils.startTransaction();
    String hql = "FROM Work WHERE originalTitle='" + title + "'";
    List<Pelicula> peliculas = session.createQuery(hql, Pelicula.class).list();
    HibernateUtils.commitTransaction();
    HibernateUtils.closeSession();
    return peliculas;
  }

  /**
   * Busca confirmar si existe una pelicula
   * @param title
   * @return
   */
  public boolean ifExists(String title) {
    HibernateUtils.openSession();
    HibernateUtils.startTransaction();
    String hql = "FROM Work WHERE originalTitle='" + title + "'";
    List<Pelicula> peliculas = session.createQuery(hql, Pelicula.class).list();
    HibernateUtils.commitTransaction();
    HibernateUtils.closeSession();
    return !peliculas.isEmpty();
  }
}
