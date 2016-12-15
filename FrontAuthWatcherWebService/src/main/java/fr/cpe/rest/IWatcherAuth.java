package fr.cpe.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.cpe.models.UserModel;
import fr.cpe.models.UserResponseModel;

@Path("/WatcherAuth")
public interface IWatcherAuth {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	UserResponseModel authentication(UserModel user);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/test")
	UserModel authenticationTest(UserModel user);

}
