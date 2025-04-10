package com.kennedy.kennedy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //ici je teste à cause d'une erreur qui m'énerve
        URL fxmlUrl = getClass().getResource("/com/kennedy/kennedy/views/hello-view.fxml");
        System.out.println("FXML Url: " + fxmlUrl);
        if (fxmlUrl == null) {
            throw new IllegalStateException("Le fichier FXML n'a pas été trouvé !");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        // Appliquer le style CSS à l'application
        URL cssUrl = getClass().getResource("/com/kennedy/kennedy/css/viewapp.css");
        System.out.println("css Url: " + cssUrl);
        if (cssUrl == null) {
            throw new IllegalStateException("Le fichier css n'a pas été trouvé !");
        }
        scene.getStylesheets().add(cssUrl.toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Liste Appareils");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
