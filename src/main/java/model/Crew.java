package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase Crew que representa una entidad de la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "crew")
public class Crew implements Serializable {
  @Id
  @Column(name = "id")
  private int idCrew;

  @Column(name = "name")
  private String crewName;

  @Column(name = "profile_path")
  private String profilePath;

  @Column(name = "job")
  private String job;

  @ManyToMany(mappedBy = "crew")
  private Set<Work> works = new HashSet<>();
}
