package model;

/**
 * Classe Video qui hérite de la classe abstraite Contenu
 * Représente un contenu de type vidéo dans un cours
 */
public class Video extends Contenu {
    // Attribut spécifique aux vidéos
    private String urlVideo; // URL de la vidéo en ligne

    /**
     * Constructeur de la classe Video
     * 
     * titre Le titre de la vidéo
     * duree La durée de la vidéo en minutes
     * urlVideo L'URL où la vidéo est hébergée
     */
    public Video(String titre, int duree, String urlVideo) {
        super(titre, duree); // Appel du constructeur de la classe parente Contenu
        this.urlVideo = urlVideo;
    }

    /**
     * Getter pour obtenir l'URL de la vidéo
     * 
     * L'URL de la vidéo
     */
    public String getUrlVideo() {
        return urlVideo;
    }

    /**
     * Implémentation de la méthode abstraite afficherDetails()
     * Affiche les détails spécifiques d'une vidéo
     */
    public void afficherDetails() {
        System.out.println("=== Video ===");
        System.out.println("Titre: " + getTitre());
        System.out.println("URL: " + getUrlVideo());
        System.out.println("Duree: " + getDuree() + " minutes");
        ;
    }
}
