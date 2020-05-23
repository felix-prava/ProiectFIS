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
import org.json.simple.JSONObject;
import sample.Regisration.EncryptPassword;

import java.io.File;
import java.io.IOException;
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
        Button ok = new Button("Gata!");
        ok.setOnAction(e ->
        {
            EncryptPassword encrypt = new EncryptPassword();
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = Paths.get("src\\main\\resources\\DB.json").toFile();
            JsonNode node = mapper.createObjectNode();
            ((ObjectNode) node).put("nume_de_utilizator", text1.getText());
            ((ObjectNode) node).put("parola", encrypt.encryptPassword(text2.getText(), text1.getText()));
            ((ObjectNode) node).put("rol", comboBox.getValue().toString());
            ((ObjectNode) node).put("email", text4.getText());
            try {
                ArrayNode root = (ArrayNode) mapper.readTree(jsonFile);
                //System.out.println(root.get(0));
                root.add(node);
                mapper.writeValue(jsonFile, root);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            AlertBox.display("Cont nou", "Înregistrarea a fost realizată cu succes!");
            primaryStage.setScene(scene);
        });
        GridPane.setConstraints(ok, 1, 4);
        grid2.getChildren().addAll(l24, l24a, l24b, l24c, text1, text2, comboBox, text4, ok);
        grid2.setAlignment(Pos.CENTER);
        return sceneInregistrare;
    }
}