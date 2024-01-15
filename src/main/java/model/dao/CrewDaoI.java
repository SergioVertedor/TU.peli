package model.dao;

import java.util.List;

import model.Crew;

/**
 * Interface for Crew
 */
public interface CrewDaoI extends CommonDaoInt<Crew> {
	
	public Crew searchById(final int idCrew);
	
	public List<Crew> searchByName(final String crewName);

}
