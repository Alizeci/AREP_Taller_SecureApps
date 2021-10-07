package co.edu.escuelaing.arep.model;

/**
 * Clase que define las propiedades de un usuario
 * 
 * @author Laura Izquierdo
 */
public class User {

	private String username;
	private String password;

	/**
	 * Constructor of an User
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = Encrypt.encryptPasswdSHA256(password);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


}
