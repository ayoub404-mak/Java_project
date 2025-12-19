package model;

/**
 * Classe représentant un enseignant
 * Contient les informations personnelles et professionnelles d'un enseignant
 */
public class Enseignant {
    // Attributs privés de l'enseignant
    private String nom; // Nom de famille de l'enseignant
    private String prenom; // Prénom de l'enseignant
    private String specialite; // Domaine de spécialité (ex: Informatique, Mathématiques)

    /**
     * Constructeur de la classe Enseignant
     * 
     * nom Le nom de famille de l'enseignant
     * prenom Le prénom de l'enseignant
     * specialite La spécialité de l'enseignant
     */
    public Enseignant(String nom, String prenom, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    /**
     * Getter pour obtenir le nom de l'enseignant
     * 
     * Le nom de famille
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter pour obtenir le prénom de l'enseignant
     * 
     * Le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getter pour obtenir la spécialité de l'enseignant
     * 
     * La spécialité
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * Méthode toString pour afficher les informations de l'enseignant
     * 
     * Une chaîne formatée avec le nom, prénom et spécialité
     */
    public String toString() {
        return nom + " " + prenom + " (Specialite: " + specialite + ")";
    }
}
