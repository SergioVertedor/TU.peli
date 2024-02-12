package utils;

import controllers.PaneBusquedaController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/** Clase que facilita el cambio de paneles en una aplicación JavaFX. */
public class PaneSwitcher {

  /** Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML. */
  public static void switchPane(String paneTarget, Pane centralPane) {
    String fxmlFile = "/views/" + paneTarget + ".fxml";

    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();

      // Hacer que los contenedores se expandan si el tamaño de la ventana cambia
      //      HBox.setHgrow(myPane, Priority.ALWAYS);
      //      VBox.setVgrow(myPane, Priority.ALWAYS);

      centralPane.getChildren().setAll(myPane);
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }

  /**
   * Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML y
   * rellenando los resultados de la búsqueda.
   * @param paneTarget
   * @param centralPane
   * @param type {m}ovie or {t}v
   */
  public static void switchSearchPane(String paneTarget, Pane centralPane, char type) {
    String fxmlFile = "/views/" + paneTarget + ".fxml";
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();
      centralPane.getChildren().setAll(myPane);
      PaneBusquedaController paneBusquedaController = loader.getController();
      paneBusquedaController.fillResults(type);
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }
}
