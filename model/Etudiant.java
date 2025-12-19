package model;

/**
 * Classe représentant un étudiant
 * Contient les informations personnelles d'un étudiant inscrit sur la
 * plateforme
 */
public class Etudiant {
    // Attributs privés de l'étudiant
    private String nom; // Nom de famille de l'étudiant
    private String prenom; // Prénom de l'étudiant
    private String email; // Adresse email de l'étudiant

    /**
     * Constructeur de la classe Etudiant
     * 
     *Le nom de famille de l'étudiant
     *Le prénom de l'étudiant
     *L'adresse email de l'étudiant
     */
    public Etudiant(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    /**
     * Getter pour obtenir le nom de l'étudiant
     * 
     * Le nom de famille
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter pour obtenir le prénom de l'étudiant
     * 
     *Le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getter pour obtenir l'email de l'étudiant
     * 
     *L'adresse email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Méthode toString pour afficher les informations de l'étudiant
     * 
     *Une chaîne formatée avec le nom, prénom et email
     */
    public String toString() {
        return nom + " " + prenom + " (" + email + ")";
    }
}
