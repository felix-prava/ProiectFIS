package sample;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import sample.Scenes.LoginScene;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene;
        scene = LoginScene.test(primaryStage);

        String first = "src\\main\\resources\\DB3.json";

        try {
            String contents = new String((Files.readAllBytes(Paths.get(first))));
            //JSONObject o = new JSONObject(contents);
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = Paths.get(first).toFile();
            ArrayNode root = (ArrayNode) mapper.readTree(jsonFile);

            try {

                for (JsonNode node : root) {

                    if (node.path("nume_de_utilizator").asText().equals("Felix")) {
                        ((ObjectNode) node).put("email", "alabala");
                        mapper.writeValue(jsonFile, root);


                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }


            // System.out.println(Lista.getJSONObject(1));
            //   modJO(Lista.getJSONObject(1));
            // System.out.println(Lista.getJSONObject(1));
        } catch (IOException e) {
            e.printStackTrace();
        }


        primaryStage.setScene(scene);
        primaryStage.setTitle("Doctori Tg-Jiu");
        primaryStage.show();
    }




}
