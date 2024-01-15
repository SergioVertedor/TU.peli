package service;

import com.google.gson.Gson;
import java.io.IOException;
import model.dto.movie.Movie;
import model.dto.movie.MovieSearchResult;
import model.dto.tv.TV;
import model.dto.tv.TVSearchResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.Formatter;

/**
 * Clase que realiza peticiones HTTP a la API de TheMovieDB.
 */
public class APIService {
  /**
   * Busca una película en la API de TheMovieDB.
   * @param name Nombre de la película a buscar.
   * @return Array de objetos Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public Movie[] searchMovie(String name) throws IOException {

    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/search/movie?query="
            + name
            + "&include_adult=true&language=es-ES&page=1";
    MovieSearchResult resultados = (MovieSearchResult) realizaPeticion(url);
    return resultados.getResults();
  }

  /**
   * Busca una serie en la API de TheMovieDB.
   * @param name Nombre de la serie a buscar.
   * @return Array de objetos Java con los resultados de la búsqueda.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  public TV[] searchSerie(String name) throws IOException {
    OkHttpClient client = new OkHttpClient();
    // Generamos la URL de la petición HTTP.
    String url =
        "https://api.themoviedb.org/3/search/tv?query="
            + name
            + "&include_adult=true&language=es-ES&page=1";
    TVSearchResult resultados = (TVSearchResult) realizaPeticion(url);
    return resultados.getResults();
  }

  /**
   * Realiza una petición HTTP a la API de TheMovieDB.
   * @param url URL de la petición HTTP.
   * @return Objeto Java con la respuesta de la petición HTTP.
   * @throws IOException Excepción en caso de que la petición HTTP falle.
   */
  private Object realizaPeticion(String url) throws IOException {
    OkHttpClient client = new OkHttpClient();
    url = Formatter.acondicionaUrl(url);
    // Realizamos la petición HTTP.
    Request request =
        new Request.Builder()
            .url(url)
            .get()
            .addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYWY3ZjMyNDg3M2MwMDE3NTgyOWZiYWU1Mzc5ZGZiYiIsInN1YiI6IjY1NDdmOGNlOWNjNjdiMDBjNDQ0MjhjYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.yG0pBbkkyQIuKQC2R29693wlZDiTYR9grEOgNfw6Kx8")
            .build();
    // Obtenemos la respuesta de la petición HTTP.
    Response response = client.newCall(request).execute();
    assert response.body() != null;
    String respuesta = response.body().string();
    // Parseamos la respuesta a un objeto Java.
    Gson gson = new Gson();
    return gson.fromJson(respuesta, Object.class);
  }
}
