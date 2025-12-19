package model;

/**
 * Interface Inscriptible
 * Définit le contrat pour les classes qui permettent l'inscription d'étudiants
 * Toute classe implémentant cette interface doit fournir une méthode inscrire()
 */
public interface Inscriptible {
    /**
     * Méthode pour inscrire un étudiant
     * 
     *L'étudiant à inscrire
     */
    void inscrire(Etudiant etudiant);
}
