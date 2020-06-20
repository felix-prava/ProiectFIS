package sample.Scenes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EditareProfil {
    public static Scene editareProfil(Stage primaryStage, Scene scene, String numeUtilizator) {

        GridPane grid2 = new GridPane();

        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        Scene editareProfil = new Scene(grid2, 400, 250);

        TextField editare = new TextField();
        GridPane.setConstraints(editare, 1, 0);
        Button salveaza = new Button("Salveaza");
        salveaza.setOnAction(e ->
        {
            String first = "src/main/resources/DB.json";
            try {
                String contents = new String((Files.readAllBytes(Paths.get(first))));
                ObjectMapper mapper = new ObjectMapper();
                File jsonFile = Paths.get(first).toFile();
                ArrayNode root = (ArrayNode) mapper.readTree(jsonFile);

                try {

                    for (JsonNode node : root) {

                        if (node.path("nume_de_utilizator").asText().equals(numeUtilizator)) {
                            ((ObjectNode) node).put("profil", editare.getText());
                            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, root);
                        }
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            } catch (IOException exc) {
                exc.printStackTrace();
            }


            Scene inapoi = SignInDoctor.inregis(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(inapoi);
        });
        GridPane.setConstraints(salveaza, 0, 0);

        Button inapoi = new Button("Inapoi");
        inapoi.setOnAction(e -> {
            Scene newScene = SignInDoctor.inregis(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(inapoi, 2, 0);

        grid2.getChildren().addAll(editare, salveaza, inapoi);
        grid2.setAlignment(Pos.CENTER);
        return editareProfil;
    }
}