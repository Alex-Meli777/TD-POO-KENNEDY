package com.kennedy.kennedy.controllers;

import com.kennedy.kennedy.metiers.Appareil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;

public class AppareilCell extends ListCell<Appareil> {

    @FXML private HBox root;
    @FXML private ImageView imageView;
    @FXML private Label nomLabel;
    @FXML private Label empreinteLabel;
    @FXML private Label statutLabel;

    private FXMLLoader loader;

    @Override
    protected void updateItem(Appareil Appareil, boolean empty) {
        super.updateItem(Appareil, empty);

        if (empty || Appareil == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (loader == null) {
                loader = new FXMLLoader(getClass().getResource("/com/kennedy/kennedy/views/appareil-cell.fxml"));
                loader.setController(this);
                try {
                    loader.load();
                } catch (IOException e) {
                    System.err.println("Erreur: "+e.getMessage());
                }
            }
            // Remplir les données de la cellule
            nomLabel.setText(Appareil.getNom());
            empreinteLabel.setText(Appareil.getCle());
            statutLabel.setText(Appareil.getStatut());
            URL imageUrl = getClass().getResource("/com/kennedy/kennedy/css/images/"+Appareil.getCategorie().toUpperCase()+".jpeg");
            if (imageUrl == null) {
                throw new IllegalStateException("L'image n'a pas été trouvée !");
            }
            Image image = new Image(imageUrl.toExternalForm());
            imageView.setImage(image);

            setGraphic(root);
        }
    }
}
