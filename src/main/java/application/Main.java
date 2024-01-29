package application;

import connector.HibernateUtils;
import javafx.application.Application;
import javafx.stage.Stage;
import utils.DialogNotificator;
import utils.PropertiesManager;
import utils.SceneSwitcher;
import utils.SessionHandler;

/**
 * @author SVB
 * @author EPP
 */
public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    try {
      try {
        HibernateUtils.openSession();
      } catch (Exception e) {
        System.err.println("\n####### TRAZA #######\n");
        e.printStackTrace();
        var dialogNotificator = new DialogNotificator();
        dialogNotificator.databaseConnectionError();
        System.exit(1);
      }
      if (PropertiesManager.getRememberLogin() == 1) {
        // Gestiona el cambio de escena a "Pantalla Modelo"
        SceneSwitcher sceneSwitch = new SceneSwitcher();
        sceneSwitch.switchScene("PantallaModelo");
        SessionHandler.setAppUser(PropertiesManager.getUser());
      } else {
        // Gestiona el cambio de escena a "Pantalla Login"
        SceneSwitcher sceneSwitch = new SceneSwitcher();
        sceneSwitch.switchScene("PantallaLogin");
      }

    } catch (Exception e) {
      // Imprime un mensaje en caso de error
      System.err.println("Error al cargar la ventana");
    }
  }

  /**
   * Inicia la aplicación JavaFX
   *
   * @param args
   */
  public static void main(String[] args) {
    launch(args);
  }
}
