package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe Cours qui implémente l'interface Inscriptible
 * Représente un cours avec ses contenus et gère les inscriptions et
 * progressions des étudiants
 * Utilise une Map pour associer chaque étudiant à sa progression
 */
public class Cours implements Inscriptible {
    // Attributs privés du cours
    private String titre; // Titre du cours
    private Enseignant enseignant; // Enseignant responsable du cours
    private ArrayList<Contenu> contenus; // Liste des contenus (vidéos, quiz, etc.)
    private Map<Etudiant, Double> progressions; // Map: Etudiant -> Progression (en %)

    /**
     * Constructeur de la classe Cours
     * 
     * Le titre du cours
     * L'enseignant responsable du cours
     */
    public Cours(String titre, Enseignant enseignant) {
        this.titre = titre;
        this.enseignant = enseignant;
        this.contenus = new ArrayList<Contenu>(); // Initialisation de la liste vide
        this.progressions = new HashMap<Etudiant, Double>(); // Initialisation de la Map vide
    }

    /**
     * Getter pour obtenir le titre du cours
     * 
     * Le titre du cours
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Getter pour obtenir l'enseignant du cours
     * 
     * L'enseignant responsable
     */
    public Enseignant getEnseignant() {
        return enseignant;
    }

    /**
     * Getter pour obtenir la liste des contenus
     * 
     * La liste de tous les contenus du cours
     */
    public ArrayList<Contenu> getContenus() {
        return contenus;
    }

    /**
     * Getter pour obtenir la Map des progressions
     * 
     * La Map associant chaque étudiant à sa progression
     */
    public Map<Etudiant, Double> getProgressions() {
        return progressions;
    }

    /**
     * Méthode pour ajouter un contenu au cours
     * 
     * Le contenu à ajouter (Video ou Quiz)
     */
    public void ajouterContenu(Contenu contenu) {
        contenus.add(contenu);
    }

    /**
     * Implémentation de la méthode inscrire de l'interface Inscriptible
     * Inscrit un étudiant au cours avec une progression initiale de 0%
     * 
     * L'étudiant à inscrire
     */
    public void inscrire(Etudiant etudiant) {
        // Vérification si l'étudiant n'est pas déjà inscrit
        if (!progressions.containsKey(etudiant)) {
            // Ajout de l'étudiant avec une progression de 0%
            progressions.put(etudiant, 0.0);
            System.out.println("Etudiant " + etudiant.getNom() + " inscrit au cours " + titre);
        } else {
            System.out.println("Etudiant deja inscrit a ce cours");
        }
    }

    /**
     * Marque un contenu spécifique comme complété pour un étudiant
     * Met automatiquement à jour la progression de l'étudiant
     * 
     * L'étudiant concerné
     * L'index du contenu à marquer comme complété
     */
    public void marquerContenuComplete(Etudiant etudiant, int indexContenu) {
        // Vérification que l'étudiant est bien inscrit au cours
        if (!progressions.containsKey(etudiant)) {
            System.out.println("Etudiant non inscrit a ce cours");
            return;
        }

        // Vérification que l'index du contenu est valide
        if (indexContenu >= 0 && indexContenu < contenus.size()) {
            Contenu contenu = contenus.get(indexContenu);
            contenu.setEstComplete(true); // Marque le contenu comme terminé
            mettreAJourProgression(etudiant); // Recalcule la progression
            System.out.println("Contenu marque comme complete");
        } else {
            System.out.println("Index de contenu invalide");
        }
    }

    /**
     * Met à jour la progression d'un étudiant
     * Calcule le pourcentage de contenus complétés
     * 
     * L'étudiant dont on met à jour la progression
     */
    public void mettreAJourProgression(Etudiant etudiant) {
        // Si aucun contenu, progression = 0%
        if (contenus.size() == 0) {
            progressions.put(etudiant, 0.0);
            return;
        }

        // Compte le nombre de contenus complétés
        int nbComplete = 0;
        for (Contenu contenu : contenus) {
            if (contenu.isEstComplete()) {
                nbComplete++;
            }
        }

        // Calcul du pourcentage: (nombre complétés / total) * 100
        double progression = (nbComplete * 100.0) / contenus.size();
        progressions.put(etudiant, progression);
    }

    /**
     * Obtient la progression d'un étudiant spécifique
     * 
     * L'étudiant dont on veut connaître la progression
     * Le pourcentage de progression (0.0 si non inscrit)
     */
    public double getProgression(Etudiant etudiant) {
        if (progressions.containsKey(etudiant)) {
            return progressions.get(etudiant);
        }
        return 0.0; // Retourne 0% si l'étudiant n'est pas inscrit
    }
}
