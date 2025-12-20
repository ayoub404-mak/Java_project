#  Projet 4 – Plateforme E-Learning

##  Contexte
Ce projet consiste à développer une **plateforme simplifiée de e-learning** permettant de gérer les cours, les enseignants et les étudiants.  
Le système modélise différents types de contenus pédagogiques (**Vidéo, Quiz**) et assure le suivi de la progression des étudiants.

---

##  Objectifs Pédagogiques
- Maîtriser l’**Héritage** et la **Classe Abstraite** (`Contenu`).
- Appliquer le **Polymorphisme** pour l’affichage des contenus.
- Utiliser une **Interface** (`Inscriptible`) et les **Collections** (`Map`).

---

##  Fonctionnalités Requises

###  Gestion des Utilisateurs et Cours
- Ajouter différents types de contenu (**Vidéo, Quiz**) à un cours.
- Inscrire un étudiant à un cours (via l’interface `Inscriptible`).

###  Suivi de la Progression
- Marquer un contenu comme complété.
- Calculer et mettre à jour la progression totale d’un étudiant dans un cours (en **pourcentage**) via une `Map`.

---

##  Structure des Classes

###  Classe Abstraite `Contenu`
- **Attributs privés :**
  - `String titre`
  - `boolean estComplete`
- **Constructeur :**
  - `Contenu(String titre, int duree)`
- **Méthode abstraite :**
  - `abstract void afficherDetails()`

###  Classes Filles
- **Video**
  - Attribut : `String urlVideo`
  - Affiche l’URL et la durée.
- **Quiz**
  - Attribut : `int nbQuestions`
  - Affiche le nombre de questions et le score requis.

###  Interface `Inscriptible`
- Méthode : `void inscrire(Etudiant etudiant)`

###  Classe `Cours`
- Utilise `Map<Etudiant, Double>` pour gérer la progression des étudiants.

---

##  Contraintes Techniques
- **Polymorphisme strict** : `afficherDetails()` doit être implémentée pour afficher les informations uniques de `Video` et `Quiz`.
- **Map obligatoire** : Lier chaque étudiant à son pourcentage d’achèvement.
- **Progression dynamique** : Le pourcentage est calculé au moment de l’appel.

---

##  Livrables Attendus
- Code source complet organisé en packages :
  - `model`
  - `service`
  - `app`
- Classe `Main` simulant :
  - L’inscription des étudiants
  - La complétion des contenus
- Documentation **Javadoc**.

---

##  Critères d’Évaluation (100%)
-  Fonctionnement du Polymorphisme (`afficherDetails`) : **25%**
-  Utilisation pertinente de l’Interface et de la Map : **25%**
-  Logique de calcul et mise à jour de la progression : **30%**
-  Respect de l’Héritage et de l’Encapsulation : **20%**

---

##  Comment exécuter le projet
1. Cloner le dépôt :
   ```bash
   git clone https://github.com/ayoub404-mak/Java_project.git
