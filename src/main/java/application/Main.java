package application;

import controllers.PantallaLoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import utils.SceneSwitcher;

import java.io.IOException;

/**
 * Clase principal
 *
 * @author SVB
 * @author EPP
 */
public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {


      SceneSwitcher ss = new SceneSwitcher();
      ss.switchScene("PantallaLogin");
  }

  public static void main(String[] args) {
    launch(args);
  }
}
