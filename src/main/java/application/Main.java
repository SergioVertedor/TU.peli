package application;

import javafx.application.Application;
import javafx.stage.Stage;
import utils.SceneSwitcher;

/**
 * @author SVB
 * @author EPP
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// Gestiona el cambio de escena a "Pantalla Login"
			SceneSwitcher sceneSwitch = new SceneSwitcher();
			sceneSwitch.switchScene("PantallaLogin");
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
