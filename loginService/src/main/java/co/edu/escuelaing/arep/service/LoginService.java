package co.edu.escuelaing.arep.service;

import co.edu.escuelaing.arep.security.SecureUrlReader;
import spark.Request;
import spark.Response;

/**
 * Clase que maneja las operaciones de registro autorizado de un usuario
 *
 * @author Laura Izquierdo
 */
public class LoginService {
	
	private final String URL_SERVICE = "https://localhost:4500";
	//private final String URL_SERVICE = "https://ec2-184-73-66-215.compute-1.amazonaws.com:4500";

	/**
	 * Método que autentica un usuario
	 * @param req - solicitud con las credenciales requeridas
	 * @param res - respuesta HTTP
	 * @return Un mensaje de exito o no de la autenticación
	 */
	public Object authenticate(Request req, Response res) {
		System.out.println("Request to authenticate user received!");
		String username = req.queryParams("username");
		String password = req.queryParams("password");
		String response;

		if (username != null && password != null) {
			res.status(200);
			response = SecureUrlReader
					.readURL(URL_SERVICE+"/auth?username=" + username + "&password=" + password);
		} else {
			res.status(400);
			response = "BAD REQUEST!";
		}

		return response;
	}

}
