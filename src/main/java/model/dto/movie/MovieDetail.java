package model.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.dto.Genre;
import model.dto.ProductionCompany;
import model.dto.ProductionCountry;
import model.dto.SpokenLanguage;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class MovieDetail {
  private boolean adult;
  private String backdropPath;
  private BelongsToCollection belongsToCollection;
  private long budget;
  private Genre[] genres;
  private String homepage;
  private long id;
  private String imdbID;
  private String originalLanguage;
  private String originalTitle;
  private String overview;
  private double popularity;
  private String posterPath;
  private ProductionCompany[] productionCompanies;
  private ProductionCountry[] productionCountries;
  private LocalDate releaseDate;
  private long revenue;
  private long runtime;
  private SpokenLanguage[] spokenLanguages;
  private String status;
  private String tagline;
  private String title;
  private boolean video;
  private double voteAverage;
  private long voteCount;
}
