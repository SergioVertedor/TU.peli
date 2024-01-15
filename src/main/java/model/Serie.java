package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Serie extends Works {
  private String originalCountry;
  private String productionCompanies;
  private Integer numberOfEpisodes;
  private Integer numberOfSeasons;
}
