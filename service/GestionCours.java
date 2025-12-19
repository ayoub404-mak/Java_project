package service;

import model.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Classe de service GestionCours
 * Contient toutes les méthodes de gestion et d'affichage pour les cours
 * Sépare la logique métier de l'interface utilisateur (Main)
 */
public class GestionCours {

    /**
     * Affiche la liste de tous les cours disponibles
     * 
     * @param listeCours La liste des cours à afficher
     */
    public void afficherTousLesCours(ArrayList<Cours> listeCours) {
        System.out.println("\n=== Liste des cours disponibles ===");

        // Parcourt tous les cours et affiche leurs informations
        for (int i = 0; i < listeCours.size(); i++) {
            Cours cours = listeCours.get(i);
            System.out.println((i + 1) + ". " + cours.getTitre() +
                    " (Enseignant: " + cours.getEnseignant().getNom() + ")");
        }
    }

    /**
     * Affiche les informations détaillées d'un cours spécifique
     * 
     * @param cours Le cours dont on veut afficher les informations
     */
    public void afficherInfosCours(Cours cours) {
        System.out.println("\n=== Informations du cours ===");
        System.out.println("Titre: " + cours.getTitre());
        System.out.println("Enseignant: " + cours.getEnseignant());
        System.out.println("Nombre de contenus: " + cours.getContenus().size());
        System.out.println("Nombre d'etudiants inscrits: " + cours.getProgressions().size());
    }

    /**
     * Inscrit un étudiant à un cours
     * Délègue l'inscription à la méthode inscrire() du cours
     * 
     * @param cours    Le cours auquel inscrire l'étudiant
     * @param etudiant L'étudiant à inscrire
     */
    public void inscrireEtudiant(Cours cours, Etudiant etudiant) {
        cours.inscrire(etudiant);
    }

    /**
     * Affiche la progression d'un étudiant dans un cours
     * 
     * @param cours    Le cours concerné
     * @param etudiant L'étudiant dont on veut voir la progression
     */
    public void afficherProgression(Cours cours, Etudiant etudiant) {
        System.out.println("\n=== Progression de l'etudiant ===");
        System.out.println("Etudiant: " + etudiant);
        System.out.println("Cours: " + cours.getTitre());

        // Récupère et affiche le pourcentage de progression
        double progression = cours.getProgression(etudiant);
        System.out.println("Progression: " + progression + "%");
    }

    /**
     * Marque un contenu comme complété pour un étudiant
     * Délègue l'opération à la méthode du cours
     * 
     * @param cours        Le cours contenant le contenu
     * @param etudiant     L'étudiant qui a complété le contenu
     * @param indexContenu L'index du contenu à marquer comme complété
     */
    public void marquerContenuComplete(Cours cours, Etudiant etudiant, int indexContenu) {
        cours.marquerContenuComplete(etudiant, indexContenu);
    }

    /**
     * Affiche tous les contenus d'un cours avec leurs détails
     * 
     * @param cours Le cours dont on veut afficher les contenus
     */
    public void afficherTousLesContenus(Cours cours) {
        System.out.println("\n=== Contenus du cours: " + cours.getTitre() + " ===");
        ArrayList<Contenu> contenus = cours.getContenus();

        // Vérification si le cours contient des contenus
        if (contenus.size() == 0) {
            System.out.println("Aucun contenu disponible");
            return;
        }

        // Parcourt et affiche les détails de chaque contenu
        for (int i = 0; i < contenus.size(); i++) {
            System.out.println("\n--- Contenu " + (i + 1) + " ---");
            // Utilise le polymorphisme: afficherDetails() peut être Video ou Quiz
            contenus.get(i).afficherDetails();
        }
    }

    /**
     * Affiche la progression de tous les étudiants inscrits à un cours
     * Utilise la Map des progressions pour parcourir tous les étudiants
     * 
     * @param cours Le cours dont on veut voir les progressions
     */
    public void afficherProgressionTousEtudiants(Cours cours) {
        System.out.println("\n=== Progression de tous les etudiants ===");
        System.out.println("Cours: " + cours.getTitre());

        // Récupère la Map des progressions (Etudiant -> Pourcentage)
        Map<Etudiant, Double> progressions = cours.getProgressions();

        // Vérification si des étudiants sont inscrits
        if (progressions.size() == 0) {
            System.out.println("Aucun etudiant inscrit");
            return;
        }

        // Parcourt chaque entrée de la Map et affiche l'étudiant avec sa progression
        for (Map.Entry<Etudiant, Double> entry : progressions.entrySet()) {
            System.out.println(entry.getKey() + " - Progression: " + entry.getValue() + "%");
        }
    }
}
