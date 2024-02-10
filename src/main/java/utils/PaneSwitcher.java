package utils;

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

      // Ajuste resolución maximizada
      myPane.setMaxHeight(centralPane.getMaxHeight());
      myPane.setMaxWidth(centralPane.getMaxWidth());
      myPane.setMinHeight(centralPane.getMinHeight());
      myPane.setMinWidth(centralPane.getMinWidth());
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
