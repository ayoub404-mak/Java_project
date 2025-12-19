package model;

/**
 * Classe abstraite représentant un contenu pédagogique
 * Cette classe sert de base pour tous les types de contenus (Video, Quiz, etc.)
 * Elle utilise le polymorphisme pour permettre différents types de contenus
 */
public abstract class Contenu {
    // Attributs privés de la classe
    private String titre; // Titre du contenu
    private int duree; // Durée du contenu en minutes
    private boolean estComplete; // Indique si le contenu a été complété par l'étudiant

    /**
     * Constructeur de la classe Contenu
     * 
     * Le titre du contenu
     * La durée du contenu en minutes
     */
    public Contenu(String titre, int duree) {
        this.titre = titre;
        this.duree = duree;
        this.estComplete = false; // Par défaut, le contenu n'est pas complété
    }

    /**
     * Getter pour obtenir le titre du contenu
     * 
     * Le titre du contenu
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Getter pour obtenir la durée du contenu
     * 
     * La durée en minutes
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Getter pour vérifier si le contenu est complété
     * 
     * true si le contenu est terminé, false sinon
     */
    public boolean isEstComplete() {
        return estComplete;
    }

    /**
     * Setter pour marquer le contenu comme complété ou non
     * 
     * true pour marquer comme complété, false sinon
     */
    public void setEstComplete(boolean estComplete) {
        this.estComplete = estComplete;
    }

    /**
     * Méthode abstraite pour afficher les détails du contenu
     * Chaque sous-classe (Video, Quiz) doit implémenter cette méthode
     * selon ses propres caractéristiques
     */
    public abstract void afficherDetails();
}
