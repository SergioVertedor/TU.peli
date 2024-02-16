package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que modela la tabla "genero" de la base de datos
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genero")
public class Genres implements Serializable {
	@Id
	@Column(name = "id")
	private int idGenre;
	@Column(name = "name")
	private int nameGenre;

	@ManyToMany(mappedBy = "genres")
	private Set<Work> works = new HashSet<>();
}
