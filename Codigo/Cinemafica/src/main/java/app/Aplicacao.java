package app;

import static spark.Spark.*;
import java.net.*;
import service.*;

public class Aplicacao {
	private static UsuarioService usuarioService = new UsuarioService();
	
	public static void main(String[] args) {
		try {
            InetAddress ipAddress = InetAddress.getByName("127.0.0.1");
            int port = 5353;

            ServerSocket serverSocket = new ServerSocket(port, 0, ipAddress);
            System.out.println("Server bound to " + ipAddress + ":" + port);

			port(5353);
		    
		    staticFiles.location("/public");
		    
		    post("/usuario/insert", (request, response) -> usuarioService.insert(request, response));
		
		    get("/usuario/:ID_Usuario", (request, response) -> usuarioService.get(request, response));
		    
		    get("/usuario/list/:orderby", (request, response) -> usuarioService.getAll(request, response));
		
		    get("/usuario/update/:ID_Usuario", (request, response) -> usuarioService.getToUpdate(request, response));
		    
		    post("/usuario/update/:ID_Usuario", (request, response) -> usuarioService.update(request, response));
		       
		    get("/usuario/delete/:ID_Usuario", (request, response) -> usuarioService.delete(request, response));
		}
		catch (Exception e) {
            e.printStackTrace();	
		}
	}
}   
