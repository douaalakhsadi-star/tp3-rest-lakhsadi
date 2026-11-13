package ma.emsi.lakhsadi.tp3restlakhsadi;

import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.emsi.lakhsadi.tp3restlakhsadi.llm.LlmClient;
import ma.emsi.lakhsadi.tp3restlakhsadi.llm.InfosTouristiques;
import ma.emsi.lakhsadi.tp3restlakhsadi.llm.InfosTouristiquesAvecUsage;
import ma.emsi.lakhsadi.tp3restlakhsadi.llm.TokenUsageDto;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response endroitsDeVisite(
            @PathParam("ville_ou_pays") String lieu,
            @QueryParam("nb") @DefaultValue("2") String nombre) {
        int nb;
        try {
            nb = Integer.parseInt(nombre);
        } catch (NumberFormatException e) {
            throw new BadRequestException("Le paramètre nb doit être un entier positif.");
        }

        if (nb < 1) {
            throw new BadRequestException("Le paramètre nb doit être un entier positif.");
        }

        var resultat = llmClient.conseiller(lieu, nb);
        InfosTouristiques infos = resultat.content();
        var usage = resultat.tokenUsage();

        TokenUsageDto usageTokens = null;
        if (usage != null) {
            usageTokens = new TokenUsageDto(
                    usage.inputTokenCount(),
                    usage.outputTokenCount(),
                    usage.totalTokenCount()
            );
        }

        var reponse = new InfosTouristiquesAvecUsage(
                infos.ville_ou_pays(),
                infos.endroits_a_visiter(),
                infos.prix_moyen_repas(),
                usageTokens
        );

        return Response.ok(reponse, MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
}