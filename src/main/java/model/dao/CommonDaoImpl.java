package model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 * Clase con el DAO generico, CommonDaoImpl
 * 
 */
public abstract class CommonDaoImpl<T> implements CommonDaoInt<T> {

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
	protected CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	/**
	 * Metodo insert, que inserta un objeto en la base de datos
	 */
	public void insert(final T paramT) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		session.persist(paramT);
		session.flush();
		session.getTransaction().commit();
	}

	/**
	 * Metodo que modifica un objeto de la base de datos
	 */
	public void update(final T paramT) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		session.merge(paramT);
		session.getTransaction().commit();
	}

	/**
	 * Metodo que elimina un objeto de la base de datos
	 */
	public void delete(final T paramT) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		session.remove(paramT);
		session.getTransaction().commit();
	}


	/**
	 * Metodo que lista todos los objetos de la base de datos
	 */
	@SuppressWarnings("unchecked")
	public List<T> searchAll() {
		// if (!session.getTransaction().isActive()) {
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		// Devuelve todos los objetos
		return session.createQuery("FROM " + this.entityClass.getName()).list();
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
