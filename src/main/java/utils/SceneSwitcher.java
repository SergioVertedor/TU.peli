package utils;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase que facilita el cambio de escenas en una aplicación JavaFX y gestiona la apertura y cierre
 * de ventanas modales. Configura las escenas con tamaños predefinidos y personaliza algunas
 * propiedades de las ventanas, como la no redimensionabilidad, el icono y el título.
 * 
 * @author SVB
 * @author EPP
 */
public class SceneSwitcher {

  private static Stage stage;
  private boolean primeraVez;
  /**
   * Método que cambia la escena principal de la aplicación cargando un nuevo archivo FXML.
   *
   * @param fxml Nombre del archivo FXML que se cargará.
   * @param controller Objeto del controlador asociado a la nueva escena.
   * @throws IOException Si ocurre un error durante la carga del archivo FXML.
   */
  public void switchScene(String fxml) throws IOException {

    if (stage == null) {
      setupStage();
      primeraVez = true;
    }
    
    StringBuilder path = new StringBuilder();
    String fxmlFile = path.append("/view/").append(fxml).append(".fxml").toString();

    // Crear un cargador de FXML y establecer la ubicación del archivo FXML
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(fxmlFile));
    // Carga la pantalla principal
    Parent root = loader.load();
    // Obtiene la pantalla principal y su tamaño
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();

    // Crear la escena con las dimensiones de la pantalla y carga el archivo .css
    // asociado
    Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
    scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
    // Asigna la escena a la ventana principal
    stage.setScene(scene);
    // Quita el foco de los textbox
    root.requestFocus();
    
    // Muestra la nueva ventana y espera hasta que se cierre
    if (primeraVez) {
      stage.showAndWait();
      primeraVez = false;
    }
  }

  public void setupStage() {
    // Configura y muestra una nueva ventana modal no redimensionable
    stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setResizable(false);
    stage.setMaximized(true);
    // Asigna un título e icono a la ventana
    stage.setTitle("TU.PELI");
    Image icon = new Image("images/logo/logo.png");
    stage.getIcons().add(icon);
  }
}
