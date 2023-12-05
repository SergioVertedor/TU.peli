package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {

			// Cargar la vista fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/PantallaLogin.fxml"));
			Pane ventana = (Pane) loader.load();
			Scene scene = new Scene(ventana);

			// Cargar el css
			scene.getStylesheets().add(getClass().getResource("/resources/css/application.css").toExternalForm());


			// Cargar el controlador
			primaryStage.setScene(scene);
			primaryStage.show();

			// Poner titulo a la ventana
			primaryStage.setTitle("TU.PELI");

			// Asignar icono
			Image icon = new Image("resources/images/logo/logo.png");
			primaryStage.getIcons().add(icon);

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
