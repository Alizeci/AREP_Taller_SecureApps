package co.edu.escuelaing.arep;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.secure;

/**
 * Hello world!
 *
 */
public class HelloService {
	public static void main( String[] args )
    {
        port(getPort());
        
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);
        get("hello", (req,res) -> "Hello World, here goes your security!");
    }

	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567;
	}
}
