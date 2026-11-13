package ma.emsi.lakhsadi.tp3restlakhsadi.llm;

public record TokenUsageDto(
        Integer tokens_entree,
        Integer tokens_sortie,
        Integer total_tokens
) {
}