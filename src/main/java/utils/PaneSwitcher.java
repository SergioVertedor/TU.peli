package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/** Clase que facilita el cambio de paneles en una aplicación JavaFX. */
public class PaneSwitcher {

  /** Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML. */
  public static void switchPane(String paneTarget, Pane centralPane) {
    StringBuilder path = new StringBuilder();
    String fxmlFile = path.append("/views/").append(paneTarget).append(".fxml").toString();

    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();

      // Ajuste resolución maximizada
      myPane.setPrefHeight(centralPane.getPrefHeight());
      myPane.setPrefWidth(centralPane.getPrefWidth());
      
      // Hacer que los contenedores se expandan si el tamaño de la ventana cambia
      HBox.setHgrow(myPane, Priority.ALWAYS);
      VBox.setVgrow(myPane, Priority.ALWAYS);

      centralPane.getChildren().setAll(myPane);
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }
}
