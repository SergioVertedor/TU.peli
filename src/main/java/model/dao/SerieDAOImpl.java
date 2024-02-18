package model.dao;

import java.util.List;
import model.Serie;
import model.connector.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 * Clase que implementa la interfaz SerieDAOI

 */
public class SerieDAOImpl extends CommonDAOImpl<Serie> implements SerieDAOI {

  private Session session;

  public SerieDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  /**
   * Busca Serie por título
   * @param name del nombre
   * @return
   */
  @Override
  public Serie getSerie(String name) {
    HibernateUtils.openSession();
    Session session = HibernateUtils.getSession();
    session.beginTransaction();
    String hql = "FROM Serie WHERE originalTitle='" + name + "'";
    Serie serie = session.createQuery(hql, Serie.class).getSingleResult();
    HibernateUtils.commitTransaction();
    HibernateUtils.closeSession();
    return serie;
  }

  /**
   * Busca Serie por id
   * @param idSerie
   * @return
   */
  @Override
  public Serie searchById(int idSerie) {
    if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
      session.getTransaction().begin();
    }

    return (Serie) session.createQuery("FROM Serie WHERE idWork=" + idSerie).uniqueResult();
  }

  /**
   * Busca Series por titulo
   * @param title
   * @return
   */
  @Override
  public List<Serie> searchByTitle(String title) {
    if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
      session.getTransaction().begin();
    }

    return session.createQuery("FROM Serie WHERE originalTitle='" + title + "'").list();
  }

  /**
   * Busca Series por género
   * @param genre
   * @return
   */
  @Override
  public List<Serie> searchByGenre(String genre) {
    if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
      session.getTransaction().begin();
    }

    return session.createQuery("FROM Serie WHERE genre='" + genre + "'").list();
  }

  /**
   * Busca Series con una duración menor a la indicada
   * @param runtime
   * @return
   */
  @Override
  public List<Serie> searchByLessRuntime(Integer runtime) {
    if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
      session.getTransaction().begin();
    }

    return session.createQuery("FROM Serie WHERE runtime < " + runtime).list();
  }

  /**
   * Busca Series por pais
   * @param country
   * @return
   */
  @Override
  public List<Serie> searchByCountry(String country) {
    if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
      session.getTransaction().begin();
    }

    return session.createQuery("FROM Serie WHERE originalCountry='" + country + "'").list();
  }
}
