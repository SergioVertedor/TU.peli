package model.dao;

import java.util.List;

import model.Serie;

//TODO: Eva - Las series y las películas donde guardan el género?

/**
 * Interface para Serie
 *
 */
public interface SerieDaoI extends CommonDaoInt<Serie> {

	/**
	 * Busca Serie por id
	 * @param idSerie
	 * @return Serie con id dada
	 */
	public Serie searchById(final int idSerie);

	/**
	 * Busca Series por titulo
	 * @param title
	 * @return Series con el titulo dado
	 */
	public List<Serie> searchByTitle(final String title);

	/**
	 * Busca Series con una duración menor a la indicada
	 * @param runtime
	 * @return Series con duración menor a la indicada
	 */
	public List<Serie> searchByLessRuntime(final Integer runtime);

	/**
	 * Busca Series por poularidad
	 * @param popularity
	 * @return Series con popularidad igual a la indicada
	 */
	public List<Serie> searchByPopularity(final Double popularity);

	/**
	 * Busca Series por pais
	 * @param country
	 * @return Series del pais indicado
	 */
	public List<Serie> searchByCountry(final String country);

}
