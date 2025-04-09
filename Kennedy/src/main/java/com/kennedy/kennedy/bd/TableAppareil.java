package com.kennedy.kennedy.bd;

import com.kennedy.kennedy.Appareil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class TableAppareil {

    public List<Appareil> getAllAppareils(String username) {
        List<Appareil> appareils = new ArrayList<>();
        String sql = "SELECT * FROM APPAREIL WHERE PROPRIETAIRE = " + username;
        try (Connection con = ConnectDatabase.getConnection();
             PreparedStatement requete = con.prepareStatement(sql);
             ResultSet resultat = requete.executeQuery()) {
            while (resultat.next()) {
                Appareil app = new Appareil(
                        resultat.getString("NOM"),
                        resultat.getString("CLE"),
                        resultat.getString("CATEGORIE"),
                        resultat.getString("STATUT"),
                        resultat.getString("DATE_ACHAT"),
                        username
                );
                appareils.add(app);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        return appareils;
    }

    public void insertAppareil(Appareil appareil) {
        String req = "INSERT INTO APPAREIL VALUES (\""
                + appareil.getCle() + "\",\""
                + appareil.getNom() + "\",\""
                + appareil.getCategorie().toUpperCase() + "\",\""
                + appareil.getDateAchat() + "\",\""
                + appareil.getStatut().toUpperCase() + "\",\""
                + appareil.getUsername() + "\""
                + ");";

        try {
            Connection con = ConnectDatabase.getConnection();
            Statement stat = con.createStatement();
            stat.executeUpdate(req);
            stat.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
    }

    public void modifyStatus(String cle, String statut) {
        String req = "UPDATE APPAREIL SET" +
                " STATUT = \"" + statut +
                "\" WHERE Cle = \"" + cle + "\";";


        try {
            Connection con = ConnectDatabase.getConnection();
            Statement stat = con.createStatement();
            stat.executeUpdate(req);
            stat.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void deleteAppareil(String cle) {
        String req = "DELETE FROM APPAREIL WHERE CLE = " + cle + ";";

        try {
            Connection con = ConnectDatabase.getConnection();
            Statement stat = con.createStatement();
            stat.executeUpdate(req);
            stat.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
    }
}