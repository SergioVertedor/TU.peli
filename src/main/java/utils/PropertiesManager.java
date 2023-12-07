package utils;

import java.io.*;
import java.util.Properties;

/**
 * Clase que se encarga de manejar el archivo de configuración del programa
 * 
 * @author SVB
 * @author EPP
 * 
 */
public class PropertiesManager {

	/** Ruta del archivo de configuración por defecto */
	private static final String CONFIG_FILE = "src/main/resources/config.properties";

	/**
	 * Método que se encarga de obtener el valor de la propiedad remember
	 * 
	 * @param i valor por defecto
	 */
	public static void setRemember(String i) {

		Properties prop = new Properties();
		InputStream input = null;
		OutputStream output = null;

		try {
			// Se intenta cargar la configuración existente desde el archivo especificado
			input = new FileInputStream(CONFIG_FILE);
			prop.load(input);
			// Se establece el valor proporcionado en "remember"
			prop.setProperty("remember", i);
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
}
