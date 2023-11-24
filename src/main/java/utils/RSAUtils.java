package utils;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAUtils {
  final public static String PASSWORD_KEYSTORE = "Megustalapizzamucho.RSA";
  final public static String RUTA_KEYSTORE = "main/files/tupeliKeyStore";

  /**
   * Método que cifra el mensaje que recibe y lo devuelve en base64
   * 
   * @param mensaje
   * @param alias
   * @return
   */

  public static String cifra(String mensaje, String alias) {
    KeyStore almacen = null;
    try {
      almacen = KeyStore.getInstance(new File(RUTA_KEYSTORE), PASSWORD_KEYSTORE.toCharArray());
    } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
      e.printStackTrace();
    }
    PublicKey clavePublica = getPublicKey(almacen, alias);
    Cipher cifrador;
    byte[] mensajeCifrado = null;
    try {
      cifrador = Cipher.getInstance("RSA");
      cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
      mensajeCifrado = cifrador.doFinal(mensaje.getBytes());
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
        | IllegalBlockSizeException | BadPaddingException e) {
      e.printStackTrace();
    }
    return Base64.getEncoder().encodeToString(mensajeCifrado);
  }

/**
 * Método que descifra el contenido de un mensaje cifrado en RSA 2048 en base64
 * @param mensajeCifrado
 * @param alias
 * @return
 */
  public static String descifra(String mensajeCifrado, String alias) {
    KeyStore almacen = null;
    byte[] mensajeOriginal = Base64.getDecoder().decode(mensajeCifrado);
    byte[] resultado = null;
    try {
      almacen = KeyStore.getInstance(new File(RUTA_KEYSTORE), PASSWORD_KEYSTORE.toCharArray());
    } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
      e.printStackTrace();
    }
    PrivateKey clavePrivada = getPrivateKey(almacen, alias);
    Cipher cifrador;
    try {
      cifrador = Cipher.getInstance("RSA");
      cifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
      resultado = cifrador.doFinal(mensajeOriginal);
    } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
        | IllegalBlockSizeException | BadPaddingException e) {
      e.printStackTrace();
    }
    return new String(resultado);
  }

  /**
   * Método que recoge la clave privada RSA del almacen y la devuelve.
   * 
   * @param almacen
   * @param alias
   * @return
   */
  private static PrivateKey getPrivateKey(KeyStore almacen, String alias) {
    PrivateKey clavePrivada = null;
    try {
      clavePrivada = (PrivateKey) almacen.getKey(alias, PASSWORD_KEYSTORE.toCharArray());
    } catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return clavePrivada;
  }

  /**
   * Método que recoge la clave pública RSA del almacen y la devuelve.
   * 
   * @param almacen
   * @param alias
   * @return
   */
  private static PublicKey getPublicKey(KeyStore almacen, String alias) {
    Certificate certificado = null;
    PublicKey clavePublica = null;
    try {
      certificado = almacen.getCertificate(alias);
      clavePublica = certificado.getPublicKey();
    } catch (KeyStoreException e) {
      e.printStackTrace();
    }
    return clavePublica;
  }
}
