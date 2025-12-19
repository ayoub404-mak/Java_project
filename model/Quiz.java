package model;

/**
 * Classe Quiz qui hérite de la classe abstraite Contenu
 * Représente un contenu de type quiz/évaluation dans un cours
 */
public class Quiz extends Contenu {
    // Attributs spécifiques aux quiz
    private int nbQuestions; // Nombre de questions dans le quiz
    private int scoreRequis; // Score minimum requis pour réussir (en pourcentage)

    /**
     * Constructeur de la classe Quiz
     * 
     * Le titre du quiz
     * La durée du quiz en minutes
     * Le nombre de questions dans le quiz
     * Le score minimum requis pour réussir (en %)
     */
    public Quiz(String titre, int duree, int nbQuestions, int scoreRequis) {
        super(titre, duree); // Appel du constructeur de la classe parente Contenu
        this.nbQuestions = nbQuestions;
        this.scoreRequis = scoreRequis;
    }

    /**
     * Getter pour obtenir le nombre de questions
     * 
     * Le nombre de questions du quiz
     */
    public int getNbQuestions() {
        return nbQuestions;
    }

    /**
     * Getter pour obtenir le score requis
     * 
     * Le score minimum requis en pourcentage
     */
    public int getScoreRequis() {
        return scoreRequis;
    }

    /**
     * Implémentation de la méthode abstraite afficherDetails()
     * Affiche les détails spécifiques d'un quiz
     */
    public void afficherDetails() {
        System.out.println("=== Quiz ===");
        System.out.println("Titre: " + getTitre());
        System.out.println("Nombre de questions: " + getNbQuestions());
        System.out.println("Score requis: " + getScoreRequis() + "%");
        System.out.println("Duree: " + getDuree() + " minutes");
    }
}
