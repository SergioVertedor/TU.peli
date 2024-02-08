package service;

import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import service.dto.GenreSearchResult;
import service.dto.credits.Credits;
import service.dto.movie.MovieDetail;
import service.dto.movie.MovieSearchResult;
import service.dto.tv.TVDetail;
import service.dto.tv.TVSearchResult;
import utils.Formatter;

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
  public MovieSearchResult searchMovie(String name) throws IOException {
    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/search/movie?query="
            + Formatter.acondicionaUrl(name)
            + "&include_adult=true&language=es-ES&page=1";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), MovieSearchResult.class);
  }

  /**
   * Busca una serie en la API de TheMovieDB.
   *
   * @param name Nombre de la serie a buscar.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public TVSearchResult searchSerie(String name) throws IOException {
    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/search/tv?query="
            + Formatter.acondicionaUrl(name)
            + "&include_adult=true&language=es-ES&page=1";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), TVSearchResult.class);
  }
public MovieDetail getMovieDetail(int id) throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/movie/" + id + "?language=es-ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), MovieDetail.class);
  }

  public TVDetail getTVDetail(int id) throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/tv/" + id + "?language=es-ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), TVDetail.class);
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
   * @param idPelicula ID de la película.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public Credits getMovieCredits(int idPelicula) throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/movie/" + idPelicula + "/credits?language=es-ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), Credits.class);
  }

  /**
   * Obtiene los créditos de una serie.
   * @param idSerie ID de la serie.
   * @return Objeto Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public Credits getTVCredits(int idSerie) throws IOException {
    // Generamos la URL de la petición HTTP.
    String url = "https://api.themoviedb.org/3/tv/" + idSerie + "/credits?language=es-ES";
    Gson gson = new Gson();
    return gson.fromJson(doRequest(url), Credits.class);
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
