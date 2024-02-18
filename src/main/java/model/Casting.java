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
 * Clase que representa un casting de una película o serie.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "casting")
public class Casting implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int idCasting;

  @Column(name = "name")
  private String castName;

  @Column(name = "character")
  private String character;

  @Column(name = "order")
  private int castOrder;

  @Column(name = "profile_path")
  private String profilePath;

  @ManyToMany(mappedBy = "casting")
  private Set<Work> works = new HashSet<>();
}
