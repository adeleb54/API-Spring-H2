package com.example.tp3exo_vuefx;

import javafx.stage.Stage;

public class AccueilController {

    private Stage recherche;
    private Stage ajout;
    private Stage modification;
    private Stage suppression;

    public AccueilController(Stage recherche, Stage ajout, Stage modification, Stage suppression) {
        this.recherche = recherche;
        this.ajout = ajout;
        this.modification = modification;
        this.suppression = suppression;
    }

    public void recherche(){
        recherche.show();
        recherche.toFront();
    }

    public void ajout(){
        ajout.show();
        ajout.toFront();
    }

    public void modification(){
        modification.show();
        modification.toFront();
    }

    public void suppression(){
        suppression.show();
        suppression.toFront();
    }
}
