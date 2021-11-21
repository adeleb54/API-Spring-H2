package com.example.tp3exo_vuefx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class RechercheController {

    private java.util.Scanner s;
    @FXML
    private Text resRecherche;
    @FXML
    private TextField idField;

    public void recherche(){
        try {
            String id = idField.getText();
            s = new java.util.Scanner(new java.net.URL("http://localhost:8080/Pets/"+id).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(s.hasNext()){
            String res = s.useDelimiter("\\A").next();
            //resRecherche.setText(res);
            JSONParser parser = new JSONParser();
            try {
                JSONObject obj =  (JSONObject) parser.parse(res);
                StringBuilder sb = new StringBuilder();
                sb.append("ID: "+ obj.get("id"));
                sb.append("\nName: "+ obj.get("name"));
                sb.append("\nAnimal: "+ obj.get("animal"));
                sb.append("\nAge: "+ obj.get("age"));
                resRecherche.setText(sb.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
