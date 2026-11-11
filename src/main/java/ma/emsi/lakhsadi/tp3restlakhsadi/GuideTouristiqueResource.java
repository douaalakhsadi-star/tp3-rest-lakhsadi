package ma.emsi.lakhsadi.tp3restlakhsadi;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.lakhsadi.tp3restlakhsadi.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    /**
     * Demande à Gemini deux lieux à visiter et le prix moyen d'un repas.
     *
     * @param lieu nom de la ville ou du pays
     * @return conseils touristiques au format JSON
     */
    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(@PathParam("ville_ou_pays") String lieu) {
        return llmClient.conseiller(lieu);
    }
}