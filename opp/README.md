---
title: Java - Toutes les notions des bases aux baux
tags:
  - java
  - révision
  - oop
  - holberton
---

# Java — Fiche de révision avec navigation

**Périmètre :** rappels Java Basics et toutes les notions abordées dans les tâches OOP 0 à 13 du projet immobilier. Java 21, sans outil de build ni bibliothèque externe. La tâche 14 n'est pas encore incluse.

**Utilisation :** clique sur une notion du sommaire pour rejoindre sa description, son exemple et les points à retenir. Chaque fiche possède un lien de retour. Dans Obsidian, ouvre cette note en mode lecture pour naviguer facilement. Les titres techniques courts servent d'ancres stables.

**Lecture des exemples :** ce sont des extraits pédagogiques indépendants, pas un programme unique à coller tel quel. Sauf indication contraire, `p`, `apartment`, `tenant`, `owner`, `portfolio` ou `agency` désignent des objets déjà créés ; les méthodes sont placées dans leur classe. Les imports standard sont parfois omis pour garder l'exemple court. À partir de la tâche 7, crée un bien concret : `Apartment`, `House` ou `CommercialSpace`.

## sommaire

**Bases utiles**

- [Compiler et exécuter : JDK, javac, java, classpath](#compilation)
- [Organisation des fichiers, package et import](#fichiers)
- [Types primitifs, types objets et null](#types)
- [Calculs, division entière et dépassement](#calculs)
- [Conditions, comparaisons et court-circuit](#conditions)
- [Boucles for, while et parcours](#boucles)
- [Tableaux, indices, longueur et varargs](#tableaux)
- [String, immuabilité, comparaison et StringBuilder](#chaines)
- [Scanner, conversion et NumberFormatException](#saisie)
- [Méthodes, paramètres, return et void](#methodes)
- [Portée des variables et passage par valeur](#portee)

**Tâches 0 et 1 — Objets et protection des données**

- [Classe : le modèle](#classe)
- [Objet, instance et new](#objet)
- [Attributs et état de chaque objet](#attributs)
- [Constructeur et initialisation](#constructeur)
- [Constructeur par défaut](#defaut)
- [this : l’objet courant](#this)
- [public, private, protected et accès de package](#visibilite)
- [static : un membre de classe](#static)
- [final sur un attribut, une méthode ou une classe](#final)
- [Encapsulation, getters et setters](#encapsulation)
- [Invariants et validation partagée](#invariants)
- [Immuabilité et identité stable](#immutabilite)
- [matches et expressions régulières](#regex)

**Tâche 2 — Méthodes d’Object**

- [Object : la classe parente commune](#object)
- [toString : décrire un objet](#tostring)
- [Identité avec == et égalité avec equals](#egalite)
- [instanceof et conversion de type](#instanceof)
- [hashCode et contrat d égalité](#hashcode)

**Tâches 3 et 4 — Records et enums**

- [Record et accesseurs générés](#record)
- [Constructeur compact d’un record](#compact)
- [Enum : une liste fixe de constantes](#enum)
- [values, ordinal, name et compareTo des enums](#enumoutils)

**Tâches 5 à 8 — Héritage et contrats**

- [Héritage et extends](#heritage)
- [super et ordre des constructeurs](#super)
- [Override : redéfinir une méthode](#override)
- [Surcharge et différence avec la redéfinition](#surcharge)
- [Polymorphisme et type réel](#polymorphisme)
- [Classe abstraite et méthodes abstraites](#abstraction)
- [protected et outil partagé entre enfants](#protected)
- [Interface et implements](#interface)
- [Méthode default d’une interface](#default)
- [Classe abstraite, interface, record ou enum](#contrats)

**Tâche 9 — Personnes et composition**

- [Composition : possède un](#composition)
- [Délégation : confier une opération](#delegation)
- [État de location et règles métier](#location)

**Tâche 10 — Collections et portefeuille**

- [List, ArrayList et taille variable](#list)
- [Copie défensive et liste interne](#copie)
- [Portfolio : recherche, filtres et indicateurs](#portfolio)

**Tâche 11 — Registre et génériques**

- [Map : associer une clé à une valeur](#map)
- [HashMap, TreeMap et HashSet](#maps)
- [Génériques, paramètre T et diamant](#generiques)
- [Borne générique : T extends Identifiable](#borne)
- [Registry : stockage générique par identifiant](#registry)

**Tâche 12 — Tris**

- [Comparable : l’ordre naturel](#comparable)
- [Comparator : des ordres supplémentaires](#comparator)
- [Lambda, référence de méthode et tri combiné](#lambda)
- [Trier une copie et traiter les égalités](#tri)

**Tâche 13 — Exceptions et baux**

- [Exceptions : signaler un échec](#exceptions)
- [Checked et unchecked](#checked)
- [throw et throws](#throw)
- [try, catch, finally et propagation](#trycatch)
- [Créer une exception personnalisée](#personnalisees)
- [serialVersionUID et avertissements Xlint](#serialisation)
- [Argument invalide ou état invalide](#erreurs)
- [Lease : bail, loyer total et dépôt](#lease)
- [Agency : contrôles et signature des baux](#agency)
- [Validation avant mutation et ordre des contrôles](#atomicite)

**Vérification**

- [Tests, erreurs de compilation et diagnostic](#tests)

- [Les quatre piliers de la POO](#piliers)
- [Carte des tâches 0 à 13](#parcours)
- [Vocabulaire rapide](#vocabulaire)
- [Erreurs fréquentes a éviter](#pieges)

---

## compilation

**Compiler et exécuter : JDK, javac, java, classpath**

**Description.** Le JDK fournit les outils Java. `javac` transforme les fichiers `.java` en fichiers `.class` contenant du bytecode ; `java` lance le programme sur la JVM. Le classpath indique où chercher les classes.

```bash
javac -Xlint:all 5-inheritance/*.java
java -cp 5-inheritance PropertyDemo
java tests/Task05Test.java
```

**Exemple expliqué.** La première commande compile toutes les classes du dossier. La deuxième lance le `main` de `PropertyDemo`. La troisième exécute directement le fichier source du test, qui utilise les classes compilées du projet.

**À retenir.** Enregistre tes modifications et recompile avant les tests. Un ancien `.class` peut ne plus correspondre au `.java`. Le JDK demandé ici est Java 21 ; aucune bibliothèque externe, aucun Maven ou Gradle.

[Retour au sommaire](#sommaire)

---

## fichiers

**Organisation des fichiers, package et import**

**Description.** Chaque classe publique va dans un fichier du même nom. Chaque dossier de tâche contient toutes ses dépendances : on copie les sources de la tâche précédente pour conserver les anciennes versions.

```bash
mkdir 6-polymorphism
cp 5-inheritance/*.java 6-polymorphism/
```

```java
import java.util.ArrayList;
import java.util.List;
```

**Exemple expliqué.** `Apartment.java`, `Property.java` et `Address.java` sont directement dans le dossier de la tâche. Dans ce projet, ils ne déclarent aucun `package` et appartiennent au package non nommé : aucun import entre eux. Les types de `java.lang`, comme `String`, `Object` et `Comparable`, sont disponibles automatiquement.

**À retenir.** `tests/` reste à la racine de `oop`. Ajoute `*.class` dans `.gitignore`. Utilise quatre espaces, pas de tabulations, et termine les fichiers par une nouvelle ligne.

[Retour au sommaire](#sommaire)

---

## types

**Types primitifs, types objets et null**

**Description.** `int` représente un entier, `boolean` un booleen. Une variable de type objet, comme `String` ou `Property`, contient une référence vers un objet, ou `null` pour l'absence d'objet.

```java
int surface = 25;
boolean occupied = false;
String city = "Paris";
Tenant tenant = null;
```

**Exemple expliqué.** Un bien sans locataire a `tenant == null`. En revanche, un `int` ne peut pas recevoir `null`.

**À retenir.** Appeler `tenant.getName()` quand `tenant` vaut `null` provoque une `NullPointerException`. Dans le projet, les montants sont des `int` en euros entiers.

[Retour au sommaire](#sommaire)

---

## calculs

**Calculs, division entière et dépassement**

**Description.** Les operateurs `+`, `-`, `*`, `/` et `%` servent aux calculs. Entre entiers, `/` produit un résultat entier : pour des nombres positifs, la partie décimale est retirée.

```java
int landCharge = 39 / 20;       // 1
int occupancy = 1 * 100 / 3;    // 33
int annualRent = 950 * 12;      // 11400
int remainder = 10 % 3;        // 1
```

**Exemple expliqué.** Un bien loué sur trois donne un taux d'occupation de 33 %. Fais la multiplication avant la division : `1 / 3 * 100` donnerait 0.

**À retenir.** Un `int` a une taille limitée. Pour une multiplication intermédiaire potentiellement grande, `(long) monthlyCost * 3` effectue le calcul en `long` sans changer le type des montants stockés.

[Retour au sommaire](#sommaire)

---

## conditions

**Conditions, comparaisons et court-circuit**

**Description.** `if` choisit une action ; `&&` signifie « et », `||` signifie « ou », `!` inverse un booleen. `&&` et `||` s'arrêtent des que le résultat est connu.

```java
if (address == null || address.isBlank()) {
    throw new IllegalArgumentException("Address must not be blank");
}

String label = hasElevator ? "elevator" : "no elevator";
```

**Exemple expliqué.** Si `address` est `null`, Java n'appelle pas `isBlank()`. L'opérateur ternaire `condition ? valeurSiVrai : valeurSiFaux` choisit une valeur.

**À retenir.** Une paire d'accolades vide ne fait rien : `if (surface > 0) {}` ne refuse aucune valeur. `switch` est une autre façon de choisir entre plusieurs cas, vue dans Java Basics.

[Retour au sommaire](#sommaire)

---

## boucles

**Boucles for, while et parcours**

**Description.** Une boucle répète des instructions. `for` convient au comptage, `while` convient à une répétition conditionnelle, et le `for` amélioré parcourt les éléments d'un tableau ou d'une collection.

```java
int total = 0;
for (Property property : properties) {
    total += property.getMonthlyRent();
}
```

**Exemple expliqué.** À chaque tour, `property` désigne le prochain bien et son loyer est ajouté au total. `total += valeur` signifie `total = total + valeur`.

**À retenir.** `return` termine toute la méthode ; `break` quitte une boucle ; `continue` passe au tour suivant. Pour retirer des éléments d'une liste, utilise une méthode adaptée, un itérateur ou un parcours contrôle par indices.

[Retour au sommaire](#sommaire)

---

## tableaux

**Tableaux, indices, longueur et varargs**

**Description.** Un tableau contient plusieurs éléments du même type et conserve une taille fixe. Les indices commencent a zéro ; `length` donne sa longueur.

```java
int[] values = {10, 20, 30};
int first = values[0];       // 10
values[1] = 25;
int count = values.length;   // 3
int[][] grid = {{1, 2}, {3, 4}};
int cell = grid[1][0];       // 3
```

**Exemple expliqué.** `values[3]` est invalide : le dernier indice est 2. Une méthode déclarée avec `int... values` accepte plusieurs entiers et les reçoit sous forme de tableau.

**À retenir.** Un setter `setSurface(int surface)` attend’un entier, pas `int[] args`. La taille d'un tableau ne change pas, mais ses éléments peuvent changer.

[Retour au sommaire](#sommaire)

---

## chaines

**String, immuabilité, comparaison et StringBuilder**

**Description.** Une `String` est un texte immuable. Ses méthodes de transformation renvoient une valeur : elles ne modifient pas le texte initial. `StringBuilder` construit progressivement un texte modifiable.

```java
String city = " Paris ";
String cleaned = city.trim();  // "Paris"
boolean same = cleaned.equals("Paris");
boolean sameIgnoringCase = cleaned.equalsIgnoreCase("paris");

StringBuilder builder = new StringBuilder();
builder.append("P-001").append(" | ").append(25);
String text = builder.toString();
```

**Exemple expliqué.** `trim()` retire les espaces et caractères de contrôle de bord couverts par cette méthode ; `isBlank()` détecte une chaîne vide ou faite seulement d'espaces blancs reconnus par Java. `StringBuilder` est utile pour des ajouts répétés.

**À retenir.** Compare les textes avec `equals()`, pas `==`. Le partagé de certaines chaînes par le pool peut donner l'impression trompeuse que `==` compare les contenus.

[Retour au sommaire](#sommaire)

---

## saisie

**Scanner, conversion et NumberFormatException**

**Description.** `Scanner` lit une saisie. `Integer.parseInt()` convertit un texte en entier et lève une `NumberFormatException` si le texte ne représente pas un `int` valide.

```java
try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
    if (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        try {
            int number = Integer.parseInt(line);
            System.out.println(number * 2);
        } catch (NumberFormatException e) {
            System.err.println("Entier invalide : " + line);
        }
    }
}
```

**Exemple expliqué.** `"42"` devient 42 ; `"bonjour"` est refuse. `hasNextLine()` permet de vérifier qu'une ligne est disponible. `System.out` est la sortie normale, `System.err` la sortie d'erreur.

**À retenir.** `System.exit(code)` arrête tout le programme et fournit un code de sortie ; dans ce projet OOP, il est interdit avant la tâche 14. Cet extrait de rappel ne l'utilise pas.

[Retour au sommaire](#sommaire)

---

## methodes

**Méthodes, paramètres, return et void**

**Description.** Une méthode regroupe un comportement. Ses paramètres sont les valeurs reçues ; les arguments sont les valeurs transmises lors de l'appel. Le type de retour indique ce qu'elle renvoie.

```java
public int getAnnualRent() {
    return monthlyRent * 12;
}

public void setMonthlyRent(int monthlyRent) {
    this.monthlyRent = validateMonthlyRent(monthlyRent);
}
```

**Exemple expliqué.** Le getter renvoie un `int`. Le setter renvoie `void`, c'est-a-dire aucune valeur. `return` transmet une valeur au code appelant ; il ne l'affiche pas.

**À retenir.** Le `main`, déclare `public static void main(String[] args)`, est le point d'entrée d'un programme exécutable. Toutes les classes n'ont pas besoin d'un `main`.

[Retour au sommaire](#sommaire)

---

## portee

**Portée des variables et passage par valeur**

**Description.** Une variable locale existe dans son bloc. Un attribut appartient à l'objet ou à la classe. Java passe toujours les arguments par valeur : il copie un entier ou la référence vers un objet.

```java
static void change(int value) {
    value = 99;
}

static void changeFirst(int[] values) {
    values[0] = 99;
}
```

**Exemple expliqué.** `change(number)` ne remplace pas l'entier de l'appelant. `changeFirst(array)` modifie le tableau partagé, car les deux références désignent le même tableau.

**À retenir.** Réaffecter le paramètre objet à un autre objet ne remplace pas la variable de l'appelant. Cette distinction explique pourquoi une copie de liste peut encore contenir les mêmes biens.

[Retour au sommaire](#sommaire)

---

## classe

**Classe : le modèle**

**Description.** Une classe définit les données et les comportements d'une famille d'objets. Elle sert de modèle, pas d'exemplaire particulier.

```java
public class Counter {
    private int value;

    public int getValue() {
        return value;
    }
}
```

**Exemple expliqué.** `Counter` decrit un compteur avec sa valeur et une méthode pour la lire. Dans le projet immobilier, `Property` decrit les caracteristiques communes aux biens.

**À retenir.** Une déclaration de classe ne crée pas automatiquement un objet. `class`, `record`, `enum` et `interface` sont des mots-clés de déclaration de types.

[Retour au sommaire](#sommaire)

---

## objet

**Objet, instance et new**

**Description.** Un objet est une instance concrète d'une classe. `new` crée l'instance et appelle un constructeur. Une variable objet permet d'y accéder par une référence.

```java
Address address = new Address("12 Rue de la Paix", "75002", "Paris");
Apartment apartment = new Apartment(
    "P-001", address, 25, 950, EnergyClass.D, 3, true
);
```

**Exemple expliqué.** `Apartment` est le type de la variable ; `apartment` est son nom ; `new Apartment(...)` crée le bien. Un autre appel à `new Apartment(...)` crée un autre objet.

**À retenir.** À partir de la tâche 7, `Property` est abstraite : `new Property(...)` devient interdit. Créer un `Apartment`, un `House` ou un `CommercialSpace` reste autorise.

[Retour au sommaire](#sommaire)

---

## attributs

**Attributs et état de chaque objet**

**Description.** Un attribut conserve une information de l'objet. L'ensemble de ses valeurs constitue son état. Chaque instance a ses propres attributs d'instance.

```java
private final String reference;
private Address address;
private int surface;
private int monthlyRent;
```

**Exemple expliqué.** Un appartement peut avoir une surface de 25 et une maison une surface de 120. Leurs valeurs ne s'ecrasent pas mutuellement.

**À retenir.** Une variable locale aide temporairement une méthode ; un attribut conserve l'information dans l'objet après la fin de l'appel.

[Retour au sommaire](#sommaire)

---

## constructeur

**Constructeur et initialisation**

**Description.** Un constructeur initialise une nouvelle instance. Il porte le nom de la classe et n'a aucun type de retour, même pas `void`.

```java
public Owner(Contact contact) {
    if (contact == null) {
        throw new IllegalArgumentException("Contact must not be null");
    }
    this.contact = contact;
}
```

**Exemple expliqué.** `new Owner(contact)` appelle ce constructeur. Si le contact est invalide, la construction échoue : aucun objet construit avec succes n'est renvoye à l'appelant.

**À retenir.** Un constructeur peut valider les arguments avant de les enregistrer. Une classe peut déclarer plusieurs constructeurs avec des paramètres différents.

[Retour au sommaire](#sommaire)

---

## defaut

**Constructeur par défaut**

**Description.** Pour une classe ordinaire qui ne déclare aucun constructeur, Java fournit un constructeur sans argument. Des que tu déclarés un constructeur, ce constructeur automatique n'est plus ajouté.

```java
public class Example {
}
// new Example() est possible.
```

```java
public class Counter {
    private int value;
    public Counter(int value) {
        this.value = value;
    }
}
// new Counter(5) fonctionne ; new Counter() ne fonctionne pas.
```

**À retenir.** Le constructeur par défaut appelle implicitement `super()`. Si la classe parente n'a pas de constructeur sans argument accessible, il faut écrire un constructeur adapté.

[Retour au sommaire](#sommaire)

---

## this

**this : l’objet courant**

**Description.** `this` désigne l'objet sur lequel on travaille. Il distingue un attribut d'un paramètre qui porte le même nom.

```java
public void setSurface(int surface) {
    this.surface = validateSurface(surface);
}
```

**Exemple expliqué.** A gauche, `this.surface` est l'attribut du bien. Dans l'appel de validation, `surface` est le paramètre reçu.

**À retenir.** Dans une méthode `static`, il n'y a pas d'objet courant : `this` n'est donc pas disponible. `this(...)` sert aussi a appeler un autre constructeur de la même classe, en première instruction avec Java 21.

[Retour au sommaire](#sommaire)

---

## visibilite

**public, private, protected et accès de package**

**Description.** La visibilité détermine quel code peut accéder à une déclaration.

| Mot-clé | Acces |
| --- | --- |
| `public` | Depuis les autres classes, sous reserve de l'accessibilite du type. |
| `private` | Dans la classe qui déclare le membre ; les classes imbriquees ont aussi des règles d'accès privilégiées. |
| `protected` | Dans le même package et, avec des restrictions hors package, depuis les classes enfants. |
| Aucun | Dans le même package. |

```java
private int surface;
public int getSurface() { return surface; }
protected int getCommonCharges() { return surface * 2; }
```

**Exemple expliqué.** Les autres classes lisent la surface via le getter. Les classes enfants peuvent utiliser le calcul commun protège, sans accéder directement à l'attribut privé.

**À retenir.** `protected` ne veut pas dire « uniquement les enfants » : le package a aussi accès. Dans le projet, tous les attributs d'instance restent privés.

[Retour au sommaire](#sommaire)

---

## static

**static : un membre de classe**

**Description.** Un membre `static` appartient à la classe, au lieu d'appartenir séparément à chaque instance.

```java
private static int nextId = 1;

public static int getNextId() {
    return nextId;
}
```

**Exemple expliqué.** Un compteur d'identifiants `nextId` peut etre partagé par tous les tickets. Dans une classe `Ticket` contenant cet exemple, on appelle la méthode avec `Ticket.getNextId()`. Autre exemple du projet : `EnergyClass.fromConsumption(70)`.

**À retenir.** La surface d'un bien ne doit pas etre `static` : chaque bien a sa propre surface. Une méthode de validation peut etre `private static` lorsqu'elle ne depend que de son argument.

[Retour au sommaire](#sommaire)

---

## final

**final sur un attribut, une méthode ou une classe**

**Description.** Le sens de `final` depend de son emplacement.

| Emplacement | Effet |
| --- | --- |
| Attribut ou variable | Impossible de lui affecter une autre valeur après son initialisation. |
| Méthode | Impossible pour une classe enfant de la redéfinir. |
| Classe | Impossible de créer une classe qui en hérite. |

```java
private final String reference;
private static final int ELEVATOR_CHARGE = 40;
public final int getMonthlyCost() {
    return monthlyRent + getMonthlyCharges();
}
```

**Exemple expliqué.** La référence est définitive ; les 40 euros sont une constante nommee ; la formule du coût mensuel ne peut pas etre redéfinie.

**À retenir.** Une liste `final` reste modifiable avec `add()` ou `remove()` : seule la variable ne peut plus designer une autre liste. Un objet ne devient pas immuable simplement parce qu'une variable qui le désigne est `final`.

[Retour au sommaire](#sommaire)

---

## encapsulation

**Encapsulation, getters et setters**

**Description.** L'encapsulation protège l'état interne d'un objet. Les getters permettent de lire les informations ; les setters encadrent leurs modifications.

```java
public int getSurface() {
    return surface;
}

public void setSurface(int surface) {
    this.surface = validateSurface(surface);
}
```

**Exemple expliqué.** Le getter lit une valeur déjà valide. Le setter contrôle une nouvelle valeur avant de l'enregistrer. Le constructeur doit effectuer la même validation pour la valeur initiale.

**À retenir.** Ne valide pas seulement au moment de l'affichage : l'objet pourrait déjà etre invalide. Un attribut `private` ne suffit pas si le constructeur ou les setters acceptent n'importe quoi.

[Retour au sommaire](#sommaire)

---

## invariants

**Invariants et validation partagée**

**Description.** Un invariant est une règle qui doit rester vraie pour chaque objet construit avec succes et après chaque modification publique. Une méthode privée permet de partager une règle entre constructeur et setter.

```java
private static int validateSurface(int surface) {
    if (surface <= 0) {
        throw new IllegalArgumentException(
            "Surface must be positive: " + surface
        );
    }
    return surface;
}
```

**Exemple expliqué.** La surface doit etre strictement positive. Le loyer, lui, peut etre nul : sa validation refuse seulement les valeurs inferieures a zéro.

**À retenir.** Dans le constructeur et le setter : `this.surface = validateSurface(surface);`. Évite d'appeler des setters publics redéfinissables depuis un constructeur : une méthode enfant pourrait etre exécutée avant l'initialisation complete de l'enfant, ce qui peut provoquer un avertissement `this-escape`.

[Retour au sommaire](#sommaire)

---

## immutabilite

**Immuabilité et identité stable**

**Description.** Un objet immuable ne change plus d'état après sa construction. Un identifiant stable, comme la référence d'un bien, ne peut plus etre remplace.

```java
Address oldAddress = new Address("12 Rue de la Paix", "75002", "Paris");
Address newAddress = new Address("5 Rue Victor Hugo", "69002", "Lyon");
p.setAddress(newAddress);
```

**Exemple expliqué.** Le bien utilise une nouvelle adresse. L'objet `oldAddress` n'a pas ete modifie. `Property` reste mutable, car son loyer, son adresse ou son locataire peuvent changer.

**À retenir.** Les composants du record `Address` sont des `String` immuables. Un record contenant une liste modifiable ne rendrait pas automatiquement cette liste immuable : l'immuabilité des records est superficielle par défaut.

[Retour au sommaire](#sommaire)

---

## regex

**matches et expressions régulières**

**Description.** `String.matches()` vérifie qu'un texte entier respecte un motif, appelé expression régulière.

```java
boolean validReference = "P-001".matches("P-[0-9]{3}"); // true
boolean validZip = "01000".matches("[0-9]{5}");         // true
boolean invalid = "P-1".matches("P-[0-9]{3}");          // false
```

**Exemple expliqué.** `[0-9]` représente un chiffre. `{3}` demandé exactement trois répétitions. La référence contient donc `P-` puis exactement trois chiffres.

**À retenir.** Verifie `null` avant d'appeler `matches()`. Le code postal reste une chaîne afin de conserver le zéro de début de `"01000"`.

[Retour au sommaire](#sommaire)

---

## object

**Object : la classe parente commune**

**Description.** Toute classe Java ordinaire hérite directement ou indirectement d'`Object`. Des méthodes existent donc déjà, même sans parent explicitement écrit.

```java
public class Example {
}
// Pour cette classe ordinaire, le parent implicite est Object.
```

```java
String type = p.getClass().getSimpleName();
```

**Exemple expliqué.** `getClass()` retrouve le type réel de l'objet ; `getSimpleName()` donne un nom comme `Apartment`. `Object` fournit notamment `toString()`, `equals()` et `hashCode()`.

**À retenir.** Un record hérite directement de `java.lang.Record`, qui hérite d'`Object`. Un enum hérite de `java.lang.Enum`. Il n'est pas nécessaire de déclarer un parent soi-même pour utiliser `@Override`.

[Retour au sommaire](#sommaire)

---

## tostring

**toString : décrire un objet**

**Description.** `toString()` renvoie une representation textuelle de l'objet. `System.out.println(objet)` l'utilise automatiquement pour un objet non nul.

```java
@Override
public String toString() {
    return street + ", " + zipCode + " " + city;
}
```

**Exemple expliqué.** Pour une adresse parisienne, cela renvoie `12 Rue de la Paix, 75002 Paris`. La méthode prépare le texte ; `println()` l'affiche.

**À retenir.** Respecte les espaces et la ponctuation demandes. Dans `Property`, les separateurs sont ` | `. Depuis la tâche 7, son texte commence par `getType()`.

[Retour au sommaire](#sommaire)

---

## egalite

**Identité avec == et égalité avec equals**

**Description.** Sur des références d'objets, `==` demandé si elles désignent le même objet. `equals()` applique la règle d'égalité du type. Dans le projet, deux biens sont égaux si leur référence métier est identique.

```java
Address address = new Address("12 Rue de la Paix", "75002", "Paris");
Property a = new Apartment("P-001", address, 25, 950, EnergyClass.D, 3, true);
Property b = new Apartment("P-001", address, 40, 800, EnergyClass.C, 0, false);

System.out.println(a == b);       // false
System.out.println(a.equals(b));  // true
```

**Exemple expliqué.** Les deux objets sont distincts, mais représentent le même bien selon la règle du projet. `a.equals(null)` doit renvoyer `false`.

**À retenir.** Une référence métier comme `"P-001"` est un identifiant textuel ; une référence Java est ce qu'une variable objet utilise pour designer l'instance. Ne confonds pas ces deux sens du mot « référence ».

[Retour au sommaire](#sommaire)

---

## instanceof

**instanceof et conversion de type**

**Description.** `instanceof` vérifie si un objet est compatible avec un type. Une conversion explicite, ou cast, permet ensuite de le traiter comme ce type.

```java
@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (!(o instanceof Property)) {
        return false;
    }
    Property other = (Property) o;
    return reference.equals(other.reference);
}
```

**Exemple expliqué.** L'argument peut etre n'importe quel `Object`. La vérification refuse `null` et les objets qui ne sont pas des biens avant la conversion.

**À retenir.** Le paramètre doit etre `Object`, pas `Property`, pour redéfinir la méthode d'`Object`. Les génériques permettent ensuite d'éviter de nombreux casts dans les collections et le registre.

[Retour au sommaire](#sommaire)

---

## hashcode

**hashCode et contrat d égalité**

**Description.** `hashCode()` fournit un entier utilise par les collections de hachage. Deux objets égaux doivent obligatoirement avoir le même code de hachage ; l'inverse n'est pas garanti.

```java
@Override
public int hashCode() {
    return reference.hashCode();
}
```

**Exemple expliqué.** Puisque l'égalité des biens depend’uniquement de la référence, leur code de hachage depend’uniquement de cette référence. Un `HashSet` qui reçoit deux biens égaux n'en conserve qu'un.

**À retenir.** Redefinis `equals()` et `hashCode()` ensemble. L'égalité doit etre réflexive, symétrique, transitive et cohérente tant que les valeurs concernees ne changent pas ; un objet non nul n'est pas égal a `null`. Une référence `final` aide a stabiliser cette règle.

[Retour au sommaire](#sommaire)

---

## record

**Record et accesseurs générés**

**Description.** Un record est une forme de classe qui regroupe des données et génère le code courant associe à ses composants : attributs privés et définitifs, constructeur canonique, accesseurs, `equals()`, `hashCode()` et `toString()`.

```java
public record Contact(String name, String email) {
}

// Utilisation :
Contact contact = new Contact("Alice Martin", "alice@example.com");
String name = contact.name();
```

**Exemple expliqué.** L'accesseur est `name()`, pas `getName()`. Deux contacts ont l'égalité générée si leurs composants sont égaux. Dans ce projet, `Address`, `Contact` et `Lease` sont des records.

**À retenir.** Un record est implicitement `final`, ne peut pas étendre une autre classe, et peut implémenter une interface. Il ne peut pas ajoutér d'attribut d'instance en dehors de ses composants ; les constantes `static` sont possibles.

[Retour au sommaire](#sommaire)

---

## compact

**Constructeur compact d’un record**

**Description.** Le constructeur compact valide ou normalise les composants sans réécrire leurs paramètres ni leurs affectations aux attributs.

```java
public record Contact(String name, String email) {
    public Contact {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        // La validation de l'email doit aussi etre ajoutee dans le projet.
    }
}
```

**Exemple expliqué.** `public Contact { ... }` ne comporte pas de parenthèses. Les composants reçus sont accessibles directement. Java les enregistre automatiquement à la fin du constructeur si les vérifications réussissent.

**À retenir.** Pour `Address`, valide la rue, le code postal et la ville. Pour `Contact`, le projet demandé exactement un `@`, ni au début ni à la fin : il s'agit d'une règle simplifiee, pas d'une validation complete de toutes les adresses email possibles.

[Retour au sommaire](#sommaire)

---

## enum

**Enum : une liste fixe de constantes**

**Description.** Un enum définit un ensemble ferme de valeurs nommees. Chaque constante peut avoir des attributs et des méthodes.

```java
public enum EnergyClass {
    A(70), B(110), C(180), D(250), E(330), F(420), G(Integer.MAX_VALUE);

    private final int maxConsumption;

    EnergyClass(int maxConsumption) {
        this.maxConsumption = maxConsumption;
    }

    public int getMaxConsumption() {
        return maxConsumption;
    }
}
```

**Exemple expliqué.** `EnergyClass.C` est une constante existante ; on n'écrit pas `new EnergyClass(...)`. Son seuil est 180. L'enum est un vrai type, pas une simple collection de textes.

**À retenir.** Dans le projet, seule la classe G interdit la location. C'est une règle pédagogique de l'exercice, pas une presentation de la réglementation réelle.

[Retour au sommaire](#sommaire)

---

## enumoutils

**values, ordinal, name et compareTo des enums**

**Description.** Les enums possèdent des outils qui evitent de répéter leurs constantes ou leurs seuils.

```java
EnergyClass.A.ordinal();                 // 0
EnergyClass.C.name();                    // "C"
EnergyClass.A.compareTo(EnergyClass.B);   // negatif

for (EnergyClass energyClass : EnergyClass.values()) {
    System.out.println(energyClass.name());
}
```

**Exemple expliqué.** `values()` fournit les constantes dans leur ordre de déclaration. Pour `fromConsumption`, parcours-les et renvoie la première dont le seuil est superieur ou égal à la consommation : 70 donne A, 71 donne B.

**À retenir.** `isBetterThan(other)` peut utiliser `compareTo(other) < 0`. Une consommation négative doit etre refusée avant le parcours. Ne réécris pas les seuils dans une suite de conditions.

[Retour au sommaire](#sommaire)

---

## heritage

**Héritage et extends**

**Description.** L'héritage exprime « est un ». Une classe enfant spécialise une classe parente en réutilisant ses comportements et en ajoutant ses particularites.

```java
public class Apartment extends Property {
    private int floor;
    private boolean hasElevator;
    // Constructeur et methodes a ajouter.
}
```

**Exemple expliqué.** Un appartement est un bien immobilier. Ses données communes sont gerees par `Property` ; ses propres champs sont l'étage et l'ascenseur. Une maison ajoute la surface du terrain.

**À retenir.** Ne redeclare pas `reference`, `surface` ou `monthlyRent` dans les enfants. Les attributs privés de la parente ne sont pas directement accessibles : utilise ses getters. Les constructeurs ne sont pas hérités.

[Retour au sommaire](#sommaire)

---

## super

**super et ordre des constructeurs**

**Description.** `super(...)` appelle un constructeur de la classe parente. `super.methode()` appelle sa version d'une méthode concrète héritée.

```java
public Apartment(String reference, Address address, int surface,
                 int monthlyRent, EnergyClass energyClass,
                 int floor, boolean hasElevator) {
    super(reference, address, surface, monthlyRent, energyClass);
    if (floor < 0) {
        throw new IllegalArgumentException("Floor must not be negative: " + floor);
    }
    this.floor = floor;
    this.hasElevator = hasElevator;
}
```

**Exemple expliqué.** En Java 21, l'appel explicite au constructeur parent est en première instruction. Les données communes sont initialisées avant les instructions propres à l'enfant.

**À retenir.** Depuis la tâche 7, `getMonthlyCharges()` est abstraite dans `Property` : `super.getMonthlyCharges()` n'a plus d'implementation a appeler. Les enfants utilisent `getCommonCharges()`.

[Retour au sommaire](#sommaire)

---

## override

**Override : redéfinir une méthode**

**Description.** Redefinir consiste a fournir, dans un enfant, une implementation adaptée d'une méthode héritée. `@Override` fait vérifier cette intention par le compilateur.

```java
@Override
public String getType() {
    return "Apartment";
}
```

**Exemple expliqué.** `Property` déclare `getType()` ; l'appartement fournit sa reponse. Redefinir `toString()` est aussi possible grace à l'héritage d'`Object`.

**À retenir.** Respecte le nom, les paramètres et un retour compatible. Une faute comme `tostring()` est détectée par `@Override`. L'annotation ne crée pas l'héritage : elle vérifie la redéfinition. Les méthodes statiques sont masquées, pas redéfinies de cette manière.

[Retour au sommaire](#sommaire)

---

## surcharge

**Surcharge et différence avec la redéfinition**

**Description.** La surcharge donne le même nom a plusieurs méthodes avec des listes de paramètres différentes. La redéfinition personnalise une méthode héritée de même signature.

```java
public static int max(int a, int b) {
    return Math.max(a, b);
}

public static int max(int a, int b, int c) {
    return Math.max(max(a, b), c);
}
```

**Exemple expliqué.** `max(2, 5)` et `max(2, 5, 7)` sélectionnent des surcharges selon leurs arguments. `equals(Property other)` surchargerait `equals(Object o)` au lieu de le redéfinir.

**À retenir.** Changer uniquement le type de retour ne suffit pas a surcharger. Le choix d'une surcharge se fait à la compilation ; le choix d'une implementation redéfinie depend de l'objet à l'exécution.

[Retour au sommaire](#sommaire)

---

## polymorphisme

**Polymorphisme et type réel**

**Description.** Une variable du type parent peut designer un objet enfant. Pour une méthode d'instance redéfinie, Java choisit l'implementation correspondant au type réel de l'objet.

```java
Property p = new Apartment(
    "P-001", new Address("12 Rue de la Paix", "75002", "Paris"),
    25, 950, EnergyClass.D, 3, true
);
int charges = p.getMonthlyCharges(); // 90
int cost = p.getMonthlyCost();       // 1040
```

**Exemple expliqué.** La variable est une `Property`, l'objet est un `Apartment`. Les charges sont 25 × 2 + 40. La méthode finale `getMonthlyCost()` appelle elle aussi la bonne version de `getMonthlyCharges()`.

**À retenir.** Dans une boucle sur `Property[]` ou `List<Property>`, aucun `if` ni `instanceof` n'est nécessaire pour choisir le calcul de charges.

[Retour au sommaire](#sommaire)

---

## abstraction

**Classe abstraite et méthodes abstraites**

**Description.** Une classe abstraite fournit une base commune sans etre directement instanciable. Une méthode abstraite déclare une opération que les classes concrètes doivent implémenter.

```java
public abstract class Property {
    public abstract String getType();
    public abstract int getMonthlyCharges();
    // Autres attributs, constructeur et methodes.
}
```

**Exemple expliqué.** `new Property(...)` est interdit ; `Property p = new House(...)` reste possible. `Apartment`, `House` et `CommercialSpace` fournissent le type et les charges.

**À retenir.** Une méthode abstraite se termine par `;`, sans corps. Une classe qui en déclare doit etre abstraite. Une classe abstraite peut avoir des attributs, un constructeur et des méthodes concrètes.

[Retour au sommaire](#sommaire)

---

## protected

**protected et outil partagé entre enfants**

**Description.** Une méthode protégée permet de fournir un outil commun aux classes enfants sans l'exposer comme une méthode publique de service.

```java
private static final int CHARGES_PER_SQUARE_METER = 2;

protected int getCommonCharges() {
    return surface * CHARGES_PER_SQUARE_METER;
}
```

**Exemple expliqué.** Les appartements ajoutent eventuellement les frais d'ascenseur ; les maisons ajoutent `landSurface / 20` ; les locaux commerciaux doublent les charges communes.

**À retenir.** Le constructeur de `Property` devient aussi `protected` à la tâche 7. Le mot-clé n'accorde pas automatiquement aux enfants l'accès aux attributs `private`.

[Retour au sommaire](#sommaire)

---

## interface

**Interface et implements**

**Description.** Une interface définit un contrat de capacités. Une classe ne peut étendre qu'une classe, mais elle peut implémenter plusieurs interfaces.

```java
public interface Identifiable {
    String getId();
}
```

```java
public abstract class Property
        implements Insurable, Comparable<Property>, Identifiable {
    // Implementations et membres du projet.
}
```

**Exemple expliqué.** Un bien est assurable, comparable et identifiable. Les méthodes abstraites déclarées dans une interface sont implicitement publiques ; leur implementation doit etre publique.

**À retenir.** Dans `T extends Identifiable`, `extends` exprime une borne générique, même si `Identifiable` est une interface. Une classe abstraite peut laisser certains contrats à ses enfants.

[Retour au sommaire](#sommaire)

---

## default

**Méthode default d’une interface**

**Description.** Une méthode `default` fournit une implementation partagée dans une interface. Les classes qui l'implémentent peuvent l'utiliser ou la redéfinir.

```java
public interface Insurable {
    int MIN_PREMIUM = 150;
    int PREMIUM_RATE = 3;
    int PREMIUM_VALUE_UNIT = 1000;

    int getInsuredValue();

    default int getYearlyInsurancePremium() {
        return Math.max(MIN_PREMIUM,
            getInsuredValue() * PREMIUM_RATE / PREMIUM_VALUE_UNIT);
    }
}
```

**Exemple expliqué.** Un appartement assure pour 75000 euros paie 225 euros. Une valeur faible produit tout de même une prime minimale de 150 euros. Le local commercial double la prime héritée, après application du minimum.

**À retenir.** Les constantes de l'interface sont implicitement `public static final`. Ne confonds pas une méthode `default` avec le constructeur par défaut d'une classe.

[Retour au sommaire](#sommaire)

---

## contrats

**Classe abstraite, interface, record ou enum**

**Description.** Ces outils répondent a des besoins différents et peuvent se combiner.

| Forme | Usage | Exemple |
| --- | --- | --- |
| Classe ordinaire | Objets avec état et comportements. | `Owner`, `Portfolio`. |
| Classe abstraite | Base partagée incomplète. | `Property`. |
| Interface | Capacite ou contrat. | `Insurable`, `Identifiable`. |
| Record | Données regroupees avec code génère. | `Address`, `Contact`, `Lease`. |
| Enum | Ensemble fixe de valeurs. | `EnergyClass`. |

```java
public class Apartment extends Property {
    // Reutilise une base et fournit ses comportements specifiques.
}
```

**Exemple expliqué.** Un appartement est une `Property`, possède une `Address` et respecte les interfaces implémentées par `Property`.

**À retenir.** Le mot `public` règle l'accessibilite du type ; `class`, `record`, `enum` et `interface` indiquent sa forme.

[Retour au sommaire](#sommaire)

---

## composition

**Composition : possède un**

**Description.** La composition assemble des objets : un objet contient une référence vers un autre objet qui représente une partie de ses données ou de ses responsabilites.

```java
public class Owner {
    private final Contact contact;
    // Constructeur et methodes.
}
```

**Exemple expliqué.** Un propriétaire possède un contact. Un locataire possède aussi un contact, mais n'est pas un propriétaire. Un bien possède une adresse, un propriétaire et eventuellement un locataire.

**À retenir.** « Est un » suggère l'héritage ; « possède un » suggère la composition. Évite de créer une hiérarchie uniquement pour partager un nom et un email. Ici, le terme composition est utilise au sens pédagogique d'assemblage d'objets, sans imposer une destruction commune des objets.

[Retour au sommaire](#sommaire)

---

## delegation

**Délégation : confier une opération**

**Description.** Déléguer consiste a transmettre une demandé à un autre objet qui sait déjà y répondre.

```java
public String getName() {
    return contact.name();
}

public boolean isRentable() {
    return energyClass.isRentable();
}
```

**Exemple expliqué.** `Owner` demandé son nom au `Contact`. `Property` demandé à son enum si sa classe énergétique autorise la location.

**À retenir.** Le nom et l'email ne doivent pas etre stockés à la fois dans `Contact` et dans `Owner` ou `Tenant`. Une seule source évite les incoherences.

[Retour au sommaire](#sommaire)

---

## location

**État de location et règles métier**

**Description.** Le locataire courant définit si un bien est loué. Les méthodes de modification verifient la situation avant de changer cet état.

```java
public boolean isRented() {
    return tenant != null;
}
```

```java
p.rentTo(tenant);   // Apres les controles, enregistre le locataire.
p.release();        // Apres controle, remet le locataire a null.
```

**Exemple expliqué.** `rentTo` refuse d'abord’un locataire nul, puis un bien déjà loué, puis un bien non louable. `release` refuse un bien déjà vacant.

**À retenir.** La présence d'un propriétaire n'est pas une condition de location ajoutée par l'énoncé. `Tenant.canAfford()` compare les revenus à trois fois le coût mensuel ; le contrôle des revenus intervient dans `Agency.signLease()` à la tâche 13.

[Retour au sommaire](#sommaire)

---

## list

**List, ArrayList et taille variable**

**Description.** `List` est une interface de collection ordonnee ; `ArrayList` est une classe qui l'implémente. Une liste peut grandir et diminuer.

```java
List<Property> properties = new ArrayList<>();
properties.add(apartment);
int count = properties.size();
Property first = properties.get(0);
boolean exists = properties.contains(apartment);
```

**Exemple expliqué.** Le type déclaré est `List<Property>`, mais l'objet créé est un `ArrayList`. Une `ArrayList` conserve ici l'ordre d'insertion. `contains()` et `remove(objet)` utilisent l'égalité des objets.

**À retenir.** Un tableau utilise `length` ; une liste utilise `size()`. Un indice invalide reste une erreur, même dans une liste. Importe `java.util.List` et `java.util.ArrayList`.

[Retour au sommaire](#sommaire)

---

## copie

**Copie défensive et liste interne**

**Description.** Une copie défensive protège une structure interne contre les modifications directes effectuées par le code appelant.

```java
public List<Property> getProperties() {
    return new ArrayList<>(properties);
}
```

```java
List<Property> copy = portfolio.getProperties();
copy.clear(); // Le portefeuille conserve ses biens.
```

**Exemple expliqué.** La copie est une nouvelle liste, mais ses éléments désignent toujours les mêmes biens. `copy.get(0).setMonthlyRent(1000)` peut donc encore modifier le bien partagé, si cet élément existe.

**À retenir.** `return properties;` exposerait la liste interne. Une copie de liste est superficielle : elle ne clone pas chaque objet. Pour cette tâche, une copie modifiable est attendue, notamment pour pouvoir appeler `clear()` dessus.

[Retour au sommaire](#sommaire)

---

## portfolio

**Portfolio : recherche, filtres et indicateurs**

**Description.** Le portefeuille rassemble les biens, refuse les doublons par référence et calcule des indicateurs sur leur état courant.

```java
portfolio.add(apartment);
Property found = portfolio.findByReference("P-001");
List<Property> paris = portfolio.findByCity("paris");
List<Property> vacant = portfolio.getVacant();
```

**Exemple expliqué.** `findByCity` compare les villes sans tenir compte de la casse. Les filtres conservent l'ordre d'insertion. `getMonthlyIncome()` additionne les loyers des biens loués uniquement, tandis que `getTotalMonthlyRent()` additionne tous les loyers.

**À retenir.** Le taux d'occupation est 0 pour une liste vide, sinon `nombreLoue * 100 / nombreTotal`, arrondi vers le bas. Les revenus du portefeuille portent sur les loyers, pas sur les loyers plus charges.

[Retour au sommaire](#sommaire)

---

## map

**Map : associer une clé à une valeur**

**Description.** Une `Map<K, V>` associe chaque clé à une valeur. Elle permet de retrouver un objet à partir de son identifiant.

```java
Map<String, Owner> owners = new TreeMap<>();
owners.put("alice@example.com", owner);
Owner found = owners.get("alice@example.com");
boolean exists = owners.containsKey("alice@example.com");
Owner removed = owners.remove("alice@example.com");
```

**Exemple expliqué.** La clé est l'email et la valeur l'objet `Owner`. `get()` renvoie `null` si aucune entrée n'est présente, dans le registre qui ne stocke pas de valeurs nulles.

**À retenir.** `put()` remplace une valeur si la clé existe déjà. `Registry.register()` doit donc vérifier le doublon avant d'appeler `put()` pour conserver le premier objet.

[Retour au sommaire](#sommaire)

---

## maps

**HashMap, TreeMap et HashSet**

**Description.** Les collections n'offrent pas toutes le même ordre ni la même recherche des clés.

| Type | Fonctionnement utile ici |
| --- | --- |
| `HashMap` | Associe des clés et valeurs, sans garantir l'ordre ; utilise `hashCode()` et `equals()`. |
| `TreeMap` | Trie les clés selon leur ordre naturel ou un comparateur. |
| `HashSet` | Conserve des éléments uniques selon `hashCode()` et `equals()`, sans garantir l'ordre. |

```java
Map<String, Property> items = new TreeMap<>();
items.put("P-002", secondProperty);
items.put("P-001", firstProperty);
// Les valeurs sont parcourues dans l'ordre des cles : P-001, P-002.
```

**Exemple expliqué.** `TreeMap` simplifié le registre qui doit restituer ses éléments triés par identifiant.

**À retenir.** Une clé de `HashMap` doit avoir une égalité et un code de hachage cohérents et stables pendant son utilisation. Pour `TreeMap`, une comparaison donnant 0 fait considérer les clés comme équivalentes dans la map.

[Retour au sommaire](#sommaire)

---

## generiques

**Génériques, paramètre T et diamant**

**Description.** Un type générique réutilise du code pour plusieurs types tout en preservant les contrôles de type à la compilation.

```java
List<Property> properties = new ArrayList<>();
Registry<Owner> owners = new Registry<>();
Owner alice = owners.get("alice@example.com");
```

**Exemple expliqué.** Dans `Registry<Owner>`, `T` devient `Owner`. La méthode `get()` renvoie donc un `Owner`, sans cast. Le diamant `<>` laisse le compilateur déduire le type à droite.

**À retenir.** Évite les types bruts comme `List` sans paramètre : ils perdent les garanties de type et peuvent provoquer des avertissements. Les génériques utilisent des types références : une liste d'entiers s'écrit `List<Integer>`, pas `List<int>`.

[Retour au sommaire](#sommaire)

---

## borne

**Borne générique : T extends Identifiable**

**Description.** Une borne limite les types acceptes par un paramètre générique. Elle garantit aussi quelles méthodes sont disponibles sur un objet de type `T`.

```java
public class Registry<T extends Identifiable> {
    // T possede obligatoirement une methode getId().
}
```

```java
Registry<Property> properties = new Registry<>();
Registry<Owner> owners = new Registry<>();
// Registry<String> refuse : String n'implemente pas Identifiable.
```

**Exemple expliqué.** Le registre accepte les biens, propriétaires ou locataires parce qu'ils implémentent tous `Identifiable`. Il n'a pas besoin de connaître leurs classes concrètes.

**À retenir.** `Property.getId()` renvoie la référence du bien ; `Owner.getId()` et `Tenant.getId()` renvoient leur email. Le registre ne doit contenir ni cast, ni traitement spécifique pour ces classes.

[Retour au sommaire](#sommaire)

---

## registry

**Registry : stockage générique par identifiant**

**Description.** Le registre conserve une seule map interne et propose des opérations génériques sur ses éléments.

```java
private final Map<String, T> items = new TreeMap<>();

public T get(String id) {
    return items.get(id);
}

public List<T> getAll() {
    return new ArrayList<>(items.values());
}
```

**Exemple expliqué.** `register(item)` refuse `null` et un identifiant déjà utilise. `unregister(id)` retire et renvoie l'objet. La copie fournie par `getAll()` suit l'ordre des clés de la `TreeMap`.

**À retenir.** Un identifiant stable évite qu'un objet change d'identité après son enregistrement. `final` sur la map protège la variable ; la copie protège la collection retournée.

[Retour au sommaire](#sommaire)

---

## comparable

**Comparable : l’ordre naturel**

**Description.** `Comparable<T>` définit l'ordre naturel d'un type à l'aide de `compareTo(T other)`.

```java
@Override
public int compareTo(Property other) {
    return reference.compareTo(other.reference);
}
```

**Exemple expliqué.** Un résultat négatif signifie « avant », zéro signifie « équivalent pour le tri », un résultat positif signifie « après ». Les références P-001 et P-002 sont comparées comme des chaînes.

**À retenir.** Le résultat n'est pas obligatoirement -1, 0 ou 1. Ici, `compareTo()` est cohérent avec `equals()` : une même référence donne une comparaison égale a zéro et une égalité vraie.

[Retour au sommaire](#sommaire)

---

## comparator

**Comparator : des ordres supplémentaires**

**Description.** Un comparateur est un objet qui définit une autre façon de comparer deux valeurs, à l'extérieur de leur classe.

```java
public static final Comparator<Property> BY_RENT =
    Comparator.comparingInt(Property::getMonthlyRent);

public static final Comparator<Property> BY_SURFACE_DESC =
    Comparator.comparingInt(Property::getSurface).reversed();
```

**Exemple expliqué.** Le premier place les loyers faibles au début. Le second place les grandes surfaces au début. L'ordre naturel par référence reste disponible.

**À retenir.** `PropertyComparators` est une classe utilitaire `final` avec un unique constructeur privé. Ses comparateurs sont des constantes `public static final Comparator<Property>`.

[Retour au sommaire](#sommaire)

---

## lambda

**Lambda, référence de méthode et tri combiné**

**Description.** Une lambda écrit un comportement court. Une référence de méthode, avec `::`, indique une méthode existante. `thenComparing` ajoute un critere utilise seulement en cas d'égalité du premier.

```java
Comparator<Property> byRent =
    (a, b) -> Integer.compare(a.getMonthlyRent(), b.getMonthlyRent());

Comparator<Property> byCityThenRent =
    Comparator.comparing((Property p) -> p.getAddress().city())
        .thenComparing(byRent);
```

**Exemple expliqué.** La ville est prioritaire ; les loyers départagent les biens de la même ville. `Property::getMonthlyRent` peut servir de fonction d'extraction avec `comparingInt`.

**À retenir.** Utilise `Integer.compare()` ou `comparingInt()` plutôt que soustraire les valeurs : une soustraction peut dépasser les limites d'un entier. Le tri par ville demandé ici l'ordre naturel des chaînes ; seul le filtre de la tâche 10 ignore explicitement la casse.

[Retour au sommaire](#sommaire)

---

## tri

**Trier une copie et traiter les égalités**

**Description.** Trier une copie permet d'offrir plusieurs vues du portefeuille sans changer son ordre d'insertion interne.

```java
public List<Property> sorted(Comparator<Property> comparator) {
    List<Property> copy = new ArrayList<>(properties);
    copy.sort(comparator);
    return copy;
}
```

**Exemple expliqué.** `sorted(null)` utilise l'ordre naturel défini par `Comparable`. `sorted(PropertyComparators.BY_RENT)` utilise l'ordre des loyers. `List.sort()` est stable : deux éléments équivalents pour le comparateur gardent leur ordre relatif.

**À retenir.** Pour `getMostExpensive()`, ne remplace le meilleur candidat que si le nouveau loyer est strictement plus grand. Avec `>` plutôt que `>=`, le premier bien ajouté gagne en cas d'égalité. Une liste vide donne `null`.

[Retour au sommaire](#sommaire)

---

## exceptions

**Exceptions : signaler un échec**

**Description.** Une exception signale qu'une opération ne peut pas continuer normalement. Elle interrompt le chemin courant et remonte jusqu'à un gestionnaire adapté.

```java
if (surface <= 0) {
    throw new IllegalArgumentException(
        "Surface must be positive: " + surface
    );
}
```

**Exemple expliqué.** L'affectation qui suit n'est pas exécutée si la validation lève une exception. Un retour normal et un échec par exception sont donc deux chemins différents.

**À retenir.** `getMessage()` récupère le message. Le projet teste les messages exacts : mots, espaces et ponctuation doivent correspondre à l'énoncé.

[Retour au sommaire](#sommaire)

---

## checked

**Checked et unchecked**

**Description.** Une exception checked est vérifiée par le compilateur : le code appelant doit la capturer ou déclarer qu'il la transmet. Pour une exception unchecked, cette obligation n'existe pas.

| Type | Hierarchie | Exemple du projet |
| --- | --- | --- |
| Checked | Sous-classe d'`Exception`, hors `RuntimeException`. | `InvalidLeaseException`. |
| Unchecked | `RuntimeException` et ses sous-classes ; les `Error` sont aussi unchecked. | `PropertyUnavailableException`, `IllegalArgumentException`. |

```java
public void endLease(String reference) throws InvalidLeaseException {
    // L'appelant doit traiter cette possibilite ou la declarer.
}
```

**Exemple expliqué.** Une durée invalide devient un refus de bail checked. Un bien indisponible utilise une exception métier unchecked dans cet exercice.

**À retenir.** La différence obligatoire porte sur le contrôle du compilateur. Une exception unchecked n'est pas forcément une simple faute de programmation : le projet l'utilise aussi pour une indisponibilité métier.

[Retour au sommaire](#sommaire)

---

## throw

**throw et throws**

**Description.** `throw` déclenche une exception à un endroit précis. `throws` annonce dans la signature qu'une méthode peut laisser remonter une exception.

```java
public Lease signLease(String reference, Tenant tenant, int months)
        throws InvalidLeaseException {
    throw new InvalidLeaseException("Invalid duration: " + months + " months");
}
```

**Exemple expliqué.** Cet extrait volontairement simplifié montre les deux rôles : déclaration de la possibilité dans la signature, déclenchement dans le corps.

**À retenir.** `throws` ne déclenche rien et ne capture rien. Une méthode peut aussi laisser remonter une exception provenant d'une autre méthode qu'elle appelle.

[Retour au sommaire](#sommaire)

---

## trycatch

**try, catch, finally et propagation**

**Description.** `try` encadre une opération susceptible d'échouer. Un `catch` adapté traite l'exception. Sans gestionnaire, elle remonte à la méthode appelante.

```java
try {
    Lease lease = agency.signLease("P-001", tenant, 24);
    System.out.println("Deposit: " + lease.deposit() + " EUR");
} catch (InvalidLeaseException e) {
    System.out.println("Lease refused: " + e.getMessage());
}
```

**Exemple expliqué.** Si la signature échoue avec `InvalidLeaseException`, le programme exécute le `catch`. Sinon, il affiche le dépôt. Ce `catch` ne capture pas `PropertyUnavailableException`, qui est un autre type.

**À retenir.** Capture les types utiles, pas `Exception` de façon générale. Un bloc `finally` sert au nettoyage et s'exécute en fonctionnement normal lors de la sortie du `try`/`catch` ; il n'est pas garanti si la JVM est interrompue brutalement. Le try-with-resources ferme automatiquement les ressources compatibles, comme `Scanner`.

[Retour au sommaire](#sommaire)

---

## personnalisees

**Créer une exception personnalisée**

**Description.** Une exception personnalisée donne un nom métier à un échec et peut transporter des informations supplémentaires.

```java
public class PropertyUnavailableException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String reference;

    public PropertyUnavailableException(String reference, String reason) {
        super(reference + " is unavailable: " + reason);
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }
}
```

**Exemple expliqué.** `new PropertyUnavailableException("P-001", "already rented")` prépare le message `P-001 is unavailable: already rented`. `throw` est nécessaire pour la déclencher.

**À retenir.** Pour la version checked, `InvalidLeaseException` étend `Exception` et transmet simplement le message à `super(message)`.

[Retour au sommaire](#sommaire)

---

## serialisation

**serialVersionUID et avertissements Xlint**

**Description.** Les exceptions sont sérialisables via leur hiérarchie. `serialVersionUID` déclare un identifiant de version utilise par le mécanisme de sérialisation Java.

```java
private static final long serialVersionUID = 1L;
```

```bash
javac -Xlint:all 13-exceptions/*.java
```

**Exemple expliqué.** Ajoute le champ dans chacune des deux exceptions personnalisées. Cela évite l'avertissement `serial` émis par `-Xlint:all` lorsqu'il manque.

**À retenir.** Ce nombre n'est ni l'identifiant du bien, ni son code de hachage. Dans ce projet, l'objectif est de déclarer correctement la classe et de compiler sans avertissement.

[Retour au sommaire](#sommaire)

---

## erreurs

**Argument invalide ou état invalide**

**Description.** Une erreur d'argument porte sur la valeur reçue. Une erreur d'état porte sur une opération impossible dans la situation actuelle de l'objet.

```java
throw new IllegalArgumentException("Tenant must not be null");
```

```java
throw new IllegalStateException(reference + " is not rented");
```

**Exemple expliqué.** Un locataire `null` est un mauvais argument. Libérer un bien déjà vacant est un appel incompatible avec son état. À la tâche 13, `rentTo` utilise `PropertyUnavailableException` pour les biens déjà loués ou de classe G, tandis que `release` conserve son exception précédente.

**À retenir.** Ne change pas arbitrairement les types d'exceptions : les tests attendent ceux de l'énoncé, même si d'autres choix seraient possibles dans une autre application.

[Retour au sommaire](#sommaire)

---

## lease

**Lease : bail, loyer total et dépôt**

**Description.** Un bail regroupe le bien, le locataire et la durée. Il est représente par un record `Lease(Property property, Tenant tenant, int durationMonths)`.

```java
Lease lease = new Lease(p, tenant, 24);
int total = lease.totalRent();
int deposit = lease.deposit();
```

**Exemple expliqué.** Avec un loyer de 950 euros et 24 mois, le total est 22800 euros et le dépôt de deux mois est 1900 euros. Ces calculs utilisent le loyer seul, sans les charges.

**À retenir.** Le constructeur compact de `Lease` refuse le bien et le locataire nuls. La plage de durée 12 à 36 mois est contrôlée par `Agency.signLease()`. Le record conserve des références vers un bien mutable : il ne fige pas automatiquement le montant du loyer au jour de signature.

[Retour au sommaire](#sommaire)

---

## agency

**Agency : contrôles et signature des baux**

**Description.** L'agence coordonne le portefeuille, les locataires et les baux. Elle vérifie la demandé avant de louer et de conserver le bail.

```java
Agency agency = new Agency(portfolio);
try {
    Lease lease = agency.signLease("P-001", tenant, 24);
} catch (InvalidLeaseException e) {
    System.out.println(e.getMessage());
}
```

**Exemple expliqué.** L'ordre de contrôle est obligatoire : locataire nul ; bien inconnu ; durée hors de 12 à 36 mois inclus ; revenu insuffisant pour trois fois le coût mensuel ; enfin disponibilité via `rentTo()`.

**À retenir.** `endLease(reference)` libère le bien et retire le bail. Un bail absent donne `InvalidLeaseException` avec `No lease for: <reference>`. `getLeases()` renvoie une copie dans l'ordre des signatures.

[Retour au sommaire](#sommaire)

---

## atomicite

**Validation avant mutation et ordre des contrôles**

**Description.** Une opération refusée doit laisser les objets dans leur état précédent. On valide avant d'enregistrer une modification ou de l'ajouter à une collection.

```java
this.surface = validateSurface(surface);
```

```java
Lease lease = new Lease(property, tenant, durationMonths);
property.rentTo(tenant);
leases.add(lease);
```

**Exemple expliqué.** Dans le setter, si la validation échoue, l'affectation n'a pas lieu. Dans la signature, les contrôles de durée et de revenus précèdent cet extrait ; si `rentTo()` refuse, le bail n'est pas ajouté.

**À retenir.** « Inchange » signifie aussi qu'un bien déjà loué garde son ancien locataire. L'ordre des contrôles détermine l'erreur renvoyée lorsqu'il y a plusieurs problèmes. Ce principe en mémoire n'est pas une transaction de base de données.

[Retour au sommaire](#sommaire)

---

## tests

**Tests, erreurs de compilation et diagnostic**

**Description.** Les tests du projet verifient les signatures, les règles et parfois la structure des classes. Une erreur de compilation doit etre corrigee avant d'interpréter les échecs de comportement.

```bash
javac -Xlint:all 13-exceptions/*.java
java tests/Task13Test.java
```

| Message | Vérification utile |
| --- | --- |
| `cannot find symbol` | Nom, présence de la méthode et signature. |
| `String cannot be converted to Address` | Un appel ou un paramètre utilise encore l'ancien type. |
| `Property is abstract; cannot be instantiated` | Remplacer `new Property(...)` dans les démos par un type concret. |
| `constructor ... cannot be applied` | Nombre et types des arguments, notamment `energyClass`. |
| `Agency.class not found` | `Agency.java` existe, n'est pas vide, est enregistre et a ete compile. |
| `.class` ancien | Recompiler le bon dossier après l'enregistrement. |

**Exemple expliqué.** Un fichier `.java` vide peut compiler sans générer de `.class`. Les démos copiées doivent aussi compiler, même lorsqu'elles ne sont plus testées.

**À retenir.** Ne modifie pas les tests fournis. Le grader global ne compile pas tes solutions pour toi. La tâche 14 de lecture de fichier et de rapport n'est pas encore traitée dans cette fiche.

[Retour au sommaire](#sommaire)

---

## piliers

**Les quatre piliers de la programmation orientee objet**

| Pilier | Explication simple | Exemple du projet |
| --- | --- | --- |
| Encapsulation | Proteger l'état et encadrer les modifications. | Surface privée, constructeur et setter qui refusent les valeurs invalides. |
| Héritage | Specialiser un type commun. | `Apartment extends Property`. |
| Polymorphisme | Employer un type commun avec des comportements propres aux objets réels. | `p.getMonthlyCharges()` choisit le calcul de l'appartement, de la maison ou du local. |
| Abstraction | Definir l'essentiel et les contrats sans tout concretiser. | `Property` abstraite et interface `Insurable`. |

**Exemple parlant.** La boucle de calcul des coûts manipule des `Property`, sans connaître toutes les règles des enfants. Chaque enfant fournit son calcul, tandis que les invariants communs restent dans la base.

[Retour au sommaire](#sommaire)

---

## parcours

**Carte des tâches 0 à 13**

| Tâche | Ce que tu construis | Notions a revoir |
| --- | --- | --- |
| 0 | Un bien et une demo. | [Classe](#classe), [objet](#objet), [constructeur](#constructeur), [this](#this). |
| 1 | Des valeurs toujours valides. | [Encapsulation](#encapsulation), [invariants](#invariants), [final](#final). |
| 2 | Description et égalité des biens. | [toString](#tostring), [equals](#egalite), [hashCode](#hashcode), [Override](#override). |
| 3 | Une adresse structuree. | [Record](#record), [constructeur compact](#compact), [immuabilité](#immutabilite). |
| 4 | Une classe énergétique de A a G. | [Enum](#enum), [outils des enums](#enumoutils), [static](#static). |
| 5 | Appartements et maisons. | [Héritage](#heritage), [super](#super), [visibilité](#visibilite). |
| 6 | Charges selon le type de bien. | [Polymorphisme](#polymorphisme), [redéfinition](#override), [final](#final). |
| 7 | Une base abstraite et des locaux commerciaux. | [Abstraction](#abstraction), [protected](#protected). |
| 8 | Assurance et ordre par référence. | [Interface](#interface), [default](#default), [Comparable](#comparable). |
| 9 | Propriétaires, locataires et occupation. | [Composition](#composition), [délégation](#delegation), [état de location](#location). |
| 10 | Un portefeuille de biens. | [List et ArrayList](#list), [copie défensive](#copie), [indicateurs](#portfolio). |
| 11 | Un registre générique par identifiant. | [Génériques](#generiques), [borne](#borne), [Map](#map), [TreeMap](#maps). |
| 12 | Plusieurs ordres de tri. | [Comparator](#comparator), [lambda](#lambda), [tri de copie](#tri). |
| 13 | Signature et fin des baux. | [Checked](#checked), [throw et throws](#throw), [exceptions personnalisées](#personnalisees), [agence](#agency). |

[Retour au sommaire](#sommaire)

---

## vocabulaire

**Vocabulaire rapide**

| Terme | Definition simple | Detail et exemple |
| --- | --- | --- |
| Classe | Modele définissant données et comportements. | [Classe](#classe). |
| Instance | Objet concret construit à partir d'une classe. | [Objet](#objet). |
| Attribut / champ | Variable qui appartient à un objet ou à une classe. | [Attributs](#attributs). |
| État | Valeurs actuelles des attributs d'un objet. | [Location](#location). |
| Méthode | Comportement déclaré dans un type. | [Méthodes](#methodes). |
| Paramètre | Variable déclarée pour recevoir un argument. | [Méthodes](#methodes). |
| Argument | Valeur effectivement transmise lors d'un appel. | [Méthodes](#methodes). |
| Signature | Nom et types des paramètres d'une méthode, avec des précisions pour les génériques. | [Surcharge](#surcharge). |
| Constructeur | Code d'initialisation d'un nouvel’objet. | [Constructeur](#constructeur). |
| Référence Java | Valeur permettant de designer un objet. | [Objet](#objet). |
| Référence métier | Identifiant textuel du bien, comme P-001. | [Egalite](#egalite). |
| Getter / accesseur | Méthode pour consulter une valeur. | [Encapsulation](#encapsulation). |
| Setter / mutateur | Méthode pour modifier une valeur de façon contrôlée. | [Encapsulation](#encapsulation). |
| Invariant | Règle qui doit rester vraie pour l'objet. | [Invariants](#invariants). |
| Immuable | Dont l'état ne change plus après la construction. | [Immuabilité](#immutabilite). |
| Parent / superclasse | Classe dont une autre hérite. | [Héritage](#heritage). |
| Enfant / sous-classe | Classe qui spécialise une classe parente. | [Héritage](#heritage). |
| Redéfinition / overriding | Implementation adaptée d'une méthode héritée. | [Override](#override). |
| Surcharge / overloading | Même nom de méthode, paramètres différents. | [Surcharge](#surcharge). |
| Contrat | Regles et opérations qu'un type promet de respecter. | [Interface](#interface). |
| Composition | Assemblage d'objets : possède un. | [Composition](#composition). |
| Délégation | Confier une opération à un autre objet. | [Délégation](#delegation). |
| Collection | Structure standard regroupant plusieurs éléments. | [List](#list). |
| Cle / valeur | Identifiant de recherche et objet associe dans une map. | [Map](#map). |
| Type générique | Type parametrable, comme Registry<T>. | [Génériques](#generiques). |
| Borne | Restriction des types génériques autorises. | [Borne](#borne). |
| Copie défensive | Nouvelle structure pour protéger la structure interne. | [Copie](#copie). |
| Comparateur | Objet qui définit une règle de tri. | [Comparator](#comparator). |
| Exception | Signal d'échec qui interrompt le chemin normal. | [Exceptions](#exceptions). |
| Propagation | Remontee d'une exception vers le code appelant. | [try/catch](#trycatch). |
| JVM | Machine virtuelle qui exécute le bytecode Java. | [Compilation](#compilation). |
| JDK | Ensemble des outils de developpement Java. | [Compilation](#compilation). |
| Classpath | Endroits ou Java recherche les classes nécessaires. | [Compilation](#compilation). |

[Retour au sommaire](#sommaire)

---

## pieges

**Erreurs fréquentes a éviter**

1. Verifier les nouvelles valeurs dans les getters au lieu du constructeur et des setters.
2. Modifier un attribut avant sa validation, puis lever une exception trop tard.
3. Refuser un loyer nul alors que seul un loyer négatif est interdit.
4. Ajouter `setReference()` alors que la référence doit rester définitive.
5. Comparer des textes avec `==` au lieu de `equals()`.
6. Redefinir `equals(Property)` au lieu de `equals(Object)`.
7. Redefinir `equals()` sans adapter `hashCode()`.
8. Croire que `@Override` crée l'héritage ou réalise le comportement à ta place.
9. Ecrire `extends Property` pour `Address` alors qu'un bien possède une adresse.
10. Ecrire `getCity()` pour un record qui fournit automatiquement `city()`.
11. Croire qu'un champ `final` rend tout l'objet qu'il désigne immuable.
12. Appeler `new EnergyClass(...)` au lieu d'utiliser `EnergyClass.A`, etc.
13. Appeler `new Property(...)` après son passage en classe abstraite.
14. Continuer d'appeler `super.getMonthlyCharges()` quand cette méthode est devenue abstraite.
15. Dupliquer les règles de charges ou de location entre la base, les enfants et l'enum.
16. Retourner directement une liste interne ou trier cette liste au lieu d'une copie.
17. Croire qu'une copie de liste clone aussi chaque objet qu'elle contient.
18. Ecraser un identifiant dans la map au lieu de refuser le doublon.
19. Utiliser `>=` dans la recherche du loyer maximal, ce qui ferait perdre la priorité au premier ajoute.
20. Calculer l'occupation avec `loues / total * 100`, ce qui tronque trop tot.
21. Verifier les revenus sur le loyer seul alors que la signature exige le coût mensuel avec charges.
22. Confondre `throw` et `throws`, ou capturer toutes les erreurs avec `catch (Exception e)`.
23. Relancer les tests sans enregistrer et recompiler les fichiers du bon dossier.
24. Oublier que les anciennes démos copiées doivent aussi compiler.

[Retour au sommaire](#sommaire)
