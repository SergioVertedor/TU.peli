package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Crew {
	private int idCrew;
	private String crewName;
	private String profilePath;
	private String job;
}
