# **Simulation de Chasse Gazelle \- Optimisation Multi-Objectif**

## **Description du Projet**

Ce projet est une simulation qui modélise le problème de la chasse d'une gazelle par un léopard en utilisant un algorithme d'optimisation multi-objectif. L'objectif est de trouver les stratégies de chasse optimales pour le léopard, qui cherche à la fois à maximiser la taille de la gazelle capturée et à minimiser la distance qu'il doit parcourir pour y parvenir.

Le projet est développé en Java et structuré comme un projet NetBeans.

## **Problème Modélisé : Chasse d'une Gazelle par un Léopard**

Le scénario central est la décision prise par un léopard lors de la chasse. Chaque décision (ou "stratégie") a deux conséquences principales qui sont les objectifs à optimiser :

1. **Taille de la Gazelle :** Le léopard préfère capturer une gazelle de grande taille pour un meilleur apport énergétique. Cet objectif doit être **maximisé**.  
2. **Distance Parcourue :** Le léopard souhaite minimiser l'effort et le temps de la chasse en réduisant la distance à parcourir. Cet objectif doit être **minimisé**.

Ces deux objectifs sont souvent conflictuels ; une gazelle plus grande pourrait être plus éloignée, ou une gazelle proche pourrait être de petite taille. L'optimisation multi-objectif vise à trouver un ensemble de solutions qui représentent les meilleurs compromis possibles entre ces objectifs.

## **Approche : Algorithme d'Optimisation Multi-Objectif**

Le projet utilise une approche basée sur un algorithme d'optimisation évolutionniste (similaire aux algorithmes génétiques multi-objectifs comme NSGA-II) pour résoudre ce problème. L'algorithme explore un espace de "stratégies de chasse" potentielles en appliquant des opérateurs inspirés de la biologie évolutive.

Les étapes clés de l'algorithme incluent :

1. **Représentation des Solutions :** Chaque solution (ou individu dans la population) représente une stratégie de chasse, typiquement encodée par des paramètres comme la distance à parcourir et la taille de la gazelle ciblée.  
   * Exemple : \[Distance: 500m, Taille Gazelle: Grande\]  
2. **Population Initiale :** Génération d'un ensemble initial de stratégies de chasse aléatoires ou pré-définies.  
3. **Fonctions Objectifs :** Évaluation de chaque stratégie en fonction des deux objectifs :  
   * f1​(strateˊgie)=Taille de la gazelle cibleˊe (à maximiser)  
   * f2​(strateˊgie)=Distance aˋ parcourir (à minimiser)  
4. **Opérateurs Génétiques :** Application d'opérateurs pour créer de nouvelles stratégies à partir de la population existante :  
   * **Croisement (Crossover) :** Combinaison d'éléments de deux stratégies parentes pour former une ou plusieurs stratégies enfants. Par exemple, prendre la distance d'une stratégie et la taille de gazelle d'une autre.  
   * **Mutation :** Modification aléatoire légère des paramètres d'une stratégie pour explorer de nouvelles possibilités dans l'espace de recherche.  
5. **Critère de Sélection :** Utilisation d'un mécanisme de sélection basé sur la dominance non-dominée. Les stratégies qui ne sont pas dominées par d'autres (c'est-à-dire qu'aucune autre stratégie n'est meilleure sur *tous* les objectifs) sont privilégiées pour la reproduction et la survie dans les générations futures. Ceci permet de converger vers l'ensemble de Pareto des solutions optimales.

## **Structure du Projet**

Le projet est organisé comme un projet standard NetBeans en Java. Les classes principales incluront probablement :

* Une classe représentant une StratégieChasse (ou Solution) avec ses attributs (distance, taille gazelle) et ses valeurs d'objectifs.  
* Des classes implémentant les opérateurs génétiques (Croisement, Mutation).  
* Une classe pour l'algorithme principal d'optimisation multi-objectif, gérant la population, l'évaluation, la sélection et l'évolution sur plusieurs générations.  
* Une classe principale (main) pour initialiser et exécuter la simulation.

## **Comment Exécuter le Projet**

1. **Prérequis :**  
   * JDK (Java Development Kit) installé.  
   * NetBeans IDE installé.  
2. **Ouvrir le Projet :**  
   * Lancez NetBeans.  
   * Allez dans File \> Open Project....  
   * Naviguez jusqu'au répertoire où vous avez cloné ou téléchargé le code source du projet et sélectionnez le dossier du projet NetBeans.  
3. **Exécuter :**  
   * Une fois le projet ouvert dans NetBeans, localisez la classe principale (celle contenant la méthode main).  
   * Faites un clic droit sur le fichier de la classe principale dans l'explorateur de projet.  
   * Sélectionnez Run File.

La simulation s'exécutera, et les résultats (probablement les stratégies non-dominées trouvées à la fin de l'optimisation) seront affichés dans la console de sortie de NetBeans.

## **Objectifs de l'Optimisation**

L'algorithme vise à identifier un ensemble de stratégies de chasse qui représentent les meilleurs compromis possibles entre :

* **Maximiser la taille de la gazelle.**  
* **Minimiser la distance parcourue.**

L'ensemble final des solutions non-dominées représente la frontière de Pareto approximative pour ce problème, montrant les différentes options disponibles pour le léopard en fonction de ses priorités.

## **Dépendances**

* Java  
* NetBeans IDE

## **Auteur**

\[Votre Nom / Pseudo GitHub\]  
\[Lien vers votre profil GitHub (Optionnel)\]

## **Licence**

\[Ajoutez ici les informations sur la licence de votre projet, par exemple : MIT, Apache 2.0, etc.\]"# SimulationChasseGazelle-OptimisationMulti-Objectif" 
