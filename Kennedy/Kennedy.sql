CREATE DATABASE KENNEDY;
USE KENNEDY;


CREATE TABLE UTILISATEUR(
    USERNAME VARCHAR(20) PRIMARY KEY,
    MOT_DE_PASSE VARCHAR(20) NOT NULL,
    FICHIER VARCHAR(100)
);

CREATE TABLE APPAREIL(
    CLE VARCHAR(20) PRIMARY KEY,
    NOM VARCHAR(20) NOT NULL,
    CATEGORIE VARCHAR(20) CHECK(CATEGORIE IN ('TELEPHONE', 'ORDINATEUR')),
    DATE_ACHAT DATE,
    STATUT VARCHAR(20) CHECK(STATUT IN ('RAS', 'PERDU')),
    PROPRIETAIRE VARCHAR(20) NOT NULL,
    FOREIGN KEY (PROPRIETAIRE) REFERENCES UTILISATEUR(USERNAME)
);


