package ma.emsi.lakhsadi.tp3restlakhsadi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {

    @GET
    @Path("personnes/{nom}")
    @Produces("text/plain")
    public String hello(@PathParam("nom") String nom) {
        return "Hello, " + nom;
    }
}