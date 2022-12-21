package ec.edu.ups.appweb.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;

import ec.edu.ups.appweb.business.PersonaONLocal;
import ec.edu.ups.appweb.model.Persona;

@Path("users")
@OpenAPIDefinition(info= @Info(title = "Saludos usuarios server", description = "Servicio de registro y listado de usuario", version="1.0"))
public class UserService {
	@Inject
	private PersonaONLocal personaON;
	
	@POST
	@Path("register")
	@Counted(description="Registro de usuarios", absolute= true)
	@Timed(name="Register-time", description="Tiempo de registro de usuario", unit=MetricUnits.MILLISECONDS, absolute=true)
	@APIResponse(
			responseCode = "200",
			description = "Usuario Creado",
			content = @Content(mediaType = "application/json")
			)
	@Operation(summary="Registrar un usuario", description="Retorno del registro de nuevo ususario")
	@Consumes(MediaType.APPLICATION_JSON)
	public void registrarUsuario(Persona persona) {
		try {
			personaON.insert(persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("listado")
	@Counted(description="Lectura de usuarios", absolute= true)
	@Timed(name="ReadUsers-time", description="Tiempo de recuperación de usuarios", unit=MetricUnits.MILLISECONDS, absolute=true)
	@APIResponse(
			responseCode = "200",
			description = "Usuarios recuperados",
			content = @Content(mediaType = "application/json")
			)
	@Operation(summary="Recuperar usuarios", description="Recupera los usuarios registrados")
	@Produces(MediaType.APPLICATION_JSON)	//En qué parámetro respondemos
	public List<Persona> getUsuarios(){
		return personaON.getUsers();
	}
	
}