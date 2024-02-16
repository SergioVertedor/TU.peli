package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * Clase que representa una serie.
 */
@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@DiscriminatorValue("S")
public class Serie extends Work implements java.io.Serializable {
  @Column(name = "original_country")
  private String originalCountry;
  @Column(name = "production_companies")
  private String productionCompanies;
  @Column(name = "number_of_episodes")
  private Integer numberOfEpisodes;
  @Column(name = "number_of_seasons")
  private Integer numberOfSeasons;

  // Añade este constructor que llama al constructor de la clase padre (Work)
  public Serie(String originalTitle, LocalDate releaseDate, Integer runtime, String overview, String backdropPath, String posterPath, Double popularity, LocalDate lastViewDate, String userComment, String originalCountry, String productionCompanies, Integer numberOfEpisodes, Integer numberOfSeasons) {
    super(originalTitle, releaseDate, runtime, overview, backdropPath, posterPath, popularity, lastViewDate, userComment);
    this.originalCountry = originalCountry;
    this.productionCompanies = productionCompanies;
    this.numberOfEpisodes = numberOfEpisodes;
    this.numberOfSeasons = numberOfSeasons;
  }
}
