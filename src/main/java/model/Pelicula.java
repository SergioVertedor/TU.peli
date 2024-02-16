package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Esta clase representa una película. Hereda de la clase Work.
 */
@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@DiscriminatorValue("M")
public class Pelicula extends Work implements java.io.Serializable {
  @Column(name = "production_companies")
  private String productionCountries;

  public Pelicula(
      String originalTitle,
      LocalDate releaseDate,
      Integer runtime,
      String overview,
      String backdropPath,
      String posterPath,
      Double popularity,
      LocalDate lastViewDate,
      String userComment,
      String productionCountries) {
    super(
        originalTitle,
        releaseDate,
        runtime,
        overview,
        backdropPath,
        posterPath,
        popularity,
        lastViewDate,
        userComment);
    this.productionCountries = productionCountries;
  }

  public Pelicula() {}
}
