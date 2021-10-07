package co.edu.escuelaing.arep;

import static spark.Spark.port;
import static spark.Spark.secure;

import co.edu.escuelaing.arep.controller.AuthController;
import co.edu.escuelaing.arep.service.AuthService;

/**
 * Clase que gestiona las operaciones sobre el servidor
 * 
 * @author Laura Izquierdo
 */
public class SparkWebServer {
	
	/**
	 * SparkWebServer maneja la autenticación de un usuario en un contexto seguro.
	 * 
	 * @author Laura Izquierdo
	 */
	public static void main(String[] args) {
		port(getPort());
		// pasar a desplegar

		secure("keystores/authkeystore.p12", "123456", null, null);

		new AuthController(new AuthService());
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
		return 4500;
	}
}
