package model.dao;

import model.Crew;

/**
 * Interface para Crew
 */
public interface CrewDAOI extends CommonDAOInt<Crew> {
	
	/**
	 * Busca Crew por id
	 * @param idCrew
	 * @return Crew con el id dado
	 */
	public Crew searchById(final int idCrew);
	
	/**
	 * Busca Crews con el nombre dado
	 * @param crewName
	 * @return Crews que coincidan con el nombre dado
	 */
}
