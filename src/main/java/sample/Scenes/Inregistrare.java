package sample.Scenes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.json.JSONArray;
import sample.Regisration.EncryptPassword;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Inregistrare {
    public static Scene inregis(Stage primaryStage, Scene scene) {
        //Buton Inregistrare + fereastra noua
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        Scene sceneInregistrare = new Scene(grid2, 400, 250);
        Label l24 = new Label("Nume utilizator:");
        GridPane.setConstraints(l24, 0, 0);
        Label l24a = new Label("Parolă:");
        GridPane.setConstraints(l24a, 0, 1);
        Label l24b = new Label("Rol:");
        GridPane.setConstraints(l24b, 0, 2);
        Label l24c = new Label("Email:");
        GridPane.setConstraints(l24c, 0, 3);
        Label l24d = new Label("Adresă:");
        GridPane.setConstraints(l24d, 0, 4);
        TextField text1 = new TextField();
        GridPane.setConstraints(text1, 1, 0);
        TextField text2 = new TextField();
        GridPane.setConstraints(text2, 1, 1);

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Doctor",
                        "Client"
                );
        final ComboBox comboBox = new ComboBox(options);

        GridPane.setConstraints(comboBox, 1, 2);
        TextField text4 = new TextField();
        GridPane.setConstraints(text4, 1, 3);
        TextField text5 = new TextField();
        GridPane.setConstraints(text5, 1, 4);
        Button ok = new Button("Gata!");
        ok.setOnAction(e ->
        {
            if (text1.getText().equals("") || text2.getText().equals("") || comboBox.getValue() == null || text4.getText().equals("") || text5.getText().equals(""))
                AlertBox.display("Cont nou", "Trebuie completate toate căsuțele!");
            else {
                String first = "src\\main\\resources\\DB.json";
                boolean OK = false;
                try {
                    String contents = new String((Files.readAllBytes(Paths.get(first))));
                    //JSONObject o = new JSONObject(contents);
                    JSONArray Lista = new JSONArray(contents);
                    for (int i = 0; i < Lista.length(); i++) {
                        if (Lista.getJSONObject(i).getString("nume_de_utilizator").equals(text1.getText()))
                            OK = true;
                    }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
            if (OK == true) {
                System.out.println("Numele a fost deja folosit");
                AlertBox.display("Cont nou", "Numele de utilizator este deja folosit!");
            } else {
                EncryptPassword encrypt = new EncryptPassword();
                ObjectMapper mapper = new ObjectMapper();
                File jsonFile = Paths.get("src\\main\\resources\\DB.json").toFile();
                JsonNode node = mapper.createObjectNode();
                System.out.println(text1.getText() + " " + text2.getText());
                ((ObjectNode) node).put("nume_de_utilizator", text1.getText());
                ((ObjectNode) node).put("parola", encrypt.encryptPassword(text2.getText(), text1.getText()));
                ((ObjectNode) node).put("rol", comboBox.getValue().toString());
                ((ObjectNode) node).put("email", text4.getText());
                ((ObjectNode) node).put("adresa", text5.getText());
                ((ObjectNode) node).put("profil", "Necompletat");

                try {
                    ArrayNode root = (ArrayNode) mapper.readTree(jsonFile);
                    //System.out.println(root.get(0));
                    root.add(node);
                    mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, root);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                AlertBox.display("Cont nou", "Înregistrarea a fost realizată cu succes!");
                primaryStage.setScene(scene);
            }
            }
        });
        GridPane.setConstraints(ok, 1, 5);
        grid2.getChildren().addAll(l24, l24a, l24b, l24c, l24d, text1, text2, comboBox, text4, text5, ok);
        grid2.setAlignment(Pos.CENTER);
        return sceneInregistrare;

    }
}