# ElderHealthcare

ElderHealthcare est une application mobile conçue pour aider les aidants des personnes âgées à gérer les soins de santé quotidiens de leurs proches. L'application offre des fonctionnalités pour organiser les médicaments, programmer des tests médicaux, trouver des médecins à proximité et accéder à des articles de santé utiles.

## Fonctionnalités

- **Gestion des médicaments** :
  - Ajouter des médicaments avec des dates et recevoir des notifications de rappel.
- **Gestion des tests médicaux** :
  - Ajouter, consulter, modifier et supprimer des tests médicaux.
- **Localisation des médecins** :
  - Trouver des médecins à proximité via une carte interactive.
- **Accès à des ressources santé** :
  - Lire des articles pertinents sur la santé des personnes âgées.

## Prérequis

Avant de commencer, assurez-vous d'avoir les outils suivants installés :

- **Android Studio**
- **JDK (Java Development Kit)**
- **Spring Boot**
- **SQL Database**
- **Android SDK**

## Installation

### Frontend (Application Mobile)
1. Clonez le dépôt :
   ```bash
   git clone https://github.com/salma510/ElderCare.git
   ```
2. Ouvrez le projet dans Android Studio.
3. Configurez l'environnement avec le SDK Android.
4. Exécutez l'application sur un émulateur ou un appareil physique.

### Backend (API Spring Boot)
1. Accédez au répertoire `backend` :
   ```bash
   cd backend
   ```
2. Démarrez l'application Spring Boot :
   ```bash
   mvn spring-boot:run
   ```
3. Assurez-vous que la base de données SQL est configurée et connectée.

## Structure du Projet

- **Frontend** : Application mobile (Android) développée avec Java et Android Studio.
- **Backend** : API REST développée avec Spring Boot.
- **Base de données** : Utilise une base SQL pour stocker les informations sur les utilisateurs, médicaments, tests médicaux, etc.

## Utilisation

1. **Inscription et Connexion**
   - Créez un compte ou connectez-vous à l'application.
2. **Ajout de Médicaments**
   - Naviguez vers la section "Médicaments" et ajoutez un médicament avec la date et l'heure de prise.
3. **Gestion des Tests Médicaux**
   - Naviguez vers "Tests Médicaux" pour ajouter, modifier ou supprimer des tests.
4. **Recherche de Médecins**
   - Utilisez la fonction de localisation pour trouver un médecin près de chez vous.
5. **Consulter des Articles de Santé**
   - Accédez à une liste d'articles pour des conseils sur la santé des personnes âgées.

## Technologies Utilisées

- **Langages** : Java
- **Frameworks** : Spring Boot, Android SDK
- **Base de données** : SQL
- **Outils** : Android Studio, Maven, Git

## Contribution

Les contributions sont les bienvenues ! Suivez ces étapes pour contribuer :

1. Forkez le projet.
2. Créez une branche pour votre fonctionnalité :
   ```bash
   git checkout -b feature/nom-de-la-fonctionnalite
   ```
3. Effectuez vos modifications et committez :
   ```bash
   git commit -m "Ajout de la fonctionnalité X"
   ```
4. Poussez les modifications sur votre branche :
   ```bash
   git push origin feature/nom-de-la-fonctionnalite
   ```
5. Créez une Pull Request sur le dépôt principal.



