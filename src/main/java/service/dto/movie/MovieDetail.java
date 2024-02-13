package service.dto.movie;

import java.time.LocalDate;
import lombok.Data;
import service.dto.Genre;
import service.dto.ProductionCompany;
import service.dto.ProductionCountry;
import service.dto.SpokenLanguage;

@Data
public class MovieDetail {
  private boolean adult;
  private String backdrop_path;
  private Object belongs_to_collection;
  private long budget;
  private Genre[] genres;
  private String homepage;
  private long id;
  private String imdbID;
  private String original_language;
  private String original_title;
  private String overview;
  private double popularity;
  private String poster_path;
  private ProductionCompany[] production_companies;
  private ProductionCountry[] production_countries;
  private LocalDate release_date;
  private long revenue;
  private long runtime;
  private SpokenLanguage[] spoken_languages;
  private String status;
  private String tagline;
  private String title;
  private boolean video;
  private double vote_average;
  private long vote_count;
}
