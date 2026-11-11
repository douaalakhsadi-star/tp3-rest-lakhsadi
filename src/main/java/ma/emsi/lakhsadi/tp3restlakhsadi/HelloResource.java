package ma.emsi.lakhsadi.tp3restlakhsadi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/hello-world")
public class HelloResource {

    @GET
    @Path("personnes/{nom}")
    @Produces("text/plain")
    public Response hello(@PathParam("nom") String nom) {
        // return Response.ok("Hello, " + nom).build();
        return Response.serverError().entity("Internal Server Error").build();
    }
}