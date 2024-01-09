package service;

import com.google.gson.Gson;
import java.io.IOException;
import model.dto.movie.Movie;
import model.dto.movie.MovieSearchResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIService {
  public Movie[] searchMovie(String name) throws IOException {
    OkHttpClient client = new OkHttpClient();
    // Generamos la URL de la petición HTTP.
      String url =
              "https://api.themoviedb.org/3/search/movie?query=" +
                      name +
                      "&include_adult=true&language=es-ES&page=1";
    url = url.replace(" ", "%20").replace("ñ", "%C3%B1");

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

    // Convertimos la respuesta a un objeto MovieSearchResult.
    Gson gson = new Gson();
    MovieSearchResult resultados = gson.fromJson(respuesta, MovieSearchResult.class);

    return resultados.getResults();
  }
}
