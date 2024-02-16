package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.time.LocalDate;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import service.dto.GenreSearchResult;
import service.dto.credits.Credits;
import service.dto.movie.MovieDetail;
import service.dto.movie.MovieSearchResult;
import service.dto.tv.TVDetail;
import service.dto.tv.TVSearchResult;
import service.dto.watchprovider.WatchProvider;
import utils.Formatter;
import utils.LocalDateAdapter;

/** Clase que realiza peticiones HTTP a la API de TheMovieDB. */
public class APIService {
  private static final String API_KEY =
      "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMjZlMzczZjc2YTg2MDVmOTQ0ZjYwOTMzZTY0N2Y2NiIsInN1YiI6IjY1NDdmOGNlOWNjNjdiMDBjNDQ0MjhjYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.PD_QdMd_IC5sm_WkUyNSEORJJOZLXpGUNHm5qvMf_IE";

  /**
   * Busca una película en la API de TheMovieDB.
   *
   * @param name Nombre de la película a buscar.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public MovieSearchResult searchMovie(String name) {
    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/search/movie?query="
            + Formatter.acondicionaUrl(name)
            + "&include_adult=true&language=es-ES&page=1";
    Gson gson = new Gson();
    try {
      return gson.fromJson(doRequest(url), MovieSearchResult.class);
    } catch (IOException e) {
      System.err.println("Error al buscar películas.");
      throw new RuntimeException(e);
    }
  }

  /**
   * Busca una película por año en la API de TheMovieDB.
   *
   * @param date Año desde el que se quiere buscar películas.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException
   */
  public MovieSearchResult searchMovieByDate(String date) {
    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/discover/movie?include_adult=true&include_video=false&language=es-ES&page=1&release_date.gte="
            + date
            + "&sort_by=popularity.desc";
    Gson gson = new Gson();
    try {
      return gson.fromJson(doRequest(url), MovieSearchResult.class);
    } catch (IOException e) {
      System.err.println("Error al buscar películas por fecha.");
      throw new RuntimeException(e);
    }
  }

  public TVSearchResult searchSerieByYear(String date) {
    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/discover/tv?include_adult=true&include_video=true&language=es-ES&page=1&first_air_date.gte="
            + date
            + "&sort_by=popularity.desc";
    Gson gson = new Gson();
    try {
      return gson.fromJson(doRequest(url), TVSearchResult.class);
    } catch (IOException e) {
      System.err.println("Error al buscar series por año.");
      throw new RuntimeException(e);
    }
  }

  /**
   * Busca una serie en la API de TheMovieDB.
   *
   * @param name Nombre de la serie a buscar.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public TVSearchResult searchSerie(String name) {
    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/search/tv?query="
            + Formatter.acondicionaUrl(name)
            + "&include_adult=true&language=es-ES&page=1";
    Gson gson = new Gson();
    try {
      return gson.fromJson(doRequest(url), TVSearchResult.class);
    } catch (IOException e) {
      System.err.println("Error al buscar series.");
      throw new RuntimeException(e);
    }
  }

  /**
   * Obtiene el detalle de una serie.
   *
   * @param id ID de la serie.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public TVDetail getTVDetail(int id) {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/tv/" + id + "?language=es-ES";
    Gson gson =
        new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
    try {
      return gson.fromJson(doRequest(url), TVDetail.class);
    } catch (IOException e) {
      System.err.println("Error al obtener los detalles de la serie.");
      throw new RuntimeException(e);
    }
  }

  /**
   * Obtiene las películas más populares de la semana.
   *
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public MovieSearchResult getTrendingMovies() throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/trending/movie/week?language=es-ES";
    // Parseamos la respuesta a un objeto Java.
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), MovieSearchResult.class);
  }

  /**
   * Obtiene las series más populares de la semana.
   *
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public TVSearchResult getTrendingSeries() throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/trending/tv/day?language=es-ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), TVSearchResult.class);
  }

  /**
   * Obtiene los géneros de las películas.
   *
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public GenreSearchResult getTVGenres() throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/genre/tv/list?language=es-ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), GenreSearchResult.class);
  }

  /**
   * Obtiene los géneros de las series.
   *
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public GenreSearchResult getMovieGenres() throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/genre/movie/list?language=es-ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), GenreSearchResult.class);
  }

  /**
   * Obtiene los detalles de una película.
   *
   * @param id ID de la película.
   * @return Objeto Java con los resultados de la búsqueda.
   */
  public MovieDetail getMovieDetails(int id) {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/movie/" + id + "?language=es-ES";
    Gson gson =
        new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
    try {
      return gson.fromJson(doRequest(url), MovieDetail.class);
    } catch (IOException e) {
      System.err.println("Error al obtener los detalles de la película.");
      throw new RuntimeException(e);
    }
  }

  /**
   * Obtiene las películas por género.
   *
   * @param idGenero ID del género.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public MovieSearchResult getMovieByGenre(int idGenero) throws IOException {
    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/discover/movie?include_adult=true&include_video=false&language=es-ES&page=1&sort_by=popularity.desc&with_genres="
            + idGenero;
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), MovieSearchResult.class);
  }

  /**
   * Obtiene las series por género.
   *
   * @param idGenero ID del género.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public TVSearchResult getTVByGenre(int idGenero) throws IOException {
    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/discover/tv?include_adult=true&include_video=true&language=es-ES&page=1&sort_by=popularity.desc&with_genres="
            + idGenero;
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), TVSearchResult.class);
  }

  /**
   * Obtiene los créditos de una película.
   *
   * @param idPelicula ID de la película.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public Credits getMovieCredits(long idPelicula) {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/movie/" + idPelicula + "/credits?language=es-ES";
    Gson gson = new Gson();
    try {
      return gson.fromJson(doRequest(url), Credits.class);
    } catch (IOException e) {

      System.err.println("Error al obtener los créditos de la película.");
      throw new RuntimeException(e);
    }
  }

  /**
   * Obtiene los créditos de una serie.
   *
   * @param idSerie ID de la serie.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public Credits getTVCredits(long idSerie) {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/tv/" + idSerie + "/credits?language=es-ES";
    Gson gson = new Gson();
    try {
      return gson.fromJson(doRequest(url), Credits.class);
    } catch (IOException e) {
      System.err.println("Error al obtener los créditos de la serie.");
      throw new RuntimeException(e);
    }
  }

  /**
   * Obtiene las películas mejor valoradas.
   *
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public MovieSearchResult getTopMovies() throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/movie/top_rated?language=es-ES&page=1";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), MovieSearchResult.class);
  }

  /**
   * Obtiene las series mejor valoradas.
   *
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public TVSearchResult getTopSeries() throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/tv/top_rated?language=es-ES&page=1";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), TVSearchResult.class);
  }

  /**
   * Obtiene las películas que se están proyectando en los cines.
   *
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public MovieSearchResult getNowPlayingMovies() throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/movie/now_playing?language=es-ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), MovieSearchResult.class);
  }

  /**
   * Obtiene las películas que se estrenarán.
   *
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public MovieSearchResult getUpcomingMovies() throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/movie/upcoming?language=es-ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), MovieSearchResult.class);
  }

  /**
   * Obtiene los proveedores de streaming de una película.
   * @param id
   * @return
   */
  public WatchProvider getMovieWatchProviders(int id) {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/movie/" + id + "/watch/providers?language=es-ES";
    Gson gson = new Gson();
    try {
      return gson.fromJson(doRequest(url), WatchProvider.class);
    } catch (IOException e) {
      System.out.println("Error al obtener los proveedores de streaming.");
      throw new RuntimeException(e);
    }
  }

  /**
   * Obtiene los proveedores de streaming de una serie.
   * @param id
   * @return
   * @throws IOException
   */
  public WatchProvider getTVWatchProviders(int id) throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/tv/" + id + "/watch/providers?language=es-ES&watch_region=ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), WatchProvider.class);
  }

  /**
   * Realiza una petición HTTP a la API de TheMovieDB.
   *
   * @param url URL de la petición HTTP.
   * @return XML con los resultados de la petición en String.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  private String doRequest(String url) throws IOException {
    OkHttpClient client = new OkHttpClient();
    // Realizamos la petición HTTP.
    Request request =
        new Request.Builder()
            .url(url)
            .get()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer " + API_KEY)
            .build();
    // Obtenemos la respuesta de la petición HTTP.
    Response response = client.newCall(request).execute();
    assert response.body() != null;
    return response.body().string();
  }
}
