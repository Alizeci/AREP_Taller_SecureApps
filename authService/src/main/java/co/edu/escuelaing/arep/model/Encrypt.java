package co.edu.escuelaing.arep.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite agregar seguridad a una propiedad del usuario
 *
 * @author Laura Izquierdo
 */
public class Encrypt {

	/**
	 * Método que cifra en un hash SHA-256 la contraseña del usuario
	 * @param password - contraseña sin cifrar
	 * @return contraseña cifrada
	 */
	public static String encryptPasswdSHA256(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}

		byte[] hash = messageDigest.digest(password.getBytes());
		StringBuilder stringBuffer = new StringBuilder();

		for (byte b : hash) {
			stringBuffer.append(String.format("%02x", b));
		}

		return stringBuffer.toString();
	}
}