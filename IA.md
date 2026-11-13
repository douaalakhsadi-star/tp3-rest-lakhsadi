# Utilisation de l’IA dans le TP 3

- **Test REST.** L’IA m’a guidée dans IntelliJ et a expliqué la réponse 404 à la racine du projet. Elle a vérifié la route `/api/hello-world` et expliqué le rôle de `@ApplicationPath` et de `@Path`.
- **Route touristique.** L’IA a proposé le code de `GuideTouristiqueResource` pour renvoyer le lieu en texte, puis dans un tableau JSON. Le test pour Nice a renvoyé `["Nice"]`.
- **Gemini.** L’IA a proposé la configuration Maven, le code de `GuideTouristique` et de `LlmClient`, ainsi que l’injection du client dans la ressource. J’ai testé dans Chrome la réponse JSON pour Nice.
- **Bonus.** À ma demande de terminer le TP, l’IA a ajouté la lecture du paramètre `nb`, sa valeur par défaut de 2 et la validation des valeurs invalides. Elle a adapté la consigne envoyée à Gemini et rédigé ce fichier.
## Gestion des versions Maven

- **Difficulté et raison de l’aide.** Je voulais appliquer le conseil du professeur sur `dependencyManagement` et comprendre comment Maven choisit les versions de LangChain4j.
- **Prompt.** « c'est quoi BOM »
- **Réponse de l’IA.** L’IA m’a proposé d’importer `langchain4j-bom` dans `dependencyManagement` et m’a expliqué que le BOM fournit les versions des deux dépendances LangChain4j.
- **Ce que j’ai appris.** Je peux déclarer la version du BOM une seule fois. Maven utilise ensuite les versions prévues par le BOM pour chaque dépendance, y compris la version bêta du module Gemini.

## Test avec une page HTML

- **Difficulté et raison de l’aide.** Je ne savais pas quelle partie de l’adresse modifier dans la page HTML du professeur. Après avoir ouvert la page locale, j’ai aussi rencontré une erreur lors de l’appel à l’API.
- **Prompt.** « Dans ce fichier, cherche `context-path` avec Ctrl + F. […] jai pas compris »
- **Réponse de l’IA.** L’IA a adapté le code HTML à l’adresse de mon API et proposé une modification de `GuideTouristiqueResource` pour ajouter l’en-tête CORS.
- **Ce que j’ai appris.** La page HTML utilise l’adresse complète de la ressource REST. L’en-tête CORS permet à Chrome de lire la réponse de Payara depuis la page ouverte comme fichier local. J’ai vérifié que la page affiche deux lieux à Nice et le prix moyen d’un repas.