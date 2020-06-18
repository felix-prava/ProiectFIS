package sample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Scenes.LoginScene;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene;
        scene = LoginScene.test(primaryStage);


        String first = "src\\main\\java\\sample\\DB2.json";

        try {
            String contents = new String((Files.readAllBytes(Paths.get(first))));
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = Paths.get(first).toFile();
            ArrayNode root = (ArrayNode) mapper.readTree(jsonFile);

            try {

                for (JsonNode node : root) {

                    if (node.path("nume_de_utilizator").asText().equals("Test1")) {
                        ((ObjectNode) node).put("parola", "alabala");
                        mapper.writeValue(jsonFile, root);
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        primaryStage.setScene(scene);
        primaryStage.setTitle("Doctori Tg-Jiu");
        primaryStage.show();
    }




}
