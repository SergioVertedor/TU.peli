package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import model.Serie;

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

		return (Serie) session.createQuery("FROM Serie WHERE idWork=" + idSerie).uniqueResult();
	}

	@Override
	public List<Serie> searchByTitle(String title) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Serie WHERE originalTitle='" + title + "'").list();
	}
	
	@Override
	public List<Serie> searchByGenre(String genre) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Serie WHERE genre='" + genre + "'").list();
	}

	@Override
	public List<Serie> searchByLessRuntime(Integer runtime) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Serie WHERE runtime < " + runtime).list();
	}

	@Override
	public List<Serie> searchByCountry(String country) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Serie WHERE originalCountry='" + country + "'").list();
	}


}
