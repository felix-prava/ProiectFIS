package sample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Scenes.LoginScene;
import sample.Users.Persoana;

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

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loginUser(Persoana user) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("DB2.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode userNode = rootNode.path("nume_de_utilizator");


            Iterator<JsonNode> elements = userNode.elements();
            while (elements.hasNext()) {
                JsonNode username = elements.next();
                System.out.println(username.asText());
                if (username.asText().equals(user.getUser())) {
                    JsonNode parola = username.findParent("nume_de_utilizator").path("parola");
                    if (parola.asText().equals(user.getParola()))
                        System.out.println("E ok");
                    else
                        System.out.println("Parola gresita");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}
