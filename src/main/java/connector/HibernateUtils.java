package connector;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
  @Getter private static Session session;
  private static Transaction transaction;
  private static SessionFactory sessionFactory;

  /** Método que abre la conexión con la base de datos. */
  public static void openSession() {
    if (session == null || !session.isOpen()) {
      StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
      sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();
      session = sessionFactory.openSession();
    }
  }

  /** Método que limpia la sesión. */
  public static void clearSession() {
    session.clear();
  }

  public static void flushSession() {
    session.flush();
  }

  /** Método que cierra la sesión. */
  public static void closeSession() {
    session.close();
    if ((sessionFactory != null) && (!sessionFactory.isClosed())) {
      sessionFactory.close();
    }
  }

  /**
   * Método que devuelve la sesión.
   *
   * @return la sesión
   */
  public static Session getSession() {
    if (session == null || !session.isOpen()) {
      openSession();
    }
    return session;
  }

  /** Método que inicia la transacción. */
  public static void startTransaction() {
    if (transaction == null || !transaction.isActive()) {
     transaction = session.beginTransaction();
    }
  }

  /** Método que confirma la transacción. */
  public static void commitTransaction() {
    transaction.commit();
  }

  public static void rollbackTransaction() {
    transaction.rollback();
  }
}
