package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import service.APIService;
import service.dto.Genre;
import service.dto.credits.Credits;
import service.dto.movie.Movie;
import service.dto.tv.TV;
import service.dto.watchprovider.Flatrate;

/**
 * Clase que almacena las listas de películas y series.
 
 */
public class ListStorage {
  // Añadimos las listas de películas y series más populares.
  @Setter @Getter private static List<Movie> trendingMovies = new ArrayList<>();
  @Setter @Getter private static List<TV> trendingSeries = new ArrayList<>();

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
  @Setter @Getter private static Credits credits;

  // Añadimos la lista de peliculas en el cine.
  @Setter @Getter private static List<Movie> nowPlayingMovies;

  // Añadimos la lista de peliculas y las series más populares.
  @Setter @Getter private static List<Movie> topMovies;
  @Setter @Getter private static List<TV> topSeries;

  // Añadimos la lista de peliculas que se estrenarán.
  @Setter @Getter private static List<Movie> upcomingMovies;

  // Añadimos la lista de proveedores de streaming.
  @Setter @Getter private static List<Flatrate> watchProviders;

  /**
   * Método que rellena las listas de películas y series.
   */
  public static void fillLists() {
    var apiService = new APIService();
    try {
      trendingSeries = Arrays.stream(apiService.getTrendingSeries().getResults()).toList();
      trendingMovies = Arrays.stream(apiService.getTrendingMovies().getResults()).toList();
      movieGenres = Arrays.stream(apiService.getMovieGenres().getGenres()).toList();
      tvGenres = Arrays.stream(apiService.getTVGenres().getGenres()).toList();
      topMovies = Arrays.stream(apiService.getTopMovies().getResults()).toList();
      topSeries = Arrays.stream(apiService.getTopSeries().getResults()).toList();
      upcomingMovies = Arrays.stream(apiService.getUpcomingMovies().getResults()).toList();
      nowPlayingMovies = Arrays.stream(apiService.getNowPlayingMovies().getResults()).toList();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
