package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Entity
@SuperBuilder
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
}
