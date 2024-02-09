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

/**
 * Clase que proporciona métodos para cifrar y descifrar mensajes utilizando el
 * algoritmo RSA. Opera en mensajes codificados en Base64.
 * 
 * @author SVB
 * @author EPP
 *
 */
public class RSAUtils {

	/** Contraseña del almacén de claves */
	public static final String PASSWORD_KEYSTORE = "Megustalapizzamucho.RSA";

	/** Ruta del almacén de claves */
	public static final String RUTA_KEYSTORE = "files/tupeliKeyStore";

	/** Alias del almacén de claves */
	public static final String ALIAS = "tupelistore";

	/**
	 * Método que cifra el contenido de un password en RSA 2048 en base64
	 *
	 * @param password mensaje a cifrar
	 * @return mensaje cifrado
	 */
	public static String cifra(String password) {
		KeyStore almacen = null;
		try {
			// Carga el almacén de claves desde el archivo especificado
			almacen = KeyStore.getInstance(new File(RUTA_KEYSTORE), PASSWORD_KEYSTORE.toCharArray());
		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
			e.printStackTrace();
		}
		PublicKey clavePublica = getPublicKey(almacen, ALIAS);
		Cipher cifrador;
		byte[] passwordCifrado = null;
		try {
			cifrador = Cipher.getInstance("RSA");
			cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
			passwordCifrado = cifrador.doFinal(password.getBytes());
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}

		// Codifica el mensaje cifrado en formato Base64
		return Base64.getEncoder().encodeToString(passwordCifrado);
	}

	/**
	 * Método que descifra el contenido de un password cifrado en RSA 2048 en base64
	 *
	 * @param passwordCifrado mensaje cifrado en base64
	 * @return mensaje descifrado
	 */
	public static String descifra(String passwordCifrado) {
		KeyStore almacen = null;
		byte[] passwordOriginal = Base64.getDecoder().decode(passwordCifrado);
		byte[] resultado = null;
		try {
			// Carga el almacén de claves desde el archivo especificado
			almacen = KeyStore.getInstance(new File(RUTA_KEYSTORE), PASSWORD_KEYSTORE.toCharArray());
		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
			e.printStackTrace();
		}

		// Obtiene la clave privada del almacén
		PrivateKey clavePrivada = getPrivateKey(almacen, ALIAS);

		// Descifra el mensaje utilizando RSA
		Cipher cifrador;
		try {
			cifrador = Cipher.getInstance("RSA");
			cifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
			resultado = cifrador.doFinal(passwordOriginal);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}

		// Devuelve el resultado
		return new String(resultado);
	}

	/**
	 * Método que recoge la clave privada RSA del almacen y la devuelve.
	 *
	 * @param almacen almacen de claves
	 * @param alias   alias del usuario
	 * @return clave privada
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
	 * @param almacen almacen de claves
	 * @param alias   alias del usuario
	 * @return clave pública
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
