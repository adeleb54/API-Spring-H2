package com.example.tp3exo_vuefx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AjouterController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField animalField;
    @FXML
    private TextField ageField;
    @FXML
    private Text textRes;

    public void ajouter(){
        String parameters = "{\n" +
                "\"name\": \""+nameField.getText()+"\",\n" +
                "\"animal\": \""+animalField.getText()+"\",\n" +
                "\"age\": "+ageField.getText()+"\n" +
                "}";

        try {
            String request = "http://localhost:8080/Pets";
            URL url = new URL( request );
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.addRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(parameters.getBytes());
            os.flush();
            os.close();
            if(conn.getResponseCode() == 500){
                textRes.setText("Error 500");
            }
            else{
                textRes.setText("Welcome "+nameField.getText()+" !");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
