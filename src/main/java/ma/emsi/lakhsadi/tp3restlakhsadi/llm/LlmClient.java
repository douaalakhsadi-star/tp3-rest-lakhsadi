package ma.emsi.lakhsadi.tp3restlakhsadi.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LlmClient {

    private final GuideTouristique guide;

    public LlmClient() {
        ChatModel modele = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-3.5-flash-lite")
                .responseFormat(ResponseFormat.JSON)
                .build();

        this.guide = AiServices.builder(GuideTouristique.class)
                .chatModel(modele)
                .build();
    }

    public String conseiller(String lieu) {
        return guide.conseiller(lieu);
    }
}