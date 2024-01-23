package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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
