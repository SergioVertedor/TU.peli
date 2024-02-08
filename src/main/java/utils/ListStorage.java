package utils;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import service.dto.Genre;
import service.dto.credits.Credits;
import service.dto.movie.Movie;
import service.dto.tv.TV;

public class ListStorage {
  // Añadimos las listas de películas y series más populares.
  @Setter @Getter private static List<Movie> trendingMovies;
  @Setter @Getter private static List<TV> trendingSeries;

  // Añadimos las listas de búsqueda.
  @Setter @Getter private static List<Movie> searchMovies;
  @Setter @Getter private static List<TV> searchSeries;

  // Añadimos las listas de géneros.
  @Setter @Getter private static List<Genre> movieGenres;
  @Setter @Getter private static List<Genre> tvGenres;

  // Añadimos las listas de películas y series por género.
  @Setter @Getter private static List<Movie> movieByGenre;
  @Setter @Getter private static List<TV> tvByGenre;

  // Añadimos los créditos de las películas y series.
  @Setter @Getter private static Credits movieCredits;
}
