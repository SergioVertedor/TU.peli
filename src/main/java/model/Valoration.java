package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Valoration {
	private int idWork;
	private int idUser;
	private double rating;
	private String userComment;
}
