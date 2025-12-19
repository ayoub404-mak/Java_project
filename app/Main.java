package app;

import model.*;
import service.GestionCours;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principale de l'application e-learning
 * Cette classe contient le point d'entrée du programme et gère le menu
 * principal
 */
public class Main {
    /**
     * Méthode principale qui démarre l'application
     * 
     * Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        // Initialisation du scanner pour lire les entrées utilisateur
        Scanner scanner = new Scanner(System.in);

        // Création de l'objet de gestion des cours
        GestionCours gestion = new GestionCours();

        // Liste qui contiendra tous les cours disponibles
        ArrayList<Cours> listeCours = new ArrayList<Cours>();

        // ========== Création des enseignants ==========
        // Création de deux enseignants avec leurs spécialités
        Enseignant ens1 = new Enseignant("Dupont", "Jean", "Informatique");
        Enseignant ens2 = new Enseignant("Martin", "Marie", "Mathematiques");

        // ========== Création des cours ==========
        // Chaque cours est associé à un enseignant
        Cours cours1 = new Cours("Programmation Java", ens1);
        Cours cours2 = new Cours("Algebre Lineaire", ens2);

        // ========== Ajout de contenus au cours 1 (Programmation Java) ==========
        // Ajout d'une vidéo d'introduction (titre, durée en minutes, URL)
        cours1.ajouterContenu(new Video("Introduction a Java", 30, "http://video.com/java1"));

        // Ajout d'un quiz (titre, durée, nombre de questions, score requis en %)
        cours1.ajouterContenu(new Quiz("Quiz Java Basics", 15, 10, 70));

        // Ajout d'une vidéo sur la POO
        cours1.ajouterContenu(new Video("POO en Java", 45, "http://video.com/java2"));

        // ========== Ajout de contenus au cours 2 (Algèbre Linéaire) ==========
        cours2.ajouterContenu(new Video("Matrices", 40, "http://video.com/math1"));
        cours2.ajouterContenu(new Quiz("Quiz Matrices", 20, 15, 80));

        // Ajout des cours à la liste
        listeCours.add(cours1);
        listeCours.add(cours2);

        // ========== Création des étudiants ==========
        // Création de deux étudiants avec leurs informations personnelles
        Etudiant etud1 = new Etudiant("Benali", "Ahmed", "ahmed@email.com");
        Etudiant etud2 = new Etudiant("Alami", "Fatima", "fatima@email.com");

        // Variable de contrôle pour la boucle du menu principal
        boolean continuer = true;

        // ========== Boucle principale du menu ==========
        // Continue tant que l'utilisateur ne choisit pas de quitter
        while (continuer) {
            // Affichage du menu principal avec toutes les options disponibles
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1. Afficher tous les cours disponibles");
            System.out.println("2. Afficher les informations du cours");
            System.out.println("3. Inscrire un etudiant a un cours");
            System.out.println("4. Voir progression d'un etudiant");
            System.out.println("5. Marquer un contenu d'un etudiant comme termine");
            System.out.println("6. Afficher tous les contenus d'un cours");
            System.out.println("7. Afficher la progression de tous les etudiants");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            // Lecture du choix de l'utilisateur
            int choix = scanner.nextInt();

            // ========== Option 1: Afficher tous les cours ==========
            if (choix == 1) {
                // Appel de la méthode pour afficher la liste complète des cours
                gestion.afficherTousLesCours(listeCours);

                // ========== Option 2: Afficher les informations d'un cours spécifique
                // ==========
            } else if (choix == 2) {
                // Demande à l'utilisateur de choisir un cours
                System.out.print("Numero du cours (1-" + listeCours.size() + "): ");
                int numCours = scanner.nextInt();

                // Vérification que le numéro est valide
                if (numCours > 0 && numCours <= listeCours.size()) {
                    // Affichage des informations du cours sélectionné (index = numCours - 1)
                    gestion.afficherInfosCours(listeCours.get(numCours - 1));
                } else {
                    System.out.println("Numero de cours invalide");
                }

                // ========== Option 3: Inscrire un étudiant à un cours ==========
            } else if (choix == 3) {
                // Demande le numéro du cours
                System.out.print("Numero du cours (1-" + listeCours.size() + "): ");
                int numCours = scanner.nextInt();

                // Demande quel étudiant inscrire
                System.out.print("Choisir etudiant (1=Ahmed, 2=Fatima): ");
                int numEtud = scanner.nextInt();

                // Vérification et inscription
                if (numCours > 0 && numCours <= listeCours.size()) {
                    // Sélection de l'étudiant selon le choix (opérateur ternaire)
                    Etudiant etudiant = (numEtud == 1) ? etud1 : etud2;

                    // Inscription de l'étudiant au cours
                    gestion.inscrireEtudiant(listeCours.get(numCours - 1), etudiant);
                } else {
                    System.out.println("Numero invalide");
                }

                // ========== Option 4: Voir la progression d'un étudiant ==========
            } else if (choix == 4) {
                // Demande le cours et l'étudiant
                System.out.print("Numero du cours (1-" + listeCours.size() + "): ");
                int numCours = scanner.nextInt();
                System.out.print("Choisir etudiant (1=Ahmed, 2=Fatima): ");
                int numEtud = scanner.nextInt();

                // Affichage de la progression
                if (numCours > 0 && numCours <= listeCours.size()) {
                    Etudiant etudiant = (numEtud == 1) ? etud1 : etud2;

                    // Affiche le pourcentage de complétion du cours pour cet étudiant
                    gestion.afficherProgression(listeCours.get(numCours - 1), etudiant);
                } else {
                    System.out.println("Numero invalide");
                }

                // ========== Option 5: Marquer un contenu comme terminé ==========
            } else if (choix == 5) {
                // Demande le cours, l'étudiant et le contenu
                System.out.print("Numero du cours (1-" + listeCours.size() + "): ");
                int numCours = scanner.nextInt();
                System.out.print("Choisir etudiant (1=Ahmed, 2=Fatima): ");
                int numEtud = scanner.nextInt();
                System.out.print("Numero du contenu: ");
                int numContenu = scanner.nextInt();

                // Marque le contenu comme complété et met à jour la progression
                if (numCours > 0 && numCours <= listeCours.size()) {
                    Etudiant etudiant = (numEtud == 1) ? etud1 : etud2;

                    // Marque le contenu spécifique comme terminé (index = numContenu - 1)
                    gestion.marquerContenuComplete(listeCours.get(numCours - 1),
                            etudiant, numContenu - 1);
                } else {
                    System.out.println("Numero invalide");
                }

                // ========== Option 6: Afficher tous les contenus d'un cours ==========
            } else if (choix == 6) {
                // Demande le numéro du cours
                System.out.print("Numero du cours (1-" + listeCours.size() + "): ");
                int numCours = scanner.nextInt();

                // Affiche tous les contenus (vidéos, quiz, etc.) du cours
                if (numCours > 0 && numCours <= listeCours.size()) {
                    gestion.afficherTousLesContenus(listeCours.get(numCours - 1));
                } else {
                    System.out.println("Numero de cours invalide");
                }

                // ========== Option 7: Afficher la progression de tous les étudiants ==========
            } else if (choix == 7) {
                // Demande le numéro du cours
                System.out.print("Numero du cours (1-" + listeCours.size() + "): ");
                int numCours = scanner.nextInt();

                // Affiche la progression de tous les étudiants inscrits à ce cours
                if (numCours > 0 && numCours <= listeCours.size()) {
                    gestion.afficherProgressionTousEtudiants(listeCours.get(numCours - 1));
                } else {
                    System.out.println("Numero de cours invalide");
                }

                // ========== Option 0: Quitter l'application ==========
            } else if (choix == 0) {
                // Arrête la boucle et termine le programme
                continuer = false;
                System.out.println("Au revoir!");

                // ========== Choix invalide ==========
            } else {
                System.out.println("Choix invalide");
                break;
            }
        }

        // Fermeture du scanner pour libérer les ressources
        scanner.close();
    }
}
