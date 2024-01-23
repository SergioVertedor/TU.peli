package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Genres implements Serializable {
	@Id
	@Column(name = "id")
	private int idGenre;
	@Column(name = "name")
	private int nameGenre;

	@ManyToMany(mappedBy = "genres")
	private Set<Work> works = new HashSet<>();
}
