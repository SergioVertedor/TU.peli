package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Genres implements java.io.Serializable {
	private int idGenre;
	private int nameGenre;
}
