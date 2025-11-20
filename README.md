# Activité 2.2 : Calculatrice Distribuée par Échange d'Objets

## 📋 Description
Cette activité représente une évolution majeure par rapport aux précédentes. Au lieu d'échanger de simples octets ou des chaînes de caractères qu'il faut découper (parser), nous utilisons ici la **Sérialisation Java**.

L'application permet au client d'encapsuler les données de l'opération (opérandes et opérateur) dans une instance de classe (`Operation`), de transférer cet objet complet via le réseau, et de le faire traiter par le serveur.

## 🛠️ Architecture du Projet
Le code est modulaire et réparti en trois packages :

1.  **`operateurPackage`** :
    *   **`Operation`** : Une classe implémentant l'interface `Serializable`. Elle sert de conteneur de données (Java Bean) pour transporter `x1` (entier), `x2` (entier) et `o` (opérateur) à travers le réseau.
2.  **`serverPackage`** :
    *   **`Server`** : Reçoit le flux d'objet, le **désérialise** pour reconstituer l'objet `Operation` en mémoire, effectue le calcul et renvoie le résultat.
3.  **`clientPackage`** :
    *   **`Client`** : Récupère les saisies, crée une instance de `Operation`, la **sérialise** pour l'envoyer au serveur et affiche le résultat retourné.

## ⚙️ Fonctionnalités Techniques Clés

*   **Sérialisation (`java.io.Serializable`)** : Mécanisme permettant de convertir un état d'objet en une séquence d'octets pour le stockage ou la transmission réseau.
*   **Flux d'Objets** : Utilisation de :
    *   `ObjectOutputStream` et sa méthode `writeObject()` pour l'envoi.
    *   `ObjectInputStream` et sa méthode `readObject()` pour la réception.
*   **Encapsulation** : Toute la logique de données est regroupée dans une seule entité (`Operation`), simplifiant la maintenance et l'évolution du protocole.

## 🚀 Prérequis
*   Java JDK 8 ou supérieur.
*   Port **1234** disponible sur la machine.

## ▶️ Instructions d'Exécution

### 1. Démarrer le Serveur
Exécutez la classe `serverPackage.Server`.
> **Console Serveur :**
> `Je suis un serveur en attente la connexion d'un client`

### 2. Démarrer le Client
Exécutez la classe `clientPackage.Client`.

### 3. Interaction
Suivez les invites dans la console client :
1.  Saisissez le premier nombre.
2.  Saisissez l'opérateur (+, -, *, /).
3.  Saisissez le deuxième nombre.

> **Exemple Console Client :**
> ```text
> donner entier 1: 50
> donner l'opérateur: *
> donner entier 2: 2
> la resultat=100
> ```

> **Exemple Console Serveur :**
> ```text
> un client est connecté
> Multiplication : 50 * 2 = 100
> ```

## ⚠️ Remarque sur le Code
Bien que l'envoi (Requête) se fasse par objet (`Operation`), le retour (Réponse) du serveur dans cette version est envoyé sous forme d'entier simple via `os.write(res)` et lu via `is.read()`.
Pour une application 100% orientée objet, le serveur pourrait également renvoyer un objet (ex: `Resultat`) via `ObjectOutputStream`.

