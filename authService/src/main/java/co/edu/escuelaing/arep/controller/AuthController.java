package co.edu.escuelaing.arep.controller;

import static spark.Spark.get;

import co.edu.escuelaing.arep.service.AuthService;

/**
 * Clase que maneja los endpoints del servicio
 *
 * @author Laura Izquierdo
 */
public class AuthController {

	/**
	 * Método que gestiona el login del AuthService
	 * 
	 * @param authService - servicio a gestionar
	 */
	public AuthController(final AuthService authService) {
		get("hello", (req, res) -> "Hello World, from Authentication Service!");
		get("auth", (req, res) -> authService.login(req, res));
	}

}
