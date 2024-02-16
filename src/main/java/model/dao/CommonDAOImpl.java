package model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import model.connector.HibernateUtils;
import org.hibernate.Session;

/** Clase con el DAO generico, CommonDaoImpl */
public abstract class CommonDAOImpl<T> implements CommonDAOInt<T> {

  /** Tipo de clase */
  private Class<T> entityClass;

  /** Sesion de conexion a BD */
  Session session;

  /**
   * Constructor de la clase
   *
   * @param session Session de la base de datos
   */
  @SuppressWarnings("unchecked")
  protected CommonDAOImpl(Session session) {
    setEntityClass(
        (Class<T>)
            ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
    this.session = session;
  }

  /** Metodo insert, que inserta un objeto en la base de datos */
  public void insert(final T paramT) {

    session = HibernateUtils.getSession();
    try {
      HibernateUtils.startTransaction();
      session.persist(paramT);
      HibernateUtils.flushSession();
      HibernateUtils.commitTransaction();
    } catch (Exception e) {
      HibernateUtils.rollbackTransaction();
      System.out.println("Error al insertar.");
      System.out.println(e.getMessage());
    } finally {
      HibernateUtils.closeSession();
    }
  }

  /** Metodo que modifica un objeto de la base de datos */
  public void update(final T paramT) {
    try {
      HibernateUtils.openSession();
      HibernateUtils.startTransaction();
      HibernateUtils.flushSession();
      HibernateUtils.commitTransaction();
    } catch (Exception e) {
      HibernateUtils.rollbackTransaction();
      System.out.println("Error al actualizar.");
    } finally {
      HibernateUtils.closeSession();
    }
  }

  /** Metodo que elimina un objeto de la base de datos */
  public void delete(final T paramT) {
    try {
      session = HibernateUtils.getSession();
      HibernateUtils.startTransaction();
      session.remove(paramT);
      HibernateUtils.commitTransaction();
    } catch (Exception e) {
      HibernateUtils.rollbackTransaction();
      System.out.println("Error al eliminar.");
      System.out.println(e.getMessage());
    } finally {
      HibernateUtils.closeSession();
    }
  }

  /** Método que lista todos los objetos de la base de datos */
  public List<T> searchAll() {
    HibernateUtils.openSession();
    List<T> list = null;
    try {
      list =
          HibernateUtils.getSession()
              .createQuery("FROM " + this.entityClass.getName(), this.entityClass)
              .list();
    } catch (Exception e) {
      System.out.println("Error al listar.");
    } finally {
      HibernateUtils.closeSession();
    }
    return list;
  }

  /**
   * @return the entityClass
   */
  public Class<T> getEntityClass() {
    return entityClass;
  }

  /**
   * @param entityClass the entityClass to set
   */
  public void setEntityClass(Class<T> entityClass) {
    this.entityClass = entityClass;
  }
}
