package ma.emsi.lakhsadi.tp3restlakhsadi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Renvoie le lieu demandé dans un tableau à un seul élément.
     *
     * @param lieu nom de la ville ou du pays
     * @return tableau contenant le nom du lieu
     */
    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] endroitsDeVisite(@PathParam("ville_ou_pays") String lieu) {
        return new String[]{lieu};
    }
}