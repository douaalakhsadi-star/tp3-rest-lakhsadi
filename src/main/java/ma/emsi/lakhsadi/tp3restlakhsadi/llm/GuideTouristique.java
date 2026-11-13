package ma.emsi.lakhsadi.tp3restlakhsadi.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.Result;

public interface GuideTouristique {

    @SystemMessage("""
            Tu es un guide touristique. Pour la ville ou le pays demandé,
            donne exactement le nombre demandé de lieux à visiter et le prix moyen
            d'un repas dans la devise du pays.

            Réponds uniquement avec un objet JSON dans ce format :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["nom du lieu à visiter"],
              "prix_moyen_repas": "<prix> <devise du pays>"
            }
            """)
    Result<InfosTouristiques> conseiller(String demande);
}