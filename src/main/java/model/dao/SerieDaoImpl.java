package model.dao;

import java.util.List;

import org.hibernate.Session;

import model.Serie;

public class SerieDaoImpl extends CommonDaoImpl<Serie> implements SerieDaoI{


	private Session session;

	public SerieDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Serie searchById(int idSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serie> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serie> searchByRuntime(Integer runtime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serie> searchByPopularity(Double popularity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serie> searchByCountry(String Country) {
		// TODO Auto-generated method stub
		return null;
	}

}
