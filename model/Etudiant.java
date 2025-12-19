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
     * @param nom    Le nom de famille de l'étudiant
     * @param prenom Le prénom de l'étudiant
     * @param email  L'adresse email de l'étudiant
     */
    public Etudiant(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    /**
     * Getter pour obtenir le nom de l'étudiant
     * 
     * @return Le nom de famille
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter pour obtenir le prénom de l'étudiant
     * 
     * @return Le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getter pour obtenir l'email de l'étudiant
     * 
     * @return L'adresse email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Méthode toString pour afficher les informations de l'étudiant
     * 
     * @return Une chaîne formatée avec le nom, prénom et email
     */
    public String toString() {
        return nom + " " + prenom + " (" + email + ")";
    }
}
