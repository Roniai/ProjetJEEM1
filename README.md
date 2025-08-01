# Gestion des visites médicales

## Télécharger et Installer "Eclipse IDE for Enterprise Java and Web Developers" :
- Extraire le dossier compressé
- Lancer le fichier exécutable "eclipse.exe"

## Télécharger et configurer le serveur Tomcat :
- Extraire le dossier compressé
- Ouvrir eclipse :
- --> Aller dans : **Windows/Preferences/Serveur Runtime Environments**
- --> Add + Apache + VERSION_DE_VOTRE_TOMCAT
- --> Chemin de dossier <apache tomcat ...> extrait + Finish

## Télécharger et configurer Hibernate :
- Télécharger **hibernate**
- Télécharger **hibernate annotation**
- Télécharger **slf4j-api** et **slf4j-simple**
- Télécharger **mysql-connector** JAVA

## Regrouper les Jar pour en créer des librairies :
Les Jars tirés de hibernate-distribution :
- hibernate*.jar (/ hibernate-distribution)
- cglib-*.jar (/ hibernate-distribution/lib/bytecode/cglib)
- javassist-*.jar (/ hibernate-distribution/lib/bytecode/javassist)
- ehcache-*.jar (/ hibernate-distribution/lib/optional/ehcache)
- antr-*.jar (/ hibernate-distribution/lib/required)
- commons-collection-*.jar (/ hibernate-distribution/lib/required)
- jta-*.jar (/ hibernate-distribution/lib/required)

Les Jars tirés de hibernate-annotation :
- hibernate-annotation.jar (/ hibernate-annotation)
- dom4j-*.jar (/ hibernate-annotation/lib/)
- hibernate-core.jar (/ hibernate-annotation/lib/)
- asm.jar (/ hibernate-annotation/lib/test)
- asm-attrs.jar (/ hibernate-annotation/lib/test)
- jta.jar (/ hibernate-annotation/lib/test)
- log4g.jar (/ hibernate-annotation/lib/test)

Créer un nouveau dossier (nommé Hibernate)
- Extraire les 2 fichiers zip (hibernate-distribution et hibernate-annotation)
- Copier des Jar dans les 2 dossiers extraits et les coller dans le nouveau dossier crée
- Copier aussi les slf4j-api et slf4j-simple dans le nouveau dossier

## Configurer Eclipse :
- Aller dans Window\Preferences et tapez : User
- Aller dans User Librairies
- Créer une nouvelle librairie comme nom "Hibernate" et ajouter tous les external JAR à l'intérieur
- Créer une nouvelle livrairie comme nom "mysql-connector" et ajouter le JAR mysql-connector
- Apply and close

## Créer une base de données vide comme nom : "m1visitmed_db"

## Lancer le projet :
- Aller sur l'onglet "Servers" en bas
- Déplacer (drag & drop) le projet vers le serveurs tomcat en bas
- Lancer le serveur
- Aller dans un navigateur et entrer l'URL suivant : "http://localhost:8080/ProjetJEEM1"
