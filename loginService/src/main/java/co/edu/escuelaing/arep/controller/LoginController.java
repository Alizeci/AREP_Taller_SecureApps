package co.edu.escuelaing.arep.controller;

import static spark.Spark.get;

import co.edu.escuelaing.arep.service.LoginService;

/**
 * Clase que maneja los endpoints del servicio
 *
 * @author Laura Izquierdo
 */
public class LoginController {

	/**
	 * Método que gestiona la autenticación del login service
	 * 
	 * @param loginService - servicio a gestionar
	 */
	public LoginController(final LoginService loginService) {
		get("hello", (req, res) -> "Hello World, from Login Service!");
		get("auth", (req, res) -> loginService.authenticate(req, res));
	}

}
