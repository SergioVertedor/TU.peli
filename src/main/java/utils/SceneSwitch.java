package utils;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase que facilita el cambio de escenas en una aplicación JavaFX y gestiona
 * la apertura y cierre de ventanas modales. Configura las escenas con tamaños
 * predefinidos y personaliza algunas propiedades de las ventanas, como la no
 * redimensionabilidad, el icono y el título.
 * 
 * @author SVB
 * @author EPP
 */
public class SceneSwitch {

	/**
	 * Método que cambia la escena principal de la aplicación cargando un nuevo
	 * archivo FXML.
	 *
	 * @param fxml       Nombre del archivo FXML que se cargará.
	 * @param controller Objeto del controlador asociado a la nueva escena.
	 * @throws IOException Si ocurre un error durante la carga del archivo FXML.
	 */
	public void switchScene(String fxml, Object controller) throws IOException {

		StringBuilder path = new StringBuilder();
		String fxmlFile = path.append("/view/").append(fxml).append(".fxml").toString();

		// Crear un cargador de FXML y establecer la ubicación del archivo FXML
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxmlFile));
		// Carga la pantalla principal
		Parent root = loader.load();
//		controller = loader.getController();

		// Configura y muestra una nueva ventana modal no redimensionable
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);

		// Obtiene la pantalla principal y su tamaño
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		// Crear la escena con las dimensiones de la pantalla y carga el archivo .css
		// asociado
		Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

		stage.setScene(scene);
		stage.setMaximized(true);

		// Quita el foco de los textbox
		root.requestFocus();

		// Asigna un título e icono a la ventana
		stage.setTitle("TU.PELI");
		Image icon = new Image("images/logo/logo.png");
		stage.getIcons().add(icon);

		// Muestra la nueva ventana y espera hasta que se cierre
		stage.showAndWait();
	}

  /**
   * Método que cierra la ventana modal asociada al botón proporcionado.
   *
   * @param boton Botón dentro de la ventana modal cuya ventana se cerrará.
   */
	public void closeDialog(Button boton) {
		Stage stage = (Stage) boton.getScene().getWindow();
		stage.close();
	}

}
