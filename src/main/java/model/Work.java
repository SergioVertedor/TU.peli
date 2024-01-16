package model;

import connector.HibernateUtils;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "work_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "obra")
public class Work {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
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
