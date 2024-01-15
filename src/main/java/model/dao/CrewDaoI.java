package model.dao;

import java.util.List;

import model.Crew;

/**
 * Interface para Crew
 */
public interface CrewDaoI extends CommonDaoInt<Crew> {
	
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
	public List<Crew> searchByName(final String crewName);

}
