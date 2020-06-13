package sample.Scenes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Regisration.EncryptPassword;
import sample.Regisration.ReadingJSON;
import sample.Users.Persoana;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class LoginScene {
    public static Scene test(Stage primaryStage) {

        //Prima fereastra(cea de inceput)
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Scene scene = new Scene(grid, 520, 250);

        Label l1 = new Label("Bine ati venit!");
        GridPane.setConstraints(l1, 1, 0);
        Label l2a = new Label("");

        GridPane.setConstraints(l2a, 0, 0);

        Label l2b = new Label("");
        GridPane.setConstraints(l2b, 0, 1);

        Label l2 = new Label("Programează-te la orice \ndentist din oraș!");
        GridPane.setConstraints(l2, 0, 2);

        Button buttonA = new Button("Înregistrare");
        buttonA.setOnAction(event -> {
            Scene newScene = Inregistrare.inregis(primaryStage, scene);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(buttonA, 0, 3);

        Label l3a = new Label("");
        GridPane.setConstraints(l3a, 2, 0);

        Label l3 = new Label("        Ai deja cont?");
        GridPane.setConstraints(l3, 2, 1);

        TextField text1 = new TextField();
        text1.setPromptText("Username");
        GridPane.setConstraints(text1, 2, 2);

        TextField text2 = new TextField();
        text2.setPromptText("Parolă");
        GridPane.setConstraints(text2, 2, 3);

        Persoana user = new Persoana();
        Button signIn = new Button("Sign In");
        signIn.setOnAction(e ->
        {
            String numeTextField = text1.getText();
            String parolaTextField = text2.getText();
            String encryptPass = EncryptPassword.encryptPassword(parolaTextField, numeTextField);

            user.setUser(numeTextField);
            user.setParola(encryptPass);

            System.out.println(user.getUser() + "+" + user.getParola());
            System.out.println(encryptPass);

            if (ReadingJSON.citireSignIn(numeTextField, encryptPass) == 1) {
                Scene newScene = SignInDoctor.inregis(primaryStage, scene);
                primaryStage.setScene(newScene);
                System.out.println("Doctor");
            } else if (ReadingJSON.citireSignIn(numeTextField, encryptPass) == 2)
                System.out.println("Client");
            else System.out.println("Greseala!");

        });
        GridPane.setConstraints(signIn, 2, 4);
        Button forgot = new Button("Ai uitat parola?");
        GridPane.setConstraints(forgot, 2, 5);
        grid.getChildren().addAll(l1, l2, l2a, l2b, buttonA, l3a, l3, text1, text2, signIn, forgot);
        grid.setAlignment(Pos.CENTER);

        //Buton 'Ai uitat parola?'(forgot) + fereastra noua
        Label textParolaUitata = new Label("                 Introdu username-ul");
        Button parola_Uitata = new Button("Gata! ");
        TextField usernameParola = new TextField();
        HBox h1 = new HBox(20);
        h1.getChildren().addAll(usernameParola, parola_Uitata);
        VBox parolaUitata = new VBox(20);
        parolaUitata.getChildren().addAll(textParolaUitata, h1);
        Scene amUitatParola = new Scene(parolaUitata, 300, 200);
        forgot.setOnAction(e -> primaryStage.setScene(amUitatParola));

        //Buton Gata! + mesaj corespunzator
        parola_Uitata.setOnAction(e ->
                {
                    if (!usernameParola.getText().equals("")) {
                        AlertBox.display("Resetare parola", "Ti-a fost trimis un mail de resetare parola la acest username!");
                        primaryStage.setScene(scene);
                    } else
                        AlertBox.display("Resetare parola", "Username gresit!");
                }
        );
        return scene;

    }

    private static void loginUser(Persoana user) throws FileNotFoundException {
        try {

            /*

            //////////////////////////////////////////////////////////////
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = (ArrayNode)  objectMapper.readTree(new File("src\\main\\resources\\DB.json"));
            System.out.println(arrayNode.size());
            for(int i = 0; i < arrayNode.size(); i++) {
                JsonNode arrayElement = arrayNode.get(i);
                JsonNode username = arrayElement.get("nume_de_utilizator");
                if(username.textValue().equals("Test1")) {
                    System.out.println(username);
                    JsonNode pass= arrayElement.get("parola");
                    if(pass.textValue().equals("testtest")) {
                        System.out.println("SUCCESS");
                    }
                    else System.out.println("PAROLA GRESITA");
                }
            }
            System.out.println("user nu a fost gasit") ;
            ////////////////////////////////////////////////////////////////*/


            byte[] jsonData = Files.readAllBytes(Paths.get("src\\main\\resources\\DB.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(new File("src\\main\\resources\\DB.json"));

            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode userNode = rootNode.path("nume_de_utilizator");


            Iterator<JsonNode> elements = userNode.elements();
            while (elements.hasNext()) {
                JsonNode username = elements.next();
                System.out.println(username);
                if (username.asText().compareTo(user.getUser()) == 0) {
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

        /*
            File jsonData = new File("src\\main\\resources\\DB.json");
            JSONTokener jsonDataFile = new JSONTokener(new FileInputStream(jsonData));
            JSONObject jsonObject = new JSONObject(jsonDataFile);

            System.out.println(jsonObject.getString("nume_de_utilizator"));
            //System.out.println(jsonObject.getInt("varsta"));
        */
    }
}