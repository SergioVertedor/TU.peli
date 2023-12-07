package application;

import controllers.PantallaLoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import utils.SceneSwitch;

/**
 * Clase principal
 * 
 * @author SVB
 * @author EPP
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// Gestiona el cambio de escena a "Pantalla Login"
			SceneSwitch sceneSwitch = new SceneSwitch();
			sceneSwitch.switchScene("PantallaLogin", new PantallaLoginController());
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
