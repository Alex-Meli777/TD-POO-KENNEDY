package com.kennedy.kennedy.controllers;

import com.kennedy.kennedy.metiers.Appareil;
import com.kennedy.kennedy.bd.TableAppareil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;


public class HelloController {
    @FXML
    public ListView<Appareil> AppareilsListView;

    public TableAppareil instanceTableAppareil = new TableAppareil();

    public void initialize() {
        // Création d'une liste d'exemple
        ObservableList<Appareil> Appareils = FXCollections.observableArrayList(instanceTableAppareil.getAllAppareils("MOI"));
        AppareilsListView.setItems(Appareils);

        // Définir le cellFactory pour utiliser notre ListCell Appareil ininalisée
        AppareilsListView.setCellFactory(listView -> new AppareilCell());
    }
}
