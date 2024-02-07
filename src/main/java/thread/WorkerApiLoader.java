package thread;

import service.APIService;
import utils.ListStorage;

public class WorkerApiLoader extends Thread {
  @Override
  public void run() {
    APIService apiService = new APIService();
    try {
      ListStorage.setTrendingTrendingMovies(apiService.getTrendingMovies().getResults());
      // ListStorage.setTrendingSeries(Arrays.stream(apiService.getTrendingSeries()).toList());
    } catch (Exception e) {
      System.err.println("Error al cargar las películas y series más populares");
      throw new RuntimeException(e);
    }
    System.out.println(ListStorage.getTrendingTrendingMovies().size());
    // System.out.println(ListStorage.getTrendingSeries().size());
  }
}
