# 📦 Java SQL Importer

Ce projet Java Maven permet d'importer automatiquement un fichier CSV contenant des informations de clients dans une base de données PostgreSQL.

---

## 🚀 Fonctionnalités

- Interface de sélection du fichier `.csv`
- Lecture ligne par ligne avec `BufferedReader`
- Insertion en base via `PreparedStatement`
- Chargement sécurisé des variables avec `.env`
- Base PostgreSQL, JDBC driver, dotenv intégrés via Maven

---

## 📁 Structure du projet

```
java_sql/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── ETLClientImporter.java
│   │   │   └── ClientExporter.java
│   │   └── resources/
│   │       └── .env
├── data/
│   └── data.csv
├── pom.xml
└── README.md
```

---

## ⚙️ Prérequis

- Java 17
- PostgreSQL ≥ 13
- Maven ≥ 3.6

---

## 🔐 Fichier `.env` (dans `src/main/resources`)

```dotenv
DB_URL=jdbc:postgresql://localhost:5432/java_sql
DB_USER=postgres
DB_PASSWORD=ton_mot_de_passe
```

---

## 🧱 Structure de la table `clients`

À exécuter une fois dans PostgreSQL :

```sql
CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    ville VARCHAR(100),
    entreprise VARCHAR(100),
    email VARCHAR(150)
);
```

---

## 📦 Exemple de `data.csv`

```csv
nom,prenom,ville,entreprise,email
Durand,Pierre,Paris,RATP,pdurand@ratp.fr
Dupuis,Martine,Lyon,ENEDIS,m.dupuis@enedis.fr
```

---

## ▶️ Exécution

```bash
mvn clean install
mvn exec:java
```

Un sélecteur de fichier s'ouvrira pour choisir ton fichier CSV.

---

## 🛠️ Technologies utilisées

- Java 17
- PostgreSQL (via `org.postgresql:postgresql`)
- Dotenv (`io.github.cdimascio:dotenv-java`)
- Maven + exec plugin

---

## 📄 Licence

Libre d'utilisation à des fins éducatives ou professionnelles.
