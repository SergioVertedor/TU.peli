package application;

import controllers.PantallaLoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.SceneSwitch;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {


			// Tamaño manual - NO FUNCIONA
//			primaryStage.setMaxWidth(1920);
//			primaryStage.setMaxHeight(1080);

			SceneSwitch sceneSwitch  = new SceneSwitch();
      sceneSwitch.switchScene("PantallaLogin", new PantallaLoginController());


			// Cargar la fuente desde el archivo externo
			try {
				Font.loadFont(getClass().getResourceAsStream("/resources/fonts/KronaOne-Regular.ttf"),12);
			} catch (Exception e) {
				System.err.println("Error al cargar la fuente");
			}

			// Arranca maximizado
//      primaryStage.setMaximized(false);

			// Permitir que la ventana sea redimensionable (true) o no (false)
			primaryStage.setResizable(false);

		} catch (Exception e) {
			System.err.println("Error al cargar la ventana");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
