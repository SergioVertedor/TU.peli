package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import model.Serie;

//TODO: Eva - Me da fallos el .createQuery, aparece como deprecated aunque es lo que usa Nacho
// No me gusta tener que comprobar la sesión en cada uno de los métodos, pero es como lo ahce Nacho xD
public class SerieDaoImpl extends CommonDaoImpl<Serie> implements SerieDaoI {

	private Session session;

	public SerieDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Serie searchById(int idSerie) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return (Serie) session.createQuery("FROM Serie WHERE idWork='" + idSerie + "'").uniqueResult();
	}

	@Override
	public List<Serie> searchByTitle(String title) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Serie WHERE originalTitle='" + title + "'").list();
	}

	@Override
	public List<Serie> searchByLessRuntime(Integer runtime) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Serie WHERE runtime < " + runtime).list();
	}

	@Override
	public List<Serie> searchByPopularity(Double popularity) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Serie WHERE popularity= " + popularity).list();
	}

	@Override
	public List<Serie> searchByCountry(String country) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Serie WHERE originalCountry='" + country + "'").list();
	}

}
