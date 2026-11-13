package ma.emsi.lakhsadi.tp3restlakhsadi.llm;

import java.util.List;

public record InfosTouristiquesAvecUsage(
        String ville_ou_pays,
        List<String> endroits_a_visiter,
        String prix_moyen_repas,
        TokenUsageDto usage_tokens
) {
}