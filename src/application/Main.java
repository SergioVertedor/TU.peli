package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/PantallaLogin.fxml"));
			
			Pane ventana = (Pane) loader.load();

			Scene scene = new Scene(ventana);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
			// Arranca maximizado
			primaryStage.setMaximized(true);
			
			// Asignar icono
			Image icon = new Image("resources/logo.png");
			primaryStage.getIcons().add(icon);
			
			// Poner titulo a la ventana
			primaryStage.setTitle("TU.PELI");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
