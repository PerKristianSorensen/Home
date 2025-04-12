package pk.home.training.impl.resources;

import java.util.Optional;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pk.home.training.api.dto.UserDto;
import pk.home.training.api.resource.UserApi;
import pk.home.training.impl.service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource implements UserApi {

    @Inject
    private UserService userService;

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Long id) {
        Optional<UserDto> user = userService.getUserById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @POST
    public Response createUser(UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, UserDto userDto) {
        userDto.setId(id);
        UserDto updatedUser = userService.updateUser(userDto);
        if (updatedUser == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedUser).build();
    }
}