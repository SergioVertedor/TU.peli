package connector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/** Clase HibernateUtils que abre la conexión con la base de datos. */
public class HibernateUtils {
  private static Session session;
  private static SessionFactory sessionFactory;

  /**
   * Método que devuelve la sesión.
   * @return session
   */
    public static Session getSession() {
    return session;
  }

  /**
   * Método que abre la conexión con la base de datos.
   */
  public static void openSession() {
    if (session == null || !session.isOpen()) {
      StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();
      sessionFactory.openSession();
      session = sessionFactory.openSession();
    }
  }
  /**
   * Método que limpia la sesión.
   */
  public static void clearSession() {
    session.clear();
    session.flush();
  }

  /**
   * Método que cierra la sesión.
   */
  public static void closeSession() {
    session.close();
    if ((sessionFactory != null) && (!sessionFactory.isClosed())) {
      sessionFactory.close();
    }
  }
}
