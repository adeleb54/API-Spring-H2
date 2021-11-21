package com.example.tp3exo_vuefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PetApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Rechercher.fxml"));
        loader.setControllerFactory(iC->new RechercheController());
        Stage recherche = new Stage();
        recherche.setScene(new Scene(loader.load()));
        recherche.hide();

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Ajouter.fxml"));
        loader.setControllerFactory(iC->new AjouterController());
        Stage ajouter = new Stage();
        ajouter.setScene(new Scene(loader.load()));
        ajouter.hide();

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Modifier.fxml"));
        loader.setControllerFactory(iC->new ModifierController());
        Stage modifier = new Stage();
        modifier.setScene(new Scene(loader.load()));
        modifier.hide();

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Supprimer.fxml"));
        loader.setControllerFactory(iC->new SupprimerController());
        Stage supprimer = new Stage();
        supprimer.setScene(new Scene(loader.load()));
        supprimer.hide();

        FXMLLoader fxmlLoader = new FXMLLoader(PetApplication.class.getResource("Accueil.fxml"));
        fxmlLoader.setControllerFactory(iC-> new AccueilController(recherche, ajouter, modifier, supprimer));
        Scene scene = new Scene(fxmlLoader.load(), 370, 240);
        stage.setTitle("Pets");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}