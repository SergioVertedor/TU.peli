package utils;

import model.connector.HibernateUtils;
import java.io.*;
import java.util.Properties;
import model.AppUser;
import model.dao.AppUserImpl;

/**
 * Clase que se encarga de manejar el archivo de configuración del programa
 *
 * @author SVB
 * @author EPP
 */
public class PropertiesManager {

  /** Ruta del archivo de configuración por defecto */
  private static final String CONFIG_FILE = "src/main/resources/config.properties";

  /**
   * Método que se encarga de obtener el valor de la propiedad user
   * @param nombreUsuario
   */
  public static void setUser(String nombreUsuario) {
    Properties prop = new Properties();
    InputStream input = null;
    OutputStream output = null;

    try {
      // Se intenta cargar la configuración existente desde el archivo especificado
      input = new FileInputStream(CONFIG_FILE);
      prop.load(input);
      // Se establece el valor proporcionado en "user"
      prop.setProperty("user", nombreUsuario);
      // Se guarda la configuración actualizada en el mismo archivo
      output = new FileOutputStream(CONFIG_FILE);
      prop.store(output, null);
      // Imprime un mensaje en caso de error
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

  /**
   * Método que se encarga de obtener el valor de la propiedad user
   * @return
   */
  public static AppUser getUser() {
    Properties prop = new Properties();
    InputStream input = null;
    AppUser user = null;
    try {
      // Se intenta cargar la configuración existente desde el archivo especificado
      input = new FileInputStream(CONFIG_FILE);
      prop.load(input);
      // Se obtiene el valor de "user"
      String username = prop.getProperty("user");
      // Se obtiene el usuario con el nombre de usuario obtenido
      var appUserImpl = new AppUserImpl(HibernateUtils.getSession());
      user = appUserImpl.searchByUsername(username);
      // Imprime un mensaje en caso de error
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
    }
    return user;
  }

  /**
   * Método que se encarga de obtener el valor de la propiedad remember
   *
   * @param valor valor por defecto
   */
  public static void setRememberLogin(String valor) {

    Properties prop = new Properties();
    InputStream input = null;
    OutputStream output = null;

    try {
      // Se intenta cargar la configuración existente desde el archivo especificado
      input = new FileInputStream(CONFIG_FILE);
      prop.load(input);
      // Se establece el valor proporcionado en "remember"
      prop.setProperty("rememberLogin", valor);
      // Se guarda la configuración actualizada en el mismo archivo
      output = new FileOutputStream(CONFIG_FILE);
      prop.store(output, null);
      // Imprime un mensaje en caso de error
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

  /**
   * Método que se encarga de obtener el valor de la propiedad remember
   *
   * @return valor de la propiedad remember
   */
  public static int getRememberLogin() {
    Properties prop = new Properties();
    InputStream input = null;
    int rememberLogin = 0;
    try {
      // Se intenta cargar la configuración existente desde el archivo especificado
      input = new FileInputStream(CONFIG_FILE);
      prop.load(input);
      // Se obtiene el valor de "remember"
      rememberLogin = Integer.parseInt(prop.getProperty("rememberLogin"));
      // Imprime un mensaje en caso de error
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
    }
    return rememberLogin;
  }
}
