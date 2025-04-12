package pk.home.training.api.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pk.home.training.api.dto.UserDto;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserApi {
    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Long id);

    @POST
    public Response createUser(UserDto userDto);

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, UserDto userDto);
}