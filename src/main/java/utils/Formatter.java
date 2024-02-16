package utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/** Clase que formatea cadenas de texto */
public class Formatter {
  public static String acondicionaUrl(String cadena) {
    StringBuilder resultado = new StringBuilder();
    String cadenaValida = "@-.0123456789@ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz~";
    char[] charValidos = cadenaValida.toCharArray();
    boolean esValido = false;
    for (int i = 0; i < cadena.length(); i++) {
      char caracterAVerificar = cadena.charAt(i);
      for (char charValido : charValidos) {
        if (caracterAVerificar == charValido) {
          esValido = true;
          break;
        }
      }
      if (!esValido) {
        String charComoString = String.valueOf(caracterAVerificar);
        resultado.append(URLEncoder.encode(charComoString, StandardCharsets.UTF_8));
      } else {
        resultado.append(caracterAVerificar);
      }
      esValido = false;
    }
    return resultado.toString().replace("+", "%20");
  }
}
