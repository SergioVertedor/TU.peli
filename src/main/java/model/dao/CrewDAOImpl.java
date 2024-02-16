package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import model.Crew;

/**
 * Clase con el DAO generico, CommonDaoImpl y la interfaz CrewDAOI

 */
public class CrewDAOImpl extends CommonDAOImpl<Crew> implements CrewDAOI {

	// Sesion para Crew
	private Session session;

	public CrewDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	/**
	 * Busca Crew por id
	 */
	@Override
	public Crew searchById(int idCrew) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return (Crew) session.createQuery("FROM Crew WHERE idCrew ='" + idCrew + "'", Crew.class).uniqueResult();
	}

	/**
	 * Busca Crew por nombre
	 */
	public List<Crew> searchByName(String crewName) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Crew WHERE crewName='" + crewName + "'").list();
	}

}
