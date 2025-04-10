package com.kennedy.kennedy.metiers;

public class Appareil {
    private String nom;
    private String cle;
    private String categorie;
    private String statut;
    private String dateAchat;
    private String username;

    // Constructeur
    public Appareil(String nom, String cle, String categorie, String statut, String dateAchat, String username) {
        this.nom = nom;
        this.cle = cle;
        this.categorie = categorie;
        this.statut = statut;
        this.dateAchat = dateAchat;
        this.username = username;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getCle() {
        return cle;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getStatut() {
        return statut;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
