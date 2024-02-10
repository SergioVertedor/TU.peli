package application.thread;

import java.util.Arrays;

import controllers.PaneInicioController;
import service.APIService;
import utils.ListStorage;

/**
 * Clase que realiza peticiones HTTP a la API de TheMovieDB y los almacena en la lista de películas
 * y series más populares.
 */
public class WorkerPantallaInicio extends Thread {
  @Override
  public void run() {
    PaneInicioController.fillWorks();
  }
}
