package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import model.Crew;

public class CrewDaoImpl extends CommonDaoImpl<Crew> implements CrewDaoI {

	private Session session;

	public CrewDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Crew searchById(int idCrew) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return (Crew) session.createQuery("FROM Crew WHERE idCrew='" + idCrew + "'").uniqueResult();
	}

	@Override
	public List<Crew> searchByName(String crewName) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Crew WHERE crewName='" + crewName + "'").list();
	}

}
