package application.thread;

import java.util.Arrays;
import service.APIService;
import utils.ListStorage;

/**
 * Clase que realiza peticiones HTTP a la API de TheMovieDB y los almacena en la lista de películas
 * y series más populares.
 */
public class WorkerMovieSearch extends Thread {
  private final String name;
public WorkerMovieSearch(String name) {
    this.name = name;
  }
  @Override
  public void run() {
    APIService apiService = new APIService();
    try {
      ListStorage.setSearchMovies(
          Arrays.stream(apiService.searchMovie(name).getResults()).toList());
      ListStorage.setTrendingSeries(
          Arrays.stream(apiService.searchSerie(name).getResults()).toList());
    } catch (Exception e) {
      System.err.println("Error al cargar las películas y series más populares");
      throw new RuntimeException(e);
    }
  }
}
