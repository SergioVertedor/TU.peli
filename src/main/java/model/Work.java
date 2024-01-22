package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Entity
// Inheritance indica que la clase es padre de otras clases
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// DiscriminatorColumn indica el nombre de la columna que indica el tipo de obra
@DiscriminatorColumn(name = "work_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "obra")
public class Work implements java.io.Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "work_id")
  private int idWork;

  @Column(name = "original_title")
  private String originalTitle;

  @Column(name = "release_date")
  private LocalDate releaseDate;

  @Column(name = "runtime")
  private Integer runtime;

  @Column(name = "overview")
  private String overview;

  @Column(name = "backdrop_path")
  private String backdropPath;

  @Column(name = "poster_path")
  private String posterPath;

  @Column(name = "popularity")
  private Double popularity;

  @Column(name = "last_view_date")
  private LocalDate lastViewDate;

  @Column(name = "user_comment")
  private String userComment;

  @OneToMany(mappedBy = "id.work", cascade = CascadeType.ALL)
  private Set<WorkUserStorage> workUserStorages = new HashSet<>();

  public Work(
      String originalTitle,
      LocalDate releaseDate,
      Integer runtime,
      String overview,
      String backdropPath,
      String posterPath,
      Double popularity,
      LocalDate lastViewDate,
      String userComment) {
    this.originalTitle = originalTitle;
    this.releaseDate = releaseDate;
    this.runtime = runtime;
    this.overview = overview;
    this.backdropPath = backdropPath;
    this.posterPath = posterPath;
    this.popularity = popularity;
    this.lastViewDate = lastViewDate;
    this.userComment = userComment;
  }
}
