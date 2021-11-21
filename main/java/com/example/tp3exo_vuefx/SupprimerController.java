package com.example.tp3exo_vuefx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SupprimerController {

    private java.util.Scanner s;
    @FXML
    private TextField idField;
    @FXML
    private Text textRes;

    public void supprimer(){
        try {
            String id = idField.getText();
            URL url = new URL("http://localhost:8080/Pets/"+id);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("DELETE");
            httpCon.connect();
            textRes.setText(String.valueOf(httpCon.getResponseCode())+" : animal with ID n°"+id+" deleted.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
