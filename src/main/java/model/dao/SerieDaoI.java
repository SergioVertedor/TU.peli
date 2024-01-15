package model.dao;

import java.util.List;

import model.Serie;

public interface SerieDaoI extends CommonDaoInt<Serie> {

	public Serie searchById(final int idSerie);

	public List<Serie> searchByTitle(final String title);

	public List<Serie> searchByRuntime(final Integer runtime);

	public List<Serie> searchByPopularity(final Double popularity);

	public List<Serie> searchByCountry(final String Country);

}
