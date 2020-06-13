package sample.Scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONArray;
import sample.Users.Doctor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListaDoctori {

    public static Scene inregis(Stage primaryStage, Scene scene) {


        VBox vBox = new VBox();
        vBox.getChildren().addAll();

        Scene scene2 = new Scene(vBox, 300, 400);

        return scene2;
    }

    public ObservableList<Doctor> getDoctor() {
        ObservableList<Doctor> doctori = FXCollections.observableArrayList();
        String first = "src\\main\\resources\\DB.json";
        String contents = null;
        try {
            contents = new String((Files.readAllBytes(Paths.get(first))));

            JSONArray Lista = new JSONArray(contents);
            for (int i = 0; i < Lista.length(); i++) {
                if (Lista.getJSONObject(i).getString("rol").equals("Doctor")) {
                    String a = Lista.getJSONObject(i).getString("nume_de_utilizator");
                    String b = Lista.getJSONObject(i).getString("email");
                    String c = Lista.getJSONObject(i).getString("adresa");
                    String d = Lista.getJSONObject(i).getString("profil");
                    doctori.add(new Doctor(a, b, c, d));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        doctori.add(new Doctor("a", "b", "c", "d"));
        return doctori;
    }


}
