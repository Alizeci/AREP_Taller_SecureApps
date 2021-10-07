package co.edu.escuelaing.arep;

import static spark.Spark.port;
import static spark.Spark.secure;

import co.edu.escuelaing.arep.controller.LoginController;
import co.edu.escuelaing.arep.security.SecureUrlReader;
import co.edu.escuelaing.arep.service.LoginService;

/**
 * Clase que gestiona las operaciones sobre el servidor
 * 
 * @author Laura Izquierdo
 */
public class SparkWebServer {
	
	/**
	 * SparkWebServer maneja el login de un usuario en un contexto seguro.
	 * 
	 * @author Laura Izquierdo
	 */
	public static void main(String[] args) {
		port(getPort());

		// API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,
		// truststorePassword);
		secure("keystores/ecikeystore.p12", "123456", null, null);
		SecureUrlReader.initSecureContext();

		new LoginController(new LoginService());
	}

    /**
     * Obtiene el puerto en las variables de entorno del sistema o el por defecto.
     * 
     * @return el puerto
     */
	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567;
	}
}
