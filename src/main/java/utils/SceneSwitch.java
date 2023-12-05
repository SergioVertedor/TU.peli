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

public class SceneSwitch {
	public void switchScene(String fxml, Object controller) throws IOException {
		StringBuilder path = new StringBuilder();
		String fxmlFile = path.append("/view/").append(fxml).append(".fxml").toString();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxmlFile));
		Parent root = loader.load(); // Carga pantalla principal
		controller = loader.getController();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);

		// EVA - Obtener la pantalla principal
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		// Crear la escena con las dimensiones de la pantalla
		Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight());

		// No lo borro para que veas el cambio
//        Scene scene = new Scene(root);
		stage.setScene(scene);
		// Quita el foco de los textbox
		root.requestFocus();
		// Poner icono a la ventana
		Image icon = new Image("resources/images/logo/logo.png");
		stage.getIcons().add(icon);
		// Poner titulo a la ventana
		stage.setTitle("TU.PELI");
		stage.showAndWait();

	}

	public void closeDialog(Button boton) {
		Stage stage = (Stage) boton.getScene().getWindow();
		stage.close();
	}

}
