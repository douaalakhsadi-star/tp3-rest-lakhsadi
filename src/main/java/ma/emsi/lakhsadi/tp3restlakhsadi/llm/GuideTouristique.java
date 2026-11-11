package ma.emsi.lakhsadi.tp3restlakhsadi.llm;

import dev.langchain4j.service.SystemMessage;

public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique. Pour la ville ou le pays demandé,
        indique exactement deux endroits à visiter et estime le prix moyen
        d'un repas dans la devise du pays.

        Réponds uniquement avec un objet JSON au format suivant :
        {
          "ville_ou_pays": "nom de la ville ou du pays",
          "endroits_a_visiter": ["endroit 1", "endroit 2"],
          "prix_moyen_repas": "<prix> <devise du pays>"
        }
        """)
    String conseiller(String demande);
}