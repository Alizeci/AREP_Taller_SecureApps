package co.edu.escuelaing.arep.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import co.edu.escuelaing.arep.model.User;
import spark.Request;
import spark.Response;
import static spark.Spark.halt;

/**
 * Clase que maneja las operaciones de acceso de un usuario
 *
 * @author Laura Izquierdo
 */
public class AuthService {

	private static Map<String, String> users = new HashMap<>(); // caché

	/**
	 * Método que permite el acceso a un usuario válido
	 * @param req - solicitud con las credenciales requeridas
	 * @param res - respuesta HTTP
	 * @return Un mensaje de exito o no del acceso al servicio
	 */
	public Object login(Request req, Response res) {
		String username = req.queryParams("username");
		String password = req.queryParams("password");
		String response;

		boolean isValid = validate(username, password);

		if (isValid) {
			res.status(200);
			response = "Succesful Login! Welcome " + username + " to your Secure Website";
		} else {
			res.status(403);
			halt(403, "<h1>403 Forbidden, check your credentials!</h1>");
			response = "Forbidden, check your credentials!";
		}

		return response;
	}

	/**
	 * Método que valída al usuario que desea acceder al servicio
	 * @param username - parte de la credencial del usuario
	 * @param password - parte de la credencial del usuario
	 * @return si es válido
	 */
	public boolean validate(String username, String password) {
		System.out.println("Login received");
		defaultCreate();

		boolean result = false;

		Iterator<String> it = users.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			User tmpUser = new User(username, password);
			if (tmpUser.getUsername().equals(key) && tmpUser.getPassword().equals(users.get(key))) {
				result = true;
				break;
			}
		}
		return result;

	}
	
	/**
	 * Método que crea un usuario para efectos de prueba
	 */
	public void defaultCreate() {
		String username = "tester";
		String password = "1234";

		User user = new User(username, password);
		users.put(user.getUsername(), user.getPassword());
	}

}
