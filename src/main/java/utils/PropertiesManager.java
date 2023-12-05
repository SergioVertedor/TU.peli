package utils;

import java.io.*;
import java.util.Properties;

/**
 * Clase que se encarga de manejar el archivo de configuración del programa
 */
public class PropertiesManager {
  private static final String CONFIG_FILE = "src/main/resources/config.properties";

  /**
   * Método que se encarga de obtener el valor de la propiedad remember
   * @param i valor por defecto
   */
  public static void setRemember(String i) {
    Properties prop = new Properties();
    InputStream input = null;
    OutputStream output = null;
    try {
      input = new FileInputStream(CONFIG_FILE);
      prop.load(input);
      prop.setProperty("remember", i);
      // save properties to project root folder
      output = new FileOutputStream(CONFIG_FILE);
      prop.store(output, null);
    } catch (IOException e) {
      System.err.println("Error al cargar el archivo de configuración");
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          System.err.println("Error al cerrar el archivo de configuración");
        }
      }
      if (output != null) {
        try {
          output.close();
        } catch (IOException e) {
          System.err.println("Error al cerrar el archivo de configuración");
        }
      }
    }
  }
}
