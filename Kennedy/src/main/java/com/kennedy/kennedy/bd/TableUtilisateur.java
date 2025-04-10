package com.kennedy.kennedy.bd;

import java.sql.*;

public class TableUtilisateur {


    public boolean connexion(String username, String password) {
        /*Vérifie les informations de connexion transmises par l'utilisateur*/
        String sql = "SELECT * FROM UTILISATEUR WHERE USERNAME = ? AND MOT_DE_PASSE = ?";
        try (Connection con = ConnectDatabase.getConnection();
             PreparedStatement requete = con.prepareStatement(sql)) {

            requete.setString(1, username);
            requete.setString(2, password);

            try (ResultSet resultat = requete.executeQuery()) {
                if (resultat.next()) {
                    System.out.println("CLIENT TROUVÉ: " + resultat.getString("USERNAME"));
                    return true;
                } else {
                    System.out.println("Aucun utilisateur trouvé.");
                    return false;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        return false;       //si le traitement a échoué
    }

    public boolean inscrireUtilisateur(String username, String password) {
        String checkSql = "SELECT COUNT(*) FROM UTILISATEUR WHERE USERNAME = ?";
        String insertSql = "INSERT INTO UTILISATEUR VALUES (?, ?, ?)";

        try (Connection con = ConnectDatabase.getConnection();
             PreparedStatement checkStmt = con.prepareStatement(checkSql)) {

            // Vérification si le nom d'utilisateur existe déjà
            checkStmt.setString(1, username);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    System.out.println("Le nom d'utilisateur existe déjà.");
                    return false; // L'utilisateur existe déjà
                }
            }

            // Insertion du nouvel utilisateur
            try (PreparedStatement insertStmt = con.prepareStatement(insertSql)) {
                insertStmt.setString(1, username);
                insertStmt.setString(2, password);
                insertStmt.setString(3,username+".txt");
                int rowsInserted = insertStmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Utilisateur inscrit avec succès.");
                    return true;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'inscription : " + e.getLocalizedMessage());
        }

        return false; // En cas d'erreur ou d'échec
    }
}