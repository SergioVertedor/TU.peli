package utils;

import controllers.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que se encarga de cambiar el panel principal de la aplicación cargando un nuevo archivo
 */
@Getter
@Setter
public class PaneSwitcher {

  /** Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML. */
  public static void switchPane(String paneTarget, Pane centralPane) {
    String fxmlFile = "/views/" + paneTarget + ".fxml";

    try {
      centralPane.getChildren().clear();
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();

      centralPane.getChildren().setAll(myPane);
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }

  /**
   * Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML y
   * rellenando los resultados de la búsqueda.
   *
   * @param paneTarget
   * @param centralPane
   * @param type {m}ovie or {t}v
   */
  public static void switchFilmotecaPane(String paneTarget, Pane centralPane, char type) {
    String fxmlFile = "/views/" + paneTarget + ".fxml";
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();
      centralPane.getChildren().setAll(myPane);
      PaneBusquedaController paneBusquedaController = loader.getController();
      paneBusquedaController.setCentralPane(centralPane);
      Platform.runLater(() -> paneBusquedaController.fillFilmoteca(type));
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }

  /**
   * Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML y
   * @param paneTarget
   * @param centralPane
   * @param type
   * @param search
   */
  public static void switchResultPane(
      String paneTarget, Pane centralPane, String type, String search) {
    String fxmlFile = "/views/" + paneTarget + ".fxml";
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();
      centralPane.getChildren().setAll(myPane);
      PaneBusquedaController paneBusquedaController = loader.getController();
      paneBusquedaController.setCentralPane(centralPane);
      Platform.runLater(() -> paneBusquedaController.fillSearchResults(type, search));
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }

  /**
   * Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML y
   * @param paneTarget
   * @param centralPane
   * @param type
   */
  public static void switchTopPane(String paneTarget, Pane centralPane, char type) {
    String fxmlFile = "/views/" + paneTarget + ".fxml";
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();
      centralPane.getChildren().setAll(myPane);
      PaneTopController paneTopController = loader.getController();
      paneTopController.fillTopWorks(type, "");
      paneTopController.setCentralPane(centralPane);
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }

  /**
   * Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML y
   * @param paneTarget
   * @param centralPane
   * @param type
   * @param idWork
   */
  public static void switchToDetails(String paneTarget, Pane centralPane, char type, int idWork) {
    String fxmlFile = "/views/" + paneTarget + ".fxml";
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();
      centralPane.getChildren().setAll(myPane);
      PaneDetalleController paneDetalleController = loader.getController();
      PaneDetalleController.setType(type);
      Platform.runLater(() -> paneDetalleController.fillInfo(idWork));
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }

  /**
   * Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML y
   * @param paneTarget
   * @param centralPane
   */
  public static void switchInTheaterPane(String paneTarget, Pane centralPane) {
    String fxmlFile = "/views/" + paneTarget + ".fxml";
    try {
      centralPane.getChildren().clear();
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();
      centralPane.getChildren().setAll(myPane);

      PaneCarteleraController.setContentPane(centralPane);
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }

  /**
   * Método que cambia el panel principal de la aplicación cargando un nuevo archivo FXML y
   * @param paneTarget
   * @param centralPane
   */
  public static void switchUpcomingPane(String paneTarget, Pane centralPane) {
    String fxmlFile = "/views/" + paneTarget + ".fxml";
    try {
      centralPane.getChildren().clear();
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PaneSwitcher.class.getResource(fxmlFile));
      Pane myPane = loader.load();
      centralPane.getChildren().setAll(myPane);
      PaneProximamenteController.setContentPane(centralPane);
    } catch (Exception e) {
      System.out.println("Error al cargar la ventana de inicio.");
      System.out.println(e);
    }
  }
}
